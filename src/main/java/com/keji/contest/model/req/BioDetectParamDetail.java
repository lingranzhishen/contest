package com.luglobal.contest.model.req;

public class BioDetectParamDetail {

    private String terminalType;// String 是 8 终端类型 PC
    private String terminalSDK;// String 是 8 SDK 版本 1.0
    private String terminalBrowser;// String 是 8 终端浏览器 ie
    private String terminalSystem;// String 是 8 终端系统 ie
    private String idNo;// String 是 64 全网唯一识别号，可以为身份证，也可以是唯一的网络身份标识430204199702087719
    private String  channelBizNo;// String 是 64 鉴权流水号 12345678
    private String imageFileId1;// String 是 40 主账户文件系统返回的文件 ID 4c9ba02a1a1e49b156ef
    private String image1Type;// String 是 10 图片类型 jpg
    private String  image1Category;// String 是 2 文件类型,1-自拍照 1

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getTerminalSDK() {
        return terminalSDK;
    }

    public void setTerminalSDK(String terminalSDK) {
        this.terminalSDK = terminalSDK;
    }

    public String getTerminalBrowser() {
        return terminalBrowser;
    }

    public void setTerminalBrowser(String terminalBrowser) {
        this.terminalBrowser = terminalBrowser;
    }

    public String getTerminalSystem() {
        return terminalSystem;
    }

    public void setTerminalSystem(String terminalSystem) {
        this.terminalSystem = terminalSystem;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getChannelBizNo() {
        return channelBizNo;
    }

    public void setChannelBizNo(String channelBizNo) {
        this.channelBizNo = channelBizNo;
    }

    public String getImageFileId1() {
        return imageFileId1;
    }

    public void setImageFileId1(String imageFileId1) {
        this.imageFileId1 = imageFileId1;
    }

    public String getImage1Type() {
        return image1Type;
    }

    public void setImage1Type(String image1Type) {
        this.image1Type = image1Type;
    }

    public String getImage1Category() {
        return image1Category;
    }

    public void setImage1Category(String image1Category) {
        this.image1Category = image1Category;
    }
}
