package com.lx.response;

import java.util.Comparator;

/**
 * @ClassName: CommonReturnType
 * @Description:
 * @author: SeanLeong
 * @date: 2020/11/17 19:57
 */
public class CommonReturnType {
    //表明对应请求得返回处理结构"success"或"fail"
    private String status;
    //如果status=sucess，则data内返回前端需要的json数据
    //如果stttus=fail，则data内返回公用的错误码格式
    private Object data;

    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
