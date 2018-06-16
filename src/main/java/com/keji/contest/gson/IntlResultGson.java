package com.keji.contest.gson;


import com.keji.contest.enums.ResultCode;

public class IntlResultGson<T> {
    private String res_code;

    private String res_msg;

    private T data;

    public IntlResultGson() {
        this.res_code = ResultCode.OK.getCode();
        this.res_msg = ResultCode.OK.getDesc();
    }

    public IntlResultGson(String retCode, String retMsg){
        this.res_code = retCode;
        this.res_msg = retMsg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRes_msg() {
        return res_msg;
    }

    public void setRes_msg(String res_msg) {
        this.res_msg = res_msg;
    }

    public String getRes_code() {
        return res_code;
    }

    public void setRes_code(String res_code) {
        this.res_code = res_code;
    }


}
