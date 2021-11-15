/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.cart.views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author sidhesh
 */
public class cartGrid extends JPanel{
    public cartGrid() {
        for(int i =0;i<10;i++) {
            add(new cartItem());
        }
        setLayout(new GridLayout(10,1,10,10));
        setBackground(new Color(0xff0C1015));
        setVisible(true);

    }
}
