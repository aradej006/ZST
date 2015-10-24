package com.pw.zst.DTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

/**
 * Created by arade on 24-Oct-15.
 */
@Named
@RequestScoped
public class LogEntityDTO {

    private Long id;

    private Date logDate;

    private String logType;

    private String atr1;

    private String atr2;

    private String atr3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getAtr1() {
        return atr1;
    }

    public void setAtr1(String atr1) {
        this.atr1 = atr1;
    }

    public String getAtr2() {
        return atr2;
    }

    public void setAtr2(String atr2) {
        this.atr2 = atr2;
    }

    public String getAtr3() {
        return atr3;
    }

    public void setAtr3(String atr3) {
        this.atr3 = atr3;
    }
}
