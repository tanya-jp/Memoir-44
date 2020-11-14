package com.company;

public class River extends Cell{
    public static final String ANSI_BRIGHT_BG_BLUE   = "\u001B[104m";
    public River()
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
        return "river";
    }

    @Override
    public String getColor()
    {
        return ANSI_BRIGHT_BG_BLUE;
    }

    @Override
    public int checkDice(String target, String attacker, int diceNumber)
    {
        diceNumber = 0;
        return diceNumber;
    }
}
