package com.capgemini.tuto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class Class1Test {

    /**
     * Les fonctions de test
     */
    @Test
    public void testFunctions() {

        // Null/Non-null
        assertNotNull("");
        assertNull(null);

        // Primitives
        assertEquals(0, 0);
        assertEquals("abc", "abc");
        assertEquals(3.14F, 3.14F, 0.01F);

        // Arrays
        org.hamcrest.MatcherAssert.assertThat(
                Class1.split("A|B|C", "\\|"),
                is(Arrays.asList("A", "B", "C"))
        );

    }

    /**
     * Exemple de test où on couvre l'ensemble des cas.
     */
    @Test
    public void testIsValidURL() {

        // Cas nominaux positifs
        assertTrue(Class1.isValidURL("http://www.sample.io"));
        assertTrue(Class1.isValidURL("http://www.sample.io/api/"));
        assertTrue(Class1.isValidURL("http://www.sample.io/index.html"));
        assertTrue(Class1.isValidURL("https://www.sample.io/secured.html"));
        assertTrue(Class1.isValidURL("http://www.sample.io/index.html#hash"));
        assertTrue(Class1.isValidURL("http://www.sample.io/index.html?query=param"));
        assertTrue(Class1.isValidURL("http://www.sample.io//double"));

        // Cas nominaux négatifs
        assertFalse(Class1.isValidURL("ftp://www.sample.io/~bob/"));
        assertFalse(Class1.isValidURL("http//invalid/"));
        assertFalse(Class1.isValidURL("www.invalid.org"));

        // Cas non-nominaux
        assertFalse(Class1.isValidURL(""));
        assertFalse(Class1.isValidURL(null));

    }

    /**
     * Exemple de test où on attend spécifiquement une exception.
     */
    @Test
    public void testCheckNotEmptyKo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Class1.checkNotEmpty("a", "b", null);
        });
    }

}
