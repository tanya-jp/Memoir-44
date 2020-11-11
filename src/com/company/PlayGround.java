package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PlayGround {
    ////axis --> A
    private Player axis;
    /////allied --> B
    private Player allied;
    private HashMap<Integer,String> cells;
    private HashMap<Integer,String> forces;
    private HashMap<String,Integer> cards;
    private HashMap<String,Integer> usedCards;
    //1
    private Card purpleCard ;
    //2
    private Card yellowCard ;
    //3
    private Card blueCard ;
    //4
    private Card greenCard ;
    //5
    private Card cyanCard ;

    public PlayGround()
    {
        axis = new Player();
        allied = new Player();
        cells = new HashMap<>();
        forces = new HashMap<>();
        cards = new HashMap<>();
        usedCards = new HashMap<>();
        //1
        Card purpleCard = new PurpleCard();
        //2
        Card yellowCard = new YellowCard();
        //3
        Card blueCard = new BlueCard();
        //4
        Card greenCard = new GreenCard();
        //5
        Card cyanCard = new CyanCard();
        cards.put(purpleCard.getName(), 6);
        cards.put(yellowCard.getName(), 13);
        cards.put(blueCard.getName(), 10);
        cards.put(greenCard.getName(), 6);
        cards.put(cyanCard.getName(), 5);
        usedCards.put(purpleCard.getName(), 0);
        usedCards.put(yellowCard.getName(), 0);
        usedCards.put(blueCard.getName(), 0);
        usedCards.put(greenCard.getName(), 0);
        usedCards.put(cyanCard.getName(), 0);
    }
    public void setPlayers(Player p1, Player p2)
    {
        axis = p1;
        allied = p2;
    }

    public Player getAxis()
    {
        return axis;
    }

    public Player getAllied()
    {
        return allied;
    }
    public int setLocation(int x, int y)
    {
        int loc = 10 * x + y;
        return loc;
    }
    public void defineCells(int x, int y, String cell)
    {
        int loc = setLocation(x, y);
        cells.put(loc, cell);
    }
    public HashMap<Integer, String> getCells()
    {
        return cells;
    }
    public void defineForces(int x, int y, int number, String force)
    {
        int loc = setLocation(x ,y);
        int key = loc * 10 + number;
        forces.put(key, force);
    }
    public HashMap<Integer, String> getForces()
    {
        return forces;
    }
    public ArrayList<Integer> allocateCards(int cardNumber)
    {
        ArrayList<Integer> choices = new ArrayList<>();
        for( int i = 0; i < cardNumber; i++)
        {
            int flag = 1;
            if(cards.get("purple") == 0 &&
                    cards.get("yellow") == 0 &&
                    cards.get("blue") == 0 &&
                    cards.get("green") == 0 &&
                    cards.get("cyan") == 0 )
            {
                /////////player cars are important
                cards.replace("purple", 6);
                cards.replace("yellow", 13);
                cards.replace("blue", 10);
                cards.replace("green", 6);
                cards.replace("cyan", 5);
                usedCards.replace("purple", 0);
                usedCards.replace("yellow", 0);
                usedCards.replace("blue", 0);
                usedCards.replace("green", 0);
                usedCards.replace("cyan", 0);
            }
            while (flag == 1)
            {
                flag = 0;
                Random random = new Random ();
                int r = random.nextInt(5);
                r++;
                if(r == 1 && cards.get("purple") != 0)
                {
                    int v = cards.get("purple") - 1;
                    cards.replace("purple",v);
                }
                else if(r == 2 && cards.get("yellow") != 0)
                {
                    int v = cards.get("yellow") - 1;
                    cards.replace("yellow",v);
                }
                else if(r == 3 && cards.get("blue") != 0)
                {
                    int v = cards.get("blue") - 1;
                    cards.replace("blue",v);
                }
                else if(r == 4 && cards.get("green") != 0)
                {
                    int v = cards.get("green") - 1;
                    cards.replace("green",v);
                }
                else if(r == 5 && cards.get("cyan") != 0)
                {
                    int v = cards.get("cyan") - 1;
                    cards.replace("cyan",v);
                }
                else
                    flag++;
                if(flag == 0)
                    choices.add(r);
            }

        }
        return choices;
    }
    public void chooseCard(String cardName)
    {
        for (String name: cards.keySet())
        {
            if(name.equals(cardName))
            {
                int v = usedCards.get(name) + 1;
                usedCards.replace(name,v);
                return;
            }
        }
    }
    public void print()
    {
//        System.out.println("cells: "
//                + cells.toString());
        System.out.println("forces: "
                + forces.toString());
        System.out.println("cells: "
                + cells.toString());
//        System.out.println("used cards: "
//                + usedCards.toString());
    }
}
