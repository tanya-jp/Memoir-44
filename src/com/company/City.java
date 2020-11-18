package com.company;
/**
 * Keeps information of city cells
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */

import java.util.ArrayList;

public class City extends Cell implements limitation{
    private ArrayList<Integer> loc;
    public static final String ANSI_BG_PURPLE = "\u001B[45m";
    private ArrayList<Integer> forces;

    /**
     * City constructor
     */
    public City()
    {
        super();
        forces = new ArrayList<>();
    }

    /**
     * Returns name of the cell
     * @return city
     */
    @Override
    public String getName()
    {
        return "city";
    }
    /**
     * Returns color of the cell
     * @return purple
     */
    @Override
    public String getColor()
    {
        return ANSI_BG_PURPLE;
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
        if(attacker.contains("tank"))
            diceNumber -= 2;
        else if(attacker.contains("people"))
            diceNumber--;
        return diceNumber;
    }

    /**
     * Checks if this cell is city
     * @param location as location of cell
     * @return true if this cell is city
     **/
    @Override
    public boolean check(int location)
    {
        if(forces.contains(location))
            return true;
        else
            forces.add(location);
        return false;
    }
}
