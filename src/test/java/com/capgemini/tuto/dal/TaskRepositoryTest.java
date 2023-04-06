package com.capgemini.tuto.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;

    @Test
    public void testFindByLabel() {
        var item = repository.findByLabel("Test");
        assertTrue(item.isPresent());
        item.ifPresent(task -> {
            assertEquals("Test", task.getLabel());
            assertEquals("Ceci est un test", task.getComment());
            assertEquals(TaskStatus.TODO, task.getStatus());
        });
    }

    @Test
    public void testFindByStatus() {
        var items = repository.findByStatus(TaskStatus.TODO);
        assertEquals(2, items.size());
    }

}
