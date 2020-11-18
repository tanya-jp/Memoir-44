package com.company;
/**
 * Keeps information of haven cells
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class Haven extends Cell{
    public static final String ANSI_BG_RED    = "\u001B[41m";
    public Haven()
    {
        super();
    }

    /**
     * Returns name of the cell
     * @return haven
     */
    @Override
    public String getName()
    {
        return "haven";
    }
    /**
     * Returns color of the cell
     * @return red
     */
    @Override
    public String getColor()
    {
        return ANSI_BG_RED;
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
        if(target.contains("A "))
        {
            if(attacker.contains("tank"))
                diceNumber -= 2;
            else if (attacker.contains("people"))
                diceNumber--;
        }
        return diceNumber;
    }
}
