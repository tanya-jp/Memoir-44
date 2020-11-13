package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    private int result;
    private ArrayList<String>  validForces;
    public Dice()
    {
        this.result = 1;
        validForces = new ArrayList<>();
    }

    public int newDice()
    {
        Random random = new Random ();
        result = random.nextInt(6);
        result++;
        setValidForces(result);
        return result;
    }

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

    public ArrayList<String> getValidForces()
    {
        return validForces;
    }

    public void clearDice()
    {
        validForces.clear();
    }
}
