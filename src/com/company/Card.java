package com.company;

public  abstract class Card {
    private int attackNum;
    public Card()
    {}

    abstract int getAttackNum();

    public void setAttackNum(int attackNum)
    {
        this.attackNum = attackNum;
    }

    abstract String getName();

    abstract String getColor();

}
