package com.ankathvamsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankathvamsi.entity.EmployeeEntity;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
