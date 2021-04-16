package org.jeecg.meeting.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.meeting.entity.TblConferenceMinutes;
import org.jeecg.meeting.mapper.TblConferenceMinutesMapper;
import org.jeecg.meeting.service.ITblConferenceMinutes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TblConferenceMinutesService extends ServiceImpl<TblConferenceMinutesMapper, TblConferenceMinutes> implements ITblConferenceMinutes {

    @Resource
    private TblConferenceMinutesMapper tblConferenceMinutesMapper;

    @Override
    public IPage<List<Map<String, Object>>> selectAllMeetingsByReserId(IPage page, String startTime, String endTime, String userId) {
       return tblConferenceMinutesMapper.selectAllMeetingsByReserId(userId,page,startTime,endTime,page);
    }

    @Override
    public void attendMeeting(TblConferenceMinutes minutes) {
        if ("1".equals(minutes.getStatus()) || "2".equals(minutes.getStatus())){
            if ("1".equals(minutes.getStatus()))
            {
                tblConferenceMinutesMapper.attendMeeting(minutes.getConferenceId(),minutes.getStatus());
            }else{
                tblConferenceMinutesMapper.notAttendMeeting(minutes.getConferenceId(),minutes.getStatus(),minutes.getDeclareText());
            }
        }
    }

    @Override
    public Integer queryMeetingByUserId(String userId) {
        Integer integer = tblConferenceMinutesMapper.queryMeetingByUserId(userId);
        return integer;
    }
}

