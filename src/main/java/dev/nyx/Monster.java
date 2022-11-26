package dev.nyx;

public class Monster implements Species {


    private String name;
    private int hitpoints = 20;
    private int strength = 3;
    private InventoryItem loot;

    public Monster(String name, int hitpoints, int strength, InventoryItem loot) {
        this.name = name;
        this.hitpoints = hitpoints;
        this.strength = strength;
        this.loot = loot;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int reduceHitpoints(int damage) {

        int newHitpoints;

        newHitpoints = hitpoints - damage;

        if (newHitpoints < 0) {
            newHitpoints = 0;
        }

        hitpoints = newHitpoints;


        return newHitpoints;


    }

    @Override
    public int getHitpoints() {
        return hitpoints;
    }

    public InventoryItem[] collectLoot(InventoryItem[] playerInventory) {

        int arraySize = playerInventory.length + 1;


        InventoryItem[] updatedLoot = new InventoryItem[arraySize];

        for (int i = 0; i <= playerInventory.length; i++) {

            updatedLoot[i] = playerInventory[i];
            System.out.println("Index:" + i);

        }

        updatedLoot[arraySize - 1] = loot;

        return updatedLoot;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Monster " + this.name + " HP: " + this.hitpoints + " Stärke: " + this.strength +
                "\nLoot: Seltenheit: " + this.loot.getRarity() + " Wert: " + this.loot.getValue();
    }
}
