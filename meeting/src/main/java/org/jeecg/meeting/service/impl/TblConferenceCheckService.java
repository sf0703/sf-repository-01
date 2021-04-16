package org.jeecg.meeting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.meeting.entity.TblConferenceCheck;
import org.jeecg.meeting.entity.TblConferenceInfo;
import org.jeecg.meeting.mapper.TblConferenceCheckMapper;
import org.jeecg.meeting.mapper.TblConferenceInfoMapper;
import org.jeecg.meeting.service.ITblConferenceCheckService;
import org.jeecg.meeting.utils.UuidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TblConferenceCheckService extends ServiceImpl<TblConferenceCheckMapper, TblConferenceCheck> implements ITblConferenceCheckService {
    @Resource
    private TblConferenceCheckMapper tblConferenceCheckMapper;
    @Resource
    private TblConferenceInfoMapper tblConferenceInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyStatus(TblConferenceInfo tblConferenceInfo, TblConferenceCheck tblConferenceCheck) {
        String sid = UuidUtils.getUUID().replaceAll("-", "");
        tblConferenceCheck.setId(sid);
        //插入审核数据
        tblConferenceCheckMapper.insert(tblConferenceCheck);
        String checkStatus = tblConferenceCheck.getCheckStatus();
        if (!"1".equals(checkStatus) && !"2".equals(checkStatus)) {
            throw new RuntimeException("审核状态为空");
        }
        String status = null;
        if ("1".equals(checkStatus)) {
            status = "2";
        } else if ("2".equals(checkStatus)) {
            status = "3";
        }
        tblConferenceInfo.setStatus(status);
        tblConferenceInfoMapper.updateById(tblConferenceInfo);

    }
}
