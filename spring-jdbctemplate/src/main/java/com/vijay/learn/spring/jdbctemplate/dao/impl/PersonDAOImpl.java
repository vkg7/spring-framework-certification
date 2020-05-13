package com.vijay.learn.spring.jdbctemplate.dao.impl;

import com.vijay.learn.spring.jdbctemplate.dao.PersonDAO;
import com.vijay.learn.spring.jdbctemplate.model.Person;
import com.vijay.learn.spring.jdbctemplate.model.rowmapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_PERSON = "select * from people where id = ?";
    private final String SQL_DELETE_PERSON = "delete from people where id = ?";
    private final String SQL_UPDATE_PERSON = "update people set first_name = ?, last_name = ?, age  = ? where id = ?";
    private final String SQL_GET_ALL = "select * from people";
    private final String SQL_INSERT_PERSON = "insert into people(id, first_name, last_name, age) values(?,?,?,?)";

    //@Autowired
    public PersonDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Person getPersonById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new PersonRowMapper());
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query(SQL_GET_ALL, new PersonRowMapper());
    }

    @Override
    public boolean deletePerson(Person person) {
        return jdbcTemplate.update(SQL_DELETE_PERSON, person.getId()) > 0;
    }

    @Override
    public boolean updatePerson(Person person) {
        return jdbcTemplate.update(SQL_UPDATE_PERSON, person.getFirstName(), person.getLastName(), person.getAge(),
                person.getId()) > 0;
    }

    @Override
    public boolean createPerson(Person person) {
        return jdbcTemplate.update(SQL_INSERT_PERSON, person.getId(), person.getFirstName(), person.getLastName(),
                person.getAge()) > 0;
    }
}
