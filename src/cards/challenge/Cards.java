/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.challenge;

import javax.swing.JLabel;

/**
 *
 * @author mahmo
 */
public class Cards {
    
    public static enum ShapeTypes{Speed,Diamond,Clubs,RedHeart};
    public ShapeTypes type;
    public int value;
    public String imageName;
    public boolean chosen;
    public JLabel frontHolder;
    public JLabel backHolder;
    
}
