package com.luglobal.contest.model.resp;

public class BioResultData {

    private String responseCode;// String 是 10 响应代号 0
    private String responseMsg;// String 是 300 响应信息 成功
    private String isAlive;// String 是 10 业务响应码 0
    private String status;// String 否 300 业务响应信息


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
