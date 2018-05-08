import java.awt.Color;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import info.gridworld.world.*;

public class Player
{
    private String name;
    private Color color;
    private int points;
    private String direction;
    private Location location;
    private boolean loseTurn = false;
   
    public Player(String nm, Color col) 
    {
        name = nm;
        color = col;
        points = 0;
        direction = "forward";
        location = new Location(0,0);
    }
    
    public String getName()
    {
        return name;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    public String getDirection()
    {
        return direction;
    }
    
    public Location getLocation()
    {
        return location;
    }
    
    public void setPoints( int p )
    {
        points = p;
    }
    
    public void addPoints (int p)
    {
        points += p;
    }
    
    public void subtractPoints(int p)
    {
        points -= p;
    }
    
    public void reverseDirection()
    {
        if (direction == "forward")
        {
            direction = "backward";
        }
        else
        {
            direction = "forward";
        }
    }
    
    public void putPlayerAtStart()
    {
        location = new Location(0,0);
    }
    
    public void moveTo(Location loc)
    {
        location = loc;
    }
    
    public void play()
    {
        if (loseTurn)
        {
            return;
        }
        //call deck of cards -- show method
            //calls card -- play
                //path -- find tile
            //call tile -- play
        //move to new loc
    }
    
    public void loseTurn()
    {
        if (loseTurn == true)
        {
            loseTurn = false;
        }
        else 
        {
            loseTurn = true;
        }
    }
}
