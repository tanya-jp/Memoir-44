package com.company;

import java.util.ArrayList;

public class Jungle extends Cell implements limitation{
    public static final String ANSI_BG_GREEN  = "\u001B[42m";
    private ArrayList<Integer> forces;
    public Jungle()
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
        return "jungle";
    }

    @Override
    public String getColor()
    {
        return ANSI_BG_GREEN;
    }

    @Override
    public int checkDice(String  target, String  attacker, int diceNumber)
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
