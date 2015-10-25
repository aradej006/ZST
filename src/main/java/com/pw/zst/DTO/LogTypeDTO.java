package com.pw.zst.DTO;

/**
 * Created by arade on 25-Oct-15.
 */
public class LogTypeDTO {

    private String logType;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "LogTypeDTO{" +
                "logType='" + logType + '\'' +
                '}';
    }
}
