package com.ts.innerjointest.repository;

import com.ts.innerjointest.entity.Table1Entity;
import com.ts.innerjointest.entity.Table2Entity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Table2Repository extends JpaRepository<Table2Entity, String> {
}
