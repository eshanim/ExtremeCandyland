import java.util.ArrayList;

/**
 *  Creates a PlayerList, which is a structure to keep track of all the 
 *  players currently playing the game.
 *
 *  @author  juhi
 *  @version May 22, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: 
 */
public class PlayerList
{
    
    /**
     * the arraylist to hold the players
     */
    private ArrayList<Player> players;
    
    /**
     * the position in the arraylist that is currently being played
     */
    private int position;
    
    /**
     * creates a new PlayerList and sets it to an empty arraylist
     */
    public PlayerList()
    {
        players = new ArrayList<Player>();
    }
    
    /**
     * creates a new PlayerList and sets it to a given arraylist
     * @param player
     *      list of players
     */
    public PlayerList(ArrayList<Player> player)
    {
        players = player;
    }
    
    /**
     * returns list of players
     * @return
     *      ArrayList of players
     */
    public ArrayList<Player> getList()
    {
        return players;
    }
    
    /**
     * returns position currently being played
     * @return
     *      int position
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * sets current position
     * @param pos
     *      int position to set to
     */
    public void setPosition(int pos)
    {
        position = pos;
    }
    
    /**
     * adds player to PlayerList
     * @param p
     *      player to add
     */
    public void add(Player p)
    {
        players.add( p );
    }
    
}
