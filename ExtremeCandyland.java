import java.util.*;

import javax.swing.JFrame;

public class ExtremeCandyland
{

    private static Path p = new Path();
    private static DeckOfCards deck = new DeckOfCards();
    public static PlayerList players = new PlayerList();


    public static void main( String[] args )
    {
        // TODO Auto-generated method stub
        LoginWindow lw = new LoginWindow();
        
        GameBoard gb = new GameBoard(players);
        gb.showGridLayout();
        
        CardsWindow window = new CardsWindow(players); 
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setBounds( 0, 0, 187, 290 );
        window.setVisible( true );
        
        
        
        for (int i = players.getPosition(); i < players.getList().size(); i++)
        {
            players.getList().get( i ).play( deck, p );
            players.setPosition( i + 1 );
            
            if (i == players.getList().size() - 1)
            {
                players.setPosition(0);
            }
        }
        
    }

}
