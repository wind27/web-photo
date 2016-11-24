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
        public static final int FILE_UPLOAD_ERROR = 1003;

        public static final int USER_DISABLE = 1021;
        public static final int USER_NOT_EXIST = 1022;
        public static final int USER_ACCESS_TOKEN_EXPIRED = 1023;
        public static final int USER_APP_TOKEN_ERROR = 1024;
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
        public static final String FILE_UPLOAD_ERROR = "文件上传失败";
        
        public static final String USER_DISABLE = "用户不可用";
        public static final String USER_NOT_EXIST = "用户不存在";
        public static final String USER_ACCESS_TOKEN_EXPIRED = "access_token 失效";
        public static final String USER_APP_TOKEN_ERROR = "apptoken 错误";
    }
    
    public class FileSize {
    	public static final int IMAGE_MAX_SIZE = 1*1024*1024;//1M
    }
}
