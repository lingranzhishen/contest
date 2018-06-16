package com.keji.contest.model;

/**
 * Created with IntelliJ IDEA.
 * User: daiqiang
 * Date: 6/17/14
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestInfoDto extends BaseDTO {
    private String guId;
    private String remoteIp;
    private String requestReferer;
    private String requestUrl;
    private String requestUserAgent;
    private String sessionId;
    private String platform;
    private String osVersion;
    private String device;
    private String appVersion;
    private String currentLat;//当前纬度
    private String currentLng;//当前经度
    private String uuid;

    public HttpRequestInfoDto(){

    }

    public HttpRequestInfoDto(String guId, String remoteIp, String requestReferer, String requestUrl, String requestUserAgent) {
        this.guId = guId;
        this.remoteIp = remoteIp;
        this.requestReferer = requestReferer;
        this.requestUrl = requestUrl;
        this.requestUserAgent = requestUserAgent;
    }


    public String getGuId() {
        return guId;
    }

    public void setGuId(String guId) {
        this.guId = guId;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getRequestReferer() {
        return requestReferer;
    }

    public void setRequestReferer(String requestReferer) {
        this.requestReferer = requestReferer;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestUserAgent() {
        return requestUserAgent;
    }

    public void setRequestUserAgent(String requestUserAgent) {
        this.requestUserAgent = requestUserAgent;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getCurrentLat() {
        return currentLat;
    }

    public void setCurrentLat(String currentLat) {
        this.currentLat = currentLat;
    }

    public String getCurrentLng() {
        return currentLng;
    }

    public void setCurrentLng(String currentLng) {
        this.currentLng = currentLng;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
