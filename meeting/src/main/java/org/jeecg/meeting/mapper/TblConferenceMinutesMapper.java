package org.jeecg.meeting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.meeting.entity.TblConferenceMinutes;

import java.util.List;
import java.util.Map;

@Mapper

public interface TblConferenceMinutesMapper extends BaseMapper<TblConferenceMinutes> {


    void attendMeeting(@Param("conferenceId") String conferenceId, @Param("status") String status);

    void notAttendMeeting(@Param("conferenceId") String conferenceId, @Param("status") String status, @Param("declareText") String declareText);

    Integer queryMeetingByUserId(@Param("userId") String userId);

    IPage<List<Map<String, Object>>> selectAllMeetingsByReserId(@Param("userId") String userId, @Param("page") IPage page, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("page1") IPage page1);
}

