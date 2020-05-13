package com.vijay.learn.spring.jdbctemplate.dao;

import com.vijay.learn.spring.jdbctemplate.model.Person;

import java.util.List;

public interface PersonDAO {
    Person getPersonById(Long id);

    List<Person> getAllPersons();

    boolean deletePerson(Person person);

    boolean updatePerson(Person person);

    boolean createPerson(Person person);
}
