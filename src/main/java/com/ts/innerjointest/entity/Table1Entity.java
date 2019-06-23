package com.ts.innerjointest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Table1Entity {

    @Id
    private String  id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
