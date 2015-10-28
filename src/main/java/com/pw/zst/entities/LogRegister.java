package com.pw.zst.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by arade on 25-Oct-15.
 */
@Entity
public class LogRegister {

    @Id
    @GeneratedValue
    private Long id;

    private String registerName;

    private int attributsQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registryName) {
        this.registerName = registryName;
    }

    public int getAttributsQuantity() {
        return attributsQuantity;
    }

    public void setAttributsQuantity(int attributsQuantity) {
        this.attributsQuantity = attributsQuantity;
    }

    @Override
    public String toString() {
        return "LogRegister{" +
                "id=" + id +
                ", registryName='" + registerName + '\'' +
                ", attributsQuantity=" + attributsQuantity +
                '}';
    }
}
