import info.gridworld.grid.Location;

import java.awt.Color;
import java.lang.reflect.Field;

/**
 *  A color tile is a tile with a color on it. A player can move on to any of the tiles.
 *  The player can gain points by landing on the tile.
 *  It can also be licorice, which would cause a player to lose a turn.
 *
 *  @author  Juhi
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class ColorTile
{
    /**
     * the color of the tile
     */
    private Color color;
    
    /**
     * the location of the tile
     */
    private Location location;
    
    /**
     * checks to see if the tile is a licorice tile
     */
    private boolean isLicorice = false;
    
    /**
     * Constructs a new Color Tile with a given color and location
     * @param color the color of the tile
     * @param loc the location of the tile
     */
    ColorTile(Color color, Location loc)
    {
        this.color = color;
        location = loc;
    }
    
    /**
     * returns the location of the tile
     * @return the location
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * changes the location to the given value
     * @param loc the location of the tile
     */
    public void setLocation(Location loc)
    {
        location = loc;
    }
    
    /**
     * returns the color of the tile
     * @return color of tile
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * If the color of the player is the same as the color of the tile, the 
     * player gets two points; otherwise, the player gets one point
     * @param player the player receiving points
     */
    public void addPoints(Player player)
    {
        if (this.isLicorice == true)
        {
            return;
        }
        else if (player.getColor() == this.getColor())
        {
            player.addPoints( 2 );
        }
        else
        {
            player.addPoints( 1 );
        }
    }
    
    /**
     * Gives points for the player and causes the player to move
     * If licorice, causes the player to lose a turn
     */
    public void play(Player player, Path path)
    {
        this.addPoints( player );
        player.moveTo( location );
        if (isLicorice)
        {
            player.loseTurn();
        }
    }
    
    /**
     * returns the type of tile this is
     * @return the type, color
     */
    public String getType()
    {
        return "color";
    }
    
    /**
     * Causes a player to lose their turn
     */
    public void isLicorice()
    {
        isLicorice = true;
    }
    
    /**
     * returns false unless it is a shortcut tile
     * @return true if shortcut tile
     */
    public boolean isEnd()
    {
        return false;
    }
    
    /**
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>.
     *  @return a string representation of this Brokerage.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " " + field.getName() + ":"
                    + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
