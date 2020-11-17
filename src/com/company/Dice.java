package com.company;
/**
 * This class set a new value for dice
 * @author Tanya Djavaherpour
 * @version 2020
 */

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    //new result for dice
    private int result;
    //a list of forces that can move with this dice value
    private ArrayList<String>  validForces;

    /**
     * Constructs a new dice
     */
    public Dice()
    {
        this.result = 1;
        validForces = new ArrayList<>();
    }

    /**
     * Sets a new random value from 1 to 6
     * @return result as a random number
     */
    public int newDice()
    {
        Random random = new Random ();
        result = random.nextInt(6);
        result++;
        setValidForces(result);
        return result;
    }

    /**
     * sets the list of forces that can move with this dice value
     * @param dice as dice value
     */
    public void setValidForces(int dice)
    {
        if(dice == 1 || dice == 6)
            validForces.add("people");
        else if(dice == 2)
            validForces.add("tank");
        else if(dice == 5)
        {
            validForces.add("people");
            validForces.add("tank");
            validForces.add("gunnery");
        }
    }

    /**
     * returns the list of forces that can move
     * @return validForces
     */
    public ArrayList<String> getValidForces()
    {
        return validForces;
    }

    /**
     * Clears valid forces and make it free for next person in the game
     */
    public void clearDice()
    {
        validForces.clear();
    }
}
