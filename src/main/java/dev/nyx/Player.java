package dev.nyx;

public class Player implements Species {

    public InventoryItem[] inventory = {
            new InventoryItem(Rarity.COMMON, 1),
            new InventoryItem(Rarity.RARE, 2),
            new InventoryItem(Rarity.EPIC, 3),
    };
    private String name;
    private int hitpoints = 100;
    private int strength = 5;
    private int age;


    public Player(int age, String name, int hitpoints, int strength) {
        this.age = age;
        this.hitpoints = hitpoints;
        this.strength = strength;
        this.name = name;

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int reduceHitpoints(int damage) {

        int newHitpoints;

        newHitpoints = hitpoints - damage;

        hitpoints = newHitpoints;

        return newHitpoints;


    }

    @Override
    public int getHitpoints() {
        return hitpoints;
    }

    public void attack(Monster monster) {


        int remainingHitpointsMonster = monster.reduceHitpoints(this.strength);

        if (remainingHitpointsMonster <= 0) {
            System.out.println("Das Monster wurde besiegt!");

            inventory = monster.collectLoot(this.inventory);


        } else {
            System.out.println("Das Monster hat noch " + monster.getHitpoints() + "Leben....");
        }


        int remainingHitpointsPlayer = this.reduceHitpoints(monster.getStrength());

        if (remainingHitpointsPlayer <= 0) {
            System.out.println("Der Spieler wurde besiegt :(");
        } else {
            System.out.println("Der Spieler lebt noch, er hat " + getHitpoints() + " Leben.");
        }


    }


    public int getStrength() {
        return strength;
    }
}
