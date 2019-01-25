package com.wind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class PageController {
    private final static Logger logger = LoggerFactory.getLogger(PageController.class);

    /**
     * index 页面
     * 
     * @param request request
     * @return 返回结果
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        return new ModelAndView("/index");
    }

    /**
     * 登录 页面
     * 
     * @param request request
     * @return 返回结果
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        return new ModelAndView("/login");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 用户列表 页面
     * 
     * @param request request
     * @return 返回结果
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ModelAndView userList(HttpServletRequest request) {
        return new ModelAndView("user/list");
    }

    /**
     * 用户详情 页面
     * 
     * @param request request
     * @return 返回结果
     */
    @RequestMapping(value = "/user/detail", method = RequestMethod.GET)
    public ModelAndView userDetail(HttpServletRequest request) {
        return new ModelAndView("user/detail");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 图片上传 页面
     *
     * @param request request
     * @return 返回结果
     */
    @RequestMapping(value = "/image/upload", method = RequestMethod.GET)
    public ModelAndView imageUpload(HttpServletRequest request) {
        return new ModelAndView("image/upload");
    }

    /**
     * 图片列表 页面
     *
     * @param request request
     * @return 返回结果
     */
    @RequestMapping(value = "/image/list", method = RequestMethod.GET)
    public ModelAndView imageList(HttpServletRequest request) {
        return new ModelAndView("image/list");
    }

    /**
     * 图片预览 页面
     *
     * @param request request
     * @return 返回结果
     */
    @RequestMapping(value = "/image/preview", method = RequestMethod.GET)
    public ModelAndView imagePreview(HttpServletRequest request) {
        return new ModelAndView("image/preview");
    }
}
