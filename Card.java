/**
 *  An interface of a card which would be used to connect a card to a tile so that 
 *  the player can move to the appropriate place during their turn.
 *
 *  @author  Eshani
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public interface Card
{
    /**
     * moves the player to the location related to 
     * @param p the path
     * @param player the player
     */
    void moveTo(Path p, Player player);
    
    /**
     * returns the type of the card
     * @return
     */
    String getType();
}
