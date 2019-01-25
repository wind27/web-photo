package com.wind.utils;


import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookieUtil, 处理cookie辅助类
 */
public class CookieUtil {

    /**
     * 设置cookie
     * @param response response
     * @param name cookie name
     * @param value cookie value
     * @param domain domain
     * @param maxAge maxAge
     * @param httpOnly httpOnly
     * @param isSecure isSecure
     */
    public static void set(HttpServletResponse response, String name, String value, String domain, int maxAge,
            boolean httpOnly, boolean isSecure) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
//        cookie.setHttpOnly(httpOnly);
//        cookie.setSecure(isSecure);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     * @param request 请求
     * @param key cookie name
     * @return 返回结果
     */
    public static String get(HttpServletRequest request, String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie != null && key.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
    /**
     * 使用流式api添加cookie的属性
     * @param response
     * @param name
     * @param value
     * @return CookieUtil.Build实例
     */
    public static Build build(HttpServletResponse response,String name,String value){
        Build build = new Build();
        build.response = response;
        build.cookie = new Cookie(name,value);
        return build;
    }
    public static class Build{
        private HttpServletResponse response;
        private Cookie cookie;
        private String domain;
        private String path;
        private int maxAge;
        private boolean httpOnly = true;
        private boolean secure = true;
        public Build domain(String domain){
            this.domain = domain;
            return this;
        }
        public Build maxAge(int maxAge){
            this.maxAge = maxAge;
            return this;
        }
        public Build httpOnly(boolean httpOnly){
            this.httpOnly = httpOnly;
            return this;
        }
        public Build secure(boolean secure){
            this.secure = secure;
            return this;
        }
        public Build path(String path){
            this.path = path;
            return this;
        }
        public void commit(){
            cookie.setDomain(domain);
            cookie.setMaxAge(maxAge);
            cookie.setPath(path);
            cookie.setHttpOnly(httpOnly);
            cookie.setSecure(secure);
            response.addCookie(cookie);
        }
    }
}
