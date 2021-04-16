package org.jeecg.meeting.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.meeting.entity.TblConferenceInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ITblConferenceInfoService extends IService<TblConferenceInfo> {


    IPage<List<Map<String, Object>>> queryAllMeeting(IPage page,String startTime, String endTime, String status);


    void addMeetingRecords(TblConferenceInfo tblConferenceInfo,MultipartFile file);

    List<TblConferenceInfo> getInfoById(String id);

    void meetingRelease(TblConferenceInfo tblConferenceInfo);

    void meetingConference(String id, String conferenceSummary);

    List<Map<String, Object>> queryMeetingByUser(String status, String conferenceType, String userStatus,String userId);
}
