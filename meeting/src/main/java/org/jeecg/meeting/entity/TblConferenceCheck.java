package org.jeecg.meeting.entity;

import java.util.Date;
import lombok.Data;

@Data
public class TblConferenceCheck {
    /**
     * 主键
     */
    private String id;

    /**
     * 会议ID
     */
    private String conferenceId;

    /**
     * 审核状态 （0：新建 1：通过 2：不通过）
     */
    private String checkStatus;

    /**
     * 审核意见
     */
    private String checkText;

    /**
     * 审核人
     */
    private String checkBy;

    /**
     * 审核时间
     */
    private String checkTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;
}

