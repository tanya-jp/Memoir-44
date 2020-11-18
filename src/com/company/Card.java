package com.company;
/**
 * Keeps information of cards
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public  abstract class Card {
    private int attackNum;

    /**
     * Constructs a new card
     */
    public Card()
    {}
    /**
     * Returns unit number
     * @return num
     */
    abstract int getAttackNum();
    /**
     * Sets attack / unit number
     * @param attackNum as unit number
     */
    public void setAttackNum(int attackNum)
    {
        this.attackNum = attackNum;
    }
    /**
     * Gets name of the card
     */
    abstract String getName();
    /**
     * Gets color of the card
     */
    abstract String getColor();

}
