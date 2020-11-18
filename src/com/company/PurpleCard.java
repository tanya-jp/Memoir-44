package com.company;
/**
 * Keeps information of purple cards
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class PurpleCard extends Card{

    private int num;
    public static final String TEXT_PURPLE = "\u001B[35m";
    /**
     * Constructs a new purple card
     */
    public PurpleCard()
    {
        super();
        this.num = 1;
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
     * @return purple
     */
    @Override
    public String getName()
    {
        return "purple";
    }
    /**
     * Gets color of the card
     * @return purple
     */
    @Override
    public String getColor()
    {
        return TEXT_PURPLE;
    }
}
