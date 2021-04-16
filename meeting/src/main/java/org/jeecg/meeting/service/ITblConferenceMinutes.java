package org.jeecg.meeting.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.meeting.entity.TblConferenceMinutes;

import java.util.List;
import java.util.Map;


public interface ITblConferenceMinutes extends IService<TblConferenceMinutes> {




    void attendMeeting(TblConferenceMinutes minutes);

    Integer queryMeetingByUserId(String userId);

    IPage<List<Map<String, Object>>> selectAllMeetingsByReserId(IPage page, String startTime, String endTime, String userId);
}

