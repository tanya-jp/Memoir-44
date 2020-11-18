package com.company;
/**
 * Keeps information of hill cells
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class Hill extends Cell{
    public static final String ANSI_BG_YELLOW = "\u001B[43m";

    /**
     * Hill constructor
     */
    public Hill()
    {
        super();
    }
    /**
     * Returns name of the cell
     * @return hill
     */
    @Override
    public String getName()
    {
        return "hill";
    }
    /**
     * Returns color of the cell
     * @return yellow
     */
    @Override
    public String getColor()
    {
        return ANSI_BG_YELLOW;
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
        if(attacker.contains("tank") ||
        attacker.contains("people"))
            diceNumber--;
        return diceNumber;
    }
}
