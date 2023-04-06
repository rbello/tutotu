package com.capgemini.tuto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ZombieSimulatorTest {

    /**
     * Ici on ne teste que le cas nominal !
     */
    @Test
    public void simulateNominal() {
        int newZombies = ZombieSimulator.getZombieNumberAfterDays(10000, 1, 3);
        assertThat(newZombies).isEqualTo(1331);
    }

    /**
     * On peut utiliser des outils comme JUnitParams pour étendre facilement les cas
     * de test sans avoir à dupliquer les méthodes.
     *
     * Mais attention !
     *
     *  Nous venons ici d’ajouter des cas des tests supplémentaires, qui n’ont pas augmenté notre couverture de code :
     *  en effet, ils sont redondants avec les cas précédents, ils n’apportent donc rien de plus.
     *
     *  La situation est même pire que ça :
     *
     *  - Le coût récurrent de maintenance de ce test a été augmenté (si je change l’implémentation de
     *    getZombieNumberAfterDays(), je dois mettre à jour d’autant plus de valeurs de référence de « newZombies »)
     *  - Le test a perdu en clarté : les cas de test intéressants qu’il serait judicieux de mettre en lumière sont
     *    noyés dans un brouhaha de tests identiques
     *  - Le temps d’exécution de mes tests est rallongé
     */
    @ParameterizedTest
    @CsvSource({
            "10000, 1, 3, 1331",   // 3 days after 1 initial zombie in 10000 people
            "10000, 2, 3, 2662",   // 3 days after 2 initial zombies in 10000 people
            "100000, 2, 4, 29282", // 4 days after 2 initial  zombies in 100000 people
            "10000, 0, 3, 0",      // no initial zombies in 10000 people
            "10000, 1, 28, 10001", // 28 days after 1 initial zombie in 10000 people
            "10000, 1, 0, 1",      // 1 zombie and no contamination days in 10000 people
            "10000, 3, 0, 3"       // 3 zombies and no contamination days
    })
    public void simulateAll(int initialPeople, int initialZombies, int days, int finalZombies) {
        int newZombies = ZombieSimulator.getZombieNumberAfterDays(initialPeople, initialZombies, days);
        assertThat(newZombies).isEqualTo(finalZombies);
    }

}
