package ru.otus.spring.jpatesting.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@SequenceGenerator(
        name = "person_seq_gen",
        sequenceName = "person_seq",
        initialValue = 1,
        allocationSize = 1
)
@Entity
@Table(name = "person")
public class Person {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "person_seq_gen")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Pet> pets;

    public Person(String name) {
        this.name = name;
    }
}
