package com.company;
/**
 * Keeps information of ground cells
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class Ground extends Cell{
    public static final String ANSI_BG_WHITE  = "\u001B[47m";

    /**
     * Ground constructor
     */
    public Ground()
    {
        super();
    }

    /**
     * Returns name of the cell
     * @return ground
     */
    @Override
    public String getName()
    {
        return "ground";
    }
    /**
     * Returns color of the cell
     * @return white
     */
    @Override
    public String getColor()
    {
        return ANSI_BG_WHITE;
    }
    /**
     * Fixes number of dices by checking target and attacker
     * @param target  as target's name
     * @param attacker as attacker's names
     * @param diceNumber as number od dice
     * @return new number of dices
     */
    @Override
    public int checkDice(String target, String attacker, int diceNumber)
    {
        return diceNumber;
    }
}
