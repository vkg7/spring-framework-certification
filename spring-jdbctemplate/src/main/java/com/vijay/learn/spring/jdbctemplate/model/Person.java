package com.vijay.learn.spring.jdbctemplate.model;

/*create table people (
        id serial not null primary key,
        first_name varchar(20) not null,
        last_name varchar(20) not null,
        age integer not null
        );

        insert into people (id, first_name, last_name, age) values
        (1, 'Vlad', 'Boyarskiy', 21),
        (2,'Oksi', ' Bahatskaya', 30),
        (3,'Vadim', ' Vadimich', 32);*/

public class Person {
    private Long id;
    private Integer age;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(Long id, Integer age, String firstName, String lastName) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
