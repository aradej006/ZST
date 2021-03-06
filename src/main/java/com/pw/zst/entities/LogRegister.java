package com.pw.zst.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by arade on 25-Oct-15.
 */
@Entity
public class LogRegister {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logRegister")
    private List<LogAttributeName> attributeNames;

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

    public List<LogAttributeName> getAttributeNames() {
        return attributeNames;
    }

    public void setAttributeNames(List<LogAttributeName> attributeNames) {
        this.attributeNames = attributeNames;
    }

    @Override
    public String toString() {
        return "LogRegister{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attributeNames=" + attributeNames +
                '}';
    }
}
