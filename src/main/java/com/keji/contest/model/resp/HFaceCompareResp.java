package com.luglobal.contest.model.resp;

public class HFaceCompareResp {
    /**
     *  String 是 8
     *  业务编码。唯一表示
     一种确定业务状态的
     数字编码，由服务方
     定义，提供给调用方
     使用 0 表示成功
     0
     */
    private String responseCode;
    /**
     * String 是 255
     业务信息。客户易于
     识别的文字信息，调
     用方可直接显示给客
     户，也可以根据 code
     自行组织提示信息
     成功
     */
    private String responseMsg;
    /**
     * String
     *是 8 输出项 业务编码
     */
    private String errorCode;
    //String 是 255 输出项 业务信息
    private String errorMessage;
    /**
     *String 是 128
     业务流水号，鉴权唯
     一业务流水号 201510140000376107
     */
    private String channelBizNo;
    /**
     *String 是 64

     聚友财认证唯一流水 号
     */
    private String authNo;
    /**
     *String 是 1 比对结果
     0：比对中
     1；比对一致
     2：比对不一致
     */
    private String authResult;
    // String 否 256 比对结果描述
    private String authResultMsg;
    /**
     * String 是 N 响应拓展域
     * 副本下载必含 JSON 字符串：
     {
     “result”: 副本下载结果,
     “ctidName”:”副本名”,
     “ctidStatus”:”副本状态”,
     “ctidIndex”：“副本索引”,
     “copyInfo”:副本信息
     }
     */
    private String resultExtField;

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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getChannelBizNo() {
        return channelBizNo;
    }

    public void setChannelBizNo(String channelBizNo) {
        this.channelBizNo = channelBizNo;
    }

    public String getAuthNo() {
        return authNo;
    }

    public void setAuthNo(String authNo) {
        this.authNo = authNo;
    }

    public String getAuthResult() {
        return authResult;
    }

    public void setAuthResult(String authResult) {
        this.authResult = authResult;
    }

    public String getAuthResultMsg() {
        return authResultMsg;
    }

    public void setAuthResultMsg(String authResultMsg) {
        this.authResultMsg = authResultMsg;
    }

    public String getResultExtField() {
        return resultExtField;
    }

    public void setResultExtField(String resultExtField) {
        this.resultExtField = resultExtField;
    }
}
