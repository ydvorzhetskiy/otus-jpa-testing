package ru.otus.spring.jpatesting.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PersonTest {

    @Autowired
    private TestEntityManager em;

    @Commit
    @Test
    void saveAndGet() {
        Person original = new Person("Ivan");
        Person withId = em.persist(original);
        Person fromDb = em.find(Person.class, em.getId(withId));

        assertEquals(original.getName(), fromDb.getName());
    }
}
