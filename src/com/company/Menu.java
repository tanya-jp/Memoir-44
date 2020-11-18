package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Prints information of the game
 * @author Tanya djavaherpour
 * @version 1.0 2020
 */
public class Menu {
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String ANSI_BRIGHT_BG_YELLOW = "\u001B[103m";
    public final String ANSI_BRIGHT_BG_RED    = "\u001B[101m";
    public final String ANSI_BRIGHT_BG_BLUE   = "\u001B[104m";
    public final String ANSI_BG_GREEN  = "\u001B[42m";
    public final String ANSI_BRIGHT_BG_PURPLE = "\u001B[105m";    public void printMenu()
    {
        System.out.println();
        System.out.println(ANSI_BRIGHT_BG_PURPLE);
        System.out.print(TEXT_RESET);
        System.out.println("In this game there are 2 teams: AXIS and ALLIED");
        System.out.println(ANSI_BRIGHT_BG_BLUE);
        System.out.print(TEXT_RESET);
        System.out.println("Axis has 6 groups of tank, 7 groups of people");
        System.out.println("Allied has 3 groups of tanks," +
                " 8 groups of people, 2 groups of gunnery");
        System.out.println(ANSI_BG_GREEN);
        System.out.print(TEXT_RESET);
        System.out.println("Each group has cards:");
        System.out.println("Axis has two cards and Allied has four");
        System.out.println("RULES OF CARDS:");
        System.out.println(TEXT_PURPLE+"6 purple cards. with these cards you have only one order");
        System.out.println(TEXT_YELLOW+"13 yellow cards. 2 orders");
        System.out.println(TEXT_BLUE+"10 blue cards. 3 orders");
        System.out.println(TEXT_GREEN+"6 green cards. 4 orders");
        System.out.println(TEXT_CYAN+"5 cyan cars. 1 order to a group of three"+TEXT_RESET);
        System.out.println(ANSI_BRIGHT_BG_YELLOW);
        System.out.print(TEXT_RESET);
        System.out.println("After killing all members of a group of a team by" +
                "another team, killer team receives a medal");
        System.out.println("First group that receives 6 medals is winner!");
        System.out.println("Another way to wine the game is arriving to specific cell");
        System.out.println(ANSI_BRIGHT_BG_RED);
        System.out.println(TEXT_RESET);
    }
}
