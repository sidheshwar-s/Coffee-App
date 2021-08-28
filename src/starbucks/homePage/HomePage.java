/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.homePage;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import starbucks.homePage.views.items;
import starbucks.homePage.views.topHeader;


public class HomePage extends JFrame{
   
    private final JFrame homepage;
    private final topHeader topheader;
    private final items coffeeItems;
    public HomePage() {
        homepage = new JFrame();
        topheader = new topHeader();
        coffeeItems = new items();
        homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        homepage.setSize(800,650);
        homepage.setTitle("Starbucks");
        homepage.setIconImage(new ImageIcon("src/starbucks/cup.png").getImage());
        homepage.getContentPane().setBackground(new Color(0xff0C1015));
        homepage.setLayout(new BorderLayout());
        homepage.add(topheader,BorderLayout.NORTH);
        homepage.add(new JScrollPane(coffeeItems),BorderLayout.CENTER);
        homepage.setVisible(true);
        
        
    }   
}
