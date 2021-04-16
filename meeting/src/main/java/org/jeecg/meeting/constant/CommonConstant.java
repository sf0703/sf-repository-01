package org.jeecg.meeting.constant;

import java.util.HashMap;
import java.util.Map;

public interface CommonConstant {

    /**
     * 正常状态
     */
    public static final Integer STATUS_NORMAL = 0;

    /**
     * 禁用状态
     */
    public static final Integer STATUS_DISABLE = -1;

    /**
     * 删除标志
     */
    public static final Integer DEL_FLAG_1 = 1;

    /**
     * 未删除
     */
    public static final Integer DEL_FLAG_0 = 0;

    /**
     * 系统日志类型： 登录
     */
    public static final int LOG_TYPE_1 = 1;

    /**
     * 系统日志类型： 操作
     */
    public static final int LOG_TYPE_2 = 2;

    /**
     * 操作日志类型： 查询
     */
    public static final int OPERATE_TYPE_1 = 1;

    /**
     * 操作日志类型： 添加
     */
    public static final int OPERATE_TYPE_2 = 2;

    /**
     * 操作日志类型： 更新
     */
    public static final int OPERATE_TYPE_3 = 3;

    /**
     * 操作日志类型： 删除
     */
    public static final int OPERATE_TYPE_4 = 4;

    /**
     * 操作日志类型： 倒入
     */
    public static final int OPERATE_TYPE_5 = 5;

    /**
     * 操作日志类型： 导出
     */
    public static final int OPERATE_TYPE_6 = 6;


    /**
     * {@code 500 Server Error} (HTTP/1.0 - RFC 1945)
     */
    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /**
     * {@code 200 OK} (HTTP/1.0 - RFC 1945)
     */
    public static final Integer SC_OK_200 = 200;

    /**
     * 访问权限认证未通过 510
     */
    public static final Integer SC_JEECG_NO_AUTHZ = 510;

    /**
     * 登录用户Shiro权限缓存KEY前缀
     */
    public static String PREFIX_USER_SHIRO_CACHE = "shiro:cache:org.jeecg.modules.shiro.authc.ShiroRealm.authorizationCache:";
    /**
     * 登录用户Token令牌缓存KEY前缀
     */
    public static final String PREFIX_USER_TOKEN = "prefix_user_token_";
    /**
     * Token缓存时间：3600秒即一小时
     */
    public static final int TOKEN_EXPIRE_TIME = 3600;


    /**
     * 0：一级菜单
     */
    public static final Integer MENU_TYPE_0 = 0;
    /**
     * 1：子菜单
     */
    public static final Integer MENU_TYPE_1 = 1;
    /**
     * 2：按钮权限
     */
    public static final Integer MENU_TYPE_2 = 2;

    /**
     * 通告对象类型（USER:指定用户，ALL:全体用户）
     */
    public static final String MSG_TYPE_UESR = "USER";
    public static final String MSG_TYPE_ALL = "ALL";

    /**
     * 发布状态（0未发布，1已发布，2已撤销）
     */
    public static final String NO_SEND = "0";
    public static final String HAS_SEND = "1";
    public static final String HAS_CANCLE = "2";

    /**
     * 阅读状态（0未读，1已读）
     */
    public static final String HAS_READ_FLAG = "1";
    public static final String NO_READ_FLAG = "0";

    /**
     * 优先级（L低，M中，H高）
     */
    public static final String PRIORITY_L = "L";
    public static final String PRIORITY_M = "M";
    public static final String PRIORITY_H = "H";

    /**
     * 短信模板方式  0 .登录模板、1.注册模板、2.忘记密码模板
     */
    public static final String SMS_TPL_TYPE_0 = "0";
    public static final String SMS_TPL_TYPE_1 = "1";
    public static final String SMS_TPL_TYPE_2 = "2";

    /**
     * 状态(0无效1有效)
     */
    public static final String STATUS_0 = "0";
    public static final String STATUS_1 = "1";

    /**
     * 同步工作流引擎1同步0不同步
     */
    public static final Integer ACT_SYNC_1 = 1;
    public static final Integer ACT_SYNC_0 = 0;

    /**
     * 消息类型1:通知公告2:系统消息
     */
    public static final String MSG_CATEGORY_1 = "1";
    public static final String MSG_CATEGORY_2 = "2";

    /**
     * 是否配置菜单的数据权限 1是0否
     */
    public static final Integer RULE_FLAG_0 = 0;
    public static final Integer RULE_FLAG_1 = 1;

    /**
     * 是否用户已被冻结 1正常(解冻) 2冻结
     */
    public static final Integer USER_UNFREEZE = 1;
    public static final Integer USER_FREEZE = 2;

    /**
     * 字典翻译文本后缀
     */
    public static final String DICT_TEXT_SUFFIX = "_dictText";

    /**
     * 表单设计器主表类型
     */
    public static final Integer DESIGN_FORM_TYPE_MAIN = 1;

    /**
     * 表单设计器子表表类型
     */
    public static final Integer DESIGN_FORM_TYPE_SUB = 2;

    /**
     * 表单设计器URL授权通过
     */
    public static final Integer DESIGN_FORM_URL_STATUS_PASSED = 1;

    /**
     * 表单设计器URL授权未通过
     */
    public static final Integer DESIGN_FORM_URL_STATUS_NOT_PASSED = 2;

    /**
     * 表单设计器新增 Flag
     */
    public static final String DESIGN_FORM_URL_TYPE_ADD = "add";
    /**
     * 表单设计器修改 Flag
     */
    public static final String DESIGN_FORM_URL_TYPE_EDIT = "edit";
    /**
     * 表单设计器详情 Flag
     */
    public static final String DESIGN_FORM_URL_TYPE_DETAIL = "detail";
    /**
     * 表单设计器复用数据 Flag
     */
    public static final String DESIGN_FORM_URL_TYPE_REUSE = "reuse";
    /**
     * 表单设计器编辑 Flag （已弃用）
     */
    public static final String DESIGN_FORM_URL_TYPE_VIEW = "view";

    /**
     * online参数值设置（是：Y, 否：N）
     */
    public static final String ONLINE_PARAM_VAL_IS_TURE = "Y";
    public static final String ONLINE_PARAM_VAL_IS_FALSE = "N";

    /**
     * 文件上传类型（本地：local，Minio：minio，阿里云：alioss）
     */
    public static final String UPLOAD_TYPE_LOCAL = "local";
    public static final String UPLOAD_TYPE_MINIO = "minio";
    public static final String UPLOAD_TYPE_OSS = "alioss";

    /**
     * 文档上传自定义桶名称
     */
    public static final String UPLOAD_CUSTOM_BUCKET = "eoafile";
    /**
     * 文档上传自定义路径
     */
    public static final String UPLOAD_CUSTOM_PATH = "eoafile";
    /**
     * 文件外链接有效天数
     */
    public static final Integer UPLOAD_EFFECTIVE_DAYS = 1;

    /**
     * 员工身份 （1:普通员工  2:上级）
     */
    public static final Integer USER_IDENTITY_1 = 1;
    public static final Integer USER_IDENTITY_2 = 2;

    /**
     * sys_user 表 username 唯一键索引
     */
    public static final String SQL_INDEX_UNIQ_SYS_USER_USERNAME = "uniq_sys_user_username";
    /**
     * sys_user 表 work_no 唯一键索引
     */
    public static final String SQL_INDEX_UNIQ_SYS_USER_WORK_NO = "uniq_sys_user_work_no";
    /**
     * sys_user 表 phone 唯一键索引
     */
    public static final String SQL_INDEX_UNIQ_SYS_USER_PHONE = "uniq_sys_user_phone";
    /**
     * sys_user 表 email 唯一键索引
     */
    public static final String SQL_INDEX_UNIQ_SYS_USER_EMAIL = "uniq_sys_user_email";
    /**
     * sys_quartz_job 表 job_class_name 唯一键索引
     */
    public static final String SQL_INDEX_UNIQ_JOB_CLASS_NAME = "uniq_job_class_name";
    /**
     * sys_position 表 code 唯一键索引
     */
    public static final String SQL_INDEX_UNIQ_CODE = "uniq_code";
    /**
     * sys_role 表 code 唯一键索引
     */
    public static final String SQL_INDEX_UNIQ_SYS_ROLE_CODE = "uniq_sys_role_role_code";
    /**
     * sys_depart 表 code 唯一键索引
     */
    public static final String SQL_INDEX_UNIQ_DEPART_ORG_CODE = "uniq_depart_org_code";
    /**
     * 在线聊天 是否为默认分组
     */
    public static final String IM_DEFAULT_GROUP = "1";
    /**
     * 在线聊天 图片文件保存路径
     */
    public static final String IM_UPLOAD_CUSTOM_PATH = "imfile";
    /**
     * 在线聊天 用户状态
     */
    public static final String IM_STATUS_ONLINE = "online";

    /**
     * 在线聊天 SOCKET消息类型
     */
    public static final String IM_SOCKET_TYPE = "chatMessage";

    /**
     * 考勤补卡业务状态 （1：同意  2：不同意）
     */
    public static final String SIGN_PATCH_BIZ_STATUS_1 = "1";
    public static final String SIGN_PATCH_BIZ_STATUS_2 = "2";

    /**
     * 公文文档上传自定义路径
     */
    public static final String UPLOAD_CUSTOM_PATH_OFFICIAL = "officialdoc";
    /**
     * 公文文档下载自定义路径
     */
    public static final String DOWNLOAD_CUSTOM_PATH_OFFICIAL = "officaldown";

    /**
     * WPS存储值类别(1 code文号 2 text（WPS模板还是公文发文模板）)
     */
    public static final String WPS_TYPE_1 = "1";
    public static final String WPS_TYPE_2 = "2";

    public static final Map<String, String> IS_COMPLETE = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522681730565593L;

        {
            put("0", "未完成"); //未完成
            put("1", "已完成"); //已完成
        }
    };


    /**
     * 待办消息状态 0 未读 1 已读 2 全部
     */
    public static final String CHARGE_STATUS_0 = "0";
    public static final String CHARGE_STATUS_1 = "1";
    public static final String CHARGE_STATUS_2 = "2";


    public static final Map<String, String> PLAN_COMPLETE_PIE_NAME = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522681730565593L;

        {
            put("prophase_count", "前期"); //未完成
            put("start_count", "开工"); //已完成
            put("build_count", "建成"); //已完成
            put("putoperator_count", "投运"); //已完成
            put("stop_count", "关停"); //已完成
            put("move_count", "搬迁"); //已完成
        }
    };

    /**
     * 审核结果 0 未读 1 已读 2 全部
     */
    public static final String CHECK_STATUS_NO = "0";
    public static final String CHECK_STATUS_YES = "1";


    public static final Map<String, String> TASK_STATUS = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522681730565593L;

        {
            put("0", "待征求");
            put("1", "征求中");
            put("2", "已征求");
            put("3", "进行中");
            put("4", "已完成");
        }
    };

    public static final Map<String, String> PROJECT_PROCESS = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522681730565593L;

        {
            put("0", "前期");
            put("1", "开工");
            put("2", "建成");
            put("3", "投运");
            put("4", "关停");
            put("5", "搬迁");
        }
    };

    public static final Map<String, String> PROJECT_STATE = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522681730565593L;

        {
            put("0", "待征求");
            put("1", "征求中");
            put("2", "已征求");
            put("3", "已下发");
            put("4", "未完成");
            put("5", "已完成");
        }
    };

    public static final Map<String, String> SUPERVISE_STATUS = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522681730565593L;

        {
            put("0", "未通过");
            put("1", "进行中");
            put("2", "审核中");
            put("3", "已通过");
        }
    };
    /**
     * 资源投资  0 按区 1 按类型
     */
    public static final String TYPE_0 = "0";
    public static final String TYPE_1 = "1";

    /**
     * 站点状态
     */
    public static final Map<String, String> SITE_FALG = new HashMap<String, String>() {
        {
            put("normal", "正常");
            put("abnormal", "异常");
            put("offline", "离线");
        }
    };

    /**
     * 空气质量等级
     */
    public static final Map<String, String> LEVEL = new HashMap<String, String>() {
        {
            put("1", "优");
            put("2", "良");
            put("3", "轻度污染");
            put("4", "中度污染");
            put("5", "重度污染");
            put("6", "严重污染");
            put("--", "暂无数据");
        }
    };

    public static final Map<String, String> MANAGER_TYPE_CHINESE = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522681730565593L;

        {
            put("1", "省控");
            put("2", "乡镇街道");
            put("3", "微型站");
        }
    };

    /**
     * 清新空气等级划分
     */
    public static final Map<String, String> QXKQ_LEVEL = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522665730565593L;

        {
            put("1", "Ⅰ");
            put("2", "Ⅱ");
            put("3", "Ⅲ");
            put("4", "Ⅳ");
            put("5", "Ⅴ");
            put("-1", "--");
        }
    };

    public static final Map<String, String> MANAGER_TYPE_ENGLISH = new HashMap<String, String>() {
        private static final long serialVersionUID = -3093522681730565593L;

        {
            put("1", "province");
            put("2", "township");
            put("3", "miniature");
        }
    };
    /**
     * 考核配置项
     */
    public static final Map<String, String> CHECK_CONFIG_NAME = new HashMap<String, String>() {{
        put("pm25", "pm2.5");
        put("aqi", "aqi");
        put("o3", "o3");
    }};

    /**
     * 考核配置项对应的数据库的字段
     */
    public static final Map<String, String> CHECK_CONFIG_COL = new HashMap<String, String>() {
        {
            put("pm25", "col4");
            put("aqi", "aqiValue");
            put("o3", "col3");
        }
    };

    /**
     * 机动车检测结果是否合格（0不合格，1合格）
     */
    public static final Map<String, String> VEHICLE_INSPECT_IS_QUALIFIED = new HashMap<String, String>() {
        {
            put("0", "不合格");
            put("1", "合格");
        }
    };

    public static final Map<String, String> FACTOR_OF_DUST = new HashMap<String, String>() {
        {
            put("Temperature", "温度");
            put("Humidity", "湿度");
            put("Atmos", "大气压");
            put("WindSpeed", "风速");
            put("WindDirection", "风向");
            put("Dust", "扬尘");
        }
    };


}
