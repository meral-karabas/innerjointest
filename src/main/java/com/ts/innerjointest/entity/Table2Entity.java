package com.ts.innerjointest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Table2Entity {

    @Id
    private String  TBL2;

    private String  idtable1;



    public String getIdtable1() {
        return idtable1;
    }

    public void setIdtable1(String idtable1) {
        this.idtable1 = idtable1;
    }

    public String getTBL2() {
        return TBL2;
    }

    public void setTBL2(String TBL2) {
        this.TBL2 = TBL2;
    }
}
