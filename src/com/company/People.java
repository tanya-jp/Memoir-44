package com.company;
/**
 * Keeps information of people forces
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */
public class People extends Force{
    private int movingNumber;
    private int range;
    private int attackRange;

    /**
     * Constructs the new people
     */
    public People()
    {
        super();
        this.range = 2;
        this.attackRange = 3;
    }
    /**
     * Gets name of the force
     * @return people
     */
    @Override
    public String getName()
    {
        return "people";
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
        {
            System.out.println("YOU CAN ATTACK");
            return true;
        }
        else
            return false;
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
        if(distance == 1)
            return 3;
        else if(distance == 2)
            return 2;
        else
            return 1;
    }
}
