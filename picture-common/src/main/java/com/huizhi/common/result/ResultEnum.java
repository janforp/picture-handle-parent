package com.huizhi.common.result;

/**
 * Created by Janita on 2017-05-22 12:55
 * 封装返回结果
 */
public enum ResultEnum {

    PICTURE_EMPTY(1, "请上传图片"), UPLOAD_PICTURE_FAIL(2, "上传图片失败");

    private int code;

    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
