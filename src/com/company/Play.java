package com.company;
/**
 * The main part of game happens in this class
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Play {
    //playground of the game
    private PlayGround playGround;
    //game players
    private Player player1;
    private Player player2;
    //to draw
    private Draw draw;
    //game's cells
    private ArrayList<Cell>  cells;
    //kind of cells
    private City city;
    private Bridge bridge;
    private River river;
    private Jungle jungle;
    private Hill hill;
    private Ground ground;
    private Haven haven ;
    //dice
    private Dice dice;

    /**
     * Constructs a new game by giving it's playground
     * @param pg as game playground
     */
    public Play(PlayGround pg)
    {
        playGround = new PlayGround();
        playGround = pg;
        player1 = new Player();
        player2 = new Player();
        draw = new Draw(pg);
        dice = new Dice();
        cells = new ArrayList<>();
        city = new City();
        bridge = new Bridge();
        river = new River();
        jungle = new Jungle();
        hill = new Hill();
        ground = new Ground();
        haven = new Haven();
        //adds different kinds of cells to arrayList
        cells.add(city);
        cells.add(bridge);
        cells.add(river);
        cells.add(jungle);
        cells.add(hill);
        cells.add(ground);
        cells.add(haven);
    }

    /**
     * Sets players by getting them from playground
     */
    public void setPlayers()
    {
        player1 = playGround.getAxis();
        player2 = playGround.getAllied();
    }

    /**
     * Fixes chosen forces in the beginning of the game.
     * @param max number of forces that this team has.
     * @param number the number of forces in every group.
     * @param group the team who is fixing their forces
     * @param forceName name of the forces that are being chosen
     */
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

    /**
     * Sets information and fixes the cells and forces.
     */
    public void fixGame()
    {
        System.out.println("First let us know your names");
        Scanner sc = new Scanner(System.in);
        System.out.print("First player's name as Axis: ");
        String name1 = sc.nextLine();
        player1.setCharacter("AXIS");
        player1.setName(name1);
        player1.setTag("A ");
        System.out.print("Second player's name as Allied: ");
        String name2 = sc.nextLine();
        player2.setCharacter("ALLIED");
        player2.setName(name2);
        player2.setTag("B ");
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
        System.out.println("NOW LET'S FIX AXIS'S FORCES");
        fixForces(6, 4,"A ","tank");
        fixForces(7,4,"A ","people");
        System.out.println("NOW IT'S ALLIED TURN");
        fixForces(3,3,"B ","tank");
        fixForces(8,4,"B ","people");
        fixForces(2,2,"B ","gunnery");
    }

    /**
     * Player chooses which forces he/she wants to play with.
     * @param max as max players that can be chosen that chosen card sets.
     * @param p as player who is playing
     */
    public void selectForce(int max, Player p)
    {
        int x = 0;
        int y = 0;
        int num;
        int n = 0;
        System.out.println("How many forces do you want to choose?");
        do{
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            if(n > max)
                System.out.println("You can't choose more than " + max);
        }while (n > max);
        for(int j = 0; j < n ; j++)
        {
            do{
                do{
                    System.out.print("Choose a force location: ");

                    Scanner scanner1 = new Scanner(System.in);
                    String loc = scanner1.nextLine();
                    String[] xy = loc.split(" ",2);
                    x = Integer.parseInt(String.valueOf(xy[0]));
                    y = Integer.parseInt(String.valueOf(xy[1]));
                    if(playGround.findForceNum(x, y) == 0)
                        System.out.println("INVALID FORCE LOCATION!");
                }while (playGround.findForceNum(x, y) == 0);

                num = playGround.findForceNum(x, y);
                if(!(playGround.getForces().get(playGround.setLocation(x, y)*10 + num).contains(p.getTag())))
                    System.out.println("THIS IS NOT YOURS");
            }while(!(playGround.getForces().get(playGround.setLocation(x, y)*10 + num).contains(p.getTag())));

            System.out.println("Do you want to change location?");
            Scanner scanner = new Scanner(System.in);
            String ans = scanner.nextLine();

            playGround.changeForceLocation(x,y,ans);
            draw.print(p.getCharacter());
        }
    }

    /**
     * Sets new target and checks if player can attack by checking
     * current cell of attacker and target
     * @param p as player who is playing
     */
    public void canAttack(Player p)
    {
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
                distance = (int)Math.round(calculateDistance(forceLoc/10 , forceLoc%10 , targetXY));
                System.out.println("distance "+distance);
                if(playGround.getChosenForces().get(forceLoc).getAttackRange() > distance)
                {
                    if (playGround.getCells().containsKey(forceLoc))
                        System.out.println("****"+playGround.getCells().get(forceLoc));
                    int targetNum = 0;
                    int attackerNum = 0;
                    int targetLoc = playGround.setLocation(Integer.parseInt(String.valueOf(targetXY[0])) ,
                            Integer.parseInt(String.valueOf(targetXY[1])));
                    targetNum = playGround.findForceNum(Integer.parseInt(String.valueOf(targetXY[0])) ,
                            Integer.parseInt(String.valueOf(targetXY[1])));

                    attackerNum = playGround.findForceNum(forceLoc/10, forceLoc%10);

                    System.out.println("********"+playGround.getForces().get(targetLoc*10+targetNum));

                    diceNumber = playGround.getChosenForces().get(forceLoc).getDiceNumber(distance);

                    if((playGround.getCells().containsKey(forceLoc) &&
                            ((playGround.getCells().get(forceLoc).equals("jungle") &&
                            jungle.check(forceLoc)) ||
                            (playGround.getCells().get(forceLoc).equals("city") &&
                                    city.check(forceLoc)) ||
                            !(playGround.getCells().get(forceLoc).equals("jungle")) ||
                            !((playGround.getCells().get(forceLoc).equals("city"))))) ||
                            !(playGround.getCells().containsKey(forceLoc)))
                    {
                        for (Cell cell : cells)
                        {
                            if (playGround.getCells().containsKey(targetLoc) &&
                                    cell.getName().contains(playGround.getCells().get(targetLoc)))
                            {
                                System.out.println(cell.getName());
                                System.out.println("target " +playGround.getForces().get(targetLoc*10+targetNum ));
                                System.out.println("attacker" + playGround.getForces().get(forceLoc*10+attackerNum));
                                diceNumber = cell.checkDice(playGround.getForces().get(targetLoc*10+targetNum),
                                        playGround.getForces().get(forceLoc*10+attackerNum),diceNumber);
                            }
                            if(playGround.getCells().containsKey(forceLoc) &&
                                    playGround.getCells().get(forceLoc).equals("jungle"))
                            {
                                diceNumber = 0;
                            }
                        }
                        if(playGround.getCells().containsKey(forceLoc) &&
                                (playGround.getCells().get(forceLoc).equals("city") &&
                        playGround.getForces().get(forceLoc*10+attackerNum).contains("tank")))
                            diceNumber -= 2;

                    }
                    else if(playGround.getCells().containsKey(forceLoc) &&
                            (playGround.getCells().get(forceLoc).equals("jungle") ||
                            playGround.getCells().get(forceLoc).equals("city")))
                        diceNumber = 0;

                    for(int j = 0; j < diceNumber; j++)
                    {
                        newDice = dice.newDice();
                        dices.add(newDice);
                        System.out.print("dice" + ": " + newDice + "  ");
                    }
                    if(dices.size() > 0)
                        attack(dice.getValidForces(),targetXY,p);
                    if(diceNumber > 0)
                        draw.print(p.getCharacter());
                    else
                        System.out.println("YOU CAN'T ATTACK");
                    dice.clearDice();
                    System.out.println();
                }
                else
                {
                    System.out.println("YOU CAN'T ATTACK");
                }
                printScore(p);
            }
            else
            {
                playGround.getChangedForces().get(forceLoc);
                System.out.println("**YOU CAN'T ATTACK");
            }
        }
        playGround.deleteChosenForces();
        playGround.deleteChangedForces();
    }

    /**
     * Checks if player can attack by checking the list of forces that can be target for dice numbers
     * @param validForces as list of forces that can be target
     * @param targetXY as location of target
     * @param player as player who is playing
     */
    public void attack(ArrayList<String> validForces,String[] targetXY,Player player)
    {
        int num = 0;
        int attackFlag = 0;
        int loc = playGround.setLocation(Integer.parseInt(String.valueOf(targetXY[0])) ,
                Integer.parseInt(String.valueOf(targetXY[1])));

        num = playGround.findForceNum(Integer.parseInt(String.valueOf(targetXY[0])) ,
                Integer.parseInt(String.valueOf(targetXY[1])));
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
            player.addScore();
            if(newKey % 10 == 0)
                player.addMedal();
        }
    }

    /**
     * Calculates the distance between target and attacker
     * @param x as x of attacker's location
     * @param y as y of attacker's location
     * @param xy as target's location
     * @return the distance between attacker and target
     */
    public double calculateDistance(int x , int y , String[] xy)
    {
        double distance = 0;
        double distanceX = 0;
        double distanceY = 0;
        Double forceX = new Double(x);
        Double forceY = new Double(y);
        if (forceY == Double.parseDouble(String.valueOf(xy[1])))
        {
            if(forceX > Double.parseDouble(String.valueOf(xy[0])))
                distance = forceX - Double.parseDouble(String.valueOf(xy[0]));
            else
                distance = - forceX + Double.parseDouble(String.valueOf(xy[0]));
        }
        else if (forceX == Double.parseDouble(String.valueOf(xy[0])))
        {
            if(forceY % 2 == Double.parseDouble(String.valueOf(xy[1])) % 2)
            {
                if (forceY > Double.parseDouble(String.valueOf(xy[1])))
                {
                    distance = forceY - Double.parseDouble(String.valueOf(xy[1]));
                }
                else
                {
                    distance = - forceY + Double.parseDouble(String.valueOf(xy[1]));
                }
                return distance;
            }
        }
        if(forceX > Double.parseDouble(String.valueOf(xy[0])))
            distanceX = forceX - Double.parseDouble(String.valueOf(xy[0]));
        else
            distanceX = - forceX + Double.parseDouble(String.valueOf(xy[0]));

        if (forceY > Double.parseDouble(String.valueOf(xy[1])))
            distanceY = forceY - Double.parseDouble(String.valueOf(xy[1]));
        else
            distanceY = - forceY + Double.parseDouble(String.valueOf(xy[1]));

        Double d= distanceX*distanceX + distanceY*distanceY;
        distance = Math.sqrt(d);
        return distance;
    }

    /**
     * Player gts new card after using one of them
     * @param p as the player who is playing
     */
    public void getNewCard(Player p)
    {
        p.setCards(playGround.allocateCards(1));
        System.out.println("NEW CARDS:");
        p.printCards();
    }

    /**
     * Prints score of the player after every attack
     * @param player as player who is playing
     */
    public void printScore(Player player)
    {
        System.out.println(player.getCharacter()+" score: "+player.getScore());
    }

    /**
     * Loop of playing game repeats in this method
     */
    public void playGame()
    {
        setPlayers();
        while (player1.getMedal() < 6 || player2.getMedal() < 6)
        {
//            Axis cards
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
//        Allied card
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
        endGame(player1, player2);
    }

    /**
     * When one of the players got 6 medals or arrived to specific cell this method runs
     * to say who won the game
     * @param player1 as Axis
     * @param player2 as Allied
     */
    public void endGame(Player player1, Player player2)
    {
        if(player1.getMedal() == 6)
            System.out.println(player1.getName() + " WON WITH 6 MEDALS");
        else if(player2.getMedal() == 6)
            System.out.println(player2.getName() + " WON WITH 6 MEDALS");
    }

}
