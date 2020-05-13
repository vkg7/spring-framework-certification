package com.vijay.learn.spring.hibernate.client;
/*
Project : spring-framework-certification
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.spring.hibernate.config.SpringHibernateApplicationJavaConfig;
import com.vijay.learn.spring.hibernate.model.Employee;
import com.vijay.learn.spring.hibernate.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SpringHibernateClient {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringHibernateApplicationJavaConfig.class);

        EmployeeService service = (EmployeeService) context.getBean("employeeService");

        /*
         * Create Employee1
         */
        Employee employee1 = new Employee();
        employee1.setName("Amar");
        employee1.setRole("Developer");
        employee1.setJoiningDate(LocalDateTime.now());
        employee1.setSalary(new BigDecimal(10000));
        employee1.setSsn("ssn00000003");

        /*
         * Create Employee2
         */
        Employee employee2 = new Employee();
        employee2.setName("Vijay Gupta");
        employee2.setRole("Technical Lead");
        employee2.setJoiningDate(LocalDateTime.now());
        employee2.setSalary(new BigDecimal(20000));
        employee2.setSsn("ssn00000002");

        /*
         * Persist both Employees
         */
        service.saveEmployee(employee1);
        service.saveEmployee(employee2);

        /*
         * Get all employees list from database
         */
        List<Employee> employees = service.findAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        /*
         * delete an employee
         */
        service.deleteEmployeeBySsn("ssn00000003");

        /*
         * update an employee
         */

        Employee employee = service.findBySsn("ssn00000001");
        employee.setSalary(new BigDecimal(50000));
        service.updateEmployee(employee);

        /*
         * Get all employees list from database
         */
        List<Employee> employeeList = service.findAllEmployees();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        context.close();
    }
}
