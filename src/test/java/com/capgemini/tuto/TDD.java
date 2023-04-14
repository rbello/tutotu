package com.capgemini.tuto;

import com.capgemini.tuto.srv.Car;
import com.capgemini.tuto.srv.Orientation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exigences:
 *
 * On souhaite créer un jeu d'action ou le héros principal est un loup. Il est demandé à ce que
 * le loup puisse tourner dans le sens des aiguilles d'une montre (Orientation nord, est, sud
 * et ouest). De plus il est précisé que le loup doit débuter le jeu à la position nord.
 */
public class TDD {

    /**
     * 1. J'écrit mes tests à partir de mes specifications.
     *    A ce stade, l'IDE m'indique des erreurs car je n'ai pas encore créé
     *    les classes Car et Orientation.
     *
     * 2. Je créé les classes Car et Orientation pour rendre le code compilable
     * 3. Je lance mes tests : ils sont en failure, et c'est parfait :)
     *    A cette étape je peux faire un commit et faire une pause café : quand je vais
     *    revenir, je pourrai voir exactement où j'en suis grâce à mes tests.
     */
    @Test
    public void testInitialOrientation() {
        Car car = new Car();
        assertEquals(Orientation.NORTH, car.getOrientation());
    }

    @Test
    public void testRotateOnce() {
        Car car = new Car();
        car.rotate();
        assertEquals(Orientation.EST, car.getOrientation());
    }

    @Test
    public void testRotateLoop() {
        Car car = new Car();
        car.rotate();
        car.rotate();
        car.rotate();
        car.rotate();
        assertEquals(Orientation.NORTH, car.getOrientation());
    }

}
