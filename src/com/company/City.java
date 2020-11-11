package com.company;

import java.util.ArrayList;

public class City extends Cell{
    private ArrayList<Integer> loc;
    public static final String ANSI_BG_PURPLE = "\u001B[45m";
    public City()
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
        return "city";
    }

    @Override
    public String getColor()
    {
        return ANSI_BG_PURPLE;
    }
}
