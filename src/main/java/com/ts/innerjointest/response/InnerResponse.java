package com.ts.innerjointest.response;


import javax.persistence.*;

@SqlResultSetMapping(
        name="sqlresultmapping",
        entities={
                @EntityResult(
                        entityClass = InnerResponse.class,
                        fields={
                                @FieldResult(name="tb1",column="ID"),
                                @FieldResult(name="tb2", column="TBL2")})})

@Entity
public class InnerResponse {
    @Id
    private String  tb1;
    private String  tb2;

    public String getTb1() {
        return tb1;
    }

    public void setTb1(String tb1) {
        this.tb1 = tb1;
    }

    public String getTb2() {
        return tb2;
    }

    public void setTb2(String tb2) {
        this.tb2 = tb2;
    }

}