import java.awt.Color;
import java.lang.reflect.Field;

import info.gridworld.grid.*;
/**
 * 
 *  This class creates a Player object which will move to different locations on the
 *  board and can play on the board. The object has its own name, color, and location,
 *  and has an amount of points.
 *
 *  @author  Eshani and Juhi
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class Player
{
    /**
     * the name of the player
     */
    private String name;
    
    /**
     * the color of the player
     */
    private Color color;
    
    /**
     * the number of points the player has
     */
    private int points;
    
    /**
     * the location of the player
     */
    private Location location;
    
    /**
     * a boolean to check to see if the player lost a turn
     */
    private boolean loseTurn = false;
   
    /**
     * Constructs a new player with a given name and color
     * @param nm the name of the player
     * @param col the color of the player
     */
    public Player(String nm, Color col) 
    {
        name = nm;
        color = col;
        points = 0;
        location = new Location(14,0);
    }
    
    /**
     * Returns name of this Player
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns color of this Player
     * @return the color
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Returns points of this Player
     * @return the points
     */
    public int getPoints()
    {
        return points;
    }
    
    /**
     * Returns the location of this player
     * @return the location
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Changes the number of points to the given value
     * @param p the value of points
     */
    public void setPoints( int p )
    {
        points = p;
    }
    
    /**
     * Adds the given value to the number of points for this player
     * @param p the number of points for adding
     */
    public void addPoints (int p)
    {
        points += p;
    }
    
    /**
     * Removes the given value of points 
     * from the number of points the player has
     * @param p the number of points for subtracting
     */
    public void subtractPoints(int p)
    {
        points -= p;
    }
    
    /**
     * Puts this player at the start of the gameboard,
     * at the location of the first tile
     */
    public void putPlayerAtStart()
    {
        location = new Location(14,0);
    }
    
    /**
     * Moves this player to a new location.
     * @param loc the new location
     */
    public void moveTo(Location loc)
    {
        location = loc;
    }
    
    /**
     * Plays the turn for the player
     * @param doc the deck of cards
     * @param p the path of tiles
     */
    public void play(DeckOfCards doc, Path p)
    {
        if (loseTurn)
        {
            this.loseTurn();
            return;
        }
        doc.getCard( p, this );
    }
    
    /**
     * Causes player to lose a turn
     */
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
