package com.vijay.learn.spring.jdbctemplate.dao.impl;

import com.vijay.learn.spring.jdbctemplate.dao.PersonDAO;
import com.vijay.learn.spring.jdbctemplate.model.Person;
import com.vijay.learn.spring.jdbctemplate.model.rowmapper.PersonRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NamedParameterPersonDAOImpl implements PersonDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SQL_FIND_PERSON = "select * from people where id = :empId";
    private final String SQL_DELETE_PERSON = "delete from people where id = :empId";
    private final String SQL_UPDATE_PERSON = "update people set first_name = :firstName, last_name = :lastName, age  = :age where id = :empId";
    private final String SQL_GET_ALL = "select * from people";
    private final String SQL_INSERT_PERSON = "insert into people(id, first_name, last_name, age) values(:empId,:firstName,:lastName,:age)";

    public NamedParameterPersonDAOImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public Person getPersonById(Long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("empId", id);
        return namedParameterJdbcTemplate.queryForObject(SQL_FIND_PERSON, namedParameters, new PersonRowMapper());
    }

    @Override
    public List<Person> getAllPersons() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL, new PersonRowMapper());
    }

    @Override
    public boolean deletePerson(Person person) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("empId", person.getId());
        return namedParameterJdbcTemplate.update(SQL_DELETE_PERSON,namedParameters) > 0;
    }

    @Override
    public boolean updatePerson(Person person) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("firstName", person.getFirstName()).addValue("lastName", person.getLastName()).addValue("age", person.getAge()).addValue("empId", person.getId());
        return namedParameterJdbcTemplate.update(SQL_UPDATE_PERSON, namedParameters) > 0;
    }

    @Override
    public boolean createPerson(Person person) {
        Map namedParameters = new HashMap();
        namedParameters.put("empId", person.getId());
        namedParameters.put("firstName", person.getFirstName());
        namedParameters.put("lastName", person.getLastName());
        namedParameters.put("age", person.getAge());
        return namedParameterJdbcTemplate.update(SQL_INSERT_PERSON,namedParameters) > 0;
    }
}
