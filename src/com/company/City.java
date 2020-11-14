package com.company;

import java.util.ArrayList;

public class City extends Cell implements limitation{
    private ArrayList<Integer> loc;
    public static final String ANSI_BG_PURPLE = "\u001B[45m";
    private ArrayList<Integer> forces;
    public City()
    {
        super();
        forces = new ArrayList<>();
    }

    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x,y);
    }

    @Override
    public String getName()
    {
        return "city";
    }

    @Override
    public String getColor()
    {
        return ANSI_BG_PURPLE;
    }

    @Override
    public int checkDice(String target, String attacker, int diceNumber)
    {
        if(attacker.contains("tank"))
            diceNumber -= 2;
        else if(attacker.contains("people"))
            diceNumber--;
        return diceNumber;
    }

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
