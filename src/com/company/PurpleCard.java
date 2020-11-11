package com.company;

public class PurpleCard extends Card{

    private int num;
    public static final String TEXT_PURPLE = "\u001B[35m";
    public PurpleCard()
    {
        super();
        this.num = 1;
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
        return "purple";
    }

    @Override
    public String getColor()
    {
        return TEXT_PURPLE;
    }
}
