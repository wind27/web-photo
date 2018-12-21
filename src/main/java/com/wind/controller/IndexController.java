package com.wind.controller;

import com.wind.common.Constant.FileSize;
import com.wind.common.Constant.RequestStatusCode;
import com.wind.common.Constant.RequestStatusMsg;
import com.wind.common.Meta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller
@RequestMapping("/")
public class IndexController {
private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        return new ModelAndView("/index");
    }
}
