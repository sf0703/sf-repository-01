package org.jeecg.meeting.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TblProjectSuperviseAttr implements Serializable {
    /**
    * 主键
    */
    private String id;

    /**
    * 督办id
    */
    private String superviseId;

    /**
    * 附件类型（1发起督办时附件，2处理督办时附件）
    */
    private String attType;

    /**
    * 附件名称
    */
    private String attachmentName;

    /**
    * 附件地址
    */
    private String attachmentUrl;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新人
    */
    private String updateBy;

    /**
    * 更新时间
    */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}