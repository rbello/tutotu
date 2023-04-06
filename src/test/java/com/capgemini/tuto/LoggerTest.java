package com.capgemini.tuto;

import ch.qos.logback.classic.Level;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoggerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger("MyLogger");

    @Test
    public void test() {
        LOGGER.info("Process started...");
        LOGGER.info("Step 1: success");
        LOGGER.info("Step 2: success");
        LOGGER.info("Step 3: failure");
        LOGGER.error("Error: file not found");
        LOGGER.info("Process finished...");

        assertTrue(TestAppender.getInstance().contains("Step 3"));
        assertFalse(TestAppender.getInstance().contains("Step 4"));
        assertFalse(TestAppender.getInstance().contains(Level.INFO, "file not found"));
        assertTrue(TestAppender.getInstance().contains(Level.ERROR, "file not found"));

        assertEquals(1, TestAppender.getInstance().count(Level.ERROR, "file not found"));
    }

}
