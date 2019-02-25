package com.sk.springjpa.domain;

import lombok.*;

import javax.persistence.*;


/**
 * @author Sergey Kuzhel
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "descr")
    private String descr;

    public Person(String name) {
        this.name = name;
    }
}
