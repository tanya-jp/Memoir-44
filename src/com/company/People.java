package com.company;

public class People extends Force{
//    private int movingNumber;
    private int range;
    private int attackRange;

    public People()
    {
        super();
        this.range = 2;
        this.attackRange = 3;
    }
    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x,y);
    }

    @Override
    public String getName()
    {
        return "people";
    }

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
        if(distance == 1)
            return 3;
        else if(distance == 2)
            return 2;
        else
            return 1;
    }
}
