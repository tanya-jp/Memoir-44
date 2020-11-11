package com.company;

public class Jungle extends Cell{
    public static final String ANSI_BG_GREEN  = "\u001B[42m";
    public Jungle()
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
        return "jungle";
    }

    @Override
    public String getColor()
    {
        return ANSI_BG_GREEN;
    }
}
