package com.wind.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.imageio.plugins.common.ImageUtil;
import com.wind.common.Constant.RequestStatusCode;
import com.wind.common.Constant.RequestStatusMsg;
import com.wind.common.Meta;
import com.wind.utils.FileUtil;
import com.wind.utils.HttpFileUpload;
import com.wind.utils.MD5Util;

import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;


@Controller
@RequestMapping("/")
public class CommonController {
private final static Logger logger = LoggerFactory.getLogger(CommonController.class);
    
    @Value("#{settings['voice.upload.url']}")
    private String voiceUploadUrl;
    
    @Value("#{settings['img.upload.url']}")
    private String imgUploadUrl;
    
	@Value("#{settings['file.upload.temporary.dir']}")
    private String fileUploadTemporaryDir;
    
    @Resource
    private ImageUtil imageUtil;
    //-----------------------------------------------------------------------------------
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
    	
    	int source = 0;
    	long userId = 0;
    	String apptoken = null;
    	JSONObject clientInfo = null;
    	MultipartFile multipartFile = null;
    	try {
    		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
    		if(multipartRequest.getParameter("apptoken")==null
    				|| multipartRequest.getParameter("user_id")==null 
    				|| multipartRequest.getParameter("source")==null
    				|| multipartRequest.getParameter("client_info")==null 
    				|| multipartRequest.getFile("file")==null) {
    			meta.setCode(RequestStatusCode.PARAMS_ERROR);
    	    	meta.setMsg(RequestStatusMsg.PARAMS_ERROR);
    	    	resultMap.put("meta", meta);
    	    	return resultMap;
    		}
    		apptoken = multipartRequest.getParameter("apptoken");
    		userId = Long.parseLong(multipartRequest.getParameter("user_id"));
    		source = Integer.parseInt(multipartRequest.getParameter("source"));
    		clientInfo = JSONObject.fromObject(multipartRequest.getParameter("client_info"));
    		multipartFile = multipartRequest.getFile("file");
    		
    		//判断图片的 source 是否合法
    		if(source!=200 && source!=201) {
    			meta.setCode(RequestStatusCode.PARAMS_ERROR);
    	    	meta.setMsg(RequestStatusMsg.PARAMS_ERROR);
    	    	resultMap.put("meta", meta);
    	    	return resultMap;
    		}
		} catch (Exception e) {
			meta.setCode(RequestStatusCode.PARAMS_ERROR);
	    	meta.setMsg(RequestStatusMsg.PARAMS_ERROR);
	    	resultMap.put("meta", meta);
	    	return resultMap;
		}
    	try { 
    		String data = new BASE64Encoder().encode(multipartFile.getBytes());
    		JSONObject dataJson = new JSONObject();
    		dataJson.put("uid", userId);
    		dataJson.put("source", source);
    		dataJson.put("verifystr", MD5Util.MD5(data));
    		dataJson.put("data", data);
    		dataJson.put("apptoken", "dmaitoken01");
    		dataJson.put("client_info", clientInfo);
//    		String imgUrl = imageUtil.imgUpload(dataJson);
//    		if(!StringUtils.isBlank(imgUrl)) {
//    			meta.setCode(RequestStatusCode.SUCCESS);
//    	    	meta.setMsg(RequestStatusMsg.SUCCESS);
//    	    	dataMap.put("img_url", imgUrl);
//    	    	resultMap.put("meta", meta);
//    	    	resultMap.put("data", dataMap);
//    		} else {
//    			meta.setCode(RequestStatusCode.FAIL);
//    	    	meta.setMsg(RequestStatusMsg.FAIL);
//    	    	resultMap.put("meta", meta);
//    		}
    		
    		String imgUrl = "";
    		meta.setCode(RequestStatusCode.SUCCESS);
	    	meta.setMsg(RequestStatusMsg.SUCCESS);
	    	dataMap.put("img_url", imgUrl);
	    	resultMap.put("meta", meta);
	    	resultMap.put("data", dataMap);
    		return resultMap;
    	} catch (IOException e) { 
    		logger.error("上传图片异常：", e);
    		meta.setCode(RequestStatusCode.SYSTEM_ERROR);
    		meta.setMsg(RequestStatusMsg.SYSTEM_ERROR);
    		resultMap.put("meta", meta);
    		return resultMap;
    	}    	
    }
    
    /**
     * 音频上传
     * 
     * @author qianchun  @date 2016年7月8日 上午11:28:03
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("unused")
	@ResponseBody
    @RequestMapping(value = "/upload/voice", method=RequestMethod.POST)
    public Object voiceUpload(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> resultMap = new HashMap<>();
    	Map<String, Object> dataMap = new HashMap<>();
    	Meta meta = new Meta();
    	
    	long userId = 0;
    	int source = 1;
    	String apptoken = null;
    	JSONObject clientInfo = null;
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
    	
    	try {
    		File dir = new File(fileUploadTemporaryDir);
    		if(!dir.exists()) {
    			dir.mkdirs();
    		}
    		String fileName = null;
    		File file = null;
    		boolean flag = false;
    		while(file==null || file.exists()==true) {
    			fileName = FileUtil.generateFileName(userId) + ".mp3";
    			String filepath = fileUploadTemporaryDir + fileName;
    			file = new File(filepath);
    		}
    		multipartFile.transferTo(file);
            resultMap = HttpFileUpload.postFile(voiceUploadUrl, file, apptoken, userId, clientInfo);
            file.delete();
            return resultMap;
    	} catch(Exception e) {
    		logger.error("上传音频异常：", e);
    		meta.setCode(RequestStatusCode.SYSTEM_ERROR);
	    	meta.setMsg(RequestStatusMsg.SYSTEM_ERROR);
	    	resultMap.put("meta", meta);
	    	return resultMap;
    	}
    }
}
