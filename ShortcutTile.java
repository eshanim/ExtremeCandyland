import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class ShortcutTile extends ColorTile
{
    private String position;
    
    ShortcutTile( String position, Color color, Location loc)
    {
        super(color, loc);
        this.position = position;
    }
    
    public boolean isStart()
    {
        return position.equals( "start" );
    }
    
    public boolean isEnd()
    {
        return position.equals( "end" );
    }
    
    public boolean moveTo(Player player, Path path)
    {
        if (this.isStart())
        {
            Tile tile = path.findNextShortcutTile( player.getLocation() );
            player.moveTo( tile.getLocation() );
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void play(Player player, Path path)
    {
        this.moveTo( player, path );
    }
    
    public String getType()
    {
        return "shortcut";
    }
    
}
