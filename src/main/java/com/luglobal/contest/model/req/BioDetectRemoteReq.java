package com.luglobal.contest.model.req;

public class BioDetectRemoteReq {

    private String hannelDate;// String 是 8 请求日期 yyyyMMDD 请求发起时系统日期
    private String channelJnlNo;// String 是 64 业务流水号，调用所需附带的唯一流水号，可以与鉴权流水号一致
    private String identityType;// String 是 8 身份认证服务类型，本识 别 服 务 为R0200W12 R0200W12
    private BioDetectParamDetail extData;// Object 是 Object 额外参数


    public String getHannelDate() {
        return hannelDate;
    }

    public void setHannelDate(String hannelDate) {
        this.hannelDate = hannelDate;
    }

    public String getChannelJnlNo() {
        return channelJnlNo;
    }

    public void setChannelJnlNo(String channelJnlNo) {
        this.channelJnlNo = channelJnlNo;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public BioDetectParamDetail getExtData() {
        return extData;
    }

    public void setExtData(BioDetectParamDetail extData) {
        this.extData = extData;
    }
}
