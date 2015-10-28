package com.pw.zst.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by arade on 24-Oct-15.
 */
@Entity
public class LogEntity implements Serializable, Cloneable{

    @Id
    @GeneratedValue
    private Long id;
    private Date logDate;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private LogType logType;

    private Long sourceId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "logEntity")
    private List<LogAttribute> logAttributes;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private LogRegister logRegister;

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

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public List<LogAttribute> getLogAttributes() {
        return logAttributes;
    }

    public void setLogAttributes(List<LogAttribute> logAttributes) {
        this.logAttributes = logAttributes;
    }

    public LogRegister getLogRegister() {
        return logRegister;
    }

    public void setLogRegister(LogRegister logRegister) {
        this.logRegister = logRegister;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "id=" + id +
                ", logDate=" + logDate +
                ", logType=" + logType +
                ", sourceId=" + sourceId +
                ", logAttributes=" + logAttributes +
                ", logRegister=" + logRegister +
                '}';
    }
}
