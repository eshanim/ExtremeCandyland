import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class CharacterTile implements Tile
{
    private String character;
    private Location location;
    private int points;
    
    public CharacterTile( String character, int points, Location loc)
    {
        this.character = character;
        location = new Location(0 , 0);
        this.points = points;
    }
    
    public Location getLocation()
    {
        return location;
    }
    
    public void setLocation(Location loc)
    {
        location = loc;
    }
    
    
    public boolean hasPoints()
    {
        if (points == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public void subtractPoints()
    {
        points = 0;
    }
    
    public void play(Player player, Path path)
    {
        if (this.hasPoints())
        {
            player.addPoints( points );
            this.subtractPoints();
        }
    }

    
    public String getType()
    {
        return character;
    }
    
    public Color getColor()
    {
        return Color.PINK;
    }
    
    public boolean isEnd()
    {
        return false;
    }
}
