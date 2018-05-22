import java.awt.Color;

import javax.swing.JFrame;
import java.util.*;
import info.gridworld.grid.Location;

public class ExtremeCandyland
{
    Path p;
    
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub
        
        
//        Users server = new Users();
//        LoginWindow window = new LoginWindow( "Extreme Candyland", server );
//        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//        window.setBounds( 0, 0, 280, 140 );
//        window.setVisible( true );
//        
//        Path p = new Path();
//        p.getList();
//        System.out.println(p.getList().size());
        
//        DeckOfCards doc = new DeckOfCards();
//        Card c = doc.getList().get( 0 );
//        doc.shuffle();
//        List<Card> b = doc.getList();
//        System.out.println(c);
//        System.out.println(b);
        
        Path p = new Path();
        ColorTile t = p.findNextColorTile( new Location(14,0), Color.GREEN );
        System.out.println(t);
    }

}
