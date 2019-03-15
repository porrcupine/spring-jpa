package com.sk.springjpa;

import com.sk.springjpa.dao.PersonDaoJpa;
import com.sk.springjpa.domain.Person;
import com.sk.springjpa.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringOrmJpaApplicationTests {

    @Autowired
    PersonDaoJpa dao;

    @Autowired
    PersonRepository repository;

    //@Before
    public void setUpBeforeMethod() {
            int c = 10;
            for (int i = 0; i < c; i++) {
                dao.insert(new Person("test: " + i));
            }
    }

    @Test
    public void getIdTest() {
        List<Person> persons = dao.getAll();
        Assert.assertEquals(2, persons.get(1).getId());
    }

    @Test
    public void countTest() {
        Long count = dao.count();
        Assert.assertNotNull(count);
        System.out.println(count);
    }

    @Test
    public void selectTest() {
        Person person = dao.getById(1);
        Assert.assertNotNull(person);
    }


}

