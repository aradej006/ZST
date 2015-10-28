package com.pw.zst.DTO;

import com.pw.zst.entities.LogRegister;

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

    private LogTypeDTO logTypeDTO;

    private Long sourceId;

    private LogRegisterDTO logRegisterDTO;

    private String atr1;

    private String atr2;

    private String atr3;
    private String atr4;
    private String atr5;
    private String atr6;
    private String atr7;
    private String atr8;
    private String atr9;
    private String atr10;

    @Override
    public String toString() {
        return "LogEntityDTO{" +
                "id=" + id +
                ", logDate=" + logDate +
                ", logTypeDTO=" + logTypeDTO +
                ", sourceId=" + sourceId +
                ", logRegisterDTO=" + logRegisterDTO +
                ", atr1='" + atr1 + '\'' +
                ", atr2='" + atr2 + '\'' +
                ", atr3='" + atr3 + '\'' +
                ", atr4='" + atr4 + '\'' +
                ", atr5='" + atr5 + '\'' +
                ", atr6='" + atr6 + '\'' +
                ", atr7='" + atr7 + '\'' +
                ", atr8='" + atr8 + '\'' +
                ", atr9='" + atr9 + '\'' +
                ", atr10='" + atr10 + '\'' +
                '}';
    }

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

    public LogTypeDTO getLogTypeDTO() {
        return logTypeDTO;
    }

    public void setLogTypeDTO(LogTypeDTO logTypeDTO) {
        this.logTypeDTO = logTypeDTO;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public LogRegisterDTO getLogRegisterDTO() {
        return logRegisterDTO;
    }

    public void setLogRegisterDTO(LogRegisterDTO logRegisterDTO) {
        this.logRegisterDTO = logRegisterDTO;
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

    public String getAtr4() {
        return atr4;
    }

    public void setAtr4(String atr4) {
        this.atr4 = atr4;
    }

    public String getAtr5() {
        return atr5;
    }

    public void setAtr5(String atr5) {
        this.atr5 = atr5;
    }

    public String getAtr6() {
        return atr6;
    }

    public void setAtr6(String atr6) {
        this.atr6 = atr6;
    }

    public String getAtr7() {
        return atr7;
    }

    public void setAtr7(String atr7) {
        this.atr7 = atr7;
    }

    public String getAtr8() {
        return atr8;
    }

    public void setAtr8(String atr8) {
        this.atr8 = atr8;
    }

    public String getAtr9() {
        return atr9;
    }

    public void setAtr9(String atr9) {
        this.atr9 = atr9;
    }

    public String getAtr10() {
        return atr10;
    }

    public void setAtr10(String atr10) {
        this.atr10 = atr10;
    }
}
