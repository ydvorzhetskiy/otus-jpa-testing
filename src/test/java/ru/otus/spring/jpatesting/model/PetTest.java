package ru.otus.spring.jpatesting.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PetTest {

    @Autowired
    private TestEntityManager em;

    private final Person person = new Person("Ivan");

    @Commit
    @Test
    void saveAndGet() {
        em.persist(person);
        Pet original = new Pet("Murka", person);
        Pet fromDb = em.persistFlushFind(original);

        assertEquals(original.getName(), fromDb.getName());
    }

    @Commit
    @Test
    void savePetAndGetPerson() {
        em.persist(person);
        Pet originalPet = new Pet("Zhuchka", person);
        em.persistAndFlush(originalPet);
        Person ownerFromDb = em.refresh(person);

        assertEquals(1, ownerFromDb.getPets().size());
    }
}
