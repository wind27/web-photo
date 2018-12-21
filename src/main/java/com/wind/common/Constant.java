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


    public class RSAKey {
        public static final String publicKeyIndex = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEfas4kYTV9TQTgAYspkm2ICh+O7B0NO15DwSJngXKFKl32AtUf1izWnW00A5KJlc1mz3WP1FAWmXcKMhdSITnKWb39Y3lDN/rzn6VEh5gIgtR7Rer0EnLvRdUl5DjxWC55mfwFSZIDgXpT1Zyqq618XNjoPb5ADZuQs+o00YdowIDAQAB";
        public static final String privateKeyIndex = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMR9qziRhNX1NBOABiymSbYgKH47sHQ07XkPBImeBcoUqXfYC1R/WLNadbTQDkomVzWbPdY/UUBaZdwoyF1IhOcpZvf1jeUM3+vOfpUSHmAiC1HtF6vQScu9F1SXkOPFYLnmZ/AVJkgOBelPVnKqrrXxc2Og9vkANm5Cz6jTRh2jAgMBAAECgYAIfOE7lVWmpGv2d65MmXZPrr3xDgUGUA7+Dr8EbtYTL6dObP+4S7P6M2soP2COpW9Y+nbGXX/WBtGlnAFjvjE3c6dlJce7LfHvKWFRSHKypyeyGheGAuz24+0L3afrYBF/UeVzGa3FCitsIs2AjrW8Fh7otk9i0MstvemlQzyzqQJBAPUZDVvufOpb05mY/2u1Mf20capj02GY8nHdA/iwcKMN0tNXeWNE5eX0Qvd5axZ8gyamaKZ4fI3R1rqrpTVmjGcCQQDNOyAeBPXdJdwLQcK0P3vsPiqFSnz4O6vowhC3IXbXu5UclHzsN8RdvbScQl28rl+oQgIxX+kIrw5BNeckhd9lAkBqbp2RfUe7UXLasUjBUebKgBAX6M+DAzLM5SfzV1MiSz9wzPyGcgXPTLnD03MAScN+BidNmuajgyrW1vCf9s8jAkEAo1MpVRqHe24UtpSn2YAoI7K5bggAeiAqx/ohCUxFYpvyp6L345jh2eQN5sjeBjkTATk+u4JjVrjRdE3sW+F6DQJBAJeyIUOcINbbDI+ZFwrfEXl4WFwFMIOdEswyFaq6aqXKTCrmjp6Y9a9McLUxF/jCRVvuoeqeRGKtWbqq+fsyuHQ=";

//        public static final String publicKeyIndex = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1Lvt+eRErXoUxsKU+vF7k4w2KvVO74MH0ojxRWRO6ILWWXR7fsf7KdFd0LnIS8ZvS9E/u8YTbEg7XWdEnpKK58GZgBKAo+FlEsZZxIGD+E26gT/jBKeiWc64av1Mje/aglWdC3dOTgk+neiL6U1yhIOpQ7kA2zJwu6IJulsEqjQIDAQAB";
//        public static final String privateKeyIndex = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALUu+355EStehTGwpT68XuTjDYq9U7vgwfSiPFFZE7ogtZZdHt+x/sp0V3QuchLxm9L0T+7xhNsSDtdZ0SekornwZmAEoCj4WUSxlnEgYP4TbqBP+MEp6JZzrhq/UyN79qCVZ0Ld05OCT6d6IvpTXKEg6lDuQDbMnC7ogm6WwSqNAgMBAAECgYBVrjIgTQBhkgFKzk5WrJ3zf6wXwBCo+FDAbzg2//jkPDOjN8Yx4uqqsvnoZ05qxvb5e6+RP4WkU5XRIRhXtvN8TwrmGekTNG3ldqewpXH5IQYSeWzx1BV+rpKCpIPdEpAgPMgGoAnyPFJQj/+FFBSkm3WJNJOSQDr1UpBdTkm2AQJBANrH9e4ml7EvRf5iG6WJubUadkamj7P3V7dzKBbjSSA6kPxXuJBn4qKHqwr/8ZGXb8UnRdwxcRxF9j5pya5/YPUCQQDUAaBd+2AiSAvg9NXVe7CV2Ai8RlZ1OJceaum+uAA8b2IX3nrF0QqPpxpqgq2qsY+XBPRBRD3tBdH+gGSv5cQ5AkBdsu4dBOJKvFhZzmLQzt9+NMsbDxLUnMYwh11QEB+tcefOazNchWGHAlu65krrc9Qmt98vou0ykrQXnu8FkQBRAkEAnxlxXdYtuMxUjcdvSbx/MpRjSdeHPoTvc5ZMQCIZm0EDXmJJxHYx9Mg0nMXgyn5iAbVoECrERkHd654y8YX+kQJAGEB2cxpIcXGf3yyqRsbghKxiJmxNXfmHv4F4VAPNJAvEAaiF00WJF5uTbmLBmJTn7g/rl8I8MuiDfXANNQ1r1A==";

    }

}
