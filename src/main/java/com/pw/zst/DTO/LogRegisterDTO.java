package com.pw.zst.DTO;

/**
 * Created by aradej on 2015-10-28.
 */
public class LogRegisterDTO {

    private String registerName;

    private int attributesQuantity;

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public int getAttributesQuantity() {
        return attributesQuantity;
    }

    public void setAttributesQuantity(int attributesQuantity) {
        this.attributesQuantity = attributesQuantity;
    }

    @Override
    public String toString() {
        return "LogRegisterDTO{" +
                "registerName='" + registerName + '\'' +
                ", attributesQuantity=" + attributesQuantity +
                '}';
    }
}
