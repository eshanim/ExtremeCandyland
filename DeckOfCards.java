import java.util.*;
import java.awt.Color;


public class DeckOfCards
{
    List<Card> q;
    
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
    
    public void shuffle()
    {
        Collections.shuffle( q );
    }
    
    public Card showCard(Path p)
    {
        Card c = q.get( 0 );
        q.remove( 0 );
        q.add( c );
        c.moveTo(p);
        return c;
    }
    
}
