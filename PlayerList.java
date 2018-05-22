import java.util.ArrayList;

public class PlayerList
{
    
    private ArrayList<Player> players;
    
    private int position;
    
    public PlayerList()
    {
        players = new ArrayList<Player>();
    }
    
    public ArrayList<Player> getList()
    {
        return players;
    }
    
    public int getPosition()
    {
        return position;
    }
    
    public void setPosition(int pos)
    {
        position = pos;
    }
    
}