package com.pw.zst.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by arade on 25-Oct-15.
 */
@Entity
public class LogType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String logType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "LogType{" +
                "id=" + id +
                ", logType='" + logType + '\'' +
                '}';
    }
}
