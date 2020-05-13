package com.vijay.learn.spring.hibernate.dao.impl;
/*
Project : spring-framework-certification
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring.hibernate.dao.AbstractDAO;
import com.vijay.learn.spring.hibernate.dao.EmployeeDAO;
import com.vijay.learn.spring.hibernate.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDAOImpl extends AbstractDAO implements EmployeeDAO {

    @Override
    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }

    @Override
    public Employee findBySsn(String ssn) {
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }

    @Override
    public void updateEmployee(Employee employee) {
        getSession().update(employee);
    }
}
