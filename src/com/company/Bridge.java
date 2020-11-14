package com.company;

public class Bridge extends Cell{
    public static final String ANSI_BRIGHT_BG_WHITE  = "\u001B[107m";
    public Bridge()
    {super();}

    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x,y);
    }

    @Override
    public String getName()
    {
        return "bridge";
    }

    @Override
    public String getColor()
    {
        return ANSI_BRIGHT_BG_WHITE;
    }

    @Override
    public int checkDice(String target, String attacker, int diceNumber)
    {
        return diceNumber;
    }
}
