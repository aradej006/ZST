package com.pw.zst.DTO;

import com.pw.zst.entities.LogRegister;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

/**
 * Created by arade on 24-Oct-15.
 */
public class LogEntityDTO {

    private Long id;
    private Date logDate;
    private LogTypeDTO logTypeDTO;
    private Long sourceId;
    private LogRegisterDTO logRegisterDTO;
    private List<LogAttributeDTO> logAttributeDTOs;

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

    public List<LogAttributeDTO> getLogAttributeDTOs() {
        return logAttributeDTOs;
    }

    public void setLogAttributeDTOs(List<LogAttributeDTO> logAttributeDTOs) {
        this.logAttributeDTOs = logAttributeDTOs;
    }

    @Override
    public String toString() {
        return "LogEntityDTO{" +
                "id=" + id +
                ", logDate=" + logDate +
                ", logTypeDTO=" + logTypeDTO +
                ", sourceId=" + sourceId +
                ", logRegisterDTO=" + logRegisterDTO +
                ", logAttributeDTOs=" + logAttributeDTOs +
                '}';
    }
}
