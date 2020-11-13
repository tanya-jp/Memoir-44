package com.company;

public class Tank extends Force{
//    private int movingNumber;
    private int range;
    private int attackRange;
    private int diceNumber;
    public Tank()
    {
        super();
        this.range = 3;
        this.attackRange = 3;
        this.diceNumber = 3;
    }
    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x,y);
    }

    @Override
    public String getName()
    {
        return "tank";
    }

    @Override
    public boolean canAttack(int movingNumber)
    {
        if(movingNumber <= 3)
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
        return diceNumber;
    }
}
