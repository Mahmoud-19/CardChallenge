/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.challenge;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author mahmo
 */
public class CardsChallenge {

    /**
     * @param args the command line arguments
     */
    
   
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //In this game the player has to choose 2 cards and if they are of the same number the player gets a point
        //and he plays another turn, and if the are different the turn goes to the other player.
    
        //There are 2 moods in this game single and multiplayer moods.
        
        Menus m = new Menus();
        m.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        m.setUndecorated(true);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
