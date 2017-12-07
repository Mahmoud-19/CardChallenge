/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.challenge;

import static cards.challenge.Menus.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author mahmo
 */
public class CardGuess extends JPanel{
   
    /////////////////////////////GAME MENU
    public JButton Brestart = new JButton("Restart");
    public JButton BgameExit = new JButton("Exit");
    
    public static ArrayList<Cards> card = new ArrayList<Cards>(52);
    public String DirectoryPath="C:\\Users\\mahmo\\Desktop\\Cards";
    public JLabel gamePlayImage = new JLabel();
    public JLabel toolbar = new JLabel();
    public JLabel player1Score = new JLabel();
    public JLabel player2Score = new JLabel();
    public JLabel whichTurn = new JLabel();
    public static int ArraySize =51;
    public static int cardsOnGround = 52;
    public static int turn = 0;
    public static Cards firstCard;
    public static Cards secondCard;
    public static int numOfCardsSelected;
    public static int card1Index, card2Index; 
    public static int player1 =0, player2 =0;
    
    public CardGuess()
    {
        ////////////////////////////////GameMenu        
        BgameExit.setBounds(1150, 710, 130, 50);
        BgameExit.setFont(new Font("Serif", Font.PLAIN, 25));
        Brestart.setBounds(950, 710, 130, 50);
        Brestart.setFont(new Font("Serif", Font.PLAIN, 25));
        add(Brestart);
        add(BgameExit);
        Brestart.addMouseListener(new ButtonWatcher());
        BgameExit.addMouseListener(new ButtonWatcher());
        
        Menus m = new Menus();
        whichTurn.setBounds(650, 710, 300, 50);
        whichTurn.setText(name1.getText() + " turn");
        whichTurn.setForeground(Color.BLACK);
        whichTurn.setFont(new Font("Serif", Font.PLAIN, 35));
        
        player1Score.setBounds(80, 710, 200, 50);
        player2Score.setBounds(330, 710, 200, 50);
        player1Score.setText(name1.getText() + ": " + player1);
        player1Score.setForeground(Color.BLACK);
        player1Score.setFont(new Font("Serif", Font.PLAIN, 35));
        player2Score.setText(name2.getText() + ": "+player2);
        player2Score.setForeground(Color.BLACK);
        player2Score.setFont(new Font("Serif", Font.PLAIN, 35));
        
        gamePlayImage.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\OOP Project\\gameplay.png").getImage().getScaledInstance(1370, 767, Image.SCALE_DEFAULT)));
        gamePlayImage.setBounds(0, 0, 1370, 767);
        
        toolbar.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\OOP Project\\toolbar.png").getImage().getScaledInstance(1370, 80, Image.SCALE_DEFAULT)));
        toolbar.setBounds(0, 700, 1370, 80);
        
        setLayout(null);
        for(int i=1;i<53;i++)
        {
            Cards cd = new Cards();
            if(i<14)
            {
                cd.value = i;
                cd.imageName = DirectoryPath + "\\" + i + "_of_clubs.png";
                cd.type = Cards.ShapeTypes.Clubs;
                card.add(cd);
                JLabel j = new JLabel();
                j.setIcon(new ImageIcon(new ImageIcon(cd.imageName).getImage().getScaledInstance(90, 140, Image.SCALE_DEFAULT)));
                //add(j);
                JLabel q = new JLabel();
                q.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\Cards\\cardback.png").getImage().getScaledInstance(90, 140, Image.SCALE_DEFAULT)));
                //q.setBounds(50, 450, 110, 170);
                q.addMouseListener(new ButtonWatcher());
                cd.backHolder = q;
                j.addMouseListener(new ButtonWatcher());
                //j.setBounds(Cx,Cy, 110, 170);
                cd.frontHolder=j;
            }
            else if(i>13 && i<27)
            {
                cd.value = i - 13;
                cd.imageName = DirectoryPath + "\\" + (i-13) + "_of_diamonds.png";
                cd.type = Cards.ShapeTypes.Diamond;
                card.add(cd);
                JLabel j = new JLabel();
                j.setIcon(new ImageIcon(new ImageIcon(cd.imageName).getImage().getScaledInstance(90, 140, Image.SCALE_DEFAULT)));
                //add(j);
                j.addMouseListener(new ButtonWatcher());
                JLabel q = new JLabel();
                q.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\Cards\\cardback.png").getImage().getScaledInstance(90, 140, Image.SCALE_DEFAULT)));
                //q.setBounds(50, 450, 110, 170);
                q.addMouseListener(new ButtonWatcher());
                cd.backHolder = q;
                //j.setBounds(Dx,Dy, 110, 170);
                cd.frontHolder=j;
            }
            else if(i>26 && i<40)
            {
                cd.value = i - 26;
                cd.imageName = DirectoryPath + "\\" + (i-26) + "_of_hearts.png";
                cd.type = Cards.ShapeTypes.RedHeart;
                card.add(cd);
                JLabel j = new JLabel();
                j.setIcon(new ImageIcon(new ImageIcon(cd.imageName).getImage().getScaledInstance(90, 140, Image.SCALE_DEFAULT)));
                //add(j);
                j.addMouseListener(new ButtonWatcher());
                JLabel q = new JLabel();
                q.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\Cards\\cardback.png").getImage().getScaledInstance(90, 140, Image.SCALE_DEFAULT)));
                //q.setBounds(50, 450, 110, 170);
                q.addMouseListener(new ButtonWatcher());
                cd.backHolder = q;
                //j.setBounds(Hx,Hy, 110, 170);
                cd.frontHolder=j;
            }
            else if(i>39)
            {
                cd.value = i - 39;
                cd.imageName = DirectoryPath + "\\" + (i-39) + "_of_spades.png";
                cd.type = Cards.ShapeTypes.RedHeart;
                card.add(cd);
                JLabel j = new JLabel();
                j.setIcon(new ImageIcon(new ImageIcon(cd.imageName).getImage().getScaledInstance(90, 140, Image.SCALE_DEFAULT)));
                //add(j);
                j.addMouseListener(new ButtonWatcher());
                JLabel q = new JLabel();
                q.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\Cards\\cardback.png").getImage().getScaledInstance(90, 140, Image.SCALE_DEFAULT)));
                //q.setBounds(50, 450, 110, 170);
                q.addMouseListener(new ButtonWatcher());
                cd.backHolder = q;
                //j.setBounds(Sx,Sy, 110, 170);
                cd.frontHolder=j;
            }
        }
        add(player1Score);
        add(player2Score);
        add(whichTurn);
    }
    
    public void arrange()       //arranges the cards on the ground
    {
        int X =30, Y =30;
        shuffleCards();
        for(int i=0;i<52;i++)
        {
            if(X > 1300)
            {
                Y+=150;
                X =30;
            }
            card.get(ArraySize).backHolder.setBounds(X, Y, 90, 140);
            add(card.get(ArraySize).backHolder);
            ArraySize--;
            X+=100;
        }
        add(player1Score);
        add(player2Score);
        add(whichTurn);
        add(toolbar);
        add(gamePlayImage);
    }
    
    public void giveScore()     //checks who gets the point and added to his score
    {
        if(turn%2==0)
        {
            player1++;
            player1Score.setText(name1.getText() + ": " + player1);
            JOptionPane.showMessageDialog(null, name1.getText() + " gets a point");
        }
        else
        {
            player2++;
            player2Score.setText(name2.getText() + ": " + player2);
            JOptionPane.showMessageDialog(null, name2.getText() +" gets a point");            
        }
        //turn++;
    }
    
    public void whoseTurn()    //checks and displays who's turn is it
    {
        if(turn%2==0)
        {
            whichTurn.setText(name1.getText() + " turn");
        }
        else
        {
            whichTurn.setText(name2.getText() + " turn");
        }
    }
    
    public void shuffleCards()       //shuffles the cards at the beginning before adding them to the ground
    {
        Random rand = new Random();
        
        for(int i=0;i<100;i++)
        {
            int firstPlace = rand.nextInt(52);
            int secondPlace = rand.nextInt(52);
            //JOptionPane.showMessageDialog(null, "first: " + card.get(firstPlace).value + " second: "+card.get(secondPlace).value);
            Collections.shuffle(card);      //ready made function to shuffle the cards before starting
//            card.add(card.get(secondPlace));
//            card.add(cd);
            //JOptionPane.showMessageDialog(null, "first: " + card.get(firstPlace).value + " second: "+card.get(secondPlace).value);
        }
        
    }
    
    private class ButtonWatcher implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent me) {

            if(me.getSource().equals(Brestart))
            {
//                CardGuess CG = new CardGuess();
//                add(CG);
//                CG.arrange();
                mainMenu.setVisible(true);
                add(mainMenu);
            }
            else if(me.getSource().equals(BgameExit))
            {
                exit(1);
            }
            
            for(int i=0;i<52;i++)
            {
                if(me.getSource().equals(card.get(i).backHolder))
                {
                    card.get(i).frontHolder.setBounds(card.get(i).backHolder.getBounds().x, card.get(i).backHolder.getBounds().y, card.get(i).backHolder.getBounds().width, card.get(i).backHolder.getBounds().height);
                    card.get(i).frontHolder.setVisible(true);
                    add(card.get(i).frontHolder);
                    card.get(i).backHolder.setVisible(false);
                    //add(whichTurn);
                    add(toolbar);
                    add(gamePlayImage);
                    card.get(i).frontHolder.setBorder(BorderFactory.createLineBorder(Color.RED));
                    numOfCardsSelected++;
                    
                    if(numOfCardsSelected == 1)
                    {
                        firstCard = card.get(i);
                        card1Index = i;
                    }
                    else if(numOfCardsSelected == 2)
                    {
                        //whoseTurn();
                        secondCard = card.get(i);
                        card2Index = i;
                        if(firstCard.value == secondCard.value)
                        {
                            giveScore();
                            add(player1Score);
                            add(player2Score);
                            add(whichTurn);
                            add(toolbar);
                            add(gamePlayImage);
                            JOptionPane.showMessageDialog(null, "Correct");
                            
                            card.get(card1Index).frontHolder.setVisible(false);
                            card.get(card1Index).backHolder.setVisible(false);
                            card.get(card2Index).frontHolder.setVisible(false);
                            card.get(card2Index).backHolder.setVisible(false);
                        }
                        else
                        {
                            turn++;
                            JOptionPane.showMessageDialog(null, "InCorrect");
                            card.get(card1Index).frontHolder.setVisible(false);
                            card.get(card2Index).frontHolder.setVisible(false);
                            card.get(card1Index).backHolder.setVisible(true);
                            card.get(card2Index).backHolder.setVisible(true);
                            add(whichTurn);
                            add(toolbar);
                            add(gamePlayImage);
                        }
                        numOfCardsSelected =0; 
                        whoseTurn();                        
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            // new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
}
