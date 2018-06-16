package com.keji.contest.exception;

import com.keji.contest.enums.ResultCode;

public class CommonException extends RuntimeException {
    private static final long serialVersionUID = 4089980611788905073L;
    protected ResultCode errorCode;
    protected String          errorMsg;
    public CommonException(ResultCode errorCode) {
        this.errorCode = errorCode;
        this.errorMsg =errorCode.getDesc();
    }
    public CommonException(ResultCode errorCode, Object args) {
        this.errorCode = errorCode;
        this.errorMsg = getMessage();
    }

    public CommonException(Throwable t, ResultCode errorCode, Object args) {
        super(t);
        this.errorCode = errorCode;
        this.errorMsg = String.format(errorCode.getDesc(), args);
    }

    public ResultCode getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
