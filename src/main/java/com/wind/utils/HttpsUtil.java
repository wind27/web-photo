package com.wind.utils;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

@Component
public class HttpsUtil {

	public CloseableHttpClient createSSLClientDefault(){
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

				@Override
				public boolean isTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType)
								throws java.security.cert.CertificateException {
					return false;
				}
				
			}).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return  HttpClients.createDefault();
	}
	
	public JSONObject get(String url) {
		CloseableHttpClient httpClient = createSSLClientDefault();
		HttpGet get = new HttpGet();
		try {
			get.setURI(new URI(url));
			
			HttpResponse response = httpClient.execute(get);
			System.out.println(response.getStatusLine().toString());
			
			HttpEntity entity = response.getEntity();  
            String respContent = EntityUtils.toString(entity , "UTF-8").trim();
			System.out.println(respContent);
			return JSONObject.fromObject(respContent);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		HttpsUtil httpsUtil = new HttpsUtil();
		String openid = "oa_v3t5jlc0OsadLDpvzrd3VsY9A";
		String access_token = "A4XJ_m-kXg6XnGYiPBRVNPb0IqUhgLM10wVVY_LX5LP0wEyMH8GYbXsYCKWf5P4S3DD5V0Z3KP1QFqfhXuKoawNFjxUmLMjerr14DfPjDok";
		String url = "https://api.weixin.qq.com/sns/userinfo?"
				+"access_token="+access_token
				+ "&openid="+openid
				+"&lang=zh_CN";
		JSONObject obj = httpsUtil.get(url);
		System.out.println(obj.toString());
	}
}
