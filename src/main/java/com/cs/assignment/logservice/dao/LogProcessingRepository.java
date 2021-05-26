package com.cs.assignment.logservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.assignment.logservice.model.ServerLogBean;

@Repository
public interface LogProcessingRepository extends JpaRepository<ServerLogBean, String> {

}
