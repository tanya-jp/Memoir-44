package com.company;
/**
 * Keeps information of river cells
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class River extends Cell{
    public static final String ANSI_BRIGHT_BG_BLUE   = "\u001B[104m";

    /**
     * River constructor
     */
    public River()
    {
        super();
    }
    /**
     * Returns name of the cell
     * @return river
     */
    @Override
    public String getName()
    {
        return "river";
    }
    /**
     * Returns color of the cell
     * @return blue
     */
    @Override
    public String getColor()
    {
        return ANSI_BRIGHT_BG_BLUE;
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
        diceNumber = 0;
        return diceNumber;
    }
}
