package com.vijay.learn.spring.jdbctemplate.client;

import com.vijay.learn.spring.jdbctemplate.config.ApplicationConfig;
import com.vijay.learn.spring.jdbctemplate.dao.PersonDAO;
import com.vijay.learn.spring.jdbctemplate.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcTemplateClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PersonDAO personDAO = context.getBean(PersonDAO.class);

        System.out.println("List of person is:");

        for (Person p : personDAO.getAllPersons()) {
            System.out.println(p);
        }

        System.out.println("\nGet person with ID 2");

        Person personById = personDAO.getPersonById(2L);
        System.out.println(personById);

        System.out.println("\nCreating person: ");
        Person person = new Person(4L, 36, "Sergey", "Emets");
        System.out.println(person);

        personDAO.createPerson(person);
        System.out.println("\nList of person is:");

        for (Person p : personDAO.getAllPersons()) {
            System.out.println(p);
        }

        System.out.println("\nDeleting person with ID 2");
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
