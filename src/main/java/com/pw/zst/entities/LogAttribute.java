package com.pw.zst.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by aradej on 2015-10-28.
 */
@Entity
public class LogAttribute {

    @Id
    @GeneratedValue
    private Long id;

    private String value;

    @ManyToOne
    private LogEntity logEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LogEntity getLogEntity() {
        return logEntity;
    }

    public void setLogEntity(LogEntity logEntity) {
        this.logEntity = logEntity;
    }

    @Override
    public String toString() {
        return "LogAttribute{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", logEntity=" + logEntity.getSourceId() +
                '}';
    }
}
