package com.vijay.learn.spring.hibernate.dao;

import com.vijay.learn.spring.hibernate.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);
}
