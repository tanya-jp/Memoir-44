package com.company;
/**
 * Keeps information of bridge cells
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class Bridge extends Cell{
    public static final String ANSI_BRIGHT_BG_WHITE  = "\u001B[107m";

    /**
     * Bridge constructor
     */
    public Bridge()
    {super();}
    /**
     * Returns name of the cell
     * @return bridge
     */
    @Override
    public String getName()
    {
        return "bridge";
    }
    /**
     * Returns color of the cell
     * @return black
     */
    @Override
    public String getColor()
    {
        return ANSI_BRIGHT_BG_WHITE;
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
