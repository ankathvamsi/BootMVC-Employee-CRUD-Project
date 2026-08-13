package com.ankathvamsi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankathvamsi.entity.EmployeeEntity;
import com.ankathvamsi.error.EmployeeNotFoundException;
import com.ankathvamsi.repository.IEmployeeRepository;
import com.ankathvamsi.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
		final IEmployeeRepository repo;
	public EmployeeServiceImpl(IEmployeeRepository repo) {
		this.repo=repo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String registerEmployee(EmployeeVO vo) {
		// TODO Auto-generated method stub
		EmployeeEntity entity=new EmployeeEntity();
		BeanUtils.copyProperties(vo, entity);
		repo.save(entity).getEmpId();
		return "Employee Registered Successfully with EmpId:: "+entity.getEmpId();
	}

	@Override
	public EmployeeVO showEmployeeById(int id) {
		EmployeeEntity entity=repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Invalid User Id"));
		
		EmployeeVO vo=new EmployeeVO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}

	@Override
	public List<EmployeeVO> showAllEmployees() {
		List<EmployeeEntity> listOfEntities=repo.findAll();
		List<EmployeeVO> listOfVos=new ArrayList<EmployeeVO>();
		
		listOfEntities.forEach((entity)->{
			EmployeeVO vo=new EmployeeVO();//vo is an object
			BeanUtils.copyProperties(entity, vo);
			listOfVos.add(vo);
		});
		return listOfVos;
	}

	@Override
	public String deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Invalid Id"));
		repo.deleteById(id);
		return "Employee Deleted with Id value:: "+id;
	}

	//This one is important
	@Override
	public String updateEmployee(EmployeeVO vo) {
		EmployeeEntity entity=repo.findById(vo.getEmpId()).orElseThrow(()->new EmployeeNotFoundException("Invalid User Id"));	//finding the record which you want to edit
		BeanUtils.copyProperties(vo, entity);//copying vo object to enity
		repo.save(entity);//saving the updated/edited entity to the database
		
		return "Employee Saved with id valued: "+entity.getEmpId();
	}
	
	

}
