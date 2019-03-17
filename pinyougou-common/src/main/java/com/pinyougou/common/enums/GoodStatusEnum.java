package com.pinyougou.common.enums;

/**
 * @author lhh
 * @date 2019/3/17 11:29
 */
public enum GoodStatusEnum {
    NOTAUDITED ("0", "未审核"),
    RED("100", "测试");
    private String code;
    private String message;

    GoodStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
