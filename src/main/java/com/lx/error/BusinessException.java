package com.lx.error;

/**
 * @ClassName: BusinessException
 * @Description:
 * @author: SeanLeong
 * @date: 2020/11/17 20:39
 */
//包装类：业务异常类
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    //直接接受EmBusinessError的传参用于构建业务异常
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError, String errMsg){
        super();
        this.commonError = commonError;
        commonError.setErrorMsg(errMsg);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errMsg) {
        return this.commonError.setErrorMsg(errMsg);
    }
}
