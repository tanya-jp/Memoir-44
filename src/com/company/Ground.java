package com.company;

public class Ground extends Cell{
    public static final String ANSI_BG_WHITE  = "\u001B[47m";
    public Ground()
    {
        super();
    }

    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x,y);
    }

    @Override
    public String getName()
    {
        return "ground";
    }

    @Override
    public String getColor()
    {
        return ANSI_BG_WHITE;
    }

    @Override
    public int checkDice(String target, String attacker, int diceNumber)
    {
        return diceNumber;
    }
}
