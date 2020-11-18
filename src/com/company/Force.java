package com.company;
/**
 * Keeps information of forces
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */

import java.util.ArrayList;

public abstract class Force{
    private int movingNumber;
    //max cells that the force can move
    private int range;

    /**
     * Gets name of the force
     * @return name
     */
    abstract String getName();

    /**
     * Checks if force can move with this number of passed cells
     * @param movingNumber number of passed cells
     * @return true if force can attack
     */
    abstract boolean canAttack(int movingNumber);

    /**
     * Returns max cells that the force can move
     * @return range
     */
    abstract int getRange();

    /**
     * Tells with which distance number the force can attack
     * @return attackRange
     */
    abstract int getAttackRange();

    /**
     * Gets the number of dices that is possible by checking the distance between attacker and target
     * @param distance as the distance between attacker and target
     * @return number of dices
     */
    abstract int getDiceNumber(int distance);

}
