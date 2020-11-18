package com.company;

import java.util.EnumMap;
/**
 * Keeps information of cyan cards
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class CyanCard extends Card{
    private int num;
    public static final String TEXT_CYAN = "\u001B[36m";
    /**
     * Constructs a new cyan card
     */
    public CyanCard()
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
     * @return cyan
     */
    @Override
    public String getName()
    {
        return "cyan";
    }
    /**
     * Gets color of the card
     * @return cyan
     */
    @Override
    public String getColor()
    {
        return TEXT_CYAN;
    }
}
