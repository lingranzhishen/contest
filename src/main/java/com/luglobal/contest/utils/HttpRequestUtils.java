package com.luglobal.contest.utils;


import com.luglobal.contest.model.HttpRequestInfoDto;
import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestUtils {


    public static final String HEADER_REFERER_NAME = "Referer";
    public static final String HEADER_AGENT_NAME = "User-Agent";
    public static final String HEADER_MOBILE_AGENT_NAME = "mobile_agent";
    public static final String HEADER_MOBILE_AGENT_PLATFORM = "platform";  //ios
    public static final String HEADER_MOBILE_AGENT_OSVERSION = "osVersion"; //9.0.2
    public static final String HEADER_MOBILE_AGENT_DEVICE = "device"; //iPhone6_2
    public static final String HEADER_MOBILE_AGENT_APP_VERSION = "appVersion"; //V1.04

    public static HttpRequestInfoDto getHttpRequestInfo(HttpServletRequest request) {
        if(request==null)
            return null;
        HttpRequestInfoDto requestInfoDto = new HttpRequestInfoDto();

        requestInfoDto.setRemoteIp(IpAddressUtils.getIpAddress(request));

        requestInfoDto.setRequestReferer(getHttpHeader(request,HEADER_REFERER_NAME));
        requestInfoDto.setRequestUserAgent(getHttpHeader(request,HEADER_AGENT_NAME));
        requestInfoDto.setRequestUrl(getRequestUrl(request));

        return requestInfoDto;
    }

    public static HttpRequestInfoDto getMobileHttpRequestInfo(HttpServletRequest request) {
        HttpRequestInfoDto requestInfoDto = new HttpRequestInfoDto();
        requestInfoDto.setRemoteIp(IpAddressUtils.getIpAddress(request));

        requestInfoDto.setRequestReferer(getHttpHeader(request,HEADER_REFERER_NAME));
        requestInfoDto.setRequestUserAgent(getHttpHeader(request,HEADER_AGENT_NAME));
        requestInfoDto.setRequestUrl(getRequestUrl(request));
        String mobileAgent = getHttpHeader(request, HEADER_MOBILE_AGENT_NAME);
        try {
            if (StringUtils.isNotBlank(mobileAgent)) {

                Map<String, String> map = MapUtils.convertStringToMap(mobileAgent);
                if (StringUtils.isNotBlank(map.get(HEADER_MOBILE_AGENT_PLATFORM))) {
                    requestInfoDto.setPlatform(map.get(HEADER_MOBILE_AGENT_PLATFORM));
                }
                if (StringUtils.isNotBlank(map.get(HEADER_MOBILE_AGENT_OSVERSION))) {
                    requestInfoDto.setOsVersion(map.get(HEADER_MOBILE_AGENT_OSVERSION));
                }
                if (StringUtils.isNotBlank(map.get(HEADER_MOBILE_AGENT_DEVICE))) {
                    requestInfoDto.setDevice(map.get(HEADER_MOBILE_AGENT_DEVICE));
                }
                if (StringUtils.isNotBlank(map.get(HEADER_MOBILE_AGENT_APP_VERSION))) {
                    requestInfoDto.setAppVersion(map.get(HEADER_MOBILE_AGENT_APP_VERSION));
                }
            }

        } catch (Exception e) {
//            Logger.warn(HttpRequestUtils.class, "getMobileHttpRequestInfo exception", e);
        }

        return requestInfoDto;
    }



    public static String getHttpHeader(HttpServletRequest request, String headerName) {
        return request.getHeader(headerName);
    }

    public static String getRequestUrl(HttpServletRequest request){
        if(request==null)
            return null;
        String queryStr = request.getQueryString();
        String url = request.getRequestURL().toString();
        return StringUtils.isNotBlank(queryStr)?url+"?"+queryStr:url;
    }


    /**
     * 将字符串转换成map对象
     * @param data
     * @param delimiter
     * @return
     */
    public static Map<String,String> convert2MapByDelimiter(String data,String delimiter){
        Map<String,String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(data) || StringUtils.isBlank(delimiter)){
            return map;
        }
        String[] pariKeyValArr = data.split(delimiter);
        for(int i=0;i<pariKeyValArr.length;i++){
            String keyVal = pariKeyValArr[i];
            String[] att = keyVal.split("=");
            if(att!=null && att.length==2){
                map.put(att[0],att[1]);
            }
        }
        return map;
    }


}
