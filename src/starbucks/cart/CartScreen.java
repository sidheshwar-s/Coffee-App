/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.cart;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import starbucks.cart.views.cartGrid;
import starbucks.cart.views.cartTopHeader;
import starbucks.cart.views.cartTotal;

/**
 *
 * @author sidhesh
 */
public class CartScreen extends JFrame{
    
    JPanel screen = new JPanel();
    public CartScreen() {
        setTitle("Your Cart");
        setIconImage(new ImageIcon("src/starbucks/cup.png").getImage());
        getContentPane().setBackground(new Color(0xff0C1015));
//        setLayout(new BorderLayout());
        screen.setLayout(new BorderLayout());
        screen.setBackground(new Color(0xff0C1015));
        Border screenBorder = screen.getBorder();
        Border screenMargin = new EmptyBorder(20,20,20,20);
        screen.setBorder(new CompoundBorder(screenBorder,screenMargin));
        screen.add(new cartTopHeader(),BorderLayout.NORTH);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        screen.add(new cartGrid(),BorderLayout.WEST);
        screen.add(new cartTotal(),BorderLayout.CENTER);
        screen.setVisible(true);
        add(new JScrollPane(screen));
        setVisible(true);
    }
}
