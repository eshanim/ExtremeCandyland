import java.lang.reflect.Field;

/**
 *  A card with a character name and a certain number of points. The card is associated with 
 *  a specific tile, which helps connect the player with the tile.
 *
 *  @author  Eshani
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class CharacterCard implements Card
{
    /**
     * a string of the name of the character
     */
    private String character;
    
    /**
     * the number of points the card has
     */
    private int points;
    
    /**
     * Constructs a card with a given name for the character and a given number of points
     * @param charac the character name
     * @param point the number of points
     */
    public CharacterCard( String charac, int point )
    {
        character = charac;
        points = point;
    }
     
    /**
     * Returns the name of the character of the card
     * @return the character name
     */
    public String getCharacter()
    {
        return character;
    }
    
    /**
     * Returns the number of points the card has.
     * @return the number of points
     */
    public int getPoints()
    {
        return points;
    }
    
    /**
     * Causes the player to move to the tile with the same character as the card.
     */
    public void moveTo(Path p, Player player)
    {
        ColorTile t = p.findCharacterTile(this.getCharacter());
        t.play( player, p );
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