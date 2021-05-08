package ru.otus.spring.jpatesting.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@SequenceGenerator(
        name = "pet_seq_gen",
        sequenceName = "pet_seq",
        initialValue = 1,
        allocationSize = 1
)
@Entity
@Table(name = "pet")
public class Pet {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "pet_seq_gen")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "owner_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person owner;
}
