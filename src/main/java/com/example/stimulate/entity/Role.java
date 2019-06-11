package com.example.stimulate.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/6/6.
 */
public class Role implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
