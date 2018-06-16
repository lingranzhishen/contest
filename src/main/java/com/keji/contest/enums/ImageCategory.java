package com.keji.contest.enums;

/**
 * 标识图片类别 标识图片类别 (1 -手机自拍照片， 2-身份证照片，  3-护照片，默认 1)
 * Created by yangmingyang040 on 12/10/17.
 */
public enum ImageCategory {

    /**
     * 默认为1
     */
    PHONE_IMG("1", "手机自拍照"),


    ID_IMG("2", "身份证"),

    PASSPORT_IMG("3", "护照"),

    ;

    private String code;

    /**
     * 充值上限
     */
    private String desc;


    ImageCategory(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ImageCategory getByCode(String code){
        for(ImageCategory contentType : ImageCategory.values()){
            if(contentType.getCode().equalsIgnoreCase(code)) {
                return contentType;
            }
        }
        return null;
    }

}
