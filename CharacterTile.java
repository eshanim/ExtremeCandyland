import info.gridworld.grid.Location;

import java.awt.Color;
import java.lang.reflect.Field;

/**
 *  Creates a new tile that has a character on it and a certain number of points.
 *  The first player to land on this tile will be awarded the points, and every other
 *  player will just move on to this tile without getting any points.
 *
 *  @author  juhi
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class CharacterTile extends ColorTile
{
    /**
     * A string for the name of the character
     */
    private String character;
    
    /**
     * the location of the tile
     */
    private Location location;
    
    /**
     * the number of points the tile has
     */
    private int points;
    
    /**
     * Constructs a new tile that has a given character name, number of points, and location.
     * @param character the name of the character for the tile
     * @param points the number of points for the tile
     * @param loc the location of the tile
     */
    public CharacterTile( String character, int points, Location loc)
    {
        super(Color.PINK, loc);
        this.character = character;
        location = loc;
        this.points = points;
    }
    
    /**
     * Returns the location of the tile
     * @return location
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Sets a new location for the tile
     * @param loc the location
     */
    public void setLocation(Location loc)
    {
        location = loc;
    }
    
    
    /**
     * 
     * Returns true if it has points.
     * @return true if it has points
     */
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
    
    /**
     * Sets the number of points for the tile to zero.
     */
    public void subtractPoints()
    {
        points = 0;
    }
    
    /**
     * If the tile has points, the player is awarded points and moves to the location
     * of the tile. Otherwise, the player just moves to that location.
     * @param player the player of the game
     * @param path the path of tiles
     */
    public void play(Player player, Path path)
    {
        if (this.hasPoints())
        {
            player.addPoints( points );
            this.subtractPoints();
        }
        player.moveTo( location );
    }

    /**
     * Returns the name of the character
     * @return the name of the character
     */
    public String getType()
    {
        return character;
    }
    
    /**
     * Returns the color of the tile
     * @return color
     */
    public Color getColor()
    {
        return Color.PINK;
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
