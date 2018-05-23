import java.util.*;
import java.awt.Color;
import java.lang.reflect.Field;

/**
 *  Contains a list of all the cards for the game. Can show the top card so the player
 *  sees where it is going and it can also call up a card. The cards can be shuffled
 *  in the list.
 *
 *  @author  Eshani
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class DeckOfCards
{
    /**
     * a list of all the cards
     */
    private List<Card> q;
    
    /**
     * constructs an array list with a certain number of color cards and
     * character cards
     */
    public DeckOfCards()
    {
        q = new ArrayList<Card>();
        
        for (int i = 0; i < 6; i++)
        {
            q.add( new ColorCard(Color.RED, 1) );
            q.add( new ColorCard(Color.ORANGE, 1) );
            q.add( new ColorCard(Color.YELLOW, 1) );
            q.add( new ColorCard(Color.GREEN, 1) );
            q.add( new ColorCard(Color.BLUE, 1) );
            q.add( new ColorCard(Color.MAGENTA, 1) );
        }
        for (int i = 0; i < 4; i++)
        {
            q.add( new ColorCard(Color.RED, 2) );
            q.add( new ColorCard(Color.YELLOW, 2) );
            q.add( new ColorCard(Color.BLUE, 2) );
            q.add( new ColorCard(Color.MAGENTA, 2) );
        }
        for (int i = 0; i < 3; i++)
        {
            q.add( new ColorCard(Color.ORANGE, 2) );
            q.add( new ColorCard(Color.GREEN, 2) );
        }
        
        q.add( new CharacterCard("princess lolly", 3) );
        q.add( new CharacterCard("princess frostine", 3) );
        q.add( new CharacterCard("gramma nutt", 3) );
        q.add( new CharacterCard("gingerbread man", 3) );
        q.add( new CharacterCard("plumpy", 3) );
        q.add( new CharacterCard("mr. mint", 3) );
        
    }
    
    /**
     * This randomizes the items in the deck of cards so that it is shuffled.
     */
    public void shuffle()
    {
        Collections.shuffle( q );
    }
    
    /**
     * 
     * Gets top card and calls that card's play method
     * @param p the path
     * @param player the player
     */
    public void getCard(Path p, Player player)
    {
        Card c = q.remove( 0 );
        q.add( c );
        c.moveTo(p, player);
    }
    
    /**
     * returns the deck of cards as a list
     * @return list of cards in deck of cards
     */
    public List<Card> getList()
    {
        return q;
    }
    
    /**
     * shows the top card
     * @return the top card
     */
    public Card showCard(Player player)
    {
        Card c = q.get( 0 );
        return c;
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
