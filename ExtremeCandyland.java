import java.util.*;

import javax.swing.JFrame;

public class ExtremeCandyland
{

    private static Path p = new Path();
    private static DeckOfCards deck = new DeckOfCards();
    public static PlayerList players;


    public static void main( String[] args )
    {
        // TODO Auto-generated method stub
        
        LoginWindow lw = new LoginWindow("Login");

            lw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            lw.setBounds( 0, 0, 360, 500 );
            lw.setVisible( true );
        
        players = lw.playerList;
        Gameboard gb = new Gameboard(players);
        gb.showGridLayout();
        
        CardsWindow window = new CardsWindow(players); 
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setBounds( 0, 0, 187, 290 );
        window.setVisible( true );
        
        
        int i = players.getPosition();
        while(i < players.getList().size())
        {
            players.getList().get( i ).play( deck, p );
            players.setPosition( i + 1 );
            gb.changePlayer();
            
            if (i == players.getList().size() - 1)
            {
                players.setPosition(0);
            }
        }
        
    }

}
