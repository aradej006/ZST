package com.pw.zst.entities;

import javax.persistence.*;

/**
 * Created by arade on 25-Oct-15.
 */
@Entity
public class LogRegister {

    @Id
    @GeneratedValue
    private Long id;

    private String registerName;

    private int attributesQuantity;

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

    public int getAttributesQuantity() {
        return attributesQuantity;
    }

    public void setAttributesQuantity(int attributesQuantity) {
        this.attributesQuantity = attributesQuantity;
    }

    @Override
    public String toString() {
        return "LogRegister{" +
                "id=" + id +
                ", registerName='" + registerName + '\'' +
                ", attributesQuantity=" + attributesQuantity +
                '}';
    }
}
