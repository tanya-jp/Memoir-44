package com.company;
/**
 * This class draw playground of the game with forces.
 * @author Tanya Djavaherpour
 * @version 1.0 2020
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Draw {
    //set colors
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN   = "\u001B[96m";
    public static final String ANSI_BRIGHT_BG_BLACK  = "\u001B[100m";
    public static final String ANSI_BRIGHT_BLACK  = "\u001B[90m";
    public static final String ANSI_WHITE  = "\u001B[37m";
    //game's playground
    private PlayGround playGround;
    private HashMap<Integer,String> cellsLocation;
    //an arrayList of every kind of cell
    private ArrayList<Cell>  cells;
    //different kinds of cells
    private City city = new City();
    private Bridge bridge = new Bridge();
    private River river = new River();
    private Jungle jungle = new Jungle();
    private Hill hill = new Hill();
    private Ground ground = new Ground();
    private Haven haven = new Haven();

    /**
     * Creats a new draw class
     * @param playGround as playground of game
     */
    public Draw(PlayGround playGround)
    {
        cellsLocation = new HashMap<>();
        this.playGround = playGround;
        cells = new ArrayList<>();
        cells.add(city);
        cells.add(bridge);
        cells.add(river);
        cells.add(jungle);
        cells.add(hill);
        cells.add(ground);
        cells.add(haven);
    }

    /**
     * Sets location of cells by getting them from playground class
     */
    public void setCells()
    {
        this.cellsLocation = this.playGround.getCells();
    }

    /**
     * this method prints playground
     * @param str as name of player who is playing now.
     */
    public void print(String str)
    {
        int len = 0;
        //checks name of player to print with specific color
        if(str.equals("AXIS"))
        {
            System.out.println(ANSI_BRIGHT_PURPLE);
            System.out.println(ANSI_BRIGHT_BG_BLACK+"AXIS");
            System.out.print(TEXT_RESET);
        }
        else
        {
            System.out.println(ANSI_BRIGHT_CYAN);
            System.out.println(ANSI_BRIGHT_BG_BLACK+"ALLIED");
            System.out.print(TEXT_RESET);
        }
        int loc;
        int flag = 0;
        int limit;
        for(int j = 1 ; j <= 9 ; j++)
        {
            if(j % 2 == 1)
                limit = 13;
            else
                limit = 12;
            if (limit == 12)
                System.out.print("    ");
            for(int i = 1; i <= limit ; i++)
            {
                flag = 0;
                loc = i*10 + j;
                if(playGround.getCells().containsKey(loc))
                {
                    //checks kind of cell to print with correct color
                    for (Cell cell : cells) {
                        if (cell.getName().equals(playGround.getCells().get(loc))) {
                            System.out.print(ANSI_BRIGHT_BLACK);
                            System.out.print(cell.getColor() +cell.getName().charAt(0)+"        "+ TEXT_RESET);
                            System.out.print(cell.getColor() +"|"+ TEXT_RESET);
                        }
                    }
                }
                else
                {
                    System.out.print(ANSI_BRIGHT_BLACK);
                    System.out.print(ground.getColor() +ground.getName().charAt(0)+"        "+ TEXT_RESET);
                    System.out.print(ground.getColor() +"|"+ TEXT_RESET);
                }
            }
            for (int k = 1 ; k <= 2 ; k++)
            {
                System.out.println();
                if (limit == 12)
                    System.out.print("    ");
                for(int i = 1; i <= limit ; i++)
                {
                    len = 0;
                    loc = i*10 + j;
                    flag = 0;
                    int forceNum = 0;
                    //Checks if there is a force in this cell
                    if(playGround.getForces().containsKey(loc*10))
                    {
                        forceNum = 0;
                        flag ++;
                    }
                    else if(playGround.getForces().containsKey(loc*10+1))
                    {
                        forceNum = 1;
                        flag ++;
                    }
                    else if(playGround.getForces().containsKey(loc*10+2))
                    {
                        forceNum = 2;
                        flag ++;
                    }
                    else if(playGround.getForces().containsKey(loc*10+3))
                    {
                        forceNum = 3;
                        flag ++;
                    }
                    else if(playGround.getForces().containsKey(loc*10+4))
                    {
                        forceNum = 4;
                        flag ++;
                    }
                    if(flag > 0 && k == 1)
                    {
                        String playerName;
                        if(playGround.getForces().get(loc*10+forceNum).charAt(0) == 'A')
                        {
                            playerName = "AXIS";
                            len = playerName.length();
                            System.out.print(ANSI_BRIGHT_PURPLE+playerName+TEXT_RESET);
                        }
                        else
                        {
                            playerName = "ALLIED";
                            len = playerName.length();
                            System.out.print(ANSI_BRIGHT_CYAN+playerName+TEXT_RESET);
                        }
                    }

                    else if(flag > 0 && k==2)
                    {
                        len = playGround.getForces().get(loc*10+forceNum).length() - 1;
                        System.out.print(forceNum);
                        for (int z = 2; z <= len ; z++)
                            System.out.print(playGround.getForces().get(loc*10+forceNum).charAt(z));
                    }
                    else
                        len = 0;
                    if(playGround.getCells().containsKey(loc))
                    {
                        for (Cell cell : cells) {
                            if (cell.getName().equals(playGround.getCells().get(loc))) {
                                for (int z = len ; z < 9 ; z ++)
                                    System.out.print(cell.getColor() +" ");
                                System.out.print("|"+ TEXT_RESET);
                            }
                        }
                    }
                    else
                    {
                        for (int z = len ; z < 9 ; z ++)
                            System.out.print(ground.getColor() +" ");
                        System.out.print("|"+ TEXT_RESET);
                    }
                }
            }
            System.out.println();
            if (limit == 12)
                System.out.print("    ");
            for(int i = 1; i <= limit ; i++)
            {
                loc = i * 10 + j;
                if (playGround.getCells().containsKey(loc)) {
                    for (Cell cell : cells) {
                        if (cell.getName().equals(playGround.getCells().get(loc))) {
                            System.out.print(cell.getColor() +"         "+"|"+ TEXT_RESET);
                        }
                    }
                }
                else
                    System.out.print(ground.getColor()+"         "+"|"+TEXT_RESET);
            }
            System.out.println();

        }
    }

}
