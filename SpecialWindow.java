import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import info.gridworld.grid.Location;

/**
 *  Provides GUI for displaying cards.
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
  JButton PlayerButton1;
  JButton PlayerButton2;
  JButton PlayerButton3;
  JButton PlayerButton4;
  JButton PlayerButton5;
  JButton PlayerButton6;

//  public static void main(String[] args)
//  {
//      SpecialWindow window = new SpecialWindow(new PlayerList()); 
//      thisWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//      thisWindow.setBounds( 0, 0, 360, 140 );
//      thisWindow.setVisible( true );
//  }
  
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
        JLabel switcherLabel1 = new JLabel("Need 7 Points:", JLabel.RIGHT);
        JButton switcher1 = new JButton("Switch Positions with " 
                        + playerList.getList().get(0).getName());
        switcher1.addActionListener(moveListener1);
        StartListener startListener1 = new StartListener(playerList.getList().get(0));
        JLabel startLabel1 = new JLabel("Need 14 Points:", JLabel.RIGHT);
        JButton startPos1 = new JButton("Send " + playerList.getList().get(0).getName() 
            + " Back to Start");
        startPos1.addActionListener(startListener1);
        fieldsPanel.add(switcherLabel1);
        fieldsPanel.add(switcher1);
        fieldsPanel.add(startLabel1);
        fieldsPanel.add(startPos1);
        JLabel PlayerLabel1 = new JLabel(playerList.getList().get( 0 ).getName() + "'s points: ", 
            JLabel.RIGHT);
        fieldsPanel.add(PlayerLabel1);
        PlayerButton1 = new JButton("" + playerList.getList().get( 0 ).getPoints());
        fieldsPanel.add( PlayerButton1 );
    }
    
    if (n > 1)
    {
        MoveListener moveListener2 = new MoveListener(playerList.getList().get(1));
        JLabel switcherLabel2 = new JLabel("Need 7 Points:", JLabel.RIGHT);
        JButton switcher2 = new JButton("Switch Positions with " 
                        + playerList.getList().get(1).getName());
        switcher2.addActionListener(moveListener2);
        StartListener startListener2 = new StartListener(playerList.getList().get(1));
        JLabel startLabel2 = new JLabel("Need 14 Points:", JLabel.RIGHT);
        JButton startPos2 = new JButton("Send " + playerList.getList().get(1).getName() 
            + " Back to Start");
        startPos2.addActionListener(startListener2);
        fieldsPanel.add(switcherLabel2);
        fieldsPanel.add(switcher2);
        fieldsPanel.add(startLabel2);
        fieldsPanel.add(startPos2);
        JLabel PlayerLabel2 = new JLabel(playerList.getList().get( 1 ).getName() + "'s points: ", 
            JLabel.RIGHT);
        fieldsPanel.add(PlayerLabel2);
        PlayerButton2 = new JButton("" + playerList.getList().get( 1 ).getPoints());
        fieldsPanel.add( PlayerButton2 );
    }
    
    if (n > 2)
    {
        MoveListener moveListener3 = new MoveListener(playerList.getList().get(2));
        JLabel switcherLabel3 = new JLabel("Need 7 Points:", JLabel.RIGHT);
        JButton switcher3 = new JButton("Switch Positions with " 
                        + playerList.getList().get(2).getName());
        switcher3.addActionListener(moveListener3);
        StartListener startListener3 = new StartListener(playerList.getList().get(2));
        JLabel startLabel3 = new JLabel("Need 14 Points:", JLabel.RIGHT);
        JButton startPos3 = new JButton("Send " + playerList.getList().get(2).getName() 
            + " Back to Start");
        startPos3.addActionListener(startListener3);
        fieldsPanel.add(switcherLabel3);
        fieldsPanel.add(switcher3);
        fieldsPanel.add(startLabel3);
        fieldsPanel.add(startPos3);
        JLabel PlayerLabel3 = new JLabel(playerList.getList().get( 2 ).getName() + "'s points: ", 
            JLabel.RIGHT);
        fieldsPanel.add(PlayerLabel3);
        PlayerButton3 = new JButton("" + playerList.getList().get( 2 ).getPoints());
        fieldsPanel.add( PlayerButton3 );
    }
    
    if (n > 3)
    {
        MoveListener moveListener4 = new MoveListener(playerList.getList().get(3));
        JLabel switcherLabel4 = new JLabel("Need 7 Points:", JLabel.RIGHT);
        JButton switcher4 = new JButton("Switch Positions with " 
                        + playerList.getList().get(3).getName());
        switcher4.addActionListener(moveListener4);
        StartListener startListener4 = new StartListener(playerList.getList().get(3));
        JLabel startLabel4 = new JLabel("Need 14 Points:", JLabel.RIGHT);
        JButton startPos4 = new JButton("Send " + playerList.getList().get(3).getName() 
            + " Back to Start");
        startPos4.addActionListener(startListener4);
        fieldsPanel.add(switcherLabel4);
        fieldsPanel.add(switcher4);
        fieldsPanel.add(startLabel4);
        fieldsPanel.add(startPos4);
        JLabel PlayerLabel4 = new JLabel(playerList.getList().get( 3 ).getName() + "'s points: ", 
            JLabel.RIGHT);
        fieldsPanel.add(PlayerLabel4);
        PlayerButton4 = new JButton("" + playerList.getList().get( 3 ).getPoints());
        fieldsPanel.add( PlayerButton4 );
    }
    
    if (n > 4)
    {
        MoveListener moveListener5 = new MoveListener(playerList.getList().get(4));
        JLabel switcherLabel5 = new JLabel("Need 7 Points:", JLabel.RIGHT);
        JButton switcher5 = new JButton("Switch Positions with " 
                        + playerList.getList().get(4).getName());
        switcher5.addActionListener(moveListener5);
        StartListener startListener5 = new StartListener(playerList.getList().get(4));
        JLabel startLabel5 = new JLabel("Need 14 Points:", JLabel.RIGHT);
        JButton startPos5 = new JButton("Send " + playerList.getList().get(4).getName() 
            + " Back to Start");
        startPos5.addActionListener(startListener5);
        fieldsPanel.add(switcherLabel5);
        fieldsPanel.add(switcher5);
        fieldsPanel.add(startLabel5);
        fieldsPanel.add(startPos5);
        JLabel PlayerLabel5 = new JLabel(playerList.getList().get( 4 ).getName() + "'s points: ", 
            JLabel.RIGHT);
        fieldsPanel.add(PlayerLabel5);
        PlayerButton5 = new JButton("" + playerList.getList().get( 4 ).getPoints());
        fieldsPanel.add( PlayerButton5 );
    }
    
    if (n > 5)
    {
        MoveListener moveListener6 = new MoveListener(playerList.getList().get(5));
        JLabel switcherLabel6 = new JLabel("Need 7 Points:", JLabel.RIGHT);
        JButton switcher6 = new JButton("Switch Positions with " 
                        + playerList.getList().get(5).getName());
        switcher6.addActionListener(moveListener6);
        StartListener startListener6 = new StartListener(playerList.getList().get(5));
        JLabel startLabel6 = new JLabel("Need 14 Points:", JLabel.RIGHT);
        JButton startPos6 = new JButton("Send " + playerList.getList().get(5).getName() 
            + " Back to Start");
        startPos6.addActionListener(startListener6);
        fieldsPanel.add(switcherLabel6);
        fieldsPanel.add(switcher6);
        fieldsPanel.add(startLabel6);
        fieldsPanel.add(startPos6);
        JLabel PlayerLabel6 = new JLabel(playerList.getList().get( 5 ).getName() + "'s points: ", 
            JLabel.RIGHT);
        fieldsPanel.add(PlayerLabel6);
        PlayerButton6 = new JButton("" + playerList.getList().get( 5 ).getPoints());
        fieldsPanel.add( PlayerButton6 );
    }
    co.add(fieldsPanel);
  }
  
  public void changePoints()
  {
      int n = playerList.getList().size();
      if (n > 0)
      {
          PlayerButton1.setText( "" + playerList.getList().get( 0 ).getPoints() );
      }
      if (n > 1)
      {
          PlayerButton2.setText( "" + playerList.getList().get( 1 ).getPoints() );
      }
      if (n > 2)
      {
          PlayerButton3.setText( "" + playerList.getList().get( 2 ).getPoints() );
      }
      if (n > 3)
      {
          PlayerButton4.setText( "" + playerList.getList().get( 3 ).getPoints() );
      }
      if (n > 4)
      {
          PlayerButton5.setText( "" + playerList.getList().get( 4 ).getPoints() );
      }
      if (n > 5)
      {
          PlayerButton6.setText( "" + playerList.getList().get( 5 ).getPoints() );
      }
  }
  

  /******************************************************************/
  /***      passwordField and "Login" button events handling      ***/
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
        if (pl.getPoints() < 7)
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
            pl.subtractPoints( 7 );
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
        if (pl.getPoints() < 14)
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
            pl.subtractPoints( 14 );
            gb.changePlayer();
        }
    }
  }
}
