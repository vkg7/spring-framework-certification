package com.vijay.learn.spring.jdbc;

import com.vijay.learn.spring.jdbc.dao.EmployeeDAO;
import com.vijay.learn.spring.jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class JDBCClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc/spring-application-context-jdbc.xml");

        //Get the EmployeeDAO Bean
        EmployeeDAO employeeDAO = context.getBean("employeeDAO", EmployeeDAO.class);

        //Run some tests for JDBC CRUD operations
        Employee emp = new Employee();
        int rand = new Random().nextInt(1000);
        emp.setId(rand);
        emp.setName("Pooja");
        emp.setRole("Wife");
        employeeDAO.save(emp);

        //Read
        /*Employee emp1 = employeeDAO.getById(56);
        System.out.println("Employee Retrieved::"+emp1);*/


        //Update
       /* Employee emp = new Employee();
        emp.setId(56);
        emp.setRole("CEO");
        emp.setName("Vijay Gupta");
        employeeDAO.update(emp);*/

        //Get All
       /* List<Employee> empList = employeeDAO.getAll();
        System.out.println(empList);*/

        //Delete
        //employeeDAO.deleteById(434);

        System.out.println("DONE");
    }

}
