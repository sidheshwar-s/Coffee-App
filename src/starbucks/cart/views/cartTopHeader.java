/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.cart.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author arun
 */
public class cartTopHeader extends JPanel{
    
    final JLabel title = new JLabel("Your cart");
    public cartTopHeader() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(0xff0C1015));
        title.setForeground(Color.white);
        Border titleBorder = title.getBorder();
        Border titleMargin = new EmptyBorder(20,20,20,20);
        title.setBorder(new CompoundBorder(titleBorder,titleMargin));
        title.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 25));
        title.setIcon(new ImageIcon(new ImageIcon("src/starbucks/trolley.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        title.setIconTextGap(20);
        add(title);
        
    }
}
