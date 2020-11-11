package com.company;

public class Haven extends Cell{
    public static final String ANSI_BG_RED    = "\u001B[41m";
    public Haven()
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
        return "haven";
    }

    @Override
    public String getColor()
    {
        return ANSI_BG_RED;
    }
}
