package org.jeecg.meeting.commons;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回数据格式
 *
 * @author scott
 * @email jeecgos@163.com
 * @date 2019年1月19日
 */
@Data
public class Result implements Serializable {

    public static final Integer SC_OK_200 = 200;

    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;

    public static final Integer SC_JEECG_NO_AUTHZ = 510;


    private static final long serialVersionUID = 1L;


    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 返回处理消息
     */
    private String msg;

    /**
     * 返回数据对象 data
     */
    private Object data;


    public static Result success(Object data) {
        Result rsResult = new Result();
        rsResult.setSuccess(true);
        rsResult.setMsg("success");
        rsResult.setData(data);
        return rsResult;
    }

    public static Result success(String msg, Object data) {
        Result rsResult = new Result();
        rsResult.setSuccess(true);
        rsResult.setMsg(msg);
        rsResult.setData(data);
        return rsResult;
    }

    public static Result error() {
        Result rsResult = new Result();
        rsResult.setSuccess(false);
        rsResult.setMsg("error");
        return rsResult;
    }

    public static Result error(String msg) {
        Result rsResult = new Result();
        rsResult.setSuccess(false);
        rsResult.setMsg(msg);
        return rsResult;
    }

}