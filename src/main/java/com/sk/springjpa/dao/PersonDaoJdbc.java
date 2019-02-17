package com.sk.springjpa.dao;

import com.sk.springjpa.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Sergey Kuzhel
 */
@Repository
public class PersonDaoJdbc implements PersonDao {
    private final NamedParameterJdbcOperations jdbc;

    private PersonMapper personMapper = new PersonMapper();

    @Autowired
    public PersonDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public Long count() {
        return jdbc.queryForObject("select count(*) from persons", new HashMap<>(), Long.class);
    }

    @Override
    public void insert(Person person) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", person.getId());
        params.put("name", person.getName());
        jdbc.update("insert into persons (id, name) values (:id, :name)", params);
    }

    @Override
    public Person getById(int id) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject("select * from persons where id = :id",
                params, personMapper);
    }

    @Override
    public List<Person> getAll() {
        return jdbc.query("select * from persons", new HashMap<>(),
                personMapper);
    }

    private static class PersonMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Person(id, name);
        }
    }
}
