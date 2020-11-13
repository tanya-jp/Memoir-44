package com.company;

import java.util.ArrayList;

public abstract class Force extends Location{
    private int movingNumber;
    private int range;
    public Force()
    {
        super();
    }

    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x,y);
    }

    abstract String getName();

    abstract boolean canAttack(int movingNumber);

    abstract int getRange();

    abstract int getAttackRange();

    abstract int getDiceNumber(int distance);

}
