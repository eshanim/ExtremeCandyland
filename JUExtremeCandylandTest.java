import java.awt.Color;

import org.junit.*;
import java.util.*;

import info.gridworld.grid.Location;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 * ExtremeCandyland Tests:
 *      Player
 *      Path
 *      DeckOfCards
 *      ColorTile
 *      CharacterTile
 *      ShortcutTile
 *      ColorCard
 *      CharacterCard
 *
 *  @author  juhi
 *  @version May 14, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */

public class JUExtremeCandylandTest
{
    //Test Player
    /**
     * Player Tests:
     *      PlayerConstructor - constructs a player with a name and color
     *      PlayerGetName - compares value returned to constructed value
     *      PlayerGetColor - compares value returned to constructed value
     *      PlayerGetPoints - compares value returned to constructed value
     *      PlayerGetLocation- compares value returned to constructed value
     *      PlayerSetPoints - sets known value & compares result
     *          returned by getPoints to expected value
     *      PlayerAddPoints - adds known value & compares result
     *          returned by getPoints to expected value
     *      PlayerSubtractPoints - subtracts known value & compares result
     *          returned by getPoints to expected value
     *      PlayerPutPlayerAtStart - compares value returned to constructed value
     *      PlayerMoveTo - compares value returned to constructed value
     *      PlayerPlay - compares value returned to constructed value
     *      PlayerLoseTurn - compares value returned to constructed value
     */
    
    private String name = "bop";
    private Color color = Color.BLUE;
    private int points = 0;
    private Location loc = new Location(14,0);
    
    @Test
    public void playerConstructor()
    {
        Player p = new Player(name, color);
        assertNotNull( p.toString() );
    }
    
    
    @Test
    public void playerGetName()
    {
        Player p = new Player(name, color);
        assertEquals("<< Player: " + p.getName() + " should be "
                        + name + " >>", name, p.getName());
    }
    
    @Test
    public void playerGetColor()
    {
        Player p = new Player(name, color);
        assertEquals("<< Player: " + p.getColor() + " should be "
                        + color + " >>", color, p.getColor());
    }
    
    @Test
    public void playerGetPoints()
    {
        Player p = new Player(name, color);
        assertEquals("<< Player: " + p.getPoints() + " should be "
                        + points + " >>", points, p.getPoints());
    }
    
    @Test
    public void playerGetLocation()
    {
        Player p = new Player(name, color);
        assertEquals( "<< Player: " + p.getLocation().toString() + " should be " + "(14, 0)"
            + ">>", "(14, 0)", p.getLocation().toString());
    }
    
    @Test
    public void playerSetPoints()
    {
        Player p = new Player(name, color);
        p.setPoints( 5 );
        assertEquals( "<< Player: setPoints(" + 5 + 
            ") should be " + (points + 5) + ">>", 5, p.getPoints() );
    }
    
    @Test
    public void playerAddPoints()
    {
        Player p = new Player(name, color);
        p.addPoints( 10 );
        assertEquals( "<< Player: addPoints(" + 10
            + ") should be " + ( points + 10 ) + ">>", points + 10, p.getPoints() );
    }
    
    @Test
    public void playerSubtractPoints()
    {
        Player p = new Player(name, color);
        p.setPoints( 20 );
        p.subtractPoints( 5 );
        assertEquals( "<< Player: subtractPoints(" + 5
            + ") should be " + ( 20 - 5 ) + ">>", 20 - 5, p.getPoints() );
    }
    
    @Test
    public void playerMoveTo()
    {
        Player p = new Player(name, color);
        p.moveTo( new Location(0, 5) );
        assertEquals( "<< Player: " + p.getLocation().toString() + " should be " + "(0, 5)"
                        + ">>", "(0, 5)", p.getLocation().toString());
    }
    
    @Test
    public void playerPutPlayerAtStart()
    {
        Player p = new Player(name, color);
        p.moveTo( new Location(0, 5) );
        p.putPlayerAtStart();
        assertEquals( "<< Player: " + p.getLocation().toString() + " should be " + "(14, 0)"
                        + ">>", "(14, 0)", p.getLocation().toString());
    }
    
    @Test
    public void playerPlay()
    {
        Player pl = new Player(name, color);
        DeckOfCards doc = new DeckOfCards();
        Path p = new Path();
        pl.play( doc, p );
        assertNotSame("<<Player should move>>", pl.getLocation(), loc );
        assertNotSame("<<Player should get points>>", pl.getPoints(), points );
    }
    
    @Test
    public void playerLoseTurn()
    {
        Player pl = new Player(name, color);
        DeckOfCards doc = new DeckOfCards();
        Path p = new Path();
        pl.loseTurn();
        pl.play( doc, p );
        assertEquals( "<< Player should not move>>", pl.getLocation(), loc);
        assertEquals("<<Player should not get points>>", pl.getPoints(), 0);
        //after losing one turn, the player should be able to play again as normal
        pl.play( doc, p );
        assertNotSame("<<Player should move>>", pl.getLocation(), loc );
        assertNotSame("<<Player:" + pl.getPoints() + "should be" + 0 + ">>", 
            pl.getPoints(), points );
        
    }
    
    // Test Path
    /**
     * Path Tests:
     *      PathConstructor - constructs a map and an array of tiles with locations
     *      PathGetMap - compares value returned to constructed value
     *      PathFindNextColorTile - compares value returned to constructed value
     *      PathFindNext2ColorTile - compares value returned to constructed value
     *      PathFindCharacterTile - compares value returned to constructed value
     *      PathFindNextShortcutTile - compares value returned to constructed value
     */
    
    private String character = "gingerbread man";
    
    @Test
    public void pathConstructor()
    {
        Path p = new Path();
        assertNotNull( p.toString() );
    }
    
    @Test
    public void pathGetList()
    {
        Path p = new Path();
        assertEquals("<<path should have 134 items in its list>>", p.getList().size(), 134);
    }
    
    @Test
    public void pathFindNextColorTile()
    {
        Path p = new Path();
        ColorTile t = p.findNextColorTile( loc, color );
        assertEquals( "<< Path: " + t + " should be " + p.getList().get( 3 )
            + ">>", p.getList().get( 3 ), t);
        
    }
    
    @Test
    public void pathFindNext2ColorTile()
    {
        Path p = new Path();
        ColorTile t = p.findNext2ColorTile( loc, color );
        assertEquals( "<< Path: " + t + " should be " + p.getList().get( 10 )
            + ">>", p.getList().get( 10 ), t);
    }
    
    @Test
    public void pathFindCharacterTile()
    {
        Path p = new Path();
        ColorTile t = p.findCharacterTile( character );
        assertEquals( "<< Path: " + t + " should be " + p.getList().get( 8 )
            + ">>", p.getList().get( 8 ), t);
    }
    
    @Test
    public void pathFindNextShortcutTile()
    {
        Path p = new Path();
        ColorTile t = p.findNextShortcutTile(new Location(14,4));
        assertEquals( "<< Path: " + t + " should be " + p.getList().get( 58 )
            + ">>", p.getList().get( 58 ), t);
    }
    
    //Test ColorTile
    /**
     * ColorTile Tests:
     *      ColorTileConstructor - Constructs a colortile with a color and location
     *      ColorTileGetLocation - compares value returned to constructed value
     *      ColorTileSetLocation - compares value returned to constructed value
     *      ColorTileGetColor - compares value returned to constructed value
     *      ColorTileAddPoints - adds known value & compares result
     *      ColorTilePlay - compares value returned to constructed value
     *      ColorTileGetType - compares value returned to constructed value
     *      ColorTileIsLicorice - compares value returned to constructed value
     *      ColorTileIsEnd - compares value returned to constructed value
     */
    
    
    @Test
    public void colorTileConstructor()
    {
        ColorTile t = new ColorTile(color, loc);
        assertNotNull( t.toString() );
    }
    
    @Test
    public void colorTileGetLocation()
    {
        ColorTile t = new ColorTile(color, loc);
        assertEquals( "<< ColorTile: " + t.getLocation().toString() + " should be " + "(14, 0)"
            + ">>", "(14, 0)", t.getLocation().toString());
    }
    
    @Test
    public void colorTileSetLocation()
    {
        ColorTile t = new ColorTile(color, loc);
        t.setLocation( new Location(0,5) );
        assertEquals( "<< ColorTile: " + t.getLocation().toString() + " should be " + "(0, 5)"
            + ">>", "(0, 5)", t.getLocation().toString());
    }
    
    @Test
    public void colorTileGetColor()
    {
        ColorTile t = new ColorTile(color, loc);
        assertEquals( "<< ColorTile: " + t.getColor() + " should be " + color
            + ">>", color, t.getColor());
    }
    
    @Test
    public void colorTileAddPoints()
    {
        Player p = new Player(name, color);
        ColorTile t = new ColorTile(color, loc);
        t.addPoints( p );
        assertEquals( "<< ColorTile: addPoints(if same color) should be " 
        + 2 + ">>", points + 2, p.getPoints() );
        ColorTile m = new ColorTile(Color.GREEN, new Location(0,5));
        p.setPoints( 0 );
        m.addPoints( p );
        assertEquals( "<< ColorTile: addPoints(if different color) should be " 
                        + 1 + ">>", points + 1, p.getPoints() );
        p.setPoints( 0 );
        m.isLicorice();
        assertEquals( "<< ColorTile: addPoints(if licorice) should be " 
                        + 0 + ">>", points + 0, p.getPoints() );
    }
    
    @Test
    public void colorTilePlay()
    {
        Player pl = new Player(name, color);
        ColorTile t = new ColorTile(color, new Location(14, 1));
        Path p = new Path();
        t.play( pl, p );
        assertEquals("<<Player should move to that tile>>", pl.getLocation(),
            new Location(14, 1) );
        assertEquals("<<Player should get 2 points>>", pl.getPoints(), 2 );
        
    }
    
    @Test
    public void colorTileGetType()
    {
        ColorTile t = new ColorTile(color, loc);
        assertEquals( "<< ColorTile: " + t.getType() + " should be " + "color"
            + ">>", "color", t.getType());
    }
    
    @Test
    public void colorTileIsLicorice()
    {
        Player pl = new Player(name, color);
        ColorTile t = new ColorTile(color, new Location(14, 1));
        Path p = new Path();
        DeckOfCards doc = new DeckOfCards();
        t.isLicorice();
        t.play( pl, p );
        assertEquals("<<Player should move to that tile>>", pl.getLocation(),
            new Location(14, 1) );
        assertEquals("<<Player should not get points>>", pl.getPoints(), 0);   
        pl.play( doc, p );
        assertEquals( "<< Player should not move>>", pl.getLocation(), new Location(14, 1));
        assertEquals("<<Player should not get points>>", pl.getPoints(), 0);
        //after losing one turn, the player should be able to play again as normal
        pl.play( doc, p );
        assertNotSame("<<Player should move>>", pl.getLocation(), new Location(14, 1) );
        assertNotSame("<<Player: " + pl.getPoints() + " should not be " + 0 + " >>", 
            pl.getPoints(), points );
    }
    
    @Test
    public void colorTileIsEnd()
    {
        ColorTile t = new ColorTile(color, loc);
        assertFalse( "<< ColorTile should not be end", t.isEnd());
    }
    
    //DeckOfCards
    /**
     * DeckOfCards Tests:
     *      DeckOfCardsConstructor - creates a deck of cards with a list of cards
     *      DeckOfCardsShuffle - compares value returned to constructed value
     *      DeckOfCardsGetCard - compares value returned to constructed value
     *      DeckOfCardsGetList - compares value returned to constructed value
     *      DeckOfCardsShowCard - compares value returned to constructed value
     *      
     */
    
    @Test
    public void deckOfCardsConstructor()
    {
        DeckOfCards doc = new DeckOfCards();
        assertNotNull( doc.toString() );
    }
    
    @Test
    public void deckOfCardsShuffle()
    {
        DeckOfCards doc = new DeckOfCards();
        Card a = doc.getList().get( 0 );
        Card b = doc.getList().get( doc.getList().size() - 1 );
        doc.shuffle();
        List<Card> l = doc.getList();
        Card c = l.get( 0 );
        Card d = l.get( doc.getList().size() - 1 );
        assertNotSame("<<Deck of Cards: " + a + "should not be the same as" + c + ">>", a, c);
        assertNotSame("<<Deck of Cards: " + b + "should not be the same as" + d + ">>", b, d);
    }
    
    @Test
    public void deckOfCardsGetCard()
    {
        DeckOfCards doc = new DeckOfCards();
        Path p = new Path();
        Player pl = new Player(name, color);
        doc.shuffle();
        Card a = doc.getList().get( 0 );
        Card b = doc.getList().get( 1 );
        doc.getCard( p, pl );
        Card c = doc.getList().get( 0 );
        Card d = doc.getList().get( doc.getList().size() - 1 );
        assertEquals("<<Deck of Cards should be same>>", a, d);
        assertEquals("<<Deck of Cards should be same>>", b, c);
    }
    
    @Test
    public void deckOfCardsGetList()
    {
        DeckOfCards doc = new DeckOfCards();
        assertEquals("<<Deck of Cards" + doc.getList().size() + "should be" + 64 +">>",
            doc.getList().size(), 64);
    }
    
    @Test
    public void deckOfCardsShowCard()
    {
        DeckOfCards doc = new DeckOfCards();
        assertEquals("<<ColorTile: " + doc.showCard() + " should be "
                        + doc.getList().get( 0 ) + " >>", doc.getList().get( 0 ), doc.showCard());
    }
    
    //ColorCard
    /**
     * ColorCard Tests:
     *      ColorCardConstructor - creates a colorcard object with a color and number of spaces
     *      ColorCardGetColor - compares value returned to constructed value
     *      ColorCardGetNumSpaces - compares value returned to constructed value
     *      ColorCardMoveTo - compares value returned to constructed value
     */
    
    private int numSpaces = 1;
    
    @Test
    public void colorCardConstructor()
    {
        ColorCard c = new ColorCard(color, numSpaces);
        assertNotNull( c.toString() );
    }
    
    @Test
    public void colorCardGetColor()
    {
        ColorCard c = new ColorCard(color, numSpaces);
        assertEquals("<<Should be blue>>", color, c.getColor());
    }
    
    @Test
    public void colorCardGetNumSpaces()
    {
        ColorCard c = new ColorCard(color, numSpaces);
        assertEquals("<<Should be 1>>", numSpaces, c.getNumSpaces());
    }
    
    @Test
    public void colorCardMoveTo()
    {
        ColorCard c = new ColorCard(color, numSpaces);
        Player pl = new Player(name, color);
        Path p = new Path();
        c.moveTo( p, pl );
        assertEquals("<<should be (14,3)>>", pl.getLocation(), p.getList().get( 3 ).getLocation());
        assertEquals("<<should be 2>>", pl.getPoints(), 2);
    }
    
    //CharacterCard
    /**
     * CharacterCard Tests:
     *      CharacterCardConstructor - constructs a character card object with a string character
     *      CharacterCardGetCharacter - compares value returned to constructed value
     *      CharacterCardGetPoints - compares value returned to constructed value
     *      CharacterCardMoveTo - compares value returned to constructed value
     */
    
    private int cpoints = 3;
    
    @Test
    public void characterCardConstructor()
    {
        CharacterCard c = new CharacterCard(character, cpoints);
        assertNotNull( c.toString() );
    }
    
    @Test
    public void characterCardGetCharacter()
    {
        CharacterCard c = new CharacterCard(character, cpoints);
        assertEquals("<<Should be" + character + ">>", character, c.getCharacter());
    }
    
    @Test
    public void characterCardGetPoints()
    {
        CharacterCard c = new CharacterCard(character, cpoints);
        assertEquals("<<Should be 3>>", cpoints, c.getPoints());
    }
    
    @Test
    public void characterCardMoveTo()
    {
        CharacterCard c = new CharacterCard(character, cpoints);
        Player pl = new Player(name, color);
        Path p = new Path();
        c.moveTo( p, pl );
        assertEquals("<<should be (14,8)>>", pl.getLocation(), p.getList().get( 8 ).getLocation());
        assertEquals("<<should be 3>>", pl.getPoints(), 3);
        
    }
    
    //CharacterTile
    /**
     * CharacterTile Tests:
     *      CharacterTileConstructor - constructs a tile with a character
     *      CharacterTileGetLocation - compares value returned to constructed value
     *      CharacterTileSetLocation - sets known value & compares result
     *      CharacterTileHasPoints - compares value returned to constructed value
     *      CharacterTileSubtractPoints - subtracts known value & compares result
     *      CharacterTilePlay - compares value returned to constructed value
     *      CharacterTileGetType - compares value returned to constructed value
     *      CharacterTileGetColor - compares value returned to constructed value
     *      CharacterTileIsEnd - compares value returned to constructed value
     */
    
    @Test
    public void characterTileConstructor()
    {
        CharacterTile t = new CharacterTile(character, cpoints, loc);
        assertNotNull( t.toString() );
    }
    
    @Test
    public void characterTileGetLocation()
    {
        CharacterTile t = new CharacterTile(character, cpoints, loc);
        assertEquals( "<< CharacterTile: " + t.getLocation().toString() + " should be " + "(14, 0)"
                        + ">>", "(14, 0)", t.getLocation().toString());
    }
    
    @Test
    public void characterTileSetLocation()
    {
        CharacterTile t = new CharacterTile(character, cpoints, loc);
        t.setLocation( new Location(14, 5) );
        assertEquals( "<< CharacterTile: " + t.getLocation().toString() + " should be " + "(14, 5)"
                        + ">>", "(14, 5)", t.getLocation().toString());
    }
    
    @Test
    public void characterTileHasPoints()
    {
        CharacterTile t = new CharacterTile(character, cpoints, loc);
        assertTrue("<<should have points>>", t.hasPoints());
    }
    
    @Test
    public void characterTileSubtractPoints()
    {
        CharacterTile t = new CharacterTile(character, cpoints, loc);
        t.subtractPoints();
        assertFalse("<<should no longer have points>>", t.hasPoints());
    }
    
    @Test
    public void characterTilePlay()
    {
        Player pl = new Player(name, color);
        CharacterTile t = new CharacterTile(character, cpoints, new Location(14,8));
        Path p = new Path();
        t.play( pl, p );
        assertEquals("<<Player should move to that tile>>", pl.getLocation(),
            new Location(14, 8) );
        assertEquals("<<Player should get 3 points>>", pl.getPoints(), 3 );
        assertFalse("<<It should lose all of its points>>", t.hasPoints());
    }
    
    @Test
    public void characterTileGetType()
    {
        CharacterTile t = new CharacterTile(character, cpoints, loc);
        assertEquals("<<should be character>>", character, t.getType());
    }
    
    @Test
    public void characterTileGetColor()
    {
        CharacterTile t = new CharacterTile(character, cpoints, loc);
        assertEquals("<<should be pink>>", Color.PINK, t.getColor());
    }
    
    @Test
    public void characterTileIsEnd()
    {
        CharacterTile t = new CharacterTile(character, cpoints, loc);
        assertFalse("<<should be false>>", t.isEnd());
    }
    
    //ShortcutTile
    /**
     * ShortcutTile Tests:
     *      ShortcutTileConstructor - Constructs a new short cut tile with a position
     *      ShortcutTileIsStart - compares value returned to constructed value
     *      ShortcutTileIsEnd - compares value returned to constructed value
     *      ShortcutTilePlay - compares value returned to constructed value
     *      ShortcutTileGetType - compares value returned to constructed value
     */
    
    private String start = "start";
    private String end = "end";
    
    @Test
    public void shortcutTileConstructor()
    {
        ShortcutTile t = new ShortcutTile(start, color, loc);
        assertNotNull( t.toString() );
    }
    
    @Test
    public void shortcutTileIsStart()
    {
        ShortcutTile t = new ShortcutTile(start, color, loc);
        assertTrue("<<should be start>>", t.isStart());
        ShortcutTile f = new ShortcutTile(end, color, loc);
        assertFalse("<<should not be start>>", f.isStart());
    }
    
    @Test
    public void shortcutTileIsEnd()
    {
        ShortcutTile t = new ShortcutTile(start, color, loc);
        assertFalse("<<should be start>>", t.isEnd());
        ShortcutTile f = new ShortcutTile(end, color, loc);
        assertTrue("<<should not be start>>", f.isEnd());
    }
    
    
    @Test
    public void shortcutTilePlay()
    {
        Player pl = new Player(name, color);
        Path p = new Path();
        ShortcutTile t = new ShortcutTile(start, Color.GREEN, new Location(14,4));
        t.play( pl, p );
        assertEquals("<<player should have moved to end tile>>", pl.getLocation(), 
            new Location(11,5));
        pl.putPlayerAtStart();
        ShortcutTile f = new ShortcutTile(end, color, loc);
        f.play( pl, p );
        assertEquals("<<player should have moved to end>>", pl.getLocation(), loc );
    }
    
    @Test
    public void shortcutTileGetType()
    {
        ShortcutTile t = new ShortcutTile(start, color, loc);
        assertEquals("<<should be shortcut", "shortcut", t.getType());
    }
}
