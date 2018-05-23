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
        
        players = lw.getList();
        int count = 0;
        while(players.getList().size() == 0)
        {
            System.out.println( players.getList().size() );
            count++;
        }
        Gameboard gb = new Gameboard(players);
        gb.showGridLayout();
        
        CardsWindow window = new CardsWindow(players, gb); 
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setBounds( 0, 0, 187, 290 );
        window.setVisible( true );
        
        SpecialWindow sw = new SpecialWindow(players, gb);
        sw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        sw.setBounds( 0, 0, 500, 500 );
        sw.setVisible( true );
        
    }

}
