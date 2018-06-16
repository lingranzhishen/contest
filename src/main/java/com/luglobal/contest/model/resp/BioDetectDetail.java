package com.luglobal.contest.model.resp;

public class BioDetectDetail {

    private String responseCode;// String 是 10 业务返回码 0
    private String responseMsg;// String 是 300 业务返回信息 Trade success
    private String isAlive;// String 是 1是否为活体，Y-是，N-否Y
    private String status;// String 是 8 请求状态，0-成功，2-失败0

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(String isAlive) {
        this.isAlive = isAlive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
