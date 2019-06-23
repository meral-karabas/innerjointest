package com.ts.innerjointest.controller;

import com.ts.innerjointest.entity.Table1Entity;
import com.ts.innerjointest.entity.Table2Entity;
import com.ts.innerjointest.repository.Table1Repository;
import com.ts.innerjointest.repository.Table2Repository;
import com.ts.innerjointest.response.InnerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@RestController
public class InnerJoinController {

    @GetMapping("/get")
    public ResponseEntity<InnerResponse> get(){
        Query nativeQuery = entityManager.createNativeQuery("SELECT t1.ID,t2.TBL2  FROM TABLE1ENTITY t1 INNER JOIN TABLE2ENTITY t2 ON t1.ID = t2.IDTABLE1", "sqlresultmapping");
        InnerResponse singleResult = (InnerResponse) nativeQuery.getSingleResult();
        return  new ResponseEntity<>(singleResult, HttpStatus.OK);
    }

    @Autowired
    private Table1Repository    repository;

    @Autowired
    private Table2Repository    repository2;

    @PersistenceContext
    private EntityManager   entityManager;

    @PostConstruct
    public void init(){
        Table1Entity table1Entity = new Table1Entity();
        table1Entity.setId("table1-1");

        Table2Entity table2Entity = new Table2Entity();
        table2Entity.setTBL2("table2-1");
        table2Entity.setIdtable1("table1-1");

        repository.saveAndFlush(table1Entity);
        repository2.saveAndFlush(table2Entity);

//        Query nativeQuery = entityManager.createNativeQuery("SELECT t1.ID,t2.TBL2  FROM TABLE1ENTITY t1 INNER JOIN TABLE2ENTITY t2 ON t1.ID = t2.IDTABLE1", "sqlresultmapping");
//        InnerResponse singleResult = (InnerResponse) nativeQuery.getSingleResult();
//        System.out.println(singleResult);
    }

}
