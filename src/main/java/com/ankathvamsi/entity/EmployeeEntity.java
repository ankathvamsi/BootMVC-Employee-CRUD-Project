package com.ankathvamsi.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="EMPLOYEE")
@Data
public class EmployeeEntity implements Serializable {

    
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(
            name = "gen1",
            sequenceName = "emp_id_seq",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(
            generator = "gen1",
            strategy = GenerationType.SEQUENCE)
    private Integer empId;

    @Column(length = 20)
    private String ename;

    @Column(length = 20)
    private String job;

    private Float sal;

    private Integer deptno;
    
    
}