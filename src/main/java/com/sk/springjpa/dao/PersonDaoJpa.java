package com.sk.springjpa.dao;

import com.sk.springjpa.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Sergey Kuzhel
 */
@Repository
public class PersonDaoJpa implements PersonDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Long count() {
        TypedQuery query = em.createQuery("select count (p.id) from Person p", Long.class);
        return (Long) query.getSingleResult();
    }

    @Override
    @Transactional
    public void insert(Person person) {
        em.persist(person);
    }

    @Override
    public Person getById(int id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }
}
