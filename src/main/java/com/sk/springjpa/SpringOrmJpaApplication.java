package com.sk.springjpa;

import com.sk.springjpa.dao.PersonDao;
import com.sk.springjpa.dao.PersonDaoJdbc;
import com.sk.springjpa.dao.PersonDaoJpa;
import com.sk.springjpa.domain.Animal;
import com.sk.springjpa.domain.Bobr;
import com.sk.springjpa.domain.Person;
import com.sk.springjpa.repository.PersonRepository;
import org.h2.tools.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
public class SpringOrmJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringOrmJpaApplication.class, args);

		String t = "data-jpa";
        switch (t) {
            case "jdbc":
                PersonDao dao = ctx.getBean(PersonDaoJdbc.class);
                System.out.println(dao.count());
                dao.insert(new Person(33, "John", "test"));
                //System.out.println(dao.count());
                //System.out.println(dao.getById(1).getName());
                //dao.getAll().forEach(p -> System.out.println(p.getName()));
                break;
            case "jpa":
                PersonDao dao1 = ctx.getBean(PersonDaoJpa.class);
                int c = 10;
                for (int i = 0; i < c; i++) {
                    dao1.insert(new Person("testentity - " + i));
                }
                System.out.println(dao1.count());
                System.out.println(dao1.getById(1).getName());
                System.out.println(dao1.getById(7).getName());

                List<Person> persons = dao1.getAll();
                System.out.println(persons.toString());
                break;
            case "data-jpa":
                System.out.println("HELLO WORLD");
                PersonRepository repository = ctx.getBean(PersonRepository.class);
                List<Person> person = repository.findAll();
                System.out.println(person.get(0).getName());
                System.out.println(repository.countAllBy());
                break;
            case "other":
                Error err = new Error();
                break;

        }


		try {
			Console.main(args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Autowired
    private PersonRepository repository;

	@PostConstruct
    public void init() {
        repository.save(new Person("Inokentey"));
    }

}

