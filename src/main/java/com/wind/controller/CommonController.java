package com.wind.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sun.imageio.plugins.common.ImageUtil;
import com.wind.common.Constant.RequestStatusCode;
import com.wind.common.Constant.RequestStatusMsg;
import com.wind.common.Meta;


@Controller
@RequestMapping("/")
public class CommonController {
private final static Logger logger = LoggerFactory.getLogger(CommonController.class);
    //-----------------------------------------------------------------------------------
    
	public CommonController() {
		System.out.println("********************");
	}

    @RequestMapping(value="/user/image", method=RequestMethod.GET)
    public ModelAndView visitAllFeedForPage(HttpServletRequest request) {
        return new ModelAndView("/user/image");
    }
    /**
     * 上传图片
     * 
     * @author qianchun  @date 2016年7月6日 上午10:54:36
     * @param request
     * @param response
     * @return
     */
	@ResponseBody
    @RequestMapping(value = "/upload/img", method=RequestMethod.POST)
    public Object imageUpload(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> resultMap = new HashMap<>();
    	Map<String, Object> dataMap = new HashMap<>();
    	Meta meta = new Meta();
    	MultipartFile multipartFile = null;
    	try {
    		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
    		multipartFile = multipartRequest.getFile("file");
		} catch (Exception e) {
			meta.setCode(RequestStatusCode.PARAMS_ERROR);
	    	meta.setMsg(RequestStatusMsg.PARAMS_ERROR);
	    	resultMap.put("meta", meta);
	    	return resultMap;
		}
    	return null;
    }
    
}
