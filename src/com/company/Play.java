package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
    private PlayGround playGround;
    private Player player1;
    private Player player2;
    private Draw draw;
    private People people;
    private Tank tank;
    private Gunnery gunnery;
    private Dice dice;
    public Play(PlayGround pg)
    {
        playGround = new PlayGround();
        playGround = pg;
        player1 = new Player();
        player2 = new Player();
        draw = new Draw(pg);
        tank = new Tank();
        gunnery = new Gunnery();
        people = new People();
        dice = new Dice();
    }
    public void setPlayers()
    {
        player1 = playGround.getAxis();
        player2 = playGround.getAllied();
    }

    public void fixForces(int max,int number, String group, String forceName)
    {
        String force = group.concat(forceName);
        System.out.println("Tell me your "+ forceName+ "s location");
        for (int j = 1; j <= max; j++)
        {
            System.out.print(j + "th: ");
            Scanner sc2 = new Scanner(System.in);
            String str2 = sc2.nextLine();
            String[] choice2 = str2.split(" ",2);
            playGround.defineForces(Integer.parseInt(String.valueOf(choice2[0])),
                    Integer.parseInt(String.valueOf(choice2[1])),
                    number, force);
        }
    }
    public void fixGame()
    {
        System.out.println("First let us know your names");
        Scanner sc = new Scanner(System.in);
        System.out.print("First player's name as Axis: ");
        String name1 = sc.nextLine();
        player1.setCharacter("AXIS");
        player1.setName(name1);
        System.out.print("Second player's name as Allied: ");
        String name2 = sc.nextLine();
        player2.setCharacter("ALLIED");
        player2.setName(name2);
        playGround.setPlayers(player1, player2);
        System.out.println("NOW LET'S FIX OUR PLAY GROUND!");
        System.out.println("Tell me your choices in this way: x y kind of cell");
        System.out.println("EXAMPLE: 1 1 city");
        System.out.println("And please enter OK to finish");
        int flag = 0;
        while(flag == 0)
        {
            Scanner sc1 = new Scanner(System.in);
            String str = sc1.nextLine();
            if ((str.equals("OK")))
            {
                flag++;
                continue;
            }
            String[] choice = str.split(" ",3);
            playGround.defineCells(Integer.parseInt(String.valueOf(choice[0])),
                    Integer.parseInt(String.valueOf(choice[1])),
                    choice[2]);
        }
        System.out.println("Tell me your choices in this way: x y");
        System.out.println("EXAMPLE: 1 1");
//        System.out.println("And please enter OK to finish");
        System.out.println("NOW LET'S FIX AXIS'S FORCES");
        fixForces(6, 4,"A ","tank");
        fixForces(7,4,"A ","people");
        System.out.println("NOW IT'S ALLIED TURN");
        fixForces(3,3,"B ","tank");
        fixForces(8,4,"B ","people");
        fixForces(2,2,"B ","gunnery");
    }
    public void selectForce(int max, Player p)
    {
        for(int j = 0; j < max ; j++)
        {
            System.out.print("Choose a force location: ");
            Scanner scanner1 = new Scanner(System.in);
            String loc = scanner1.nextLine();
            String[] xy = loc.split(" ",2);
            playGround.changeForceLocation(Integer.parseInt(String.valueOf(xy[0])),
                    Integer.parseInt(String.valueOf(xy[1])));
            draw.print(p.getCharacter());
        }
    }
    public void canAttack(Player p)
    {
        int i = 0;
        int distance,diceNumber,newDice;
        ArrayList<Integer> dices = new ArrayList<>();
        for (int forceLoc: playGround.getChangedForces().keySet())
        {
            if (playGround.getChangedForces().get(forceLoc))
            {
                playGround.getChangedForces().get(forceLoc);
                System.out.println("Choose your target for the group in x = "+
                        (forceLoc/10) + " y = "+ (forceLoc%10));
                Scanner scanner1 = new Scanner(System.in);
                String loc = scanner1.nextLine();
                String[] targetXY = loc.split(" ",2);
                distance = calculateDistance(forceLoc/10 , forceLoc%10 , targetXY);
                System.out.println("distance "+distance);
                if(playGround.getChosenForces().get(i).getAttackRange() > distance)
                {
                    diceNumber = playGround.getChosenForces().get(i).getDiceNumber(distance);
                    for(int j = 0; j < diceNumber; j++)
                    {
                        newDice = dice.newDice();
                        dices.add(newDice);
                        System.out.print("dice" + ++i + ": " + newDice + "  ");
                    }
                    attack(dice.getValidForces(),targetXY);
                    System.out.println("forces: "
                            + playGround.getForces().toString());
                    draw.print(p.getCharacter());
                    dice.clearDice();
                    System.out.println();
                }
                else
                {
                    System.out.println("YOU CAN'T ATTACK");
                }
            }
            else
            {
                playGround.getChangedForces().get(forceLoc);
                System.out.println("**YOU CAN'T ATTACK");
            }
            i++;
        }
        playGround.deleteChosenForces();
        playGround.deleteChangedForces();
        //////////badesh hatman remove kon vaghti halghe tamoom shod khast bere soraaghe bazikone badi
    }
    public void attack(ArrayList<String> validForces,String[] targetXY)
    {
        int num = 0;
        int attackFlag = 0;
        int loc = playGround.setLocation(Integer.parseInt(String.valueOf(targetXY[0])) ,
                Integer.parseInt(String.valueOf(targetXY[1])));
        if(playGround.getForces().containsKey(loc*10+1))
            num = 1;
        else if(playGround.getForces().containsKey(loc*10+2))
            num = 2;
        else if(playGround.getForces().containsKey(loc*10+3))
            num = 3;

        else if(playGround.getForces().containsKey(loc*10+4))
            num = 4;

        for (String force: validForces)
        {
            if((playGround.getForces().get(loc*10+num).contains(force)))
            {
                attackFlag ++;
                continue;
            }
        }
        if(attackFlag == 0)
            System.out.println("INVALID ATTACK");
        else
        {
            int newKey = loc * 10 + num - 1;
            playGround.updateForceArray(newKey);
        }
    }
    ////naghese
    public int calculateDistance(int forceX , int forceY , String[] xy)
    {
        int distance = 0;

        if (forceY == Integer.parseInt(String.valueOf(xy[1])))
        {
            if(forceX > Integer.parseInt(String.valueOf(xy[0])))
                distance = forceX - Integer.parseInt(String.valueOf(xy[0]));
            else
                distance = - forceX + Integer.parseInt(String.valueOf(xy[0]));
        }
        else if (forceX == Integer.parseInt(String.valueOf(xy[0])))
        {
            if(forceY % 2 == Integer.parseInt(String.valueOf(xy[1])) % 2)
            {
                if (forceY > Integer.parseInt(String.valueOf(xy[1])))
                {
                    distance = forceY - Integer.parseInt(String.valueOf(xy[1]));
                }
                else
                {
                    distance = - forceY + Integer.parseInt(String.valueOf(xy[1]));
                }
                return distance;
            }
        }
        return distance;
    }
    public void getNewCard(Player p)
    {
        p.setCards(playGround.allocateCards(1));
        System.out.println("NEW CARDS:");
        p.printCards();
    }
    public void playGame()
    {
        setPlayers();
        //        Axis cards
        draw.print(player1.getCharacter());
        player1.setCards(playGround.allocateCards(2));
        player1.printCards();
        System.out.print("Choose a card: ");
        Scanner sc1 = new Scanner(System.in);
        String card1 = sc1.nextLine();
        int max = player1.chooseCard(card1);
        selectForce(max, player1);
        canAttack(player1);
        getNewCard(player1);
//        //Allied card
        draw.print(player2.getCharacter());
        player2.setCards(playGround.allocateCards(4));
        player2.printCards();
        System.out.print("Choose a card: ");
        Scanner sc2 = new Scanner(System.in);
        String card2 = sc2.nextLine();
        max = player2.chooseCard(card2);
        selectForce(max, player2);
        canAttack(player2);
        getNewCard(player2);
    }

}
