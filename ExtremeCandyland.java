import java.util.*;

import javax.swing.JFrame;

/**
 *  main method that initializes
 *
 *  @author  juhi
 *  @version May 22, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: 
 */
public class ExtremeCandyland
{

    private static Path p = new Path();
    private static DeckOfCards deck = new DeckOfCards();
    public static PlayerList players;


    /**
     * main method that initializes a new login window, 
     * creates a new gameboard,
     * creates a new cardswindow
     * creates a new special moves window
     * @param args
     */
    public static void main( String[] args )
    {        
        LoginWindow lw = new LoginWindow("Login");

        lw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        lw.setBounds( 0, 0, 360, 500 );
        lw.setVisible( true );
        
        players = lw.getList();
        int count = 0;
        while(players.getList().size() == 0)
        {
            count++;
        }
        Gameboard gb = new Gameboard(players);
        gb.showGridLayout();
        
        SpecialWindow sw = new SpecialWindow(players, gb);
        sw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        sw.setBounds( 1000, 0, 400, 500 );
        sw.setVisible( true );
        
        CardsWindow window = new CardsWindow(players, gb, sw); 
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setBounds( 1000, 550, 187, 290 );
        window.setVisible( true );
        

        
    }

}
