package com.company;

public class Hill extends Cell{
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public Hill()
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
        return "hill";
    }

    @Override
    public String getColor()
    {
        return ANSI_BG_YELLOW;
    }
}
