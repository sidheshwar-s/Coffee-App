/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.cart.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import payment.mode;
import starbucks.Globals.Globals;

/**
 *
 * @author arun
 */
public class cartTotal extends JPanel{
    public static JLabel totalPrice;
    public cartTotal() {
        Border border = this.getBorder();
        Border margin = new EmptyBorder(20,20,20,20);
        this.setBorder(new CompoundBorder(border,margin));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(new Color(0xff0C1015));
        totalPrice = new JLabel("<html> Total = ₹ "+Globals.total_price+"<html/>",SwingConstants.LEFT);
        totalPrice.setFont(new Font("Arial",Font.PLAIN,23));
        totalPrice.setForeground(Color.WHITE);
        JButton order = new JButton("Place Order");
        order.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mode m = new mode();
            }
            
        });
        order.setFocusPainted(false);
        order.setFont(new Font("Arial Black", Font.PLAIN, 18));
        order.setForeground(Color.white);
        order.setVisible(true);
        order.setBackground(new Color(0xff6ECEA6));
        Border smallBorder = new EmptyBorder(10,20,10,20);
        Border smallMargin = new EmptyBorder(10,40,10,40);
        order.setBorder(new CompoundBorder(smallBorder,smallMargin));
        totalPrice.setBorder(new CompoundBorder(smallBorder,smallMargin));
        add(totalPrice);
        add(order);
        setVisible(true);
        
    }
}
