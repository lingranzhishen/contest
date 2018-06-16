package com.luglobal.contest.model;

import java.util.Date;

public class UserIdentityDTO extends BaseDTO{
    private Long id;

    private Date createdAt;

    private String createdBy;

    private Long passportImgId;

    private Long userId;

    /**
     * 手持证件照
     *
     * @mbggenerated
     */
    private Long handImgId;

    private Long faceImgId;

    /**
     * 新建，
失败，
待审核，不通过，通过
     *
     * @mbggenerated
     */
    private String status;

    private String memo;

    private Long baseImgId;

    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPassportImgId() {
        return passportImgId;
    }

    public void setPassportImgId(Long passportImgId) {
        this.passportImgId = passportImgId;
    }

    public Long getHandImgId() {
        return handImgId;
    }

    public void setHandImgId(Long handImgId) {
        this.handImgId = handImgId;
    }

    public Long getFaceImgId() {
        return faceImgId;
    }

    public void setFaceImgId(Long faceImgId) {
        this.faceImgId = faceImgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getBaseImgId() {
        return baseImgId;
    }

    public void setBaseImgId(Long baseImgId) {
        this.baseImgId = baseImgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}