import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;


/**
 *  Provides GUI for displaying special moves.
 *  
 *  @author  juhi
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: none
 */
public class SpecialWindow extends JFrame
{
  private static JFrame thisWindow;

  JPanel fieldsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
  Container co = getContentPane();
  PlayerList playerList;
  Path p = new Path();
  DeckOfCards decks = new DeckOfCards();
  Gameboard gb;

//  public static void main(String[] args)
//  {
//      SpecialWindow window = new SpecialWindow(new PlayerList()); 
//      thisWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//      thisWindow.setBounds( 0, 0, 360, 140 );
//      thisWindow.setVisible( true );
//  }
  
 /**
  * Creates a new window to display possible special moves and points required.
 * @param players
 *      PlayerList of players in the game
 * @param gb
 *      Gameboard being used in the game
 */
public SpecialWindow(PlayerList players, Gameboard gb)
  {
    super("Special Moves");
    thisWindow = this;
    playerList = players;
    this.gb = gb;
    
    int n = playerList.getList().size();
    

    fieldsPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
    
    if (n > 0)
    {
        MoveListener moveListener1 = new MoveListener(playerList.getList().get(0));
        JLabel switcherLabel1 = new JLabel("Need 10 Points:", JLabel.RIGHT);
        JButton switcher1 = new JButton("Switch Positions with " 
                        + playerList.getList().get(0).getName());
        switcher1.addActionListener(moveListener1);
        StartListener startListener1 = new StartListener(playerList.getList().get(0));
        JLabel startLabel1 = new JLabel("Need 20 Points:", JLabel.RIGHT);
        JButton startPos1 = new JButton("Send " + playerList.getList().get(0).getName() 
            + " Back to Start");
        startPos1.addActionListener(startListener1);
        fieldsPanel.add(switcherLabel1);
        fieldsPanel.add(switcher1);
        fieldsPanel.add(startLabel1);
        fieldsPanel.add(startPos1);
    }
    
    if (n > 1)
    {
        MoveListener moveListener2 = new MoveListener(playerList.getList().get(1));
        JLabel switcherLabel2 = new JLabel("Need 10 Points:", JLabel.RIGHT);
        JButton switcher2 = new JButton("Switch Positions with " 
                        + playerList.getList().get(1).getName());
        switcher2.addActionListener(moveListener2);
        StartListener startListener2 = new StartListener(playerList.getList().get(1));
        JLabel startLabel2 = new JLabel("Need 20 Points:", JLabel.RIGHT);
        JButton startPos2 = new JButton("Send " + playerList.getList().get(1).getName() 
            + " Back to Start");
        startPos2.addActionListener(startListener2);
        fieldsPanel.add(switcherLabel2);
        fieldsPanel.add(switcher2);
        fieldsPanel.add(startLabel2);
        fieldsPanel.add(startPos2);
    }
    
    if (n > 2)
    {
        MoveListener moveListener3 = new MoveListener(playerList.getList().get(2));
        JLabel switcherLabel3 = new JLabel("Need 10 Points:", JLabel.RIGHT);
        JButton switcher3 = new JButton("Switch Positions with " 
                        + playerList.getList().get(2).getName());
        switcher3.addActionListener(moveListener3);
        StartListener startListener3 = new StartListener(playerList.getList().get(2));
        JLabel startLabel3 = new JLabel("Need 20 Points:", JLabel.RIGHT);
        JButton startPos3 = new JButton("Send " + playerList.getList().get(2).getName() 
            + " Back to Start");
        startPos3.addActionListener(startListener3);
        fieldsPanel.add(switcherLabel3);
        fieldsPanel.add(switcher3);
        fieldsPanel.add(startLabel3);
        fieldsPanel.add(startPos3);
    }
    
    if (n > 3)
    {
        MoveListener moveListener4 = new MoveListener(playerList.getList().get(3));
        JLabel switcherLabel4 = new JLabel("Need 10 Points:", JLabel.RIGHT);
        JButton switcher4 = new JButton("Switch Positions with " 
                        + playerList.getList().get(3).getName());
        switcher4.addActionListener(moveListener4);
        StartListener startListener4 = new StartListener(playerList.getList().get(3));
        JLabel startLabel4 = new JLabel("Need 20 Points:", JLabel.RIGHT);
        JButton startPos4 = new JButton("Send " + playerList.getList().get(3).getName() 
            + " Back to Start");
        startPos4.addActionListener(startListener4);
        fieldsPanel.add(switcherLabel4);
        fieldsPanel.add(switcher4);
        fieldsPanel.add(startLabel4);
        fieldsPanel.add(startPos4);
    }
    
    if (n > 4)
    {
        MoveListener moveListener5 = new MoveListener(playerList.getList().get(4));
        JLabel switcherLabel5 = new JLabel("Need 10 Points:", JLabel.RIGHT);
        JButton switcher5 = new JButton("Switch Positions with " 
                        + playerList.getList().get(4).getName());
        switcher5.addActionListener(moveListener5);
        StartListener startListener5 = new StartListener(playerList.getList().get(4));
        JLabel startLabel5 = new JLabel("Need 20 Points:", JLabel.RIGHT);
        JButton startPos5 = new JButton("Send " + playerList.getList().get(4).getName() 
            + " Back to Start");
        startPos5.addActionListener(startListener5);
        fieldsPanel.add(switcherLabel5);
        fieldsPanel.add(switcher5);
        fieldsPanel.add(startLabel5);
        fieldsPanel.add(startPos5);
    }
    
    if (n > 5)
    {
        MoveListener moveListener6 = new MoveListener(playerList.getList().get(5));
        JLabel switcherLabel6 = new JLabel("Need 10 Points:", JLabel.RIGHT);
        JButton switcher6 = new JButton("Switch Positions with " 
                        + playerList.getList().get(5).getName());
        switcher6.addActionListener(moveListener6);
        StartListener startListener6 = new StartListener(playerList.getList().get(5));
        JLabel startLabel6 = new JLabel("Need 20 Points:", JLabel.RIGHT);
        JButton startPos6 = new JButton("Send " + playerList.getList().get(5).getName() 
            + " Back to Start");
        startPos6.addActionListener(startListener6);
        fieldsPanel.add(switcherLabel6);
        fieldsPanel.add(switcher6);
        fieldsPanel.add(startLabel6);
        fieldsPanel.add(startPos6);
    }

    co.add(fieldsPanel);
  }

  /******************************************************************/
  /***      button events handling      ***/
  /******************************************************************/
  
  private class MoveListener implements ActionListener
  {
      private Player player;
      
      public MoveListener(Player player)
      {
          this.player = player;
      }
      
    public void actionPerformed(ActionEvent e)
    {   
        Player pl = playerList.getList().get( playerList.getPosition() );
        if (pl.getPoints() < 10)
        {
            JOptionPane.showMessageDialog(thisWindow, "Not Enough Points",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (player.getName().equals( pl.getName() ))
        {
            JOptionPane.showMessageDialog(thisWindow, "You Cannot Switch Places With Yourself!",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Location loc1 = player.getLocation();
            Location loc2 = pl.getLocation();
            player.moveTo( loc2 );
            pl.moveTo( loc1 );
            gb.changePlayer();
        }
        
    }
  }
  
  private class StartListener implements ActionListener
  {
      private Player player;
      
      public StartListener(Player player)
      {
          this.player = player;
      }
      
    public void actionPerformed(ActionEvent e)
    {
        Player pl = playerList.getList().get( playerList.getPosition() );
        if (pl.getPoints() < 10)
        {
            JOptionPane.showMessageDialog(thisWindow, "Not Enough Points",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (player.getName().equals( pl.getName() ))
        {
            JOptionPane.showMessageDialog(thisWindow, "You Cannot Send Yourself Back to Start!",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            player.putPlayerAtStart();
            gb.changePlayer();
        }
    }
  }
}
