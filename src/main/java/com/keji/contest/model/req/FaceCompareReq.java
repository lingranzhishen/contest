package com.luglobal.contest.model.req;


/**
 * Created by fengfei754 on 1/20/17.
 */
public class FaceCompareReq{


    private String type;

    private String mediaId;
    private String username;

    private ImageExtInfo message;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ImageExtInfo getMessage() {
        return message;
    }

    public void setMessage(ImageExtInfo message) {
        this.message = message;
    }


}
