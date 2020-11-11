package com.company;

import java.util.ArrayList;

public class Location {
    private ArrayList<Integer> location;
    public Location()
    {
        location = new ArrayList<>();
    }

    public void setLocation(int x, int y)
    {
        int loc = 10 * x + y;
        location.add(loc);
    }

    public ArrayList<Integer> getLocation()
    {
        return location;
    }
}
