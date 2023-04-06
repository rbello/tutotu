package com.capgemini.tuto.ctrl;

import com.capgemini.tuto.dto.CreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class HomeControllerTest1 {

    @Autowired
    private HomeController controller;

    @Test
    public void contextLoads() throws Exception {
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

}
