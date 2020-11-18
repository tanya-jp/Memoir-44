package com.company;
/**
 * Keeps players info.
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
    final String TEXT_RESET = "\u001B[0m";
    private String tag;
    private String name;
    private String character;
    private int score;
    private int medal;
    private int chosenLoc;
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

    /**
     * Constructs new player
     */
    public Player()
    {
        cards = new ArrayList<>();
        chosenForcesLoc = new ArrayList<>();
        this.score = 0;
        this.medal = 0;
    }

    /**
     * Sets A or B
     * @param tag A or B
     */
    public void setTag(String tag)
    {
        this.tag = tag;
    }

    /**
     * Returns players tag
     * @return tag
     */
    public String getTag()
    {
        return tag;
    }

    /**
     * Sets player's name
     * @param name as player's name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns player's name
     * @return anme
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets player's character: AXIS OR ALLIED
     * @param ch as character
     */
    public void setCharacter(String ch)
    {
        character = ch;
    }

    /**
     * Returns player's character
     * @return AXIS OR ALLIED
     */
    public String getCharacter()
    {
        return character;
    }

    /**
     * Increases score
     */
    public void addScore()
    {
        this.score++;
    }

    /**
     * Returns score
     * @return score
     */
    public int getScore()
    {
        return score;
    }
    /**
     * Increases number of medals
     */
    public void addMedal()
    {
        this.medal++;
    }

    /**
     * Returns number of medals
     * @return medals number
     */
    public int getMedal()
    {
        return medal;
    }

    /**
     * Sets cards by giving random numbers
     * @param chosenNumber a random number
     */
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

    /**
     * Returns added cards
     * @return list of card
     */
    public ArrayList<Card> getCards()
    {
        return cards;
    }

    /**
     * Find which card has been chosen
     * @param cardType as name of card
     * @return index of chosen card in arrayList
     */
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

    /**
     * Choose card by giving name of it
     * @param cardName as name of card(color of it)
     * @return the number of units that can be chosen
     */
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

    /**
     * Prints player's cards
     */
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
    }
    public void setChosenLoc(int loc)
    {
        chosenLoc = loc;
    }
    public int getChosenLoc()
    {
        return chosenLoc;
    }
}
