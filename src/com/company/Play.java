package com.company;

import java.util.Scanner;

public class Play {
    private PlayGround playGround;
    private Player player1;
    private Player player2;
    private Draw draw;
    public Play(PlayGround pg)
    {
        playGround = new PlayGround();
        playGround = pg;
        player1 = new Player();
        player2 = new Player();
        draw = new Draw(pg);
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
            p.chooseForces(Integer.parseInt(String.valueOf(xy[0])),
                    Integer.parseInt(String.valueOf(xy[1])));
        }
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
        getNewCard(player2);
    }

}
