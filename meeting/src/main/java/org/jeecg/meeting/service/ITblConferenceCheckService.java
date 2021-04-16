package org.jeecg.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.meeting.entity.TblConferenceCheck;
import org.jeecg.meeting.entity.TblConferenceInfo;

public interface ITblConferenceCheckService extends IService<TblConferenceCheck> {
    void modifyStatus(TblConferenceInfo tblConferenceInfo, TblConferenceCheck tblConferenceCheck);
}
