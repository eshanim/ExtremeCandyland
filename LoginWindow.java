import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

/**
 *  Provides GUI for registering and logging in users.
 */
public class LoginWindow extends JFrame
{
  private static JFrame thisWindow;

  private JTextField nameField;
  private JTextField nameField2;
  private JTextField nameField3;
  private JTextField nameField4;
  private JTextField nameField5;
  private JTextField nameField6;
  
  public PlayerList playerList;


  /**
   *  Constructs a new login window.
   *  @param title title bar text.
   *  @param server an object that keeps track of all the registered and
   *  logged-in users.
   */
  public LoginWindow(String title)
  {
    super(title);
    thisWindow = this;

    JLabel instructions = new JLabel("You need at least two players.");
    
    JLabel name1 = new JLabel("RED PLAYER:", JLabel.RIGHT);
    nameField = new JTextField(20);

    LoginListener loginListener = new LoginListener();
    JLabel name2 = new JLabel("ORANGE PLAYER:", JLabel.RIGHT);
    nameField2 = new JTextField(20);
    JLabel name3 = new JLabel("YELLOW PLAYER:", JLabel.RIGHT);
    nameField3 = new JTextField(20);
    JLabel name4 = new JLabel("GREEN PLAYER:", JLabel.RIGHT);
    nameField4 = new JTextField(20);
    JLabel name5 = new JLabel("BLUE PLAYER:", JLabel.RIGHT);
    nameField5 = new JTextField(20);
    JLabel name6 = new JLabel("PURPLE PLAYER:", JLabel.RIGHT);
    nameField6 = new JTextField(20);

    JButton playBtn = new JButton("Play");
    playBtn.addActionListener(loginListener);

    JPanel fieldsPanel = new JPanel(new GridLayout(3, 3, 10, 10));
    fieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    fieldsPanel.add(nameField);
    fieldsPanel.add(nameField2);
    fieldsPanel.add(nameField3);
    fieldsPanel.add(nameField4);
    fieldsPanel.add(nameField5);
    fieldsPanel.add(nameField6);
    fieldsPanel.add(new JPanel());  // filler

    fieldsPanel.add(playBtn);

    Container c = getContentPane();
    c.add(fieldsPanel);
  }

  /******************************************************************/
  /***      passwordField and "Login" button events handling      ***/
  /******************************************************************/

  private class LoginListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String name1 = nameField.getText().trim().toLowerCase();
      String name2 = nameField2.getText().trim().toLowerCase();
      String name3 = nameField3.getText().trim().toLowerCase();
      String name4 = nameField4.getText().trim().toLowerCase();
      String name5 = nameField5.getText().trim().toLowerCase();
      String name6 = nameField6.getText().trim().toLowerCase();

      ArrayList<Player> players = new ArrayList<Player>();
      
      if (!name1.equals( "" ))
      {
          Player p1 = new Player(name1, Color.RED);
          players.add( p1 );
      }
      if (!name2.equals( "" ))
      {
          Player p2 = new Player(name2, Color.ORANGE);
          players.add( p2 );
      }
      if (!name3.equals( "" ))
      {
          Player p3 = new Player(name3, Color.YELLOW);
          players.add( p3 );
      }
      if (!name4.equals( "" ))
      {
          Player p4 = new Player(name4, Color.GREEN);
          players.add( p4 );
      }
      if (!name5.equals( "" ))
      {
          Player p5 = new Player(name5, Color.BLUE);
          players.add( p5 );
      }
      if (!name6.equals( "" ))
      {
          Player p6 = new Player(name6, Color.MAGENTA);
          players.add( p6 );
      }
      
      playerList = new PlayerList(players);
    }
  }
}