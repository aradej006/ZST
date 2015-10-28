package com.pw.zst.DTO;

/**
 * Created by aradej on 2015-10-28.
 */
public class LogAttributeDTO {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LogAttributeDTO{" +
                "value='" + value + '\'' +
                '}';
    }
}
