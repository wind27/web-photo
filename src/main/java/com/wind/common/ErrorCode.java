package com.wind.common;

/**
 * ErrorCode
 *
 * @author qianchun 17/7/13
 **/
public enum ErrorCode {

    SUCCESS(0, "success"), FAIL(1, "fail"), SYS_ERROR(2, "sys_error"), PARAM_ERROR(3, "param_error"), NO_PREMISSION(4,
            "no_premission"), NOT_EXISTS(5,
                    "not_exists"), EXISTS(6, "exists"), DISABLED(7, "disabled"), ERROR(-1, "error");

    private Integer value;

    private String name;

    ErrorCode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
