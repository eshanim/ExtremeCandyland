import java.awt.Color;
import java.util.*;

import info.gridworld.grid.Location;

/**
 *  This class makes a path of tiles, which is an arraylist that includes all of the tiles.
 *  The path is used for other classes to find the tile that the player needs to go to
 *  after calling a class. The class includes methods to find the next color tile in a path
 *  after a given location, the second next color tile, a character tile, and a shortcut tile.
 *
 *  @author  juhi
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class Path
{
    
    /**
     * an array list which stands as an index for all the tiles
     */
    private ArrayList<ColorTile> q;
    
    /**
     * Constructs a new path with all the tiles included
     */
    public Path()
    {
        q = new ArrayList<ColorTile>();
        ColorTile licorice1 = new ColorTile( Color.MAGENTA, new Location(8,14) );
        licorice1.isLicorice();
        ColorTile licorice2 = new ColorTile( Color.BLUE, new Location(4, 7) );
        licorice2.isLicorice();
        ColorTile licorice3 = new ColorTile( Color.YELLOW, new Location(0,6) );
        licorice3.isLicorice();
        q.add( new ColorTile( Color.RED, new Location(14,0) ) ); //0
        q.add( new ColorTile( Color.MAGENTA, new Location(14,1) ) ); //1
        q.add( new ColorTile( Color.YELLOW, new Location(14,2) ) ); //2
        q.add( new ColorTile( Color.BLUE, new Location(14,3) ) ); //3
        q.add( new ShortcutTile( "start", Color.GREEN, new Location(14,4) ) ); //4
        q.add( new ColorTile( Color.ORANGE, new Location(14,5) ) ); //5
        q.add( new ColorTile( Color.RED, new Location(14,6) ) ); //6
        q.add( new ColorTile( Color.MAGENTA, new Location(14,7) ) ); //7
        q.add( new CharacterTile( "gingerbread man", 3, new Location( 14,8) ) ); //8
        q.add( new ColorTile( Color.YELLOW, new Location(14,9) ) ); //9
        q.add( new ColorTile( Color.BLUE, new Location(14,10) ) ); //10
        q.add( new ColorTile( Color.GREEN, new Location(14,11) ) ); //11
        q.add( new ColorTile( Color.ORANGE, new Location(14,12) ) ); //12
        q.add( new ColorTile( Color.RED, new Location(14,13) ) ); //13
        q.add( new ColorTile( Color.MAGENTA, new Location(14,14) ) ); //14
        q.add( new ColorTile( Color.YELLOW, new Location(14,15) ) ); //15
        q.add( new ColorTile( Color.BLUE, new Location(14,16) ) ); //16
        q.add( new ColorTile( Color.GREEN, new Location(14,17) ) ); //17
        q.add( new ColorTile( Color.ORANGE, new Location(14,18) ) ); //18
        q.add( new CharacterTile( "mr. mint", 3, new Location( 14,19) ) ); //19
        q.add( new ColorTile( Color.RED, new Location(13,19) ) ); //20
        q.add( new ColorTile( Color.MAGENTA, new Location(12,19) ) ); //21
        q.add( new ColorTile( Color.YELLOW, new Location(12,18) ) ); //22
        q.add( new ColorTile( Color.BLUE, new Location(12,17) ) ); //23
        q.add( new ColorTile( Color.GREEN, new Location(12,16) ) ); //24
        q.add( new ColorTile( Color.ORANGE, new Location(12,15) ) ); //25
        q.add( new ColorTile( Color.RED, new Location(12,14) ) ); //26
        q.add( new ColorTile( Color.MAGENTA, new Location(12,13) ) ); //27
        q.add( new ColorTile( Color.YELLOW, new Location(12,12) ) ); //28
        q.add( new ColorTile( Color.BLUE, new Location(12,11) ) ); //29
        q.add( new ColorTile( Color.GREEN, new Location(11,11) ) ); //30
        q.add( new ColorTile( Color.ORANGE, new Location(10,11) ) ); //31
        q.add( new ColorTile( Color.RED, new Location(10,12) ) ); //32
        q.add( new ColorTile( Color.MAGENTA, new Location(10, 13) ) ); //33
        q.add( new ShortcutTile( "start", Color.YELLOW, new Location(10, 14) ) ); //34
        q.add( new ColorTile( Color.BLUE, new Location(10,15) ) ); //35
        q.add( new ColorTile( Color.GREEN, new Location(10,16) ) ); //36
        q.add( new ColorTile( Color.ORANGE, new Location(10,17) ) ); //37
        q.add( new ColorTile( Color.RED, new Location(10,18) ) ); //38
        q.add( new ColorTile( Color.MAGENTA, new Location(10, 19) ) ); //39
        q.add( new ColorTile( Color.YELLOW, new Location(9,19) ) ); //40
        q.add( new CharacterTile("plumpy", 3, new Location(8,19) ) ); //41
        q.add( new ColorTile( Color.BLUE, new Location(8,18) ) ); //42
        q.add( new ColorTile( Color.GREEN, new Location(8,17) ) ); //43
        q.add( new ColorTile( Color.ORANGE, new Location(8,16) ) ); //44
        q.add( new ShortcutTile( "end", Color.RED, new Location(8,15) ) ); //45
        q.add( licorice1 ); //46
        q.add( new ColorTile( Color.YELLOW, new Location(8,13) ) ); //47
        q.add( new ColorTile( Color.BLUE, new Location(8,12) ) ); //48
        q.add( new ColorTile( Color.GREEN, new Location(8,11) ) ); //49
        q.add( new ColorTile( Color.ORANGE, new Location(8,10) ) ); //50
        q.add( new ColorTile( Color.RED, new Location(8,9) ) ); //51
        q.add( new ColorTile( Color.MAGENTA, new Location(9,9) ) ); //52
        q.add( new ColorTile( Color.YELLOW, new Location(10,9) ) ); //53
        q.add( new ColorTile( Color.BLUE, new Location(11,9) ) ); //54
        q.add( new ColorTile( Color.GREEN, new Location(11,8) ) ); //55
        q.add( new ColorTile( Color.ORANGE, new Location(11,7) ) ); //56
        q.add( new ColorTile( Color.RED, new Location(11,6) ) ); //57
        q.add( new ShortcutTile( "end", Color.MAGENTA, new Location(11, 5) ) ); //58
        q.add( new ColorTile( Color.YELLOW, new Location(11,4) ) ); //59
        q.add( new ColorTile( Color.BLUE, new Location(11,3) ) ); //60
        q.add( new ColorTile( Color.GREEN, new Location(11,2) ) ); //61
        q.add( new ColorTile( Color.ORANGE, new Location(11,1) ) ); //62
        q.add( new ColorTile( Color.RED, new Location(11,0) ) ); //63
        q.add( new ColorTile( Color.MAGENTA, new Location(10,0) ) ); //64
        q.add( new ColorTile( Color.YELLOW, new Location(9,0) ) ); //65
        q.add( new ColorTile( Color.BLUE, new Location(8,0) ) ); //66
        q.add( new ColorTile( Color.GREEN, new Location(7,0) ) ); //67
        q.add( new CharacterTile("gramma nutt", 3, new Location(6,0) ) ); //68
        q.add( new ColorTile( Color.ORANGE, new Location(6,1) ) ); //69
        q.add( new ColorTile( Color.RED, new Location(6,2) ) ); //70
        q.add( new ColorTile( Color.MAGENTA, new Location(6, 3) ) ); //71
        q.add( new ColorTile( Color.YELLOW, new Location(6,4) ) ); //72
        q.add( new ColorTile( Color.BLUE, new Location(6,5) ) ); //73
        q.add( new ColorTile( Color.GREEN, new Location(6,6) ) ); //74
        q.add( new ColorTile( Color.ORANGE, new Location(6,7) ) ); //75
        q.add( new ColorTile( Color.RED, new Location(6,8) ) ); //76
        q.add( new ColorTile( Color.MAGENTA, new Location(6,9) ) ); //77
        q.add( new ColorTile( Color.YELLOW, new Location(6,10) ) ); //78
        q.add( new ColorTile( Color.BLUE, new Location(6,11) ) ); //79
        q.add( new ColorTile( Color.GREEN, new Location(5,11) ) ); //80
        q.add( new ColorTile( Color.ORANGE, new Location(4,11) ) ); //81
        q.add( new ColorTile( Color.RED, new Location(4,10) ) ); //82
        q.add( new ColorTile( Color.MAGENTA, new Location(4, 9) ) ); //83
        q.add( new ColorTile( Color.YELLOW, new Location(4,8) ) ); //84
        q.add( licorice2 ); //85
        q.add( new ColorTile( Color.GREEN, new Location(4,6) ) ); //86
        q.add( new ColorTile( Color.ORANGE, new Location(3, 6) ) ); //87
        q.add( new ColorTile( Color.RED, new Location(2, 6) ) ); //88
        q.add( new ColorTile( Color.MAGENTA, new Location(2, 7) ) ); //89
        q.add( new ColorTile( Color.YELLOW, new Location(2,8) ) ); //90
        q.add( new CharacterTile("princess lolly", 3, new Location(2,9) ) ); //91
        q.add( new ColorTile( Color.BLUE, new Location(2,10) ) ); //92
        q.add( new ColorTile( Color.GREEN, new Location(2,11) ) ); //93
        q.add( new ColorTile( Color.ORANGE, new Location(2,12) ) ); //94
        q.add( new ColorTile( Color.RED, new Location(2,13) ) ); //95
        q.add( new ColorTile( Color.MAGENTA, new Location(2, 14) ) ); //96
        q.add( new ColorTile( Color.YELLOW, new Location(2,15) ) ); //97
        q.add( new ColorTile( Color.BLUE, new Location(2,16) ) ); //98
        q.add( new ColorTile( Color.GREEN, new Location(2,17) ) ); //99
        q.add( new ColorTile( Color.ORANGE, new Location(2, 18) ) ); //100
        q.add( new CharacterTile("princess frostine", 3, new Location(2,19) ) ); //101
        q.add( new ColorTile( Color.RED, new Location(1,19) ) ); //102
        q.add( new ColorTile( Color.MAGENTA, new Location(0,19) ) ); //103
        q.add( new ColorTile( Color.YELLOW, new Location(0,18) ) ); //104
        q.add( new ColorTile( Color.BLUE, new Location(0,17) ) ); //105
        q.add( new ColorTile( Color.GREEN, new Location(0,16) ) ); //106
        q.add( new ColorTile( Color.ORANGE, new Location(0,15) ) ); //107
        q.add( new ColorTile( Color.RED, new Location(0,14) ) ); //108
        q.add( new ColorTile( Color.MAGENTA, new Location(0, 13) ) ); //109
        q.add( new ColorTile( Color.YELLOW, new Location(0,12) ) ); //110
        q.add( new ColorTile( Color.BLUE, new Location(0,11) ) ); //111
        q.add( new ColorTile( Color.GREEN, new Location(0,10) ) ); //112
        q.add( new ColorTile( Color.ORANGE, new Location(0,9) ) ); //113
        q.add( new ColorTile( Color.RED, new Location(0,8) ) ); //114
        q.add( new ColorTile( Color.MAGENTA, new Location(0,7) ) ); //115
        q.add( licorice3 ); //116
        q.add( new ColorTile( Color.BLUE, new Location(0,5) ) ); //117
        q.add( new ColorTile( Color.GREEN, new Location(0,4) ) ); //118
        q.add( new ColorTile( Color.ORANGE, new Location(1,4) ) ); //119
        q.add( new ColorTile( Color.RED, new Location(2,4) ) ); //120
        q.add( new ColorTile( Color.MAGENTA, new Location(3, 4) ) ); //121
        q.add( new ColorTile( Color.YELLOW, new Location(4,4) ) ); //122
        q.add( new ColorTile( Color.BLUE, new Location(4,3) ) ); //123
        q.add( new ColorTile( Color.GREEN, new Location(4,2) ) ); //124
        q.add( new ColorTile( Color.ORANGE, new Location(4,1) ) ); //125
        q.add( new ColorTile( Color.RED, new Location(4,0) ) ); //126
        q.add( new ColorTile( Color.MAGENTA, new Location(3, 0) ) ); //127
        q.add( new ColorTile( Color.YELLOW, new Location(2,0) ) ); //128
        q.add( new ColorTile( Color.BLUE, new Location(1,0) ) ); //129
        q.add( new ColorTile( Color.GREEN, new Location(0,0) ) ); //130
        q.add( new ColorTile( Color.ORANGE, new Location(0,1) ) ); //131
        q.add( new ColorTile( Color.RED, new Location(0,2) ) ); //132
        q.add( new ColorTile( Color.GRAY, new Location(1,2) ) ); //133
        
    }
    
    /**
     * returns the list with all the tiles in it
     * @return a list of color tiles
     */
    public ArrayList<ColorTile> getList()
    {
        return q;
    }
    
    /**
     * Returns the next tile of a specific color after a given location
     * for the player to move on
     * @param loc the location of the player
     * @param color the color needed to find
     * @return the tile the player needs to move to
     */
    public ColorTile findNextColorTile(Location loc, Color color)
    {
        Iterator<ColorTile> it = q.listIterator();
        while (it.hasNext())
        {
            ColorTile t = it.next();
            if (t.getLocation().equals( loc ))
            {
                int j = q.indexOf( t );
                for (int i = j + 1; i < q.size(); i++)
                {
                    ColorTile x = q.get( i );
                    if (x.getColor().equals( color ))
                    {
                        return x;
                    }
                }
            }
        }
        return q.get( q.size() - 1 );
    }
    
    /**
     * Returns the next next tile of a specific color after a given location
     * for the player to move on
     * @param loc the location of the player
     * @param color the color needed to find
     * @return the tile the player needs to move to
     */
    public ColorTile findNext2ColorTile(Location loc, Color color)
    {
        
        Iterator<ColorTile> it = q.listIterator();
        while (it.hasNext())
        {
            ColorTile t = it.next();
            if (t.getLocation().equals( loc ))
            {
                int j = q.indexOf( t );
                for (int i = j + 1; i < q.size(); i++)
                {
                    ColorTile x = q.get( i );
                    if (x.getColor().equals( color ))
                    {
                        j = q.indexOf( x );
                        for (int h = j + 1; h < q.size(); h++)
                        {
                            ColorTile m = q.get( h );
                            if (m.getColor().equals( color ))
                            {
                                return m;
                            }
                        }
                    }
                }
            }
        }
        return q.get( q.size() - 1 );
    }
    
    /**
     * Finds the tile with the corresponding character as the given character
     * @param character the character of the tile
     * @return a tile with a character
     */
    public ColorTile findCharacterTile(String character)
    {
        for(ColorTile tile: q)
        {
            if (tile.getType().equals( character ))
            {
                return tile;
            }
        }
        return q.get( q.size() - 1 );
    }
    
    /**
     * Finds the tile with the corresponding shortcut tile that is given
     * using the location
     * @param loc the location of the player
     * @return the corresponding shortcut tile
     */
    public ColorTile findNextShortcutTile(Location loc)
    {
        if (loc.equals( new Location(14 , 4) ))
        {
            return q.get( 58 );
        }
        if (loc.equals( new Location(10, 14) ))
        {
            return q.get( 45 );
        } 
        return q.get( 133 );
    }
    

}
