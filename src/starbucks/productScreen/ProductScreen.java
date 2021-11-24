/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.productScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import starbucks.homePage.models.CoffeeModel;
import starbucks.productScreen.views.productTopHeader;

/**
 *
 * @author sidhesh
 */
public class ProductScreen extends JFrame{
    
    private CoffeeModel coffee;
    public ProductScreen(CoffeeModel coffee) {
        
        this.coffee = coffee;
        setSize(800,650);
        setTitle("Starbucks");
        setIconImage(new ImageIcon("src/starbucks/cup.png").getImage());
        getContentPane().setBackground(new Color(0xff0C1015));
        setLayout(new BorderLayout());
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        add(new productTopHeader(coffee,this),BorderLayout.NORTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setVisible(true);
       
    }

}
