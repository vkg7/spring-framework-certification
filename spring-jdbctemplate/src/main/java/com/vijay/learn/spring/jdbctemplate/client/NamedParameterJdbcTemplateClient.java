package com.vijay.learn.spring.jdbctemplate.client;

import com.vijay.learn.spring.jdbctemplate.config.ApplicationConfig;
import com.vijay.learn.spring.jdbctemplate.dao.PersonDAO;
import com.vijay.learn.spring.jdbctemplate.dao.impl.NamedParameterPersonDAOImpl;
import com.vijay.learn.spring.jdbctemplate.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NamedParameterJdbcTemplateClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PersonDAO personDAO = context.getBean(NamedParameterPersonDAOImpl.class);

        System.out.println("List of person is:");

        for (Person p : personDAO.getAllPersons()) {
            System.out.println(p);
        }

        System.out.println("\nGet person with ID ");

        Person personById = personDAO.getPersonById(3L);
        System.out.println(personById);

        System.out.println("\nCreating person: ");
        Person person = new Person(5L, 40, "Vijay", "Gupta");
        System.out.println(person);

        personDAO.createPerson(person);
        System.out.println("\nList of person is:");

        for (Person p : personDAO.getAllPersons()) {
            System.out.println(p);
        }

        System.out.println("\nDeleting person with ID 3");
        personDAO.deletePerson(personById);

        System.out.println("\nUpdate person with ID 4");

        Person pperson = personDAO.getPersonById(4L);
        pperson.setLastName("CHANGED");
        personDAO.updatePerson(pperson);

        System.out.println("\nList of person is:");
        for (Person p : personDAO.getAllPersons()) {
            System.out.println(p);
        }

        context.close();
    }
}
