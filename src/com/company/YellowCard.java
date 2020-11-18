package com.company;
/**
 * Keeps information of green cards
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class YellowCard extends Card{
    private int num;
    public static final String TEXT_YELLOW = "\u001B[33m";
    /**
     * Constructs a new yellow card
     */
    public YellowCard()
    {
        super();
        this.num = 2;
    }
    /**
     * Returns unit number
     * @return num
     */
    @Override
    public int getAttackNum()
    {
        return num;
    }
    /**
     * Sets attack / unit number
     * @param num as unit number
     */
    @Override
    public void setAttackNum(int num)
    {
        super.setAttackNum(num);
    }
    /**
     * Gets name of the card
     * @return yellow
     */
    @Override
    public String getName()
    {
        return "yellow";
    }
    /**
     * Gets color of the card
     * @return yellow
     */
    @Override
    public String getColor()
    {
        return TEXT_YELLOW;
    }
}
