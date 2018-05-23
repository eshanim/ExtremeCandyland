import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


/**
 *  This class creates a Gameboard object that initializes the Candyland 
 *  gameboard with all the tiles and images on each tile. It has a changePlayer method
 *  that changes the image on the tile the player moves to to simulate the player's
 *  movement on the board.
 *
 *  @author  eshani
 *  @version May 22, 2018
 *  @author  Period: 2
 *  @author  Assignment: ExtremeCandyland
 *
 *  @author  Sources: 
 */
public class Gameboard
{
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel msglabel;
    private PlayerList playerList;
    
    ImageIcon redP = new ImageIcon("icons/redP.png");
    ImageIcon orangeP = new ImageIcon("icons/orangeP.png");
    ImageIcon yellowP = new ImageIcon("icons/yellowP.png");
    ImageIcon greenP = new ImageIcon("icons/greenP.png");
    ImageIcon blueP = new ImageIcon("icons/blueP.png");
    ImageIcon magentaP = new ImageIcon("icons/magentaP.png");
    
    private JButton[][] board = new JButton[15][20];
    private Location loc;
    private JButton old;
    private Icon icon;
    private ArrayList<Icon> listBut;
    
    Player redPlayer = new Player("name", Color.BLACK);
    Player orangePlayer = new Player("name", Color.BLACK);
    Player yellowPlayer = new Player("name", Color.BLACK);
    Player greenPlayer = new Player("name", Color.BLACK);
    Player bluePlayer = new Player("name", Color.BLACK);
    Player purplePlayer = new Player("name", Color.BLACK);
    
    /**
     * Constructs a new Gameboard for the given list of players
     * @param players
     *      a PlayerList of all the players currently playing
     */
    public Gameboard(PlayerList players){
       prepareGUI();
       playerList = players;
    }

    /**
     * Changes the icon of the image the player has moved to 
     * so it can show the icon of a player, based on its
     * color, on it.
     */
    public void changePlayer()
    {   
        redPlayer.moveTo( new Location(8,1) );
        orangePlayer.moveTo( new Location(8,1) );
        yellowPlayer.moveTo( new Location(8,1) );
        greenPlayer.moveTo( new Location(8,1) );
        bluePlayer.moveTo( new Location(8,1) );
        purplePlayer.moveTo( new Location(8,1) );
        
        for (Player player: playerList.getList())
        {
            if (player.getColor().equals( Color.RED ))
            {
                redPlayer.moveTo( player.getLocation());
            }
            else if (player.getColor().equals( Color.ORANGE ))
            {
                orangePlayer.moveTo( player.getLocation());
            }
            else if (player.getColor().equals( Color.YELLOW ))
            {
                yellowPlayer.moveTo( player.getLocation());
            }
            else if (player.getColor().equals( Color.GREEN ))
            {
                greenPlayer.moveTo( player.getLocation());
            }
            else if (player.getColor().equals( Color.BLUE ))
            {
                bluePlayer.moveTo( player.getLocation());
            }
            else if (player.getColor().equals( Color.MAGENTA ))
            {
                purplePlayer.moveTo( player.getLocation());
            }
        }
        int count = 0;
        for(int row = 0; row < board.length; row++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                Location locat = new Location(row,c);
                if (!redPlayer.getLocation().equals(locat)
                                && !orangePlayer.getLocation().equals( locat )
                                && !yellowPlayer.getLocation().equals( locat )
                                && !greenPlayer.getLocation().equals( locat )
                                && !bluePlayer.getLocation().equals( locat )
                                && !purplePlayer.getLocation().equals( locat ))
                {
                    board[row][c].setIcon( listBut.get( count ) );
                }
                count++;
            }
        }
        
        for(Player player: playerList.getList())
        {
            Location l = player.getLocation();
            int r = l.getRow();
            int c = l.getCol();
            JButton bu = board[r][c];
            if (player.getColor() == Color.RED)
            {
                bu.setIcon(redP);
            }
            else if (player.getColor() == Color.ORANGE)
            {
                bu.setIcon(orangeP);
            }
            else if (player.getColor() == Color.YELLOW)
            {
                bu.setIcon(yellowP);
            }
            else if (player.getColor() == Color.GREEN)
            {
                bu.setIcon(greenP);
            }
            else if (player.getColor() == Color.BLUE)
            {
                bu.setIcon(blueP);
            }
            else if (player.getColor() == Color.MAGENTA)
            {
                bu.setIcon(magentaP);
            }
        }
        
        Player p = playerList.getList().get(playerList.getPosition());
//        Location l = p.getLocation();
//        int r = l.getRow();
//        int c = l.getCol();
//        JButton bu = board[r][c];
//        if (p.getColor() == Color.RED)
//        {
//            bu.setIcon(redP);
//        }
//        else if (p.getColor() == Color.ORANGE)
//        {
//            bu.setIcon(orangeP);
//        }
//        else if (p.getColor() == Color.YELLOW)
//        {
//            bu.setIcon(yellowP);
//        }
//        else if (p.getColor() == Color.GREEN)
//        {
//            bu.setIcon(greenP);
//        }
//        else if (p.getColor() == Color.BLUE)
//        {
//            bu.setIcon(blueP);
//        }
//        else if (p.getColor() == Color.MAGENTA)
//        {
//            bu.setIcon(magentaP);
//        }
        
        mainFrame.repaint();
    }
    
    /**
     * Initializes the JFrame and JPanel for the Gameboard, 
     * and sets the size and layout for it.
     */
    private void prepareGUI(){
       mainFrame = new JFrame("Extreme Candyland");
       mainFrame.setSize(1000,1000);
       mainFrame.setPreferredSize( new Dimension(1000,1000 ));
       mainFrame.setLayout(new GridLayout(0, 1));

       statusLabel = new JLabel("",JLabel.CENTER);        
       statusLabel.setSize(10,10);
       
       mainFrame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent windowEvent){
             System.exit(0);
          }        
       });    
       controlPanel = new JPanel();
       controlPanel.setLayout(new FlowLayout());

       mainFrame.add(controlPanel);
       //mainFrame.add(statusLabel);
       mainFrame.setVisible(true);  
    }
    
    /**
     * Adds all the tiles to the grid layout and adds the panel to the main
     * controlPanel.
     */
    void showGridLayout(){       
       JPanel panel = new JPanel();
       panel.setBackground(Color.darkGray);
       //panel.setPreferrize( new Dimension(1000,1000 ));
       GridLayout layout = new GridLayout(0,20);
       layout.setHgap(-10);
       layout.setVgap(-10);
       
       ImageIcon bl1 = new ImageIcon("icons/blackS1.jpg");
       ImageIcon bl2 = new ImageIcon("icons/blackS2.jpg");
       ImageIcon bl3 = new ImageIcon("icons/blackS3.jpg");
       ImageIcon bl4 = new ImageIcon("icons/blackS4.jpg");
       ImageIcon r = new ImageIcon("icons/redS.png");
       ImageIcon p = new ImageIcon("icons/pinkS.png");
       ImageIcon o = new ImageIcon("icons/orangeS.png");
       ImageIcon y = new ImageIcon("icons/yellowS.png");
       ImageIcon g = new ImageIcon("icons/greenS.png");
       ImageIcon b = new ImageIcon("icons/blueS.png");
       ImageIcon m = new ImageIcon("icons/magentaS.jpg");
       ImageIcon w = new ImageIcon("icons/whiteS.png");
       ImageIcon ra = new ImageIcon("icons/rainbowS.png");
       ImageIcon icecream = new ImageIcon("icons/icecream.png");
       ImageIcon lollipop = new ImageIcon("icons/lollipop.png");
       ImageIcon peanut = new ImageIcon("icons/peanut.png");
       ImageIcon gumdrop = new ImageIcon("icons/gumdrop.png");
       ImageIcon candycane = new ImageIcon("icons/candycane.png");
       ImageIcon gingerman = new ImageIcon("icons/gingerman.png");
       ImageIcon plicorice = new ImageIcon("icons/plicorice.png");
       ImageIcon ylicorice = new ImageIcon("icons/ylicorice.png");
       ImageIcon blicorice = new ImageIcon("icons/blicorice.png");
       ImageIcon redStart = new ImageIcon("icons/redStart.png");

       listBut = new ArrayList<Icon>();
       
       panel.setLayout(layout); 
       JButton g1 = new JButton(g);
       panel.add(g1);
       //listBut.add( g1 );
       board[0][0] = g1;
       
       JButton o1 = new JButton(o);
       panel.add(o1);
       //listBut.add( o1 );
       board[0][1] = o1;
       
       JButton r1 = new JButton(r);
       panel.add(r1);
       //listBut.add( r1 );
       board[0][2] = r1;
       
       JButton w1 = new JButton(w);
       panel.add(w1);
       //listBut.add( w1 );
       board[0][3] = w1;
       
       JButton g2 = new JButton(g);
       panel.add(g2);
       //listBut.add( g2 );
       board[0][4] = g2;
       
       JButton b1 = new JButton(b);
       panel.add(b1);
       //listBut.add( b1 );
       board[0][5] = b1;
       
       JButton y1 = new JButton(ylicorice);
       panel.add(y1);
       //listBut.add( y1 );
       board[0][6] = y1;
       
       JButton m1 = new JButton(m);
       panel.add(m1);
       //listBut.add( m1 );
       board[0][7] = m1;
       
       JButton r2 = new JButton(r);
       panel.add(r2);
       board[0][8] = r2;
       
       JButton o2 = new JButton(o);
       panel.add(o2);
       board[0][9] = o2;
       
       JButton g3 = new JButton(g);
       panel.add(g3);
       board[0][10] = g3;
       
       JButton b2 = new JButton(b);
       panel.add(b2);
       board[0][11] = b2;
       
       JButton y2 = new JButton(y);
       panel.add(y2);
       board[0][12] = y2;
       
       JButton m2 = new JButton(m);
       panel.add(m2);
       board[0][13] = m2;
       
       JButton r3 = new JButton(r);
       panel.add(r3);
       board[0][14] = r3;
       
       JButton o3 = new JButton(o);
       panel.add(o3);
       board[0][15] = o3;
       
       JButton g4 = new JButton(g);
       panel.add(g4);
       board[0][16] = g4;
       
       JButton b3 = new JButton(b);
       panel.add(b3);
       board[0][17] = b3;
       
       JButton y3 = new JButton(y);
       panel.add(y3);
       board[0][18] = y3;
       
       JButton m3 = new JButton(m);
       panel.add(m3);
       board[0][19] = m3;
       
       JButton b4 = new JButton(b);
       panel.add(b4);
       board[1][0] = b4;
       
       JButton w2 = new JButton(w);
       panel.add(w2);
       board[1][1] = w2;
       
       JButton ra1 = new JButton(ra);
       panel.add(ra1);
       board[1][2] = ra1;
       
       JButton w3 = new JButton(w);
       panel.add(w3);
       board[1][3] = w3;
       
       JButton o4 = new JButton(o);
       panel.add(o4);
       board[1][4] = o4;
       
       JButton w4 = new JButton(w);
       panel.add(w4);
       board[1][5] = w4;
       
       JButton w5 = new JButton(w);
       panel.add(w5);
       board[1][6] = w5;
       
       JButton w6 = new JButton(w);
       panel.add(w6);
       board[1][7] = w6;
       
       JButton w7 = new JButton(w);
       panel.add(w7);
       board[1][8] = w7;
       
       JButton w8 = new JButton(w);
       panel.add(w8);
       board[1][9] = w8;
       
       JButton w9 = new JButton(w);
       panel.add(w9);
       board[1][10] = w9;
       
       JButton w10 = new JButton(w);
       panel.add(w10);
       board[1][11] = w10;
       
       JButton w11 = new JButton(w);
       panel.add(w11);
       board[1][12] = w11;
       
       JButton w12 = new JButton(w);
       panel.add(w12);
       board[1][13] = w12;
       
       JButton w13 = new JButton(w);
       panel.add(w13);
       board[1][14] = w13;
       
       JButton w14 = new JButton(w);
       panel.add(w14);
       board[1][15] = w14;
       
       JButton w15 = new JButton(w);
       panel.add(w15);
       board[1][16] = w15;
       
       JButton w16 = new JButton(w);
       panel.add(w16);
       board[1][17] = w16;
       
       JButton w17 = new JButton(w);
       panel.add(w17);
       board[1][18] = w17;
       
       JButton r4 = new JButton(r);
       panel.add(r4);
       board[1][19] = r4;
       
       JButton y4 = new JButton(y);
       panel.add(y4);
       board[2][0] = y4;
       
       JButton w18 = new JButton(w);
       panel.add(w18);
       board[2][1] = w18;
       
       JButton w19 = new JButton(w);
       panel.add(w19);
       board[2][2] = w19;
       
       JButton w20 = new JButton(w);
       panel.add(w20);
       board[2][3] = w20;
       
       JButton r5 = new JButton(r);
       panel.add(r5);
       board[2][4] = r5;
       
       JButton w21 = new JButton(w);
       panel.add(w21);
       board[2][5] = w21;
       
       JButton r6 = new JButton(r);
       panel.add(r6);
       board[2][6] = r6;
       
       JButton m4 = new JButton(m);
       panel.add(m4);
       board[2][7] = m4;
       
       JButton y5 = new JButton(y);
       panel.add(y5);
       board[2][8] = y5;
       
       JButton ice = new JButton(icecream);
       panel.add(ice);
       board[2][9] = ice;
       
       JButton b5 = new JButton(b);
       panel.add(b5);
       board[2][10] = b5;
       
       JButton g5 = new JButton(g);
       panel.add(g5);
       board[2][11] = g5;
       
       JButton o5 = new JButton(o);
       panel.add(o5);
       board[2][12] = o5;
       
       JButton r7 = new JButton(r);
       panel.add(r7);
       board[2][13] = r7;
       
       JButton m5 = new JButton(m);
       panel.add(m5);
       board[2][14] = m5;
       
       JButton y6 = new JButton(y);
       panel.add(y6);
       board[2][15] = y6;
       
       JButton b6 = new JButton(b);
       panel.add(b6);
       board[2][16] = b6;
       
       JButton g6 = new JButton(g);
       panel.add(g6);
       board[2][17] = g6;
       
       JButton o6 = new JButton(o);
       panel.add(o6);
       board[2][18] = o6;
       
       JButton lolli = new JButton(lollipop);
       panel.add(lolli);
       board[2][19] = lolli;
       
       JButton m6 = new JButton(m);
       panel.add(m6);
       board[3][0] = m6;
       
       JButton w22 = new JButton(w);
       panel.add(w22);
       board[3][1] = w22;
       
       JButton w23 = new JButton(w);
       panel.add(w23);
       board[3][2] = w23;
       
       JButton w24 = new JButton(w);
       panel.add(w24);
       board[3][3] = w24;
       
       JButton m7 = new JButton(m);
       panel.add(m7);
       board[3][4] = m7;
       
       JButton w25 = new JButton(w);
       panel.add(w25);
       board[3][5] = w25;
       
       JButton o7 = new JButton(o);
       panel.add(o7);
       board[3][6] = o7;
       
       JButton w26 = new JButton(w);
       panel.add(w26);
       board[3][7] = w26;
       
       JButton w27 = new JButton(w);
       panel.add(w27);
       board[3][8] = w27;
       
       JButton w28 = new JButton(w);
       panel.add(w28);
       board[3][9] = w28;
       
       JButton w29 = new JButton(w);
       panel.add(w29);
       board[3][10] = w29;
       
       JButton w30 = new JButton(w);
       panel.add(w30);
       board[3][11] = w30;
       
       JButton w31 = new JButton(w);
       panel.add(w31);
       board[3][12] = w31;
       
       JButton w32 = new JButton(w);
       panel.add(w32);
       board[3][13] = w32;
       
       JButton w33 = new JButton(w);
       panel.add(w33);
       board[3][14] = w33;
       
       JButton w34 = new JButton(w);
       panel.add(w34);
       board[3][15] = w34;
       
       JButton w35 = new JButton(w);
       panel.add(w35);
       board[3][16] = w35;
       
       JButton w36 = new JButton(w);
       panel.add(w36);
       board[3][17] = w36;
       
       JButton w37 = new JButton(w);
       panel.add(w37);
       board[3][18] = w37;
       
       JButton w38 = new JButton(w);
       panel.add(w38);
       board[3][19] = w38;

       JButton r8 = new JButton(r);
       panel.add(r8);
       board[4][0] = r8;
       
       JButton o8 = new JButton(o);
       panel.add(o8);
       board[4][1] = o8;
       
       JButton g8 = new JButton(g);
       panel.add(g8);
       board[4][2] = g8;
       
       JButton b8 = new JButton(b);
       panel.add(b8);
       board[4][3] = b8;
       
       JButton y8 = new JButton(y);
       panel.add(y8);
       board[4][4] = y8;
       
       JButton w39 = new JButton(w);
       panel.add(w39);
       board[4][5] = w39;
      
       JButton g9 = new JButton(g);
       panel.add(g9);
       board[4][6] = g9;
       
       JButton b9 = new JButton(blicorice);
       panel.add(b9);
       board[4][7] = b9;
       
       JButton y9 = new JButton(y);
       panel.add(y9);
       board[4][8] = y9;
       
       JButton m9 = new JButton(m);
       panel.add(m9);
       board[4][9] = m9;
       
       JButton r9 = new JButton(r);
       panel.add(r9);
       board[4][10] = r9;
       
       JButton o9 = new JButton(o);
       panel.add(o9);
       board[4][11] = o9;
       
       JButton w40 = new JButton(w);
       panel.add(w40);
       board[4][12] = w40;
       
       JButton w41 = new JButton(w);
       panel.add(w41);
       board[4][13] = w41;
       
       JButton w42 = new JButton(w);
       panel.add(w42);
       board[4][14] = w42;
       
       JButton w43 = new JButton(w);
       panel.add(w43);
       board[4][15] = w43;
       
       JButton w44 = new JButton(w);
       panel.add(w44);
       board[4][16] = w44;
       
       JButton w45 = new JButton(w);
       panel.add(w45);
       board[4][17] = w45;
       
       JButton w46 = new JButton(w);
       panel.add(w46);
       board[4][18] = w46;
       
       JButton w47 = new JButton(w);
       panel.add(w47);
       board[4][19] = w47;
       
       JButton w48 = new JButton(w);
       panel.add(w48);
       board[5][0] = w48;
       
       JButton w49 = new JButton(w);
       panel.add(w49);
       board[5][1] = w49;
       
       JButton w50 = new JButton(w);
       panel.add(w50);
       board[5][2] = w50;
       
       JButton w51 = new JButton(w);
       panel.add(w51);
       board[5][3] = w51;
       
       JButton w52 = new JButton(w);
       panel.add(w52);
       board[5][4] = w52;
       
       JButton w53 = new JButton(w);
       panel.add(w53);
       board[5][5] = w53;
       
       JButton w54 = new JButton(w);
       panel.add(w54);
       board[5][6] = w54;
       
       JButton w55 = new JButton(w);
       panel.add(w55);
       board[5][7] = w55;
       
       JButton w56 = new JButton(w);
       panel.add(w56);
       board[5][8] = w56;
       
       JButton w57 = new JButton(w);
       panel.add(w57);
       board[5][9] = w57;
       
       JButton w58 = new JButton(w);
       panel.add(w58);
       board[5][10] = w58;
      
       JButton g10 = new JButton(g);
       panel.add(g10);
       board[5][11] = g10;
       
       JButton w59 = new JButton(w);
       panel.add(w59);
       board[5][12] = w59;
       
       JButton w60 = new JButton(w);
       panel.add(w60);
       board[5][13] = w60;
       
       JButton w61 = new JButton(w);
       panel.add(w61);
       board[5][14] = w61;
       
       JButton w62 = new JButton(w);
       panel.add(w62);
       board[5][15] = w62;
       
       JButton w63 = new JButton(w);
       panel.add(w63);
       board[5][16] = w63;
       
       JButton w64 = new JButton(w);
       panel.add(w64);
       board[5][17] = w64;
       
       JButton w65 = new JButton(w);
       panel.add(w65);
       board[5][18] = w65;
       
       JButton w66 = new JButton(w);
       panel.add(w66);
       board[5][19] = w66;
       
       JButton nut = new JButton(peanut);
       panel.add(nut);
       board[6][0] = nut;
       
       JButton o11 = new JButton(o);
       panel.add(o11);
       board[6][1] = o11;
       
       JButton r11 = new JButton(r);
       panel.add(r11);
       board[6][2] = r11;
       
       JButton m11 = new JButton(m);
       panel.add(m11);
       board[6][3] = m11;
       
       JButton y11 = new JButton(y);
       panel.add(y11);
       board[6][4] = y11;
       
       JButton b11 = new JButton(b);
       panel.add(b11);
       board[6][5] = b11;
       
       JButton g11 = new JButton(g);
       panel.add(g11);
       board[6][6] = g11;
       
       JButton o12 = new JButton(o);
       panel.add(o12);
       board[6][7] = o12;
       
       JButton r12 = new JButton(r);
       panel.add(r12);
       board[6][8] = r12;
       
       JButton m12 = new JButton(m);
       panel.add(m12);
       board[6][9] = m12;
       
       JButton y12 = new JButton(y);
       panel.add(y12);
       board[6][10] = y12;
       
       JButton b12 = new JButton(b);
       panel.add(b12);
       board[6][11] = b12;
       
       JButton w67 = new JButton(w);
       panel.add(w67);
       board[6][12] = w67;
       
       JButton w68 = new JButton(w);
       panel.add(w68);
       board[6][13] = w68;
       
       JButton w69 = new JButton(w);
       panel.add(w69);
       board[6][14] = w69;
       
       JButton w70 = new JButton(w);
       panel.add(w70);
       board[6][15] = w70;
       
       JButton w71 = new JButton(w);
       panel.add(w71);
       board[6][16] = w71;
       
       JButton w72 = new JButton(w);
       panel.add(w72);
       board[6][17] = w72;
       
       JButton w73 = new JButton(w);
       panel.add(w73);
       board[6][18] = w67;
       
       JButton w74 = new JButton(w);
       panel.add(w74);
       board[6][19] = w74;
       
       JButton g13 = new JButton(g);
       panel.add(g13);
       board[7][0] = g13;
       
       JButton w75 = new JButton(w);
       panel.add(w75);
       board[7][1] = w75;

       JButton w76 = new JButton(w);
       panel.add(w76);
       board[7][2] = w76;

       JButton w77 = new JButton(w);
       panel.add(w77);
       board[7][3] = w77;

       JButton w78 = new JButton(w);
       panel.add(w78);
       board[7][4] = w78;

       JButton w79 = new JButton(w);
       panel.add(w79);
       board[7][5] = w79;

       JButton w80 = new JButton(w);
       panel.add(w80);
       board[7][6] = w80;

       JButton w81 = new JButton(w);
       panel.add(w81);
       board[7][7] = w81;

       JButton w82 = new JButton(w);
       panel.add(w82);
       board[7][8] = w82;

       JButton w83 = new JButton(w);
       panel.add(w83);
       board[7][9] = w83;

       JButton w84 = new JButton(w);
       panel.add(w84);
       board[7][10] = w84;

       JButton w85 = new JButton(w);
       panel.add(w85);
       board[7][11] = w85;

       JButton w86 = new JButton(w);
       panel.add(w86);
       board[7][12] = w86;

       JButton w87 = new JButton(w);
       panel.add(w87);
       board[7][13] = w87;

       JButton w88 = new JButton(w);
       panel.add(w88);
       board[7][14] = w88;

       JButton w89 = new JButton(w);
       panel.add(w89);
       board[7][15] = w89;

       JButton w90 = new JButton(w);
       panel.add(w90);
       board[7][16] = w90;

       JButton w91 = new JButton(w);
       panel.add(w91);
       board[7][17] = w91;

       JButton w92 = new JButton(w);
       panel.add(w92);
       board[7][18] = w92;

       JButton w93 = new JButton(w);
       panel.add(w93);
       board[7][19] = w93;
       
       JButton b13 = new JButton(b);
       panel.add(b13);
       board[8][0] = b13;
       
       JButton w94 = new JButton(w);
       panel.add(w94);
       board[8][1] = w94;

       JButton w95 = new JButton(w);
       panel.add(w95);
       board[8][2] = w95;

       JButton w96 = new JButton(w);
       panel.add(w96);
       board[8][3] = w96;

       JButton w97 = new JButton(w);
       panel.add(w97);
       board[8][4] = w97;

       JButton w98 = new JButton(w);
       panel.add(w98);
       board[8][5] = w98;

       JButton w99 = new JButton(w);
       panel.add(w99);
       board[8][6] = w99;

       JButton w100 = new JButton(w);
       panel.add(w100);
       board[8][7] = w100;

       JButton w101 = new JButton(w);
       panel.add(w101);
       board[8][8] = w101;
       
       JButton r13 = new JButton(r);
       panel.add(r13);
       board[8][9] = r13;
       
       JButton o13 = new JButton(o);
       panel.add(o13);
       board[8][10] = o13;
       
       JButton g14 = new JButton(g);
       panel.add(g14);
       board[8][11] = g14;
       
       JButton b14 = new JButton(b);
       panel.add(b14);
       board[8][12] = b14;
       
       JButton y14 = new JButton(y);
       panel.add(y14);
       board[8][13] = y14;
       
       JButton m13 = new JButton(plicorice);
       panel.add(m13);
       board[8][14] = m13;
       
       JButton r14 = new JButton(r);
       panel.add(r14);
       board[8][15] = r14;
       
       JButton o14 = new JButton(o);
       panel.add(o14);
       board[8][16] = o14;
       
       JButton g15 = new JButton(g);
       panel.add(g15);
       board[8][17] = g15;
       
       JButton b15 = new JButton(b);
       panel.add(b15);
       board[8][18] = b15;
       
       JButton candy = new JButton(candycane);
       panel.add(candy);
       board[8][19] = candy;
       
       JButton y13 = new JButton(y);
       panel.add(y13);
       board[9][0] = y13;
       
       JButton w102 = new JButton(w);
       panel.add(w102);
       board[9][1] = w102;

       JButton w103 = new JButton(w);
       panel.add(w103);
       board[9][2] = w103;

       JButton w104 = new JButton(w);
       panel.add(w104);
       board[9][3] = w104;

       JButton w105 = new JButton(w);
       panel.add(w105);
       board[9][4] = w105;

       JButton w106 = new JButton(w);
       panel.add(w106);
       board[9][5] = w106;

       JButton w107 = new JButton(w);
       panel.add(w107);
       board[9][6] = w107;

       JButton w108 = new JButton(w);
       panel.add(w108);
       board[9][7] = w108;

       JButton w109 = new JButton(w);
       panel.add(w109);
       board[9][8] = w109;

       JButton m14 = new JButton(m);
       panel.add(m14);
       board[9][9] = m14;

       JButton w110 = new JButton(w);
       panel.add(w110);
       board[9][10] = w110;

       JButton w111 = new JButton(w);
       panel.add(w111);
       board[9][11] = w111;

       JButton w112 = new JButton(w);
       panel.add(w112);
       board[9][12] = w112;

       JButton w113 = new JButton(w);
       panel.add(w113);
       board[9][13] = w113;

       JButton bl33 = new JButton(bl3);
       panel.add(bl33);
       board[9][14] = bl33;

       JButton bl44 = new JButton(bl4);
       panel.add(bl44);
       board[9][15] = bl44;

       JButton w116 = new JButton(w);
       panel.add(w116);
       board[9][16] = w116;

       JButton w117 = new JButton(w);
       panel.add(w117);
       board[9][17] = w117;

       JButton w118 = new JButton(w);
       panel.add(w118);
       board[9][18] = w118;

       JButton y15 = new JButton(y);
       panel.add(y15);
       board[9][19] = y15;

       JButton m15 = new JButton(m);
       panel.add(m15);
       board[10][0] = m15;

       JButton w120 = new JButton(w);
       panel.add(w120);
       board[10][1] = w120;

       JButton w121 = new JButton(w);
       panel.add(w121);
       board[10][2] = w121;

       JButton w122 = new JButton(w);
       panel.add(w122);
       board[10][3] = w122;

       JButton w123 = new JButton(w);
       panel.add(w123);
       board[10][4] = w123;

       JButton w124 = new JButton(w);
       panel.add(w124);
       board[10][5] = w124;

       JButton w125 = new JButton(w);
       panel.add(w125);
       board[10][6] = w125;

       JButton w126 = new JButton(w);
       panel.add(w126);
       board[10][7] = w126;

       JButton w127 = new JButton(w);
       panel.add(w127);
       board[10][8] = w127;

       JButton y16 = new JButton(y);
       panel.add(y16);
       board[10][9] = y16;

       JButton w128 = new JButton(w);
       panel.add(w128);
       board[10][10] = w128;
       
       JButton o15 = new JButton(o);
       panel.add(o15);
       board[10][11] = o15;
       
       JButton r15 = new JButton(r);
       panel.add(r15);
       board[10][12] = r15;
       
       JButton m16 = new JButton(m);
       panel.add(m16);
       board[10][13] = m16;
       
       JButton y17 = new JButton(y);
       panel.add(y17);
       board[10][14] = y17;
       
       JButton b16 = new JButton(b);
       panel.add(b16);
       board[10][15] = b16;
       
       JButton g16 = new JButton(g);
       panel.add(g16);
       board[10][16] = g16;
       
       JButton o16 = new JButton(o);
       panel.add(o16);
       board[10][17] = o16;
       
       JButton r16 = new JButton(r);
       panel.add(r16);
       board[10][18] = r16;
       
       JButton m17 = new JButton(m);
       panel.add(m17);
       board[10][19] = m17;
       
       JButton r17 = new JButton(r);
       panel.add(r17);
       board[11][0] = r17;
       
       JButton o17 = new JButton(o);
       panel.add(o17);
       board[11][1] = o17;
       
       JButton g20 = new JButton(g);
       panel.add(g20);
       board[11][2] = g20;
       
       JButton b17 = new JButton(b);
       panel.add(b17);
       board[11][3] = b17;
       
       JButton y18 = new JButton(y);
       panel.add(y18);
       board[11][4] = y18;
       
       JButton m18 = new JButton(m);
       panel.add(m18);
       board[11][5] = m18;
       
       JButton r18 = new JButton(r);
       panel.add(r18);
       board[11][6] = r18;
       
       JButton o18 = new JButton(o);
       panel.add(o18);
       board[11][7] = o18;
       
       JButton g18 = new JButton(g);
       panel.add(g18);
       board[11][8] = g18;
       
       JButton b18 = new JButton(b);
       panel.add(b18);
       board[11][9] = b18;

       JButton w129 = new JButton(w);
       panel.add(w129);
       board[11][10] = w129;

       JButton g19 = new JButton(g);
       panel.add(g19);
       board[11][11] = g19;

       JButton w130 = new JButton(w);
       panel.add(w130);
       board[11][12] = w130;

       JButton w131 = new JButton(w);
       panel.add(w131);
       board[11][13] = w131;

       JButton w132 = new JButton(w);
       panel.add(w132);
       board[11][14] = w132;

       JButton w133 = new JButton(w);
       panel.add(w133);
       board[11][15] = w133;

       JButton w134 = new JButton(w);
       panel.add(w134);
       board[11][16] = w134;

       JButton w135 = new JButton(w);
       panel.add(w135);
       board[11][17] = w135;

       JButton w136 = new JButton(w);
       panel.add(w136);
       board[11][18] = w136;

       JButton w137 = new JButton(w);
       panel.add(w137);
       board[11][19] = w137;

       JButton w138 = new JButton(w);
       panel.add(w138);
       board[12][0] = w138;

       JButton w139 = new JButton(w);
       panel.add(w139);
       board[12][1] = w139;

       JButton w140 = new JButton(w);
       panel.add(w140);
       board[12][2] = w140;

       JButton w141 = new JButton(w);
       panel.add(w141);
       board[12][3] = w141;

       JButton w142 = new JButton(w);
       panel.add(w142);
       board[12][4] = w142;

       JButton bl22 = new JButton(bl2);
       panel.add(bl22);
       board[12][5] = bl22;

       JButton w144 = new JButton(w);
       panel.add(w144);
       board[12][6] = w144;

       JButton w145 = new JButton(w);
       panel.add(w145);
       board[12][7] = w145;

       JButton w146 = new JButton(w);
       panel.add(w146);
       board[12][8] = w146;

       JButton w147 = new JButton(w);
       panel.add(w147);
       board[12][9] = w147;
       
       JButton w148 = new JButton(w);
       panel.add(w148);
       board[12][10] = w148;

       JButton b19 = new JButton(b);
       panel.add(b19);
       board[12][11] = b19;
       
       JButton y19 = new JButton(y);
       panel.add(y19);
       board[12][12] = y19;
       
       JButton m19 = new JButton(m);
       panel.add(m19);
       board[12][13] = m9;
       
       JButton r21 = new JButton(r);
       panel.add(r21);
       board[12][14] = r21;
       
       JButton o21 = new JButton(o);
       panel.add(o21);
       board[12][15] = o21;
       
       JButton g31 = new JButton(g);
       panel.add(g31);
       board[12][16] = g31;
       
       JButton b21 = new JButton(b);
       panel.add(b21);
       board[12][17] = b21;
       
       JButton y21 = new JButton(y);
       panel.add(y21);
       board[12][18] = y21;
       
       JButton m21 = new JButton(m);
       panel.add(m21);
       board[12][19] = m21;
       
       JButton w150 = new JButton(w);
       panel.add(w150);
       board[13][0] = w150;

       JButton w151 = new JButton(w);
       panel.add(w151);
       board[13][1] = w151;

       JButton w152 = new JButton(w);
       panel.add(w152);
       board[13][2] = w152;

       JButton w153 = new JButton(w);
       panel.add(w153);
       board[13][3] = w153;

       JButton bl11 = new JButton(bl1);
       panel.add(bl11);
       board[13][4] = bl11;

       JButton w155 = new JButton(w);
       panel.add(w155);
       board[13][5] = w155;

       JButton w156 = new JButton(w);
       panel.add(w156);
       board[13][6] = w156;

       JButton w157 = new JButton(w);
       panel.add(w157);
       board[13][7] = w157;

       JButton w158 = new JButton(w);
       panel.add(w158);
       board[13][8] = w158;

       JButton w159 = new JButton(w);
       panel.add(w159);
       board[13][9] = w159;

       JButton w160 = new JButton(w);
       panel.add(w160);
       board[13][10] = w160;

       JButton w161 = new JButton(w);
       panel.add(w161);
       board[13][11] = w161;

       JButton w162 = new JButton(w);
       panel.add(w162);
       board[13][12] = w162;

       JButton w163 = new JButton(w);
       panel.add(w163);
       board[13][13] = w163;

       JButton w164 = new JButton(w);
       panel.add(w164);
       board[13][14] = w164;

       JButton w165 = new JButton(w);
       panel.add(w165);
       board[13][15] = w165;

       JButton w166 = new JButton(w);
       panel.add(w166);
       board[13][16] = w166;

       JButton w167 = new JButton(w);
       panel.add(w167);
       board[13][17] = w167;

       JButton w168 = new JButton(w);
       panel.add(w168);
       board[13][18] = w168;
       
       JButton r22 = new JButton(r);
       panel.add(r22);
       board[13][19] = r22;
       
       JButton r61 = new JButton(redStart);
       panel.add(r61);
       board[14][0] = r61;
       
       JButton m41 = new JButton(m);
       panel.add(m41);
       board[14][1] = m41;
       
       JButton y51 = new JButton(y);
       panel.add(y51);
       board[14][2] = y51;
       
       JButton b51 = new JButton(b);
       panel.add(b51);
       board[14][3] = b51;
       
       JButton g51 = new JButton(g);
       panel.add(g51);
       board[14][4] = g51;
       
       JButton o51 = new JButton(o);
       panel.add(o51);
       board[14][5] = o51;
       
       JButton r71 = new JButton(r);
       panel.add(r71);
       board[14][6] = r71;
       
       JButton m51 = new JButton(m);
       panel.add(m51);
       board[14][7] = m51;
       
       JButton ginger = new JButton(gingerman);
       panel.add(ginger);
       board[14][8] = ginger;
       
       JButton y61 = new JButton(y);
       panel.add(y61);
       board[14][9] = y61;
       
       JButton b61 = new JButton(b);
       panel.add(b61);
       board[14][10] = b61;
       
       JButton g61 = new JButton(g);
       panel.add(g61);
       board[14][11] = g61;
       
       JButton o61 = new JButton(o);
       panel.add(o61);
       board[14][12] = o61;
       
       JButton r611 = new JButton(r);
       panel.add(r611);
       board[14][13] = r611;
       
       JButton m411 = new JButton(m);
       panel.add(m411);
       board[14][14] = m411;
       
       JButton y511 = new JButton(y);
       panel.add(y511);
       board[14][15] = y511;
       
       JButton b511 = new JButton(b);
       panel.add(b511);
       board[14][16] = b511;
       
       JButton g511 = new JButton(g);
       panel.add(g511);
       board[14][17] = g511;
       
       JButton o511 = new JButton(o);
       panel.add(o511);
       board[14][18] = o511;
       
       JButton gum = new JButton(gumdrop);
       panel.add(gum);
       board[14][19] = gum;
       
       for(int row = 0; row < board.length; row++)
       {
           for (int c = 0; c < board[0].length; c++)
           {
               listBut.add( board[row][c].getIcon() );
           }
       }
       
       this.changePlayer();
       controlPanel.doLayout();
       controlPanel.add(panel);
       //controlPanel.setPreferredSize( new Dimension(100, 1000000) );
       mainFrame.setVisible(true);  
    }
}
