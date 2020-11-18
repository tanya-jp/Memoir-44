package com.company;
/**
 * This class puts forces and sets cells of the game.
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */

import com.sun.applet2.AppletParameters;

import java.util.*;

public class PlayGround {
    ////axis --> A
    private Player axis;
    /////allied --> B
    private Player allied;
    //the int part is x and y of cells location together with this patter x*10+y --> xy
    private HashMap<Integer,String> cells;
    //the int part is x and y and number of forces together with this patter x*100+y*10+number --> xynumber
    private HashMap<Integer,String> forces;
    //forces that their location has been changed with the ability of attack
    private HashMap<Integer,Boolean> changedForces;
    //bank of visible cards
    private HashMap<String,Integer> cards;
    //bank of used cards
    private HashMap<String,Integer> usedCards;
    //target forces
    private HashMap<Integer,Force> chosenForces;
    private ArrayList<String> xy ;
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
    private People people;
    private Tank tank;
    private Gunnery gunnery;

    /**
     * Creates new playground
     */
    public PlayGround()
    {
        axis = new Player();
        allied = new Player();
        cells = new HashMap<>();
        forces = new HashMap<>();
        changedForces = new HashMap<>();
        cards = new HashMap<>();
        usedCards = new HashMap<>();
        chosenForces = new HashMap<>();
        xy = new ArrayList<>();
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
        people = new People();
        tank = new Tank();
        gunnery = new Gunnery();
        //sets first values of banks
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

    /**
     * Sets two players.
     * @param p1 as Axis
     * @param p2 as Allied
     */
    public void setPlayers(Player p1, Player p2)
    {
        axis = p1;
        allied = p2;
    }

    /**
     * Gets Axis information
     * @return axis as Axis
     */
    public Player getAxis()
    {
        return axis;
    }

    /**
     * Gets Allied information
     * @return allied as Allied
     */
    public Player getAllied()
    {
        return allied;
    }

    /**
     * Makes location in wanted form --> xy
     * @param x as x
     * @param y as y
     * @return loc as xy
     */
    public int setLocation(int x, int y)
    {
        int loc = 10 * x + y;
        return loc;
    }

    /**
     * Sets cell of given location
     * @param x as x
     * @param y as y --> first line from top has 1 number
     * @param cell as name of cell
     */
    public void defineCells(int x, int y, String cell)
    {
        int loc = setLocation(x, y);
        cells.put(loc, cell);
    }

    /**
     * Gets cells with their locations
     * @return cells
     */
    public HashMap<Integer, String> getCells()
    {
        return cells;
    }
    /**
     * Sets force of given location
     * @param x as x
     * @param y as y
     * @param force as name of forces
     */
    public void defineForces(int x, int y, int number, String force)
    {
        int loc = setLocation(x ,y);
        int key = loc * 10 + number;
        forces.put(key, force);
    }
    /**
     * Gets forces with their locations
     * @return forces
     */
    public HashMap<Integer, String> getForces()
    {
        return forces;
    }
    /**
     * Gives random cards to players.
     * number of purple = 1, yellow = 2, blue = 3, green = 4, cyan = 5
     * @param cardNumber as number of wanted cards
     * @return arrayList of cards
     */
    public ArrayList<Integer> allocateCards(int cardNumber) {
        ArrayList<Integer> choices = new ArrayList<>();
        for (int i = 0; i < cardNumber; i++) {
            int flag = 1;
            if (cards.get("purple") == 0 &&
                    cards.get("yellow") == 0 &&
                    cards.get("blue") == 0 &&
                    cards.get("green") == 0 &&
                    cards.get("cyan") == 0) {
                /////////player cars are important/////////////////////////////////////////////////////////////////////////
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
            while (flag == 1) {
                flag = 0;
                Random random = new Random();
                int r = random.nextInt(5);
                r++;
                if (r == 1 && cards.get("purple") != 0) {
                    int v = cards.get("purple") - 1;
                    cards.replace("purple", v);
                } else if (r == 2 && cards.get("yellow") != 0) {
                    int v = cards.get("yellow") - 1;
                    cards.replace("yellow", v);
                } else if (r == 3 && cards.get("blue") != 0) {
                    int v = cards.get("blue") - 1;
                    cards.replace("blue", v);
                } else if (r == 4 && cards.get("green") != 0) {
                    int v = cards.get("green") - 1;
                    cards.replace("green", v);
                } else if (r == 5 && cards.get("cyan") != 0) {
                    int v = cards.get("cyan") - 1;
                    cards.replace("cyan", v);
                } else
                    flag++;
                if (flag == 0)
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

    /**
     * Returns how many forces is in cell
     * @param x as x
     * @param y as y
     * @return number of forces
     */
    public int findForceNum(int x, int y)
    {
        int loc = setLocation(x,y);
        int num = 0;
        if(forces.containsKey(loc*10+1))
            num = 1;
        else if(forces.containsKey(loc*10+2))
            num = 2;
        else if(forces.containsKey(loc*10+3))
            num = 3;

        else if(forces.containsKey(loc*10+4))
            num = 4;

        return num;
    }
    /**
     * Sets directions while it is acceptable
     * @param validMovingNumber as the cell number that force can move
     * @return the cell number that force moved
     */
    public int  enterDirection(int validMovingNumber)
    {
        int movingNumber;
        xy.clear();
        do
        {
            movingNumber = 0;
            System.out.println("Enter directions:");
            Scanner scanner = new Scanner(System.in);
            String dir = scanner.nextLine();
            String[] XY = dir.split(" ");
            for(int j = 0; j < XY.length; j++)
                movingNumber += Integer.parseInt(String.valueOf(XY[j].charAt(0)));
            if(movingNumber > validMovingNumber)
                System.out.println("ERROR!");
            else
            {
                for(int k = 0; k < XY.length; k++)
                    xy.add(XY[k]);
            }
        }while(movingNumber > validMovingNumber);
        return movingNumber;
    }

    /**
     * Checks if the force can enter this cell or not.
     * @param newX
     * @param newY
     * @param num
     * @return
     */
    public boolean checkErrors(int newX, int newY, int num, int loc)
    {
        if (cells.containsKey(setLocation(newX,newY)))
        {
            if (cells.get(setLocation(newX, newY)).equals("river"))
            {
                System.out.println("YOU CAN'T ENTER THE RIVER!");
                return false;
            }
            else if (cells.get(setLocation(newX, newY)).equals("haven")
                    && forces.get(loc * 10 + num).contains("tank"))
            {
                System.out.println("YOU CAN'T ENTER THE HAVEN!");
                return false;
            }
        }
        if(findForceNum(newX, newY) > 0)
        {
            System.out.println("THIS CELL IS FULL");
            return false;
        }
        return true;
    }
    /**
     * Changes force location during the game
     * @param x as x
     * @param y as y
     */
    public boolean changeForceLocation(int x, int y, String answer, Player p)
    {
        boolean res = false;
        int num = 0;
        int newX = x;
        int newY = y;
        int loc = setLocation(x,y);
        int newLoc;
        int validMovingNumber ;
        int movingNumber = 0;

        num = findForceNum(x,y);

        System.out.println(forces.get(loc*10+num));
        if(forces.get(loc*10+num).contains("people"))
            validMovingNumber = people.getRange();

        else if(forces.get(loc*10+num).contains("tank"))
            validMovingNumber = tank.getRange();

        else
            validMovingNumber = gunnery.getRange();

        if(answer.equals("yes"))
            movingNumber = enterDirection(validMovingNumber);

        int i = 0 ;
        while (i < xy.size() && answer.equals("yes"))
        {
            if(xy.get(i).charAt(1) == 'L')
                for(int j = 0 ; j < Integer.parseInt(String.valueOf(xy.get(i).charAt(0))) ; j++)
                {
                    newX--;
                    if(!checkErrors(newX, newY, num, loc))
                    {
                        movingNumber = enterDirection(validMovingNumber);
                        newX = x;
                        newY = y;
                        i = 0;
                        continue;
                    }
                }

            else if(xy.get(i).charAt(1) == 'R')
                for(int j = 0 ; j < Integer.parseInt(String.valueOf(xy.get(i).charAt(0))) ; j++)
                {
                    newX++;
                    if(!checkErrors(newX, newY, num, loc))
                    {
                        movingNumber = enterDirection(validMovingNumber);
                        newX = x;
                        newY = y;
                        i = 0;
                        continue;
                    }
                }
            else if(xy.get(i).length() > 2)
            {
                for(int j = 0 ; j < Integer.parseInt(String.valueOf(xy.get(i).charAt(0))) ; j++)
                {
                    if(newY % 2 == 0)
                    {
                        if(xy.get(i).charAt(2) == 'R')
                        {
                            newX++;
                        }
                    }
                    else if(newY % 2 ==1)
                    {
                        if(xy.get(i).charAt(2) == 'L')
                            newX--;
                    }
                    if (xy.get(i).charAt(1) == 'U')
                        newY--;
                    else if (xy.get(i).charAt(1) == 'D')
                    {
                        newY++;
                    }
                    if(!checkErrors(newX, newY, num, loc))
                    {
                        movingNumber = enterDirection(validMovingNumber);
                        newX = x;
                        newY = y;
                        i = 0;
                        continue;
                    }

                }
            }
            if(!checkErrors(newX, newY, num, loc))
            {
                movingNumber = enterDirection(validMovingNumber);
                newX = x;
                newY = y;
                i = 0;
            }
            else
                i++;
        }

        newLoc = setLocation(newX, newY);
        if(newLoc == p.getChosenLoc())
        {
            System.out.println(p.getName()+" WON!");
            res = true;
            return true;
        }

        if(forces.get(loc*10+num).contains("people"))
        {
            changedForces.put(newLoc,people.canAttack(movingNumber));
            chosenForces.put(newLoc,people);
        }
        else if(forces.get(loc*10+num).contains("tank"))
        {
            changedForces.put(newLoc,tank.canAttack(movingNumber));
            chosenForces.put(newLoc,tank);
        }
        else
        {
            changedForces.put(newLoc,gunnery.canAttack(movingNumber));
            chosenForces.put(newLoc,gunnery);
        }

        if(answer.equals("yes"))
        {
            forces.put(newLoc*10 + num,forces.get(loc*10+num));
            forces.remove(loc*10+num);
        }
        return res;
    }


    /**
     * Gets a HashMap of forces that their locations have been changed
     * @return a HashMap that key is new xy of changed forces and value is their attack ability
     */
    public HashMap<Integer,Boolean> getChangedForces()
    {
        return changedForces;
    }

    /**
     * Clears changedForces when next player should play
     */
    public void deleteChangedForces()
    {
        changedForces.clear();
    }

    /**
     * Gets chosen force with location of attacker
     * @return chosenForces
     */
    public HashMap<Integer,Force> getChosenForces()
    {
        return chosenForces;
    }

    /**
     * clear chosenForces when next player should play
     */
    public void deleteChosenForces()
    {
        chosenForces.clear();
    }

    /**
     * After every attack updates forces HashMap
     * @param key as new key of the force
     */
    public void updateForceArray(int key)
    {
        if(key % 10 != 0)
          forces.put(key,forces.get(key+1));
        forces.remove(key+1);
    }
}
