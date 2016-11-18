package com.wind.utils;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

import net.sf.json.JSONObject;

public class HttpUtil {

    private AsyncHttpClient asyncHttpClient;
    private static AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();

    static {
    	builder.setConnectTimeout(3000);// 连接超时
    	builder.setReadTimeout(2000);//读取数据超时
    	builder.setMaxConnections(1000);// 最大连接数
    }

    public AsyncHttpClient getAsyncHttpClient() {
        return asyncHttpClient;
    }

    public void setAsyncHttpClient(AsyncHttpClient asyncHttpClient) {
        this.asyncHttpClient = asyncHttpClient;
    }

    public JSONObject request(String url) {
    	JSONObject result = new JSONObject();
        try {
        	ListenableFuture<JSONObject> f = getAsyncHttpClient()
        			.prepareGet(url)
        			.addHeader("Content-Type", "application/json;charset=utf-8")
        			.execute(new AsyncCompletionHandler<JSONObject>() {
        				JSONObject result = new JSONObject();
        				@Override
        				public JSONObject onCompleted(Response response) throws Exception {
        					result.put("key", response.getResponseBody());
        					result.put("success", true);
        					return result;
        				}
        				@Override
        				public void onThrowable(Throwable t) {
        					result.put("success", false);
        				}
        			});
            result = f.get();
            result.put("success", true);
        }
        catch (InterruptedException | ExecutionException e) {
            result.put("success", false);
        }

        return result;
    }
    public JSONObject request(String url, int timeout) {
    	JSONObject result = new JSONObject();
    	try {
    		ListenableFuture<JSONObject> f = getAsyncHttpClient()
    				.prepareGet(url)
    				.setRequestTimeout(timeout)
    				.addHeader("Content-Type", "application/json;charset=utf-8")
    				.execute(new AsyncCompletionHandler<JSONObject>() {
    					JSONObject result = new JSONObject();
    					
    					@Override
    					public JSONObject onCompleted(Response response) throws Exception {
    						result.put("key", response.getResponseBody());
    						result.put("success", true);
    						return result;
    					}
    					
    					@Override
    					public void onThrowable(Throwable t) {
    						result.put("success", false);
    						
    					}
    				});
    		result = f.get();
    		result.put("success", true);
    	}
    	catch (InterruptedException | ExecutionException e) {
    		result.put("success", false);
    	}
    	return result;
    }
    
    public JSONObject requestPost(String url,String data) {
        JSONObject result = new JSONObject();
        try {
        	BoundRequestBuilder builder = getAsyncHttpClient().preparePost(url);
        	builder.setHeader("Content-Type", "application/json");
        	builder.setBody(data);
        	ListenableFuture<JSONObject> f = builder
        			.execute(new AsyncCompletionHandler<JSONObject>() {
        				JSONObject result = new JSONObject();
        				
        				@Override
        				public JSONObject onCompleted(Response response) throws Exception {
        					result.put("key", response.getResponseBody());
        					return result;
        				}
        				
        				@Override
        				public void onThrowable(Throwable t) {
        					result.put("key", "error");
        					
        				}
        			});
            result = f.get();
            result.put("success", true);
        }
        catch (InterruptedException | ExecutionException e) {
            result.put("success", false);
        }

        return result;
    }
    public JSONObject requestPost(String url,String data, int timeout) {
    	JSONObject result = new JSONObject();
    	
    	try {
    		BoundRequestBuilder builder = getAsyncHttpClient().preparePost(url).setRequestTimeout(timeout);
    		builder.setHeader("Content-Type", "application/json");
    		builder.setBody(data);
    		ListenableFuture<JSONObject> f = builder
    				.execute(new AsyncCompletionHandler<JSONObject>() {
    					JSONObject result = new JSONObject();
    					
    					@Override
    					public JSONObject onCompleted(Response response) throws Exception {
    						result.put("key", response.getResponseBody());
    						return result;
    					}
    					
    					@Override
    					public void onThrowable(Throwable t) {
    						result.put("key", "error");
    						
    					}
    				});
    		result = f.get();
    		result.put("success", true);
    	}
    	catch (InterruptedException | ExecutionException e) {
    		result.put("success", false);
    	}
    	
    	return result;
    }
    public String post(String url,String data) {
        try {
            RequestBuilder requestBuilder = new RequestBuilder();
            requestBuilder.setBody(data);
            requestBuilder.addHeader("Content-type", "application/json");
            requestBuilder.setMethod("POST");
            requestBuilder.setUrl(url);
            Request request = requestBuilder.build();
            ListenableFuture<Response> f = getAsyncHttpClient().executeRequest(request);
            Response response = f.get();
            String sss = response.getResponseBody();
            System.out.println(sss);
          } catch (Exception e) {
          }
        return "";
    }
    
    public static void main(String[] args) {
		
	}
}
