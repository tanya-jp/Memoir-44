package com.company;

import java.util.ArrayList;
/**
 * Keeps information of cells
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public abstract class Cell{

    /**
     * Returns name of the cell
     */
    abstract String getName();

    /**
     * Returns color of the cell
     */
    abstract String getColor();
    /**
     * Fixes number of dices by checking target and attacker
     * @param target  as target's name
     * @param attacker as attacker's names
     * @param diceNumber as number od dice
     * @return new number of dices
     */
    abstract int checkDice(String target, String attacker, int diceNumber);
}
