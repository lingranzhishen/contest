package com.luglobal.contest.model.req;

public class FaceCompareParamDto {
    private String terminalType;// String 是 64 标识终端设备类型 微创新大赛:Pc
    private String terminalSDK;// String 是 32 标识终端设备 SDK 微创新大赛:o236
    private String terminalSystem;// String 是 64 标识终端设备使用的  软件系统微创新大赛：pamastore
    private String terminalBrowser;// String 是 64 标识是何种浏览器 微创新大赛:Ie
    private String operationType;// String 是 10 操作类型 两照对比：R0200W05
    private String platId;// String 是 8 订单管理平台(向聚友财申请)微创新大赛：8889
    private String channelBizNo;// String 是 128 业务流水号，鉴权唯 一业务流水号201510140000376107
    private String channelDate;// String 是 8 渠 道 日 期 ， 格 式“yyyyMMdd” 20160101
    private String idType;// String 是 1 证件类型：1-身份证 1
    private String idNumber;// String 是 18 证件号 230101191912287015
    private String custName;// String 是 128 客户姓名 张三
    private String phone;// String 否 15 客户手机号
    /**
     * String 否 LLV… 待比对的图片对象 1
     * 二项认证时非必填，其余认证
     必填
     先通过文件上传接口上传图
     片，上传完成之后会返回文件
     ID，将文件 ID 放入此字段
     */
    private String file_image1;

    private String image1Category;// String 否 1 图片 1 类型二项认证时非必填，其余认证 必填，1：自拍照片
    private String image1Mark;// String 否 1 标识图片 1 是否存在 二项认证时非必填，其余认证
    /**
     * k
     String 否 1
     标识图片 1 是否存在网纹
     二项认证时非必填，其余认证
     必填
     0：无网纹
     1：有网纹
     */
    private String image1CrossMark;//
    /**
     *  二项认证时非必填，其余认证
     必填
     例如 jpg，png 等
     */
    private String image1Type;// String 否 64 图片 1 格式


    private String landmarkTerminal1;
    /** String 否 500
     终端侧检测图片 1 时
     得到的质量结果
     brightness，必传参数，浮
     点数。明暗度。
     blur_motion，必传参数，
     浮点数。运动模糊。
     blur_gaussian，必传参
     数，浮点数。高斯模糊。
     deflection_h，必传参数，
     浮点数。水平偏角。
     */
    private String qualityTerminal1;


    /**
     *  二项认证时非必填，其余认证
     必填
     先通过文件上传接口上传图
     片，上传完成之后会返回文件
     ID，将文件 ID 放入此字段
     */
    private String file_image2;// String 否 LLV… 待比对的图片对象 2
    /**
     *  二项认证时非必填，其余认证
     必填
     1：自拍照片
     2：证件照片
     3:：护照照片

     */
    private String image2Category;// String 否 1 图片 2 类型

    /**
     * 标识图片 2 是否存在
     水印
     二项认证时非必填，其余认证
     必填
     0：无水印
     1：有水印
     */
    private String image2Mark;// String 否 1


    /**
     *
     String 否 1
     标识图片 2 是否存在
     网纹
     二项认证时非必填，其余认证
     必填
     0：无网纹
     1：有网纹

     */
    private String image2CrossMark;//

    /**
     * 二项认证时非必填，其余认证
     必填
     例如 jpg，png 等

     */
    private String image2Type;// String 否 64 图片 2 格式

    /**
     * 2
     String 否 500
     终端侧检测图片 2 时
     得到的定位结果
     说明同 landmarkTerminal1
     */
    private String landmarkTerminal2;


    /**
     * String 否 500
     * 终端侧检测图片 2 时
     得到的质量结果
     说明同 qualityTerminal1
     */
    private String  qualityTerminal2;


    /**
     * String 是 32 信息主体授权码
     * 被查询个人用户授权机构的
     授权代码
     微创新大赛：8889
     */
    private String entityAuthCode;//

    /**
     * String 是 24 信息主体授权时间
     yyyyMMdd
     微创新大赛：系统日期
     */
    private String  entityAuthDate;
    /**
     * String 否 500 扩展域 Json 格式组装
     */
    private String extField;

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

    public String getTerminalSystem() {
        return terminalSystem;
    }

    public void setTerminalSystem(String terminalSystem) {
        this.terminalSystem = terminalSystem;
    }

    public String getTerminalBrowser() {
        return terminalBrowser;
    }

    public void setTerminalBrowser(String terminalBrowser) {
        this.terminalBrowser = terminalBrowser;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getPlatId() {
        return platId;
    }

    public void setPlatId(String platId) {
        this.platId = platId;
    }

    public String getChannelBizNo() {
        return channelBizNo;
    }

    public void setChannelBizNo(String channelBizNo) {
        this.channelBizNo = channelBizNo;
    }

    public String getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(String channelDate) {
        this.channelDate = channelDate;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFile_image1() {
        return file_image1;
    }

    public void setFile_image1(String file_image1) {
        this.file_image1 = file_image1;
    }

    public String getImage1Category() {
        return image1Category;
    }

    public void setImage1Category(String image1Category) {
        this.image1Category = image1Category;
    }

    public String getImage1Mark() {
        return image1Mark;
    }

    public void setImage1Mark(String image1Mark) {
        this.image1Mark = image1Mark;
    }

    public String getImage1CrossMark() {
        return image1CrossMark;
    }

    public void setImage1CrossMark(String image1CrossMark) {
        this.image1CrossMark = image1CrossMark;
    }

    public String getImage1Type() {
        return image1Type;
    }

    public void setImage1Type(String image1Type) {
        this.image1Type = image1Type;
    }

    public String getLandmarkTerminal1() {
        return landmarkTerminal1;
    }

    public void setLandmarkTerminal1(String landmarkTerminal1) {
        this.landmarkTerminal1 = landmarkTerminal1;
    }

    public String getQualityTerminal1() {
        return qualityTerminal1;
    }

    public void setQualityTerminal1(String qualityTerminal1) {
        this.qualityTerminal1 = qualityTerminal1;
    }

    public String getFile_image2() {
        return file_image2;
    }

    public void setFile_image2(String file_image2) {
        this.file_image2 = file_image2;
    }

    public String getImage2Category() {
        return image2Category;
    }

    public void setImage2Category(String image2Category) {
        this.image2Category = image2Category;
    }

    public String getImage2Mark() {
        return image2Mark;
    }

    public void setImage2Mark(String image2Mark) {
        this.image2Mark = image2Mark;
    }

    public String getImage2CrossMark() {
        return image2CrossMark;
    }

    public void setImage2CrossMark(String image2CrossMark) {
        this.image2CrossMark = image2CrossMark;
    }

    public String getImage2Type() {
        return image2Type;
    }

    public void setImage2Type(String image2Type) {
        this.image2Type = image2Type;
    }

    public String getLandmarkTerminal2() {
        return landmarkTerminal2;
    }

    public void setLandmarkTerminal2(String landmarkTerminal2) {
        this.landmarkTerminal2 = landmarkTerminal2;
    }

    public String getQualityTerminal2() {
        return qualityTerminal2;
    }

    public void setQualityTerminal2(String qualityTerminal2) {
        this.qualityTerminal2 = qualityTerminal2;
    }

    public String getEntityAuthCode() {
        return entityAuthCode;
    }

    public void setEntityAuthCode(String entityAuthCode) {
        this.entityAuthCode = entityAuthCode;
    }

    public String getEntityAuthDate() {
        return entityAuthDate;
    }

    public void setEntityAuthDate(String entityAuthDate) {
        this.entityAuthDate = entityAuthDate;
    }

    public String getExtField() {
        return extField;
    }

    public void setExtField(String extField) {
        this.extField = extField;
    }
}


