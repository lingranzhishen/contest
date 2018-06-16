package com.luglobal.contest.gson;

/**
 * Created by lizehua035 on 2018/6/9.
 */
public class IdentityApproveGson {
    private Long userId;
    private String result;
    private String memo;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
