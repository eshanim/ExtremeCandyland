import java.awt.Color;
import java.lang.reflect.Field;

/**
 *  A Card with a specific color and number of spaces. The card is associated with a specific
 *  tile, which helps connect the player with the tile.
 *
 *  @author  Eshani
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class ColorCard implements Card
{
    /**
     * the color of the card
     */
    private Color color;
    
    /**
     * the number of spaces on the card
     */
    private int numSpaces;
    
    /**
     * Constructs a new card with a given color and number of spaces
     * @param col the color of the card
     * @param numOfSpaces the number of spaces on the card
     */
    public ColorCard(Color col, int numOfSpaces)
    {
        color = col;
        numSpaces = numOfSpaces;
    }
    
    /**
     * Returns the color of the card
     * @return the color
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Returns the number of spaces on the card
     * @return the number of spaces
     */
    public int getNumSpaces()
    {
        return numSpaces;
    }
    
    /**
     * Finds the tile associated with the card and calls the tile's play method
     * so that the player can move to that tile.
     */
    public void moveTo(Path p, Player player) 
    {
        ColorTile t;
        if (numSpaces == 1)
        {
            t = p.findNextColorTile(player.getLocation(), this.getColor());
        }
        else
        {
            t = p.findNext2ColorTile(player.getLocation(), this.getColor());
        }
        t.play(player, p);
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