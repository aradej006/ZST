package com.pw.zst.DTO;

/**
 * Created by arade on 28-Oct-15.
 */
public class LogAttributeNameDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LogAttributeNameDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
