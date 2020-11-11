package com.company;

public class GreenCard extends Card{
    private int num;
    public static final String TEXT_GREEN = "\u001B[32m";
    public GreenCard()
    {
        super();
        this.num = 4;
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
        return "green";
    }

    @Override
    public String getColor()
    {
        return TEXT_GREEN;
    }
}
