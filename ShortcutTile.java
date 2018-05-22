import info.gridworld.grid.Location;

import java.awt.Color;
import java.lang.reflect.Field;

/**
 *  This color tile causes the player to move even more ahead, essentially cutting the path
 *  and going a shorter way.
 *
 *  @author  juhi
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class ShortcutTile extends ColorTile
{
    /**
     * the position of the shortcut tile
     */
    private String position;
    
    /**
     * Constructs a new shortcut tile with a given position, color, and location.
     * @param position
     * @param color
     * @param loc
     */
    ShortcutTile( String position, Color color, Location loc)
    {
        super(color, loc);
        this.position = position;
    }
    
    /**
     * returns true if the shortcut tile is a starting tile
     * @return true if start
     */
    public boolean isStart()
    {
        return position.equals( "start" );
    }
    
    /**
     * returns true if the shortcut tile is a ending tile
     * @return true if end
     */
    public boolean isEnd()
    {
        return position.equals( "end" );
    }
    
    /**
     * Causes the player to play its turn and move to the correct location
     * if the player is on a start tile, moves the player to the corresponding end tile
     * @param player the player who is currently playing
     * @param path the path of tiles
     */
    public void play(Player player, Path path)
    {
        if (this.isStart())
        {
            ColorTile tile = path.findNextShortcutTile( this.getLocation() );
            player.moveTo( tile.getLocation() );
        }
        else
        {
            player.moveTo( this.getLocation() );
        }
    }
    
    /**
     * returns a string that shows the type of tile it is
     * @return type, which is shortcut
     */
    public String getType()
    {
        return "shortcut";
    }
    
    /**
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>.
     * @return a string representation of this Brokerage.
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
