package org.jeecg.meeting.entity;

import lombok.Data;

@Data
public class TblConferenceMinutes {
    /**
     *
     */
    private String id;

    /**
     * 会议ID
     */
    private String conferenceId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 状态 0 新建 1 确认参会 2 不参会
     */
    private String status;

    /**
     * 说明
     */
    private String declareText;
}

