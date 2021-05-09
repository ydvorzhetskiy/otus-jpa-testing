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
        Pet withId = em.persist(original);
        Pet fromDb = em.find(Pet.class, em.getId(withId));

        assertEquals(original.getName(), fromDb.getName());
    }
}
