package com.company;

public class YellowCard extends Card{
    private int num;
    public static final String TEXT_YELLOW = "\u001B[33m";
    public YellowCard()
    {
        super();
        this.num = 2;
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
        return "yellow";
    }

    @Override
    public String getColor()
    {
        return TEXT_YELLOW;
    }
}
