package com.company;

import java.util.ArrayList;

public abstract class Cell extends Location{

    public Cell()
    {
        super();
    }

    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x,y);
    }

    abstract String getName();

    abstract String getColor();
}
