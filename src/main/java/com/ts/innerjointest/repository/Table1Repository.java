package com.ts.innerjointest.repository;

import com.ts.innerjointest.entity.Table1Entity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Table1Repository extends JpaRepository<Table1Entity, String> {
}
