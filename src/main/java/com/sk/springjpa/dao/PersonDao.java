package com.sk.springjpa.dao;

import com.sk.springjpa.domain.Person;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sergey Kuzhel
 */
public interface PersonDao {

    Long count();

    void insert(Person person);

    Person getById(int id);

    List<Person> getAll();
}
