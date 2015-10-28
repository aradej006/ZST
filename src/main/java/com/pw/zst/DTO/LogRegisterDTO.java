package com.pw.zst.DTO;

import java.util.List;

/**
 * Created by aradej on 2015-10-28.
 */
public class LogRegisterDTO {

    private String name;

    private List<LogAttributeNameDTO> logAttributeNameDTOs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LogAttributeNameDTO> getLogAttributeNameDTOs() {
        return logAttributeNameDTOs;
    }

    public void setLogAttributeNameDTOs(List<LogAttributeNameDTO> logAttributeNameDTOs) {
        this.logAttributeNameDTOs = logAttributeNameDTOs;
    }

    @Override
    public String toString() {
        return "LogRegisterDTO{" +
                "name='" + name + '\'' +
                ", logAttributeNameDTOs=" + logAttributeNameDTOs +
                '}';
    }
}
