package com.company;
/**
 * Keeps information of gunnery forces
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class Gunnery extends Force{
    private int range;
    private int attackRange;

    /**
     * Constructs a new gunnery
     */
    public Gunnery()
    {
        super();
        this.range = 1;
        this.attackRange = 6;
    }
    /**
     * Gets name of the force
     * @return gunnery
     */
    @Override
    public String getName()
    {
        return "gunnery";
    }
    /**
     * Checks if force can move with this number of passed cells
     * @param movingNumber number of passed cells
     * @return true if force can attack
     */
    @Override
    public boolean canAttack(int movingNumber)
    {
        if(movingNumber == 1)
            return false;
        else
        {
            System.out.println("YOU CAN ATTACK");
            return true;
        }
    }
    /**
     * Returns max cells that the force can move
     * @return range
     */
    @Override
    public int getRange()
    {
        return range;
    }
    /**
     * Tells with which distance number the force can attack
     * @return attackRange
     */
    @Override
    public int getAttackRange()
    {
        return attackRange;
    }
    /**
     * Gets the number of dices that is possible by checking the distance between attacker and target
     * @param distance as the distance between attacker and target
     * @return number of dices
     */
    @Override
    public int getDiceNumber(int distance)
    {
        if(distance == 1 || distance == 2)
            return 3;
        else if(distance == 3 || distance == 4)
            return 2;
        else
            return 1;
    }
}
