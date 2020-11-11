package com.company;

import java.util.EnumMap;

public class CyanCard extends Card{
    private int num;
    private int units;
    public static final String TEXT_CYAN = "\u001B[36m";
    public CyanCard()
    {
        super();
        this.num = 1;
        this.units = 3;
    }

    public int getUnits()
    {
        return units;
    }

    @Override
    public int getAttackNum()
    {
        return num;
    }

    @Override
    public void setAttackNum(int num)
    {
        super.setAttackNum(num);
    }

    @Override
    public String getName()
    {
        return "cyan";
    }

    @Override
    public String getColor()
    {
        return TEXT_CYAN;
    }
}
