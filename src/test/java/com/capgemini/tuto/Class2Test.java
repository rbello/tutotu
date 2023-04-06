package com.capgemini.tuto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Class2Test {

    private Class2 instance;

    /**
     * Ce code va se lancer avant chaque test. Il permet d'initialiser/réinitialiser des données.
     */
    @BeforeEach
    public void initializeConfigurations() {
        this.instance = new Class2("X-FLR6", 45.5, 16.9);
    }

    /**
     * Test complet.
     */
    @Test
    public void testLifeCycle() {

        // Test pre-condition
        assertEquals("X-FLR6", this.instance.getName());
        assertEquals(45.5, this.instance.getX(), 0.01);
        assertEquals(16.9, this.instance.getY(), 0.01);

        // Execute function
        Class2.process(this.instance, 1.54);

        // Test post-condition
        assertEquals("X-FLR6", this.instance.getName());
        assertEquals(70.0, this.instance.getX(), 0.1);
        assertEquals(26.0, this.instance.getY(), 0.1);

    }

}
