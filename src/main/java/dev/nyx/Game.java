package dev.nyx;

import java.util.Scanner;

public class Game {

    // Das ist der Einstiegspunkt in dein Programm
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mögen die Spiele beginnen!");

        while (true){
            //Hiermit liest du eine Konsoleneingabe ein
            String s = scanner.next();

            if(s.equals("quit")){
                break;
            }
        }

        System.out.println("Bis bald...");
        scanner.close();

    }
}