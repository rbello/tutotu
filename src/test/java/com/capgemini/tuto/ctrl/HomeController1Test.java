package com.capgemini.tuto.ctrl;

import com.capgemini.tuto.dto.CreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class HomeController1Test {

    @Autowired
    private HomeController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    /**
     * Test en appelant directement le controller.
     */
    @Test
    public void greeting() {
        assertThat(controller.greeting()).isEqualTo("Hello, World");
    }

    /**
     * Test en appelant directement le controller.
     */
    @Test
    public void create() {
        var dto = new CreateRequest("name", "label", 5L);
        assertDoesNotThrow(() -> controller.create(dto));
    }

    /**
     * Test complet: controller + service + DAO + database
     */
    @Test
    public void getTasks() {
        var tasks = controller.getTasks();
        assertNotNull(tasks);
        assertEquals(4, tasks.size());
    }

}
