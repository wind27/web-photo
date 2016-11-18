package com.wind.utils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class HttpFileUpload {
	private final static Logger logger = LoggerFactory.getLogger(HttpFileUpload.class);
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> postFile(String url, File file, 
			String apptoken, long userId, JSONObject clientInfo) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		JSONObject resultJSON = null;
		try {  
			httpClient = HttpClients.createDefault();  
			HttpPost httpPost = new HttpPost(url);  
            FileBody bin = new FileBody(file);  
            HttpEntity reqEntity = MultipartEntityBuilder.create()  
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)  
                    .addPart("file", bin) // uploadFile对应服务端类的同名属性<File类型>  
                    .addPart("apptoken", new StringBody(apptoken, ContentType.MULTIPART_FORM_DATA))
                    .addPart("user_id", new StringBody(userId+"", ContentType.MULTIPART_FORM_DATA))
                    .addPart("client_info", new StringBody(clientInfo.toString(), ContentType.MULTIPART_FORM_DATA))
                    .setCharset(CharsetUtils.get("UTF-8")).build();  
            httpPost.setEntity(reqEntity);  
            response = httpClient.execute(httpPost);  

            // 打印响应状态  
        	int code = response.getStatusLine().getStatusCode();
        	HttpEntity resEntity = response.getEntity();  
        	if(code == 200 && resEntity!=null) {
        		resultJSON = JSONObject.fromObject(
        				EntityUtils.toString(resEntity, Charset.forName("UTF-8")));
        	}
            // 销毁  
            EntityUtils.consume(resEntity);  
		}catch (Exception e) {
			logger.error("上传文件失败", e);
			return null;
        } finally {
        	try {
        		if(response!=null) {
        			response.close();  
        		}
        		if(httpClient!=null) {
        			httpClient.close();  
        		}
			} catch (Exception e2) {
				return null;
			}
        }  
        return resultJSON;
    }  
	public static void main(String[] args) {
		File file = new File("E:/dmdata/data/talk/answer_file/audio_test.mp3");
		try {
			postFile(null, file, null, 0, null);
		} catch (Exception e) {
		}
	}
}
