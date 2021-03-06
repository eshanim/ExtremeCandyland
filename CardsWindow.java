import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import info.gridworld.grid.Location;

/**
 *  Provides GUI for displaying cards.
 */
public class CardsWindow extends JFrame
{
  private static JFrame thisWindow;

  DeckOfCards decks = new DeckOfCards();
  ColorCard c;
  CharacterCard ch;
  JButton card;
  JPanel fieldsPanel = new JPanel(new GridLayout(1, 2, 5, 0));
  JButton deck;
  Container co = getContentPane();
  PlayerList playerList;
  Path p = new Path();
  Gameboard gb;
  SpecialWindow sw;

  
  ImageIcon back = new ImageIcon("icons/cardBack.png");
  ImageIcon black = new ImageIcon("icons/blackS.jpg");
  ImageIcon red1 = new ImageIcon("icons/red1.png");
  ImageIcon orange1 = new ImageIcon("icons/orange1.png");
  ImageIcon yellow1 = new ImageIcon("icons/yellow1.png");
  ImageIcon green1 = new ImageIcon("icons/green1.png");
  ImageIcon blue1 = new ImageIcon("icons/blue1.png");
  ImageIcon magenta1 = new ImageIcon("icons/magenta1.png");
  ImageIcon red2 = new ImageIcon("icons/red2.png");
  ImageIcon orange2 = new ImageIcon("icons/orange2.png");
  ImageIcon yellow2 = new ImageIcon("icons/yellow2.png");
  ImageIcon green2 = new ImageIcon("icons/green2.png");
  ImageIcon blue2= new ImageIcon("icons/blue2.png");
  ImageIcon magenta2 = new ImageIcon("icons/magenta2.png");
  ImageIcon candycaneC = new ImageIcon("icons/candycaneC.png");
  ImageIcon gingermanC = new ImageIcon("icons/gingermanC.png");
  ImageIcon gumdropC = new ImageIcon("icons/gumdropC.png");
  ImageIcon icecreamC = new ImageIcon("icons/icecreamC.png");
  ImageIcon lollipopC = new ImageIcon("icons/lollipopC.png");
  ImageIcon peanutC = new ImageIcon("icons/peanutC.png");
  
  public CardsWindow(PlayerList players, Gameboard gb, SpecialWindow sw)
  {
    super("Deck of Cards");
    thisWindow = this;
    playerList = players;
    this.gb = gb;
    this.sw = sw;
    CardListener cardListener = new CardListener();
    decks.shuffle();
  
    deck = new JButton(back);
    deck.addActionListener(cardListener);
    card = new JButton(black);

    fieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    fieldsPanel.add(deck);
    //fieldsPanel.add(new JButton(black));


    co.add(fieldsPanel);
  }

  /******************************************************************/
  /***      passwordField and "Login" button events handling      ***/
  /******************************************************************/

  private class CardListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
        
        Card ca = decks.showCard(playerList.getList().get( playerList.getPosition() ));
        JButton temp = card;
        if (ca.getType() == "color")
        {
            c = (ColorCard)ca;
            if (c.getNumSpaces() == 1)
            {
                if (c.getColor() == Color.RED)
                {
                    card = new JButton(red1);
                }
                else if (c.getColor() == Color.ORANGE)
                {
                    card = new JButton(orange1);

                }
                else if (c.getColor() == Color.YELLOW)
                {
                    card = new JButton(yellow1);

                }
                else if (c.getColor() == Color.GREEN)
                {
                    card = new JButton(green1);

                }
                else if (c.getColor() == Color.BLUE)
                {
                    card = new JButton(blue1);

                }
                else if (c.getColor() == Color.MAGENTA)
                {
                    card = new JButton(magenta1);

                }
            }
            else if (c.getNumSpaces() == 2)
            {
                if (c.getColor() == Color.RED)
                {
                    card = new JButton(red2);

                }
                else if (c.getColor() == Color.ORANGE)
                {
                    card = new JButton(orange2);

                }
                else if (c.getColor() == Color.YELLOW)
                {
                    card = new JButton(yellow2);

                }
                else if (c.getColor() == Color.GREEN)
                {
                    card = new JButton(green2);

                }
                else if (c.getColor() == Color.BLUE)
                {
                    card = new JButton(blue2);

                }
                else if (c.getColor() == Color.MAGENTA)
                {
                    card = new JButton(magenta2);
                  
                }
            }
        }
        else 
        {
            ch = (CharacterCard)ca;
            if (ch.getCharacter() == "princess lolly")
            {
                card = new JButton(lollipopC);
            }
            else if (ch.getCharacter() == "princess frostine")
            {
                card = new JButton(icecreamC);
            }
            else if (ch.getCharacter() == "gramma nutt")
            {
                card = new JButton(peanutC);
            }
            else if (ch.getCharacter() == "gingerbread man")
            {
                card = new JButton(gingermanC);
            }
            else if (ch.getCharacter() == "plumpy")
            {
                card = new JButton(gumdropC);
            }
            else if (ch.getCharacter() == "mr. mint")
            {
                card = new JButton(candycaneC);
            }
        }
        fieldsPanel.remove(temp);
        fieldsPanel.add( card );
        co.add(fieldsPanel);
        thisWindow.setBounds( 0, 0, 375, 290 );
        thisWindow.setVisible( true );
        
        playerList.getList().get(playerList.getPosition()).play( decks, p );
        gb.changePlayer();
        sw.changePoints();
        playerList.setPosition( playerList.getPosition() + 1 );
        if (playerList.getPosition() == playerList.getList().size())
        {
            playerList.setPosition( 0 );
        }
        for (Player player: playerList.getList())
        {
            if (player.getLocation().equals( new Location(1,2) ))
            {
                JOptionPane.showMessageDialog(thisWindow, player.getName() + " won!",
                    "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
  }
}
