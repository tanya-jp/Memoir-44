package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
    final String TEXT_RESET = "\u001B[0m";
    private String name;
    private String character;
    private ArrayList<Card> cards;
    private ArrayList<Integer> chosenForcesLoc;
    //1
    private Card purpleCard = new PurpleCard();
    //2
    private Card yellowCard = new YellowCard();
    //3
    private Card blueCard = new BlueCard();
    //4
    private Card greenCard = new GreenCard();
    //5
    private Card cyanCard = new CyanCard();

    public Player()
    {
        cards = new ArrayList<>();
        chosenForcesLoc = new ArrayList<>();
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setCharacter(String ch)
    {
        character = ch;
    }
    public String getCharacter()
    {
        return character;
    }
    public void makeCards()
    {

    }
    public void setCards(ArrayList<Integer> chosenNumber)
    {
        for (int num : chosenNumber)
        {
            if(num == 1)
                cards.add(purpleCard);
            else if(num == 2)
                cards.add(yellowCard);
            else if(num == 3)
                cards.add(blueCard);
            else if(num == 4)
                cards.add(greenCard);
            else
                cards.add(cyanCard);

        }
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public int findIndex(Card cardType)
    {
        int i = 0;
        for (Card card: cards)
        {
            if(card.equals(cardType))
                return i;
            i++;
        }
        return i;
    }
    public int chooseCard(String cardName)
    {
        if(cardName.equals("purple"))
        {
            cards.remove(findIndex(purpleCard));
            return purpleCard.getAttackNum();
        }
        else if(cardName.equals("yellow"))
        {
            cards.remove(findIndex(yellowCard));
            return yellowCard.getAttackNum();
        }
        else if(cardName.equals("blue"))
        {
            cards.remove(findIndex(blueCard));
            return blueCard.getAttackNum();
        }
        else if(cardName.equals("green"))
        {
            cards.remove(findIndex(greenCard));
            return greenCard.getAttackNum();
        }
        else
        {
            cards.remove(findIndex(cyanCard));
            return cyanCard.getAttackNum();
        }

    }

    public void chooseForces(int x, int y)
    {
        chosenForcesLoc.add(10 * x + y);
    }

    public ArrayList<Integer> getChosenForcesLoc()
    {
        return chosenForcesLoc;
    }

    public void clearChosenForcesLoc()
    {
        chosenForcesLoc.clear();
    }

    public void chooseTargets(String cardName)
    {
        int number = chooseCard(cardName);
    }

    public void printCards()
    {
        System.out.println(character+"'s cards:");
        for(Card card: cards)
        {
            System.out.print (card.getColor() + "#############  " + TEXT_RESET);
        }
        System.out.println();
        for(Card card: cards)
        {
            System.out.print(card.getColor()+"# "+card.getAttackNum()+" attacks #  ");
        }
        System.out.println();
        for(int j = 0; j < 5; j++)
        {
            for(Card card: cards)
                System.out.print (card.getColor() + "#           #  " + TEXT_RESET);
            System.out.println();
        }
        for(Card card: cards)
        {
            System.out.print (card.getColor() + "#############  " + TEXT_RESET);
        }
        System.out.println();
//        }
    }
}
