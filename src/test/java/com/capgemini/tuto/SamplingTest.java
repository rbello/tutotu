package com.capgemini.tuto;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SamplingTest {

    final int valueMin = 0;
    final int valueMax = 255;

    final int acceptedMin = 15;
    final int acceptedMax = 31;

    @Test
    public void test() {

        // On souhaite vérifier si les valeurs entre [valueMin;valueMax] sont incluses dans [acceptedMin;acceptedMax]
        // On souhaite également ne pas tester TOUTES les valeurs pour des soucis de temps d'exécution des tests.

        // Le bon équilibre va être atteint en échantillonnant nos valeurs à tester.
        // On va avoir besoin d'un générateur aléatoire pour cela.
        var rnd = new Random();

        // On commence par les bornes maximales.
        assertFalse(test(valueMin));
        assertFalse(test(valueMax));

        // Puis la proximité des bornes maximales.
        assertFalse(test(valueMin + 1));
        assertFalse(test(valueMax - 1));

        // Puis les bornes attendues.
        assertTrue(test(acceptedMin));
        assertTrue(test(acceptedMax));

        // Puis une valeur incluse dans les bornes attendues.
        assertTrue(test(rnd.nextInt(acceptedMax - acceptedMin) + acceptedMin));

        // Puis la proximité des bornes attendues.
        assertTrue(test(acceptedMin + 1));
        assertTrue(test(acceptedMax - 1));
        assertFalse(test(acceptedMin - 1));
        assertFalse(test(acceptedMax + 1));

        // Puis une valeur incluse dans la partie inférieure de notre ensemble.
        assertFalse(test(rnd.nextInt(acceptedMin - valueMin) + valueMin));

        // Puis une valeur incluse dans la partie supérieure de notre ensemble.
        assertFalse(test(rnd.nextInt(valueMax - acceptedMax) + acceptedMax));

        // Si on représente graphiquement l'échantillonnage :
        //  [---------[          ]--------------------------]
        //  ^^    ^  ^^^     ^  ^^^           ^            ^^

    }

    private boolean test(int value) {
        return (value >= acceptedMin && value <= acceptedMax);
    }

}
