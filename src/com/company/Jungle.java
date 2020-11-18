package com.company;
/**
 * Keeps information of jungle cells
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
import java.util.ArrayList;

public class Jungle extends Cell implements limitation{
    public static final String ANSI_BG_GREEN  = "\u001B[42m";
    private ArrayList<Integer> forces;
    public Jungle()
    {
        super();
        forces = new ArrayList<>();
    }
    /**
     * Returns name of the cell
     * @return jungle
     */
    @Override
    public String getName()
    {
        return "jungle";
    }

    /**
     * Returns color of the cell
     * @return green
     */
    @Override
    public String getColor()
    {
        return ANSI_BG_GREEN;
    }

    /**
     * Fixes number of dices by checking target and attacker
     * @param target  as target's name
     * @param attacker as attacker's names
     * @param diceNumber as number od dice
     * @return new number of dices
     */
    @Override
    public int checkDice(String  target, String  attacker, int diceNumber)
    {
        if(attacker.contains("tank"))
            diceNumber -= 2;
        else if(attacker.contains("people"))
            diceNumber--;
        return diceNumber;
    }
    /**
     * Checks if this cell is jungle
     * @param location as location of cell
     * @return true if this cell is jungle
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
