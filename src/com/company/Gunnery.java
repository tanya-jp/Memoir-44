package com.company;

public class Gunnery extends Force{
    private int range;
    private int attackRange;
    public Gunnery()
    {
        super();
        this.range = 1;
        this.attackRange = 6;
    }
    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x,y);
    }
    @Override
    public String getName()
    {
        return "gunnery";
    }
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
    @Override
    public int getRange()
    {
        return range;
    }

    @Override
    public int getAttackRange()
    {
        return attackRange;
    }

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
