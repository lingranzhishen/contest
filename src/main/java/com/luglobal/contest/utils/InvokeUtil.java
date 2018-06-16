package com.luglobal.contest.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

public class InvokeUtil {
	
	public HttpClientUtilTest httpClient = new HttpClientUtilTest();
	{
		httpClient.init();
	}
	
	/**
	 * 获取随机流水号
	 * @return
	 */
	public String getSerialNo(int len) {
		String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String currentTimeMillis = String.valueOf(System.currentTimeMillis());
		String millis = currentTimeMillis.substring(currentTimeMillis.length() - 5);

		if (len <= 0) {
			return "";
		}
		if (1 <= len && len <= 25) {
			return RandomStringUtils.randomNumeric(len);
		} else if (25 < len && len <= 30) {
			return time + RandomStringUtils.randomNumeric(len - 17);
		} else {
			return time + millis + RandomStringUtils.randomNumeric(len - 22);
		}
	}
	
	public String getAccessToken(String channel,String privatekey,String pamaUrl){
		try {
			long timestamp = System.currentTimeMillis();
			int random = (int)((Math.random()*9+1)*100000);
			String tokendata = channel + ";" + random + ";" + timestamp;
			String sign = RSAUtils.sign(tokendata.getBytes("UTF-8"), privatekey);
			Map<String,String> map = new HashMap<String, String>();
			map.put("channel", channel);
			map.put("random", random+"");
			map.put("timestamp", timestamp+"");
			map.put("sign", sign);
			//String signstring = "{\"channel\":\""+channel+"\",\"random\":\""+randomnum+"\",\"timestamp\":\""+timestamp+"\",\"sign\":\""+sign+"\"}";
			String acctokenurl = pamaUrl+"/pama_intf_esb.applyAccessToken";
			
			String resultStr = httpClient.postJSON(acctokenurl, JSONObject.toJSONString(map));
			JSONObject result = JSONObject.parseObject(resultStr);
			if("0".equals(result.getString("responseCode"))){
				return result.getString("accessToken");
			}else{
				throw new RuntimeException(result.getString("responseMsg"));
			}
		} catch (Exception e) {
			throw new RuntimeException("900101", e);
		}
	}
	
	public String sendJson(String pamaUrl,String privatekey,String url,Map<String, Object> param,String type) throws Exception{
		String channel = MapUtils.getString(param, "channel");
		
		String service = url;
		String requestUrl = pamaUrl+"/"+service;
		
		if ("1".equals(type)) {
			String sign = RSAUtils.sign(coverMap2String(param).getBytes("UTF-8"), privatekey);
			param.put("sign", sign);
		}else if ("0".equals(type)){
			if (!StringUtils.contains(pamaUrl, "localhost")) {
			}
		}else {
			if (!StringUtils.contains(pamaUrl, "localhost")) {
				param.put("accessToken", getAccessToken(channel,privatekey,pamaUrl));
			}
		}
		System.out.println("channel:" + channel);
		System.out.println("调用地址:" + requestUrl);
		System.out.println("入参:" + JSONObject.toJSONString(param));
		String resultStr = httpClient.postJSON(requestUrl, param);
		System.err.println("出参:" + resultStr);
		return resultStr;
	}

	protected String sendJson(String paramUrl,String value){
		System.out.println("调用地址:" + paramUrl);
		System.out.println("入参:" + JSONObject.toJSONString(value));
		String resultStr = null;
		try {
			resultStr = httpClient.postJSON(paramUrl, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("出参:" + resultStr);
		return resultStr;
	}

	public String sendForm(String pamaUrl,String privatekey,String url,Map<String, String> param,String type) throws Exception{
		String channel = MapUtils.getString(param, "channel");

		String service = url;
		String requestUrl = pamaUrl+"/"+service;

		if ("1".equals(type)) {
			String sign = RSAUtils.sign(coverMap2String2(param).getBytes("UTF-8"), privatekey);
			param.put("sign", sign);
		}else if ("0".equals(type)){

		}else {
			if (!StringUtils.contains(pamaUrl, "localhost")) {
				param.put("accessToken", getAccessToken(channel,privatekey,pamaUrl));
			}
		}
		System.out.println("channel:" + channel);
		System.out.println("调用地址:" + requestUrl);
		System.out.println("入参:" + JSONObject.toJSONString(param));
		String resultStr = httpClient.postForm(requestUrl, param);
		System.err.println("出参:" + resultStr);
		return resultStr;
	}

	public String getJson(String url){
		try {
			String json = httpClient.getJson(url);
			return json;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String coverMap2String(Map<String, Object> data) throws Exception{
		TreeMap tree = new TreeMap();
		Iterator it = data.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry en = (Map.Entry) it.next();
			if ("sign".equals(((String) en.getKey()).trim())||en.getKey()==null) {
				continue;
			}
			if(en.getValue()!=null&&!"".equals(en.getValue()))
				tree.put(en.getKey(), en.getValue());
		}
		it = tree.entrySet().iterator();
		StringBuffer sf = new StringBuffer();
		while (it.hasNext()) {
			Map.Entry en = (Map.Entry) it.next();
			sf.append(new StringBuilder().append(en.getKey()).append("=").append(en.getValue()).append("&").toString());
		}

		return sf.substring(0, sf.length() - 1);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String coverMap2String2(Map<String, String> data) throws Exception{
		TreeMap tree = new TreeMap();
		Iterator it = data.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry en = (Map.Entry) it.next();
			if ("sign".equals(((String) en.getKey()).trim())||en.getKey()==null) {
				continue;
			}
			if(en.getValue()!=null&&!"".equals(en.getValue()))
				tree.put(en.getKey(), en.getValue());
		}
		it = tree.entrySet().iterator();
		StringBuffer sf = new StringBuffer();
		while (it.hasNext()) {
			Map.Entry en = (Map.Entry) it.next();
			sf.append(new StringBuilder().append((String) en.getKey()).append("=").append((String) en.getValue()).append("&").toString());
		}

		return sf.substring(0, sf.length() - 1);
	}
	
}
