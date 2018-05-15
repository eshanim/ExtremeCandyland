import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class ColorTile implements Tile
{
    
    private Color color;
    private Location location;
    private boolean isLicorice = false;
    
    ColorTile(Color color, Location loc)
    {
        this.color = color;
        location = loc;
    }
    
    public Location getLocation()
    {
        return location;
    }
    
    public void setLocation(Location loc)
    {
        location = loc;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void addPoints(Player player)
    {
        if (player.getColor() == this.getColor())
        {
            player.addPoints( 2 );
        }
        
        else
        {
            player.addPoints( 1 );
        }
    }
    
    public void play(Player player, Path path)
    {
        if (isLicorice)
        {
            player.loseTurn();
        }
        else
        {
            this.addPoints( player );
        }
    }
    
    public String getType()
    {
        return "color";
    }
    
    public void isLicorice()
    {
        isLicorice = true;
    }
    
    public boolean isEnd()
    {
        return false;
    }
}
