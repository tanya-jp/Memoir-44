package com.company;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome!"+"\n"+"Memoir 44");
        Menu menu = new Menu();
        menu.printMenu();
        PlayGround playGround = new PlayGround();
        Play game = new Play(playGround);
        game.fixGame();
        game.playGame();

    }
}
