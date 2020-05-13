package com.vijay.learn.spring.hibernate.service.impl;
/*
Project : spring-framework-certification
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring.hibernate.dao.EmployeeDAO;
import com.vijay.learn.spring.hibernate.model.Employee;
import com.vijay.learn.spring.hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        employeeDAO.deleteEmployeeBySsn(ssn);
    }

    @Override
    public Employee findBySsn(String ssn) {
        return employeeDAO.findBySsn(ssn);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }
}
