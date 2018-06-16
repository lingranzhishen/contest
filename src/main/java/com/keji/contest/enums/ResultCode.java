package com.luglobal.contest.enums;


/**
 * Created by yangmingyang040 on 2017/08/25.
 */
public enum ResultCode {

    OK("0000", "处理正常"),
    FAIL("0001", "处理失败"),
    NOT_EXIST("0003", "请求数据不存在"),
    IGNORE_DATA("0004","可以被忽略的错误"),

    EXCEPTION("9900", "系统处理异常"),
    LOSE_PARAMETER("9901", "信息未填写完整"),
    SERVICE_NOT_AVAILABLE("9902", "服务暂时不可用."),
    UN_ALLOWED_REQUEST("9904", "异常请求，被拒绝."),
    INVALID_INPUT("9905", "输入过长"),
    INVALID_PARAMETER("9908","参数错误"),
    BAD_DATA("9909","脏数据"),
    ENCRY_KEY_ERROR("9910","密钥错误"),
    UNKNOWN_ERROR("9911","未知错误"),

    USER_FACE_COMPARE_NOT_ALIVE("1407","人脸识别图片非活体"),
    ;



    private String code;
    private String desc;

    ResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCode getByCode(String code) {
        ResultCode resultCode = null;
        for (ResultCode codeEnum : ResultCode.values()) {
            if (codeEnum.getCode().equals(code)) {
                resultCode = codeEnum;
                break;
            }
        }
        return resultCode;
    }

    /**
     * 生成响应的json表示
     * @return
     */
    public String generateResponse(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"res_code\":\"").append(this.code).append("\"");
        sb.append(",\"res_msg\":\"").append(this.desc).append("\"");
        sb.append("}");
        return sb.toString();
    }
    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
