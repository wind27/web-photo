package com.wind.utils;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

@Component
public class ImageUtil {
	private final static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
	@Resource
	HttpUtil httpUtil;
	
	@Value("#{settings['img.upload.url']}")
    private String imgUploadUrl;
	
	/**
	 * 上传图片
	 * 
	 * @author qianchun  @date 2016年7月5日 下午7:35:47
	 * @param data
	 * @return
	 */
	public String imgUpload(JSONObject data) {
		String url = imgUploadUrl;
		try {
			JSONObject resultObject = httpUtil.requestPost(imgUploadUrl, data.toString());
			if(resultObject!=null && resultObject.getBoolean("success")) {
				JSONObject key = resultObject.getJSONObject("key");
				if(key !=null && key.getInt("success")==1) {
					logger.info("url:" + url + "; msg:http 调用 php 上传图片操作成功！！！");
					return key.getString("file_url");
				}
				logger.info("url:" + url + "; msg:http 调用 php 上传图片操作失败！！！");
				return null;
			}
			return null;
		} catch (Exception e) {
			logger.info("url:" + url + "; msg:http 调用 php 上传图片操作系统异常！！！");
			return null;
		}
	}
}
