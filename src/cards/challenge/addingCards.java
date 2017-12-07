///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cards.challenge;
//
//import java.awt.Color;
//import java.awt.Image;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.util.ArrayList;
//import java.util.Random;
//import javax.swing.*;
//
///**
// *
// * @author mahmo
// */
//public class addingCards extends JPanel{
//    
//    public static ArrayList<Cards> card = new ArrayList<Cards>(52);
//    public String DirectoryPath="C:\\Users\\mahmo\\Desktop\\Cards";
//    public int Cx = 10, Cy =5, Dx =10, Dy =180, Hx =10, Hy =355, Sx =10, Sy =525;
//    public JLabel gamePlayImage = new JLabel();
//    public static int ArraySize =51;
//    public static Cards cardInHand;
//    public static Cards cardOnGround;
//    public static int numOfLastPlayed;
//    
//    public addingCards()
//    {
//        gamePlayImage.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\OOP Project\\gameplay.png").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
//        gamePlayImage.setBounds(0, 0, 1365, 767);
//        
//        setLayout(null);
//        for(int i=1;i<53;i++)
//        {
//            Cards cd = new Cards();
//            if(i<14)
//            {
//                cd.value = i;
//                cd.imageName = DirectoryPath + "\\" + i + "_of_clubs.png";
//                cd.type = Cards.ShapeTypes.Clubs;
//                card.add(cd);
//                JLabel j = new JLabel();
//                j.setIcon(new ImageIcon(new ImageIcon(cd.imageName).getImage().getScaledInstance(110, 170, Image.SCALE_DEFAULT)));
//                //add(j);
//                JLabel q = new JLabel();
//                q.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\Cards\\cardback.png").getImage().getScaledInstance(110, 170, Image.SCALE_DEFAULT)));
//                //q.setBounds(50, 450, 110, 170);
//                cd.backHolder = q;
//                j.addMouseListener(new ButtonWatcher());
//                //j.setBounds(Cx,Cy, 110, 170);
//                cd.frontHolder=j;
//                Cx+=70;
//            }
//            else if(i>13 && i<27)
//            {
//                cd.value = i - 13;
//                cd.imageName = DirectoryPath + "\\" + (i-13) + "_of_diamonds.png";
//                cd.type = Cards.ShapeTypes.Diamond;
//                card.add(cd);
//                JLabel j = new JLabel();
//                j.setIcon(new ImageIcon(new ImageIcon(cd.imageName).getImage().getScaledInstance(110, 170, Image.SCALE_DEFAULT)));
//                //add(j);
//                j.addMouseListener(new ButtonWatcher());
//                JLabel q = new JLabel();
//                q.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\Cards\\cardback.png").getImage().getScaledInstance(110, 170, Image.SCALE_DEFAULT)));
//                //q.setBounds(50, 450, 110, 170);
//                cd.backHolder = q;
//                //j.setBounds(Dx,Dy, 110, 170);
//                cd.frontHolder=j;
//                Dx+=70;
//            }
//            else if(i>26 && i<40)
//            {
//                cd.value = i - 26;
//                cd.imageName = DirectoryPath + "\\" + (i-26) + "_of_hearts.png";
//                cd.type = Cards.ShapeTypes.RedHeart;
//                card.add(cd);
//                JLabel j = new JLabel();
//                j.setIcon(new ImageIcon(new ImageIcon(cd.imageName).getImage().getScaledInstance(110, 170, Image.SCALE_DEFAULT)));
//                //add(j);
//                j.addMouseListener(new ButtonWatcher());
//                JLabel q = new JLabel();
//                q.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\Cards\\cardback.png").getImage().getScaledInstance(110, 170, Image.SCALE_DEFAULT)));
//                //q.setBounds(50, 450, 110, 170);
//                cd.backHolder = q;
//                //j.setBounds(Hx,Hy, 110, 170);
//                cd.frontHolder=j;
//                Hx+=70;
//            }
//            else if(i>39)
//            {
//                cd.value = i - 39;
//                cd.imageName = DirectoryPath + "\\" + (i-39) + "_of_spades.png";
//                cd.type = Cards.ShapeTypes.RedHeart;
//                card.add(cd);
//                JLabel j = new JLabel();
//                j.setIcon(new ImageIcon(new ImageIcon(cd.imageName).getImage().getScaledInstance(110, 170, Image.SCALE_DEFAULT)));
//                //add(j);
//                j.addMouseListener(new ButtonWatcher());
//                JLabel q = new JLabel();
//                q.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\mahmo\\Desktop\\Cards\\cardback.png").getImage().getScaledInstance(110, 170, Image.SCALE_DEFAULT)));
//                //q.setBounds(50, 450, 110, 170);
//                cd.backHolder = q;
//                //j.setBounds(Sx,Sy, 110, 170);
//                cd.frontHolder=j;
//                Sx+=70;
//            }
//        }      
//    }
//    
//    public void shuffleCards()
//    {
//        Random rand = new Random();
//        
//        for(int i=0;i<100;i++)
//        {
//            Cards cd;
//            int firstPlace = rand.nextInt(52);
//            int secondPlace = rand.nextInt(52);
//            //JOptionPane.showMessageDialog(null, "new card: " + card.get(firstPlace).value + "second: "+card.get(secondPlace).value);
//            cd = card.get(firstPlace);
//            card.add(card.get(secondPlace));
//            card.add(cd);
//            //JOptionPane.showMessageDialog(null, "new card: " + card.get(firstPlace).value + "second: "+card.get(secondPlace).value);
//        }
//        
//    }
//    
//    public void arrangeCards()  //add all the cards on the ground flipped upside down
//    {
//        int y = 300;
//        for(int i=0;i<52;i++)
//        {
//            card.get(i).backHolder.setBounds(90, y, 110, 170);
//            add(card.get(i).backHolder);
//            y+=10;
//            card.get(i).frontHolder.addMouseListener(new ButtonWatcher());
//        }
//    }
//    
//    public void cardsOnGround()     //puts 4 cards on the ground to start the game
//    {
//        int x =270;
//        for(int i=0;i<4;i++)
//        {
//            card.get(ArraySize).frontHolder.setBounds(x, 230, 110, 170);
//            add(card.get(ArraySize).frontHolder);
//            x+=120;
//            numOfLastPlayed = ArraySize;
//            ArraySize--;
//        }
//    }
//    
//    public void givePlayer1Cards()    //gives the players 4 cards each time the function is called
//    {
//        int x =300;
//        for(int i=0;i<4;i++)
//        {
//            card.get(ArraySize).frontHolder.setBounds(x, 660, 110, 170);
//            add(card.get(ArraySize).frontHolder);
//            x+=120;
//            ArraySize--;
//        }
//        add(gamePlayImage);
//    }
//    
//    public void givePlayer2Cards()
//    {
//        int x =300;
//        for(int i=0;i<4;i++)
//        {
//            card.get(ArraySize).frontHolder.setBounds(x, -50, 110, 170);
//            add(card.get(ArraySize).frontHolder);
//            x+=120;
//            ArraySize--;
//        }
//        add(gamePlayImage);
//    }
//    
//    public void playOnGround()
//    {
//        int xPos = card.get(numOfLastPlayed).frontHolder.getBounds().x + 120;
//        int yPos = card.get(numOfLastPlayed).frontHolder.getBounds().y;
//        if(xPos > 900)
//        {
//            yPos+=190;
//        }
//        cardInHand.frontHolder.setBounds(xPos, yPos, 110, 170);
//    }
//    
//    public void checkMove()
//    {
//        if(cardOnGround.value != cardInHand.value)
//        {
//            playOnGround();
//        }
//        else if(cardOnGround.value == cardInHand.value)
//        {
//            cardOnGround.frontHolder.setVisible(false);
//            cardInHand.frontHolder.setVisible(false);
//            
//        }
//            
//    }
//    
//    public void playTurns()
//    {
//        Users U1 = new Users();
//        Users U2 = new Users();
//        cardsOnGround();
//        for(int i=0;i<12;i++)
//        {
//            if(i%2==0)
//            {
//                if(i%4==0)
//                {
//                    givePlayer1Cards();
//                }
//                
//            }
//            else
//            {
//                if(i%4==0)
//                {
//                    givePlayer2Cards();                    
//                }
//            }
//        }
//    }
//    
//    private class ButtonWatcher implements MouseListener{
//
//        @Override
//        public void mouseClicked(MouseEvent me) {
//
//            for(int i=0;i<52;i++)
//            {
//                if(me.getSource().equals(card.get(i).frontHolder))
//                {
//                    card.get(i).frontHolder.setBorder(BorderFactory.createLineBorder(Color.RED));
//                    
//                    if(card.get(i).frontHolder.getBounds().y < 50)
//                        cardInHand = card.get(i);
//                    else if(card.get(i).frontHolder.getBounds().y > 550)
//                        cardInHand = card.get(i);
//                    else
//                        cardOnGround = card.get(i);
//                }
//            }
//            
//        }
//
//        @Override
//        public void mousePressed(MouseEvent me) {
//            
//            
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent me) {
//            
//            
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent me) {//////////////eeeeeeeeeee
//            
//            for(int i=0;i<52;i++)
//            {
//                if(me.getSource().equals(card.get(i).frontHolder) && card.get(i).frontHolder.getBounds().y > 600)
//                {
//                    card.get(i).frontHolder.setBounds(card.get(i).frontHolder.getBounds().x, card.get(i).frontHolder.getBounds().y - 30, 110, 170);
//                }
//                else if(me.getSource().equals(card.get(i).frontHolder) && card.get(i).frontHolder.getBounds().y < 50)
//                {
//                    card.get(i).frontHolder.setBounds(card.get(i).frontHolder.getBounds().x, card.get(i).frontHolder.getBounds().y + 30, 110, 170);                    
//                }
//            }
//        }
//
//        @Override
//        public void mouseExited(MouseEvent me) {
//
//            for(int i=0;i<52;i++)
//            {
//                if(me.getSource().equals(card.get(i).frontHolder) && card.get(i).frontHolder.getBounds().y > 550)
//                {
//                    card.get(i).frontHolder.setBounds(card.get(i).frontHolder.getBounds().x, card.get(i).frontHolder.getBounds().y + 30, 110, 170);
//                }
//                else if(me.getSource().equals(card.get(i).frontHolder) && card.get(i).frontHolder.getBounds().y < 50)
//                {
//                    card.get(i).frontHolder.setBounds(card.get(i).frontHolder.getBounds().x, card.get(i).frontHolder.getBounds().y - 30, 110, 170);                    
//                }
//            }
//        }
//            
//    }
//    
//}
