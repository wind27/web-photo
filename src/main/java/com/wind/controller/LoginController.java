package com.wind.controller;

import com.wind.common.Constant;
import com.wind.common.ErrorCode;
import com.wind.passport.annotation.PwdDecrypt;
import com.wind.utils.CookieUtil;
import com.wind.utils.JsonResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static String SYD_COOKIE_WEBVIEW_KEY = "syd_auth_verify";

    private static String DOMAIN = ".hulipuhui.com";

    // cookie过期时间两周
    private static int MAXAGE = 1209600;

    private static boolean httpOnly = true;

    private static boolean isSecure = true;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    /**
     * 获取pubsign
     * 
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/pubsign", method = RequestMethod.GET)
    public Object pubsign() {
        Map<String, Object> result = new HashMap<>();
        result.put("publickey", Constant.RSAKey.publicKeyIndex);
        return JsonResponseUtil.ok(result);
    }

    /**
     * 登录
     * 
     * @param request request
     * @param response response
     * @param username 用户名
     * @param password 密码
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("username") String username, @PwdDecrypt String password) {
        try {
            System.out.println(password);
            CookieUtil.set(response, SYD_COOKIE_WEBVIEW_KEY, password, DOMAIN, MAXAGE, httpOnly, isSecure);
            System.out.println(String.format("登录, username=%s pwdResult=%s", username, password));
            return JsonResponseUtil.ok();
        } catch (Exception e) {
            System.out.println(String.format("登录异常, username=%s pwd=%s", username, password));
            e.printStackTrace();
            return JsonResponseUtil.fail(ErrorCode.SYS_ERROR);
        }
    }

    /**
     * 退出登录
     * 
     * @param request request
     * @param response response
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Object logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            String value = CookieUtil.get(request, SYD_COOKIE_WEBVIEW_KEY);
            CookieUtil.set(response, SYD_COOKIE_WEBVIEW_KEY, value, DOMAIN, 0, httpOnly, isSecure);
            return JsonResponseUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResponseUtil.fail(ErrorCode.SYS_ERROR);
        }
    }
}