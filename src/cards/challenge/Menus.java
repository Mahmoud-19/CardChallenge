/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.challenge;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static java.lang.System.exit;
import javax.swing.*;

/**
 *
 * @author mahmo
 */
public class Menus extends JFrame{
    
    /////////////////////////////MainMenu
    public JLabel Title = new JLabel("GUESS THE CARD");
    public JButton Bsingle = new JButton("Single");
    public JButton Bmulti = new JButton("Multiplayer");
    public JButton BmainHelp = new JButton("Help");
    public JButton BmainExit = new JButton("Exit");
    public static JPanel mainMenu = new JPanel();
    
    /////////////////////////////NEWGAME
    public JLabel number = new JLabel("Choose number of players");
    public JComboBox num = new JComboBox(new String[]{"2", "3", "4"});
    public JButton start = new JButton("Start");
    public JButton back = new JButton("Back");
    public JPanel newGame = new JPanel();
    
    ////////////////////////////GAMEPLAY
    public JLabel player1 = new JLabel();
    public JLabel player2 = new JLabel();
    public JLabel player1Score = new JLabel();
    public JLabel player2Score = new JLabel();
    public JLabel player3 = new JLabel();
    public JLabel player4 = new JLabel();
    public JLabel player3Score = new JLabel();
    public JLabel player4Score = new JLabel();
    public JLabel toolBar = new JLabel();
    public JButton menu = new JButton();
    public JPanel gamePlay = new JPanel();
    
   
    /////////////////////////////GAME MENU
    public JLabel Lresume = new JLabel();
    public JLabel Lrestart = new JLabel();
    public JLabel LgameHelp = new JLabel();
    public JLabel LgameExit = new JLabel();
    public JButton Bresume = new JButton();
    public JButton Brestart = new JButton();
    public JButton BgameHelp = new JButton();
    public JButton BgameExit = new JButton();
    
    /////////////////////////////////////NUMBER OF PLAYERS
    public static JLabel enterName = new JLabel("Please enter the players' names:");
    public static JLabel user1 = new JLabel("Player 1:");
    public static JLabel user2 = new JLabel("Player 2:");
    public static JLabel user3 = new JLabel("Player 3:");
    public static JLabel user4 = new JLabel("Player 4:");
    public static JTextField name1 = new JTextField("Player 1");
    public static JTextField name2 = new JTextField("Player 2");
    public static JTextField name3 = new JTextField("Player 3");
    public static JTextField name4 = new JTextField("Player 4");
    JPanel twoPlayers = new JPanel();
    JPanel threePlayers = new JPanel();
    JPanel fourPlayers = new JPanel();
    
    /////////////////////////////////////singleGamePlay
    public JLabel playerName = new JLabel("Name: ");
    public static JTextField Name = new JTextField("Player1");
    public JButton singleStart = new JButton("Start");
    public JButton singleBack = new JButton("Back");
    public JPanel singleNewGame = new JPanel();
    
    ///////////////////////////////////////
    
    JLabel mainMenuImage = new JLabel();
    JLabel newGameImage = new JLabel();
    JLabel gamePlayImage = new JLabel();
    
    public Menus()
    {
        setTitle("Cards Game");        
        mainMenuImage.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\OOP Project\\background.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        mainMenuImage.setBounds(0, 0, 1365, 767);
        newGameImage.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\OOP Project\\background.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        newGameImage.setBounds(0, 0, 1365, 767);
        
        ////////////////////////////////////MAIN MENU
        mainMenu.setLayout(null);
        Title.setBounds(100, 150, 500, 80);
        Bsingle.setBounds(250, 300, 160, 60);
        Bmulti.setBounds(Bsingle.getBounds().x, Bsingle.getBounds().y + Bsingle.getBounds().height + 25, Bsingle.getBounds().width, Bsingle.getBounds().height);
        BmainHelp.setBounds(Bsingle.getBounds().x, Bmulti.getBounds().y + Bmulti.getBounds().height + 25, Bsingle.getBounds().width, Bsingle.getBounds().height);
        BmainExit.setBounds(Bsingle.getBounds().x, BmainHelp.getBounds().y + BmainHelp.getBounds().height + 25, Bsingle.getBounds().width, Bsingle.getBounds().height);
        
        Title.setFont(new Font("Arial", Font.BOLD, 45));
        Title.setForeground(Color.WHITE);
        Bsingle.setFont(new Font("Serif", Font.PLAIN, 25));
        Bmulti.setFont(new Font("Serif", Font.PLAIN, 25));
        BmainHelp.setFont(new Font("Serif", Font.PLAIN, 25));
        BmainExit.setFont(new Font("Serif", Font.PLAIN, 25));
        
        mainMenu.add(Title);
        mainMenu.add(Bsingle);
        mainMenu.add(Bmulti);
        mainMenu.add(BmainHelp);
        mainMenu.add(BmainExit);
        mainMenu.setBackground(Color.yellow);
        Bsingle.addActionListener(new ButtonWatcher());
        Bmulti.addActionListener(new ButtonWatcher());
        mainMenu.add(mainMenuImage);
        BmainHelp.addActionListener(new ButtonWatcher());
        BmainExit.addActionListener(new ButtonWatcher());
        add(mainMenu);

        
        //////////////////////////////////NEWGAME
        newGame.setLayout(null);
        number.setBounds(200, 200, 300, 50);
        num.setBounds(number.getBounds().x + 250, number.getBounds().y, 50, 40);
        newGame.add(number);
        newGame.add(num);
        number.setForeground(Color.WHITE);
        number.setFont(new Font(null, Font.PLAIN, 18));
        start.setBounds(250, 600, 80, 30);
        back.setBounds(start.getBounds().x + start.getSize().width + 50, start.getBounds().y, 80, 30);
        newGame.add(start);
        newGame.add(back);
        newGame.add(newGameImage);
        start.addActionListener(new ButtonWatcher());
        back.addActionListener(new ButtonWatcher());
        num.addActionListener(new ButtonWatcher());
        //newGame.setBackground(Color.yellow);
        
        ///////////////////////////////////////SingleNewGame
        singleNewGame.setLayout(null);
        playerName.setBounds(150, 300, 300, 50);
        Name.setBounds(playerName.getBounds().x + 150, playerName.getBounds().y + 10, 130, 30);
        singleStart.setBounds(250, 600, 80, 30);
        singleBack.setBounds(singleStart.getBounds().x + singleStart.getSize().width +50, singleStart.getBounds().y, 80, 30);
        playerName.setFont(new Font(null, Font.PLAIN, 25));
        playerName.setForeground(Color.WHITE);
        singleNewGame.add(playerName);
        singleNewGame.add(Name);
        singleNewGame.add(singleStart);
        singleNewGame.add(singleBack);
        singleNewGame.add(newGameImage);
        singleStart.addActionListener(new ButtonWatcher());
        singleBack.addActionListener(new ButtonWatcher());
                
        /////////////////////////////////////////////
        twoPlayers.setLayout(null);
        threePlayers.setLayout(null);
        fourPlayers.setLayout(null);
        user1.setBounds(100, 300, 80, 25);
        name1.setBounds(user1.getBounds().x + user1.getSize().width + 40, user1.getBounds().y, 90, 25);
        user2.setBounds(name1.getBounds().x + name1.getSize().width + 60, name1.getBounds().y, 90, 25);
        name2.setBounds(user2.getBounds().x + user2.getSize().width + 40, user2.getBounds().y, 90, 25);
        user3.setBounds(user1.getBounds().x, name1.getBounds().y + 70, 90, 25);
        name3.setBounds(name1.getBounds().x, user3.getBounds().y, 90, 25);
        user4.setBounds(user2.getBounds().x, name2.getBounds().y + 70, 90, 25);
        name4.setBounds(name2.getBounds().x, user4.getBounds().y, 90, 25);
        user1.setFont(new Font(null, Font.PLAIN, 18));
        user2.setFont(new Font(null, Font.PLAIN, 18));
        user3.setFont(new Font(null, Font.PLAIN, 18));
        user4.setFont(new Font(null, Font.PLAIN, 18));
        user1.setForeground(Color.WHITE);
        user2.setForeground(Color.WHITE);
        user3.setForeground(Color.WHITE);
        user4.setForeground(Color.WHITE);
        
        /////////////////////////////////////////////
        
        ///////////////////////////////GamePlay
        gamePlay.setLayout(null);
        gamePlay.setBackground(Color.GREEN);
        toolBar.setBounds(0, 0, 1365, 60);
        //toolBar.setBackground(Color.BLUE);
        player1.setBounds(20, 10, 100, 30);
        player1Score.setBounds(player1.getBounds().x + 30, player1.getBounds().y, 30, 30);
        player2.setBounds(player1Score.getBounds().x + player1Score.getSize().width + 100, player1.getBounds().y, 100, 30);
        player2Score.setBounds(player2.getBounds().x + 30, player2.getBounds().y, 30, 30);
        //////////add players 3 & 4
        gamePlay.add(gamePlayImage);
        gamePlay.add(toolBar);
        gamePlay.add(player1);
        gamePlay.add(player1Score);
        gamePlay.add(player2);
        gamePlay.add(player2Score);
        gamePlay.add(player3);
        gamePlay.add(player3Score);
        gamePlay.add(player4);
        gamePlay.add(player4Score);
        
        
    }

    public void ComboBox()      //this function is to determine the value chosen in the combo box and add textfields of that number
    {
        if(num.getSelectedItem().toString().equals("2"))
        {
            twoPlayers.add(number);
            twoPlayers.add(num);
            twoPlayers.add(user1);
            twoPlayers.add(name1);
            twoPlayers.add(user2);
            twoPlayers.add(name2);
            twoPlayers.add(start);
            twoPlayers.add(back);
            twoPlayers.add(newGameImage);
            twoPlayers.setBackground(Color.RED);
            newGame.setVisible(false);
            threePlayers.setVisible(false);
            fourPlayers.setVisible(false);
            twoPlayers.setVisible(true);
            add(twoPlayers);
        }
        else if(num.getSelectedItem().toString().equals("3"))
        {
            threePlayers.add(number);
            threePlayers.add(num);
            threePlayers.add(user1);
            threePlayers.add(name1);
            threePlayers.add(user2);
            threePlayers.add(name2);
            threePlayers.add(user3);
            threePlayers.add(name3);
            threePlayers.add(start);
            threePlayers.add(back);
            threePlayers.add(newGameImage);
            threePlayers.setBackground(Color.RED);
            newGame.setVisible(false);
            twoPlayers.setVisible(false);
            fourPlayers.setVisible(false);
            threePlayers.setVisible(true);
            add(threePlayers);
        }
        else if(num.getSelectedItem().toString().equals("4"))
        {
            fourPlayers.add(number);
            fourPlayers.add(num);
            fourPlayers.add(user1);
            fourPlayers.add(name1);
            fourPlayers.add(user2);
            fourPlayers.add(name2);
            fourPlayers.add(user3);
            fourPlayers.add(name3);
            fourPlayers.add(user4);
            fourPlayers.add(name4);
            fourPlayers.add(start);
            fourPlayers.add(back);
            fourPlayers.add(newGameImage);
            fourPlayers.setBackground(Color.RED);
            newGame.setVisible(false);
            twoPlayers.setVisible(false);
            threePlayers.setVisible(false);
            fourPlayers.setVisible(true);
            add(fourPlayers);
        }
    }
    
    private class ButtonWatcher implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Object buttonPressed = ae.getSource();
            if(buttonPressed.equals(Bsingle))
            {
                mainMenu.setVisible(false);
                singleNewGame.setVisible(true);
                add(singleNewGame);
            }
            else if(buttonPressed.equals(Bmulti))
            {
                mainMenu.setVisible(false);
                newGame.setVisible(true);
                add(newGame);
            }
            else if(buttonPressed.equals(BmainHelp))
            {
                JOptionPane.showMessageDialog(null, "How to play: Start by chosing two cards and if they are the same you get a point");
            }
            else if(buttonPressed.equals(BmainExit))
            {
                exit(1);
            }
            else if(buttonPressed.equals(start))
            {
                fourPlayers.setVisible(false);
                newGame.setVisible(false);
                twoPlayers.setVisible(false);
                threePlayers.setVisible(false);
                gamePlay.setVisible(true);
                add(gamePlay);
                CardGuess cg = new CardGuess();
                add(cg);
                cg.arrange();
                
            }
            else if(buttonPressed.equals(back))
            {
                fourPlayers.setVisible(false);
                newGame.setVisible(false);
                twoPlayers.setVisible(false);
                threePlayers.setVisible(false);
                mainMenu.setVisible(true);
                add(mainMenu);
            }
            else if(buttonPressed.equals(num))
            {
                ComboBox();
            }
            else if(buttonPressed.equals(singleStart))
            {
                singleNewGame.setVisible(false);
                SinglePlayer SP = new SinglePlayer();
                add(SP);
                SP.arrange();
            }
            else if(buttonPressed.equals(singleBack))
            {
                singleNewGame.setVisible(false);
                mainMenu.setVisible(true);
                add(mainMenu);
            }
        }

    }
    
}
