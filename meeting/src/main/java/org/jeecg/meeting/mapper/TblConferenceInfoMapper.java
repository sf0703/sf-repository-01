package org.jeecg.meeting.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.meeting.entity.TblConferenceInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Mapper

public interface TblConferenceInfoMapper extends BaseMapper<TblConferenceInfo> {


    void meetingConference(@Param("id") String id, @Param("conferenceSummary") String conferenceSummary);

    List<Map<String, Object>> queryMeetingByUser(@Param("status") String status, @Param("conferenceType") String conferenceType,
                                                 @Param("userStatus") String userStatus,
                                                 @Param("userId") String userId);


    IPage<List<Map<String, Object>>> queryAllMeeting(IPage page, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status);
}