package com.keji.contest.model;

import java.util.Date;

public class UserDTO extends BaseDTO{
    private Long userId;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    private String username;

    /**
     * 手机号
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;


    private String role;//user admin
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}