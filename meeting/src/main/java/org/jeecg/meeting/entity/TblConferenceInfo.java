package org.jeecg.meeting.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
    * 会议信息表
    */
@Data
@ToString
@ApiModel
public class TblConferenceInfo implements Serializable {
    private String id;

    /**
    * 会议名称
    */
    private String conferenceName;

    /**
    * 会议地址
    */
    private String conferenceAddress;

    /**
    * 会议时间
    */
    private String conferenceTime;

    /**
    * 参会人员（乡镇）
    */
    private String attendees;

    /**
    * 会议状态 0 新建 1 审核中 2 审核通过 3 下达 4 结束
    */
    private String status;

    /**
    * 会议发起人
    */
    private String conferenceCreator;

    /**
    * 会议纪要
    */
    private String conferenceSummary;

    /**
    * 会议类型
    */
    private String conferenceType;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
    * 修改人
    */
    private String updateBy;

    /**
    * 修改时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}