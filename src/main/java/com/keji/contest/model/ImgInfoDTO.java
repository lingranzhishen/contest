package com.keji.contest.model;

import java.util.Date;

public class ImgInfoDTO extends BaseDTO{
    private Long id;

    private String path;

    private Long picSize;

    private Long height;

    private Long width;

    private Date createdAt;

    private String createdBy;

    private String type;

    private String originName;

    private String pinganId;

    private String imgExtInfo;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public Long getPicSize() {
        return picSize;
    }

    public void setPicSize(Long picSize) {
        this.picSize = picSize;
    }

    public String getPinganId() {
        return pinganId;
    }

    public void setPinganId(String pinganId) {
        this.pinganId = pinganId;
    }

    public String getImgExtInfo() {
        return imgExtInfo;
    }

    public void setImgExtInfo(String imgExtInfo) {
        this.imgExtInfo = imgExtInfo;
    }
}