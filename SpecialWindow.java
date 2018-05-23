import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

/**
 *  Provides GUI for displaying cards.
 */
public class SpecialWindow extends JFrame
{
  private static JFrame thisWindow;

  JPanel fieldsPanel = new JPanel(new GridLayout(1, 2, 5, 0));
  Container co = getContentPane();
  PlayerList playerList;
  Path p = new Path();

  public static void main(String[] args)
  {
      SpecialWindow window = new SpecialWindow(new PlayerList()); 
      thisWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      thisWindow.setBounds( 0, 0, 360, 140 );
      thisWindow.setVisible( true );
  }
  
  public SpecialWindow(PlayerList players)
  {
    super("Special Moves");
    thisWindow = this;
    playerList = players;
    
    MoveListener moveListener = new MoveListener();
    JButton switcher = new JButton("switch positions with another player");
    switcher.addActionListener(moveListener);

    StartListener startListener = new StartListener();
    JButton startPos = new JButton("move another player back to start");
    startPos.addActionListener(startListener);
    
    fieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    fieldsPanel.add(switcher);
    fieldsPanel.add(startPos);

    co.add(fieldsPanel);
  }

  /******************************************************************/
  /***      passwordField and "Login" button events handling      ***/
  /******************************************************************/

  private class MoveListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
        Player curPlayer = playerList.getList().get(playerList.getPosition());
        
    }
  }
  
  private class StartListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
        
        Card ca = decks.showCard();
        JButton temp = card;
      
        fieldsPanel.remove(temp);
        fieldsPanel.add( card );
        co.add(fieldsPanel);
        thisWindow.setBounds( 0, 0, 375, 290 );
        thisWindow.setVisible( true );
        
    }
  }
}
