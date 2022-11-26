package dev.nyx;

import java.util.Random;
import java.util.Scanner;

public class Game {


    // Das ist der Einstiegspunkt in dein Programm
    public static void main(String[] args) {

        Player player = new Player(
                20,
                "Philipp G.",
                200,
                12
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mögen die Spiele beginnen!");

        boolean isActive = true;


        while (isActive) {
            //Hiermit liest du eine Konsoleneingabe ein
            String s = scanner.next();

            Random random = new Random();

            //FixMe: Fehler ;)
            Monster monster = null;

            if (s.equals("quit")) {
                isActive = false;
            } else if (s.equals("inventory")) {

                InventoryItem[] playInventory = player.inventory;


                int totalValue = 0;

                try {
                    for (InventoryItem entry : playInventory) {
                        System.out.println("Seltenheit: " + entry.getRarity() + " - Wert: " + entry.getValue());

                        totalValue = totalValue + entry.getValue();
                    }

                    System.out.println("Summe: " + totalValue);
                } catch (NullPointerException e) {
                    System.out.println("Hey! Dein Inventar ist noch leer.");
                }


            } else if (s.equals("move")) {

                int randomNumber = random.nextInt(5);

                String[] names = {
                        "Nico", "Raphael", "Annika", "Felix", "Mihaela", "Timm", "Sebastian Stumpff"
                };


                monster = new Monster(
                        names[randomNumber],
                        randomNumber * randomNumber,
                        randomNumber,
                        new InventoryItem(Rarity.COMMON, randomNumber * 2)
                );


                System.out.println("Oh Nein! Ein Monster scheint!\n" + monster.toString());

            } else if (s.equals("attack")) {

                if (monster == null) {
                    System.out.println("Bist du blind?? Da ist kein Monster! Bewege dich weiter.");
                    continue;
                }

                int remainingHitpointMonster = monster.reduceHitpoints(player.getStrength());

                if (remainingHitpointMonster <= 0) {
                    player.inventory = monster.collectLoot(player.inventory);
                }

            }
        }

        System.out.println("Bis bald...");
        scanner.close();

    }
}