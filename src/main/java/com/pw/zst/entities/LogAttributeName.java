package com.pw.zst.entities;

import javax.persistence.*;

/**
 * Created by arade on 28-Oct-15.
 */
@Entity
public class LogAttributeName {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private LogRegister logRegister;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LogRegister getLogRegister() {
        return logRegister;
    }

    public void setLogRegister(LogRegister logRegister) {
        this.logRegister = logRegister;
    }

    @Override
    public String toString() {
        return "LogAttributeName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logRegister=" + logRegister.getName() +
                '}';
    }
}
