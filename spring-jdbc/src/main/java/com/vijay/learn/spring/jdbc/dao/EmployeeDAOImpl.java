package com.vijay.learn.spring.jdbc.dao;

import com.vijay.learn.spring.jdbc.model.Employee;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Employee employee) {
        String insertStatement = "insert into Employee (id, name, role) values (?,?,?)";
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(insertStatement);) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getRole());
            int out = preparedStatement.executeUpdate();
            if(out !=0){
                System.out.println("Employee saved for id = "+employee.getId());
            }else
                System.out.println("Employee save failed for id = "+employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(int id) {
        String selectById = "select name, role from Employee where id = ?";
        Employee emp = null;
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(selectById);) {
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                emp = new Employee();
                emp.setId(id);
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                System.out.println("Employee Found::"+emp);
            }else{
                System.out.println("No Employee found with id="+id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public void update(Employee employee) {
        String query = "update Employee set name=?, role=? where id=?";
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(query);) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getRole());
            preparedStatement.setInt(3, employee.getId());
            int out = preparedStatement.executeUpdate();
            if(out !=0){
                System.out.println("Employee updated for  id = "+employee.getId());
            }else
                System.out.println("No Employee found for  id = "+employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from Employee where id=?";
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            int out = preparedStatement.executeUpdate();
            if(out !=0){
                System.out.println("Employee deleted for id = "+id);
            }else
                System.out.println("No Employee found for id = "+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        String query = "select id, name, role from Employee";
        List<Employee> empList = new ArrayList<Employee>();

        ResultSet rs = null;
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(query);) {
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                empList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }
}
