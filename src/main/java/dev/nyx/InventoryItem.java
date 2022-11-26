package dev.nyx;

public class InventoryItem {

    private Rarity rarity;

    private int value;

    public InventoryItem(Rarity rarity, int value) {
        this.rarity = rarity;
        this.value = value;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getValue() {
        return value;
    }
}
