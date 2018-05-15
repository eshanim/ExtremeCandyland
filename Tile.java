import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public interface Tile
{
    /**
     * Returns the location of the tile
     * @return the location of the tile
     */
    Location getLocation();
    
    /**
     * Sets the tile's location to a given location
     * @param location
     */
    void setLocation(Location location);
    
    /**
     * 
     * Does a specific action to change the points of the player
     * @param player
     * @param path
     */
    void play(Player player, Path path);
    
    /**
     * 
     * TODO Write your method description here.
     * @return
     */
    String getType();
    
    Color getColor();
    
    boolean isEnd();
}
