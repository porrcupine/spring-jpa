package com.sk.springjpa.repository;

import com.sk.springjpa.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Sergey Kuzhel
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findAll();

    Long countAllBy();
}
