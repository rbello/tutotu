package com.capgemini.tuto;

public class ZombieSimulator {

    /**
     * @param initialPeople Nombre initial de personnes en bonne santé
     * @param initialZombies Nombre initial de zombies
     * @param days Nombre de jours de la simulation
     * @return Nombre de zombies infectés à la fin de la simulation
     */
    public static int getZombieNumberAfterDays(int initialPeople, int initialZombies, int days) {
        int currentPeople = initialPeople;
        int currentZombies = initialZombies;

        for (int day = 0; day < days; day++) {
            // Chaque jour un zombie contamine 10 personnes
            int newZombies = Math.min(currentZombies * 10, currentPeople);
            currentZombies = currentZombies + newZombies;
            currentPeople = currentPeople - newZombies;
        }
        return currentZombies;
    }

}
