package com.company;

public class BlueCard extends Card{
    private int num;
    final String TEXT_BLUE = "\u001B[34m";
    public BlueCard()
    {
        super();
        this.num = 3;
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
        return "blue";
    }

    @Override
    public String getColor(){return TEXT_BLUE; }
}
