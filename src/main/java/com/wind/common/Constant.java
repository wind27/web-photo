package com.wind.common;

/**
 * 常量
 *
 * @author qianchun
 * @date 2015年11月19日 上午11:06:19
 */
public class Constant {
	/**
     * 请求状态code
     *
     * @author qianchun
     * @date 2015年11月19日 上午11:06:45
     */
    public class RequestStatusCode {
        public static final int SUCCESS = 0;
        
        public static final int FAIL = 1000;
        public static final int PARAMS_ERROR = 1001;
        public static final int SYSTEM_ERROR = 1002;

        public static final int SMS_SEND_FAIL = 1011;
        public static final int SMS_VERIFY_FAIL = 1012;
        
        public static final int USER_DISABLE = 1021;
        public static final int USER_NOT_EXIST = 1022;
        public static final int USER_ACCESS_TOKEN_EXPIRED = 1023;
        public static final int USER_APP_TOKEN_ERROR = 1024;

        public static final int QUESTION_NOT_EXIST = 1031;
        public static final int QUESTION_ANSWER_NOT_EXIST = 1032;
        public static final int QUESTION_ANSWER_USER_ERROR = 1033;
        public static final int QUESTION_ANSWER_NOT_PURCHASE = 1034;

        public static final int FAVORITE_NOT_EXIST = 1041;
        public static final int FAVORITE_CANNOT_SUBSCRIBE_SELF = 1042;
        
        public static final int TAG_NOT_EXIST = 1051;
    }

    /**
     * 请求状态信息
     * 
     * @author qianchun
     * @date 2016年7月1日 下午6:47:17
     */
    public class RequestStatusMsg {
        public static final String SUCCESS = "成功";
        
        public static final String FAIL = "失败";
        public static final String PARAMS_ERROR = "参数不正确";
        public static final String SYSTEM_ERROR = "系统错误";
        
        public static final String SMS_SEND_FAIL = "短信验证失败";
        public static final String SMS_VERIFY_FAIL = "短信验证失败";
        
        public static final String USER_DISABLE = "用户不可用";
        public static final String USER_NOT_EXIST = "用户不存在";
        public static final String USER_ACCESS_TOKEN_EXPIRED = "access_token 失效";
        public static final String USER_APP_TOKEN_ERROR = "apptoken 错误";

        public static final String QUESTION_NOT_EXIST = "问题不存在";
        public static final String QUESTION_ANSWER_NOT_EXIST = "问题尚未回答";
        public static final String QUESTION_ANSWER_USER_ERROR = "邀请回答问题的不是该用户";
        public static final String QUESTION_ANSWER_NOT_PURCHASE = "问题未购买";
        
        public static final String FAVORITE_NOT_EXIST = "问题集不存在";
        public static final String FAVORITE_CANNOT_SUBSCRIBE_SELF = "自己不能订阅自己的问题集";
        
        public static final String TAG_NOT_EXIST = "标签不存在";
    }
}
