package com.sk.springjpa;

import com.sk.springjpa.dao.PersonDao;
import com.sk.springjpa.dao.PersonDaoJdbc;
import com.sk.springjpa.dao.PersonDaoJpa;
import com.sk.springjpa.domain.Person;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class SpringOrmJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringOrmJpaApplication.class, args);

		boolean usejdbc = false;
		if (usejdbc) {
			PersonDao dao = ctx.getBean(PersonDaoJdbc.class);
			System.out.println(dao.count());
			dao.insert(new Person(33, "John"));
			System.out.println(dao.count());
			System.out.println(dao.getById(1).getName());
			dao.getAll().forEach(p -> System.out.println(p.getName()));
		} else {
			PersonDao dao1 = ctx.getBean(PersonDaoJpa.class);
            int c = 10;
            for (int i = 0; i < c; i++) {
                dao1.insert(new Person(i + 1, "testentity - " + i));
            }
			//System.out.println(dao1.count());
			System.out.println(dao1.getById(1).getName());
			System.out.println(dao1.getById(7).getName());

            List<Person> persons = dao1.getAll();
            System.out.println(persons.toString());
		}

		try {
			Console.main(args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

