package com.stackroute.springdao.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.springdao.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements IEmployeeDAO {

	//JDBC Template
	//HibernateTemplate
	
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public  EmployeeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean saveEmployee(Employee employee) {
		
		try {
			this.sessionFactory.getCurrentSession().save(employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
			return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
		
	}

	@Override
	public boolean deleteEmployee(int empId) {
		try {
		Employee employee = 	this.sessionFactory.getCurrentSession().load(Employee.class, empId);
		this.sessionFactory.getCurrentSession().delete(employee);
		return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
