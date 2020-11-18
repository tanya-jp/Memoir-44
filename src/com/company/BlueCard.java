package com.company;

/**
 * Keeps information of blue cards
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class BlueCard extends Card{
    //units number
    private int num;
    //card color
    public static final String TEXT_BLUE = "\u001B[34m";

    /**
     * Constructs a new blue card
     */
    public BlueCard()
    {
        super();
        this.num = 3;
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
     * @return blue
     */
    @Override
    public String getName()
    {
        return "blue";
    }

    /**
     * Gets color of the card
     * @return blue
     */
    @Override
    public String getColor(){return TEXT_BLUE; }
}
