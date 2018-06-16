package com.keji.contest.model.resp;

public class BioDetectResp {

    private String responseCode;// String 是 10 响应代号 0
    private String responseMsg;// String 是 300 响应信息 成功
    private String thirdCode;// String 是 10 业务响应码 0
    private String thirdMsg;// String 否 300 业务响应信息
    private BioResultData resultData;// Object 是 Object 见附 2


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

    public String getThirdCode() {
        return thirdCode;
    }

    public void setThirdCode(String thirdCode) {
        this.thirdCode = thirdCode;
    }

    public String getThirdMsg() {
        return thirdMsg;
    }

    public void setThirdMsg(String thirdMsg) {
        this.thirdMsg = thirdMsg;
    }

    public BioResultData getResultData() {
        return resultData;
    }

    public void setResultData(BioResultData resultData) {
        this.resultData = resultData;
    }
}
