package com.wind.controller;

import com.wind.service.UserService;
import com.wind.utils.JsonResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UsesrController {
    private final static Logger logger = LoggerFactory.getLogger(UsesrController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户列表
     * 
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page pageModel = new Page(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        params.put("page", pageModel);


        User user = userService.findPage(1L);
        return JsonResponseUtil.ok(user);
    }

    /**
     * 用户详情
     *
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object detail() {
        User user = userService.get(1L);
        return JsonResponseUtil.ok(user);
    }

    /**
     * 用户新增
     *
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object add() {
        User user = userService.get(1L);
        return JsonResponseUtil.ok(user);
    }

    /**
     * 用户删除
     *
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object delete() {
        User user = userService.get(1L);
        return JsonResponseUtil.ok(user);
    }

    /**
     * 用户启用/停用
     *
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object updateStatus() {
        User user = userService.get(1L);
        return JsonResponseUtil.ok(user);
    }

    /**
     * 用户统计
     *
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object count() {
        User user = userService.get(1L);
        return JsonResponseUtil.ok(user);
    }

}