package org.jeecg.meeting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.meeting.entity.TblConferenceMinutes;
import org.jeecg.meeting.mapper.TblConferenceMinutesMapper;
import org.jeecg.meeting.service.ITblConferenceInfoService;
import org.jeecg.meeting.service.ITblProjectSuperviseAttrService;
import org.jeecg.meeting.utils.UuidUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.jeecg.meeting.mapper.TblConferenceInfoMapper;
import org.jeecg.meeting.entity.TblConferenceInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class TblConferenceInfoService extends ServiceImpl<TblConferenceInfoMapper,TblConferenceInfo> implements ITblConferenceInfoService {
    @Resource
    private TblConferenceInfoMapper tblConferenceInfoMapper;
    @Resource
    private ITblProjectSuperviseAttrService tblProjectSuperviseAttrService;
    @Resource
    private TblConferenceMinutesMapper tblConferenceMinutesMapper;
    @Override
    public IPage<List<Map<String, Object>>> queryAllMeeting(IPage page,
                                                            String startTime,
                                                            String endTime,
                                                            String status) {

        return tblConferenceInfoMapper.queryAllMeeting(page,startTime,endTime,status);
    }

    @Override

    public void addMeetingRecords(TblConferenceInfo tblConferenceInfo, MultipartFile file) {
        String id = UuidUtils.getUUID().replaceAll("-", "");
        tblConferenceInfo.setId(id);
        tblConferenceInfo.setStatus("0");
        String[] attendeesList = StringUtils.isEmpty(tblConferenceInfo.getAttendees()) ? new String[]{} : tblConferenceInfo.getAttendees().split(",");

        //保存信息
        tblConferenceInfoMapper.insert(tblConferenceInfo);
        //保存附件
        tblProjectSuperviseAttrService.saveMeetingAttr(file, id);
        //保存记录
        TblConferenceMinutes tblConferenceMinutes = new TblConferenceMinutes();
        saveRecords(id,attendeesList,tblConferenceMinutes);

    }


    @Override
    public List<TblConferenceInfo> getInfoById(String id) {
        LambdaQueryWrapper<TblConferenceInfo> wrapper = new QueryWrapper<TblConferenceInfo>().lambda();
        wrapper.eq(TblConferenceInfo::getId,id);
        return tblConferenceInfoMapper.selectList(wrapper);

    }

    @Override
    public void meetingRelease(TblConferenceInfo tblConferenceInfo) {
        tblConferenceInfo.setStatus("4");
        tblConferenceInfoMapper.updateById(tblConferenceInfo);
    }

    @Override
    public void meetingConference(String id, String conferenceSummary) {
        tblConferenceInfoMapper.meetingConference(id,conferenceSummary);
        TblConferenceInfo tblConferenceInfo = new TblConferenceInfo();
        tblConferenceInfo.setStatus("5");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        tblConferenceInfoMapper.update(tblConferenceInfo,wrapper);
    }

    @Override
    public List<Map<String, Object>> queryMeetingByUser(String status, String conferenceType, String userStatus,String userId) {
       List<Map<String,Object>> list = tblConferenceInfoMapper.queryMeetingByUser(status,conferenceType,userStatus,userId);
        return list;
    }


    private void saveRecords(String id,String[] attendeesList, TblConferenceMinutes tblConferenceMinutes) {
        for (String s : attendeesList) {
            tblConferenceMinutes.setUserId(s);
            String mid = UuidUtils.getUUID().replaceAll("-", "");
            tblConferenceMinutes.setId(mid);
            tblConferenceMinutes.setConferenceId(id);
            tblConferenceMinutes.setStatus("0");
            tblConferenceMinutesMapper.insert(tblConferenceMinutes);
        }
    }
}
