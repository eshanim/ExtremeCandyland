import java.awt.Color;
import java.util.*;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class Path
{
    private TreeMap<Location, Tile> tileMap;
    private ArrayList<Tile> tileIndex;
    
    public Path()
    {
        Queue<Tile> q = new LinkedList<Tile>();
        ColorTile licorice1 = new ColorTile( Color.MAGENTA, new Location(8,14) );
        licorice1.isLicorice();
        ColorTile licorice2 = new ColorTile( Color.BLUE, new Location(4, 7) );
        licorice2.isLicorice();
        ColorTile licorice3 = new ColorTile( Color.YELLOW, new Location(0,6) );
        licorice3.isLicorice();
        q.add( new ColorTile( Color.RED, new Location(14,0) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(14,1) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(14,2) ) );
        q.add( new ColorTile( Color.BLUE, new Location(14,3) ) );
        q.add( new ShortcutTile( "start", Color.GREEN, new Location(14,4) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(14,5) ) );
        q.add( new ColorTile( Color.RED, new Location(14,6) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(14,7) ) );
        q.add( new CharacterTile( "gingerbread man", 3, new Location( 14,8) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(14,9) ) );
        q.add( new ColorTile( Color.BLUE, new Location(14,10) ) );
        q.add( new ColorTile( Color.GREEN, new Location(14,11) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(14,12) ) );
        q.add( new ColorTile( Color.RED, new Location(14,13) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(14,14) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(14,15) ) );
        q.add( new ColorTile( Color.BLUE, new Location(14,16) ) );
        q.add( new ColorTile( Color.GREEN, new Location(14,17) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(14,18) ) );
        q.add( new CharacterTile( "mr. mint", 3, new Location( 14,19) ) );
        q.add( new ColorTile( Color.RED, new Location(13,19) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(12,19) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(12,18) ) );
        q.add( new ColorTile( Color.BLUE, new Location(12,17) ) );
        q.add( new ColorTile( Color.GREEN, new Location(12,16) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(12,15) ) );
        q.add( new ColorTile( Color.RED, new Location(12,14) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(12,13) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(12,12) ) );
        q.add( new ColorTile( Color.BLUE, new Location(12,11) ) );
        q.add( new ColorTile( Color.GREEN, new Location(11,11) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(10,11) ) );
        q.add( new ColorTile( Color.RED, new Location(10,12) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(10, 13) ) );
        q.add( new ShortcutTile( "start", Color.YELLOW, new Location(10, 14) ) );
        q.add( new ColorTile( Color.BLUE, new Location(10,15) ) );
        q.add( new ColorTile( Color.GREEN, new Location(10,16) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(10,17) ) );
        q.add( new ColorTile( Color.RED, new Location(10,18) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(10, 19) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(9,19) ) );
        q.add( new CharacterTile("plumpy", 3, new Location(8,19) ) );
        q.add( new ColorTile( Color.BLUE, new Location(8,18) ) );
        q.add( new ColorTile( Color.GREEN, new Location(8,17) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(8,16) ) );
        q.add( new ShortcutTile( "end", Color.RED, new Location(8,15) ) );
        q.add( licorice1 );
        q.add( new ColorTile( Color.YELLOW, new Location(8,13) ) );
        q.add( new ColorTile( Color.BLUE, new Location(8,12) ) );
        q.add( new ColorTile( Color.GREEN, new Location(8,11) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(8,10) ) );
        q.add( new ColorTile( Color.RED, new Location(8,9) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(9,9) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(10,9) ) );
        q.add( new ColorTile( Color.BLUE, new Location(11,9) ) );
        q.add( new ColorTile( Color.GREEN, new Location(11,8) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(11,7) ) );
        q.add( new ColorTile( Color.RED, new Location(11,6) ) );
        q.add( new ShortcutTile( "end", Color.MAGENTA, new Location(11, 5) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(11,4) ) );
        q.add( new ColorTile( Color.BLUE, new Location(11,3) ) );
        q.add( new ColorTile( Color.GREEN, new Location(11,2) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(11,1) ) );
        q.add( new ColorTile( Color.RED, new Location(11,0) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(10,0) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(9,0) ) );
        q.add( new ColorTile( Color.BLUE, new Location(8,0) ) );
        q.add( new ColorTile( Color.GREEN, new Location(7,0) ) );
        q.add( new CharacterTile("gramma nutt", 3, new Location(6,0) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(6,1) ) );
        q.add( new ColorTile( Color.RED, new Location(6,2) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(6, 3) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(6,4) ) );
        q.add( new ColorTile( Color.BLUE, new Location(6,5) ) );
        q.add( new ColorTile( Color.GREEN, new Location(6,6) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(6,7) ) );
        q.add( new ColorTile( Color.RED, new Location(6,8) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(6,9) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(6,10) ) );
        q.add( new ColorTile( Color.BLUE, new Location(6,11) ) );
        q.add( new ColorTile( Color.GREEN, new Location(5,11) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(4,11) ) );
        q.add( new ColorTile( Color.RED, new Location(4,10) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(4, 9) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(4,8) ) );
        q.add( licorice2 );
        q.add( new ColorTile( Color.GREEN, new Location(4,6) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(3, 6) ) );
        q.add( new ColorTile( Color.RED, new Location(2, 6) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(2, 7) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(2,8) ) );
        q.add( new CharacterTile("princess lolly", 3, new Location(2,9) ) );
        q.add( new ColorTile( Color.BLUE, new Location(2,10) ) );
        q.add( new ColorTile( Color.GREEN, new Location(2,11) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(2,12) ) );
        q.add( new ColorTile( Color.RED, new Location(2,13) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(2, 14) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(2,15) ) );
        q.add( new ColorTile( Color.BLUE, new Location(2,16) ) );
        q.add( new ColorTile( Color.GREEN, new Location(2,17) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(2, 18) ) );
        q.add( new CharacterTile("princess frostine", 3, new Location(2,19) ) );
        q.add( new ColorTile( Color.RED, new Location(1,19) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(0,19) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(0,18) ) );
        q.add( new ColorTile( Color.BLUE, new Location(0,17) ) );
        q.add( new ColorTile( Color.GREEN, new Location(0,16) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(0,15) ) );
        q.add( new ColorTile( Color.RED, new Location(0,14) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(0, 13) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(0,12) ) );
        q.add( new ColorTile( Color.BLUE, new Location(0,11) ) );
        q.add( new ColorTile( Color.GREEN, new Location(0,10) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(0,9) ) );
        q.add( new ColorTile( Color.RED, new Location(0,8) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(0,7) ) );
        q.add( licorice3 );
        q.add( new ColorTile( Color.BLUE, new Location(0,5) ) );
        q.add( new ColorTile( Color.GREEN, new Location(0,4) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(1,4) ) );
        q.add( new ColorTile( Color.RED, new Location(2,4) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(3, 4) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(4,4) ) );
        q.add( new ColorTile( Color.BLUE, new Location(4,3) ) );
        q.add( new ColorTile( Color.GREEN, new Location(4,2) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(4,1) ) );
        q.add( new ColorTile( Color.RED, new Location(4,0) ) );
        q.add( new ColorTile( Color.MAGENTA, new Location(3, 0) ) );
        q.add( new ColorTile( Color.YELLOW, new Location(2,0) ) );
        q.add( new ColorTile( Color.BLUE, new Location(1,0) ) );
        q.add( new ColorTile( Color.GREEN, new Location(0,0) ) );
        q.add( new ColorTile( Color.ORANGE, new Location(0,1) ) );
        q.add( new ColorTile( Color.RED, new Location(0,2) ) );
        q.add( new ColorTile( Color.GRAY, new Location(1,2) ) );
        
        for (int i = 0; i < q.size(); i++)
        {
            Tile t = q.remove();
            tileMap.put( t.getLocation(), t );
            tileIndex.add( t );
        }
        
        
    }
    
    public TreeMap<Location, Tile> getMap()
    {
        return tileMap;
    }
    
    public Tile findNextColorTile(Location loc, Color color)
    {
        for(Map.Entry<Location, Tile> entry: tileMap.entrySet())
        {
            Location location = entry.getKey();
            Tile tile = entry.getValue();
            if (location == loc)
            {
                int index = tileIndex.indexOf( tile );
                for (int i = index + 1; i < tileIndex.size(); i++)
                {
                    if (tileIndex.get( i ).getType() == "color")
                    {
                        if (tileIndex.get(i).getColor() == color)
                        return tileIndex.get( i );
                    }
                }
            }
        }
        return tileMap.get( loc );
    }
    
    public Tile findNext2ColorTile(Location loc, Color color)
    {
        for(Map.Entry<Location, Tile> entry: tileMap.entrySet())
        {
            Location location = entry.getKey();
            Tile tile = entry.getValue();
            if (location == loc)
            {
                int index = tileIndex.indexOf( tile );
                for (int i = index + 1; i < tileIndex.size(); i++)
                {
                    if (tileIndex.get( i ).getType() == "color")
                    {
                        if (tileIndex.get(i).getColor() == color)
                        {
                            index = i;
                            for (int j = index + 1; j < tileIndex.size(); j++)
                            {
                                if (tileIndex.get(i).getColor() == color)
                                {
                                    return tileIndex.get( j );
                                }
                            }
                        }
                    }
                }
            }
        }
        return tileMap.get( loc );
    }
    
    public Tile findCharacterTile(String character)
    {
        for(Tile tile: tileIndex)
        {
            if (tile.getType() == character)
            {
                return tile;
            }
        }
        return tileMap.lastEntry().getValue();
    }
    
    public Tile findNextShortcutTile(Location loc)
    {
        if (loc.equals( new Location(0 , 4) ))
        {
            return tileMap.get( new Location(3, 5) );
        }
        if (loc.equals( new Location(4, 14) ))
        {
            return tileMap.get( new Location(6, 15) );
        } 
        return tileMap.get( loc );
    }

}
