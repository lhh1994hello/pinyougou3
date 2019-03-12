package com.pinyougou.common.enums;

/**
 * 商家审核状态
 */
public enum SellerStatusEnum {

    WAIT("0", "等待审核"),
    RED("100", "测试");

    private String code;
    private String message;

    SellerStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    SellerStatusEnum() {
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
    }}
