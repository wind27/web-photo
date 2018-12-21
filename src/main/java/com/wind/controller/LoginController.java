package com.wind.controller;

import com.wind.common.Constant;
import com.wind.common.ErrorCode;
import com.wind.utils.JsonResponseUtil;
import com.wind.utils.RSACryptography;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.PrivateKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @ResponseBody
    @RequestMapping(value = "/pubsign", method = RequestMethod.GET)
    public Object pubsign() {
        Map<String, Object> result = new HashMap<>();
        result.put("publickey", Constant.RSAKey.publicKeyIndex);
        return JsonResponseUtil.ok(result);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
        try {
            System.out.println(pwd);
            byte[] data = Base64.getDecoder().decode(pwd.getBytes());
            PrivateKey privateKey = RSACryptography.getPrivateKey(Constant.RSAKey.privateKeyIndex);
            byte[] decryptedBytes = RSACryptography.decrypt(data, privateKey);
            String pwdResult = new String(decryptedBytes, "UTF-8");
            System.out.println(String.format("登录, username=%s pwdResult=%s", username, pwdResult));
            return JsonResponseUtil.ok();
        } catch (Exception e) {
            System.out.println(String.format("登录异常, username=%s pwd=%s", username, pwd));
            e.printStackTrace();
            return JsonResponseUtil.fail(ErrorCode.SYS_ERROR);
        }
    }
}