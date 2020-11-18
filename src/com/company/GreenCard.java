package com.company;
/**
 * Keeps information of green cards
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class GreenCard extends Card{
    private int num;
    public static final String TEXT_GREEN = "\u001B[32m";
    /**
     * Constructs a new green card
     */
    public GreenCard()
    {
        super();
        this.num = 4;
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
     * @return green
     */
    @Override
    public String getName()
    {
        return "green";
    }
    /**
     * Gets color of the card
     * @return green
     */
    @Override
    public String getColor()
    {
        return TEXT_GREEN;
    }
}
