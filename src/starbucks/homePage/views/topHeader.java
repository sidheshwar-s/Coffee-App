/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.homePage.views;

import ACCOUNT.Account;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import starbucks.LOGINPAGE.LoginPage;
import starbucks.cart.CartScreen;

/**
 *
 * @author arun
 */
public class topHeader extends JPanel {
    
    private final JLabel topLabel;
    JPanel log = new JPanel();
    private final JLabel cart;
    JButton account = new JButton("Account");
    JButton logout = new JButton("Logout");    
    public topHeader(JFrame homePage) {
        setLayout(new BorderLayout());
        setBackground(new Color(0xff0C1015));
        topLabel = new JLabel("Find the best Coffee for you");
        topLabel.setForeground(Color.WHITE);
        topLabel.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 25));
        
        logout.setVisible(true);
        logout.setBackground(new Color(0xffD27842));
        logout.setOpaque(true);
        logout.setFocusable(false);
        logout.setFont(new Font("Arial",Font.PLAIN,23));
        logout.setFocusPainted(false);
        logout.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage.dispose();
                LoginPage loginpage = new LoginPage();
            }
            
            
        });
        account.setBackground(new Color(0xffD27842));
        account.setOpaque(true);
        account.setFocusable(false);
        account.setFont(new Font("Arial",Font.PLAIN,23));
        account.setFocusPainted(false);
        account.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage.dispose();
                Account account = new Account();
            }
        });
        
        Border Labelborder = topLabel.getBorder();
        Border Labelmargin = new EmptyBorder(20,20,20,20);
        topLabel.setBorder(new CompoundBorder(Labelborder, Labelmargin));
        add(topLabel,BorderLayout.WEST);
        cart = new JLabel(" Your Orders");
        Border Cartborder = cart.getBorder();
        Border Cartmargin = new EmptyBorder(20,20,20,20);
        cart.setBorder(new CompoundBorder(Cartborder, Cartmargin));
        cart.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 14));
        cart.setForeground(Color.WHITE);
        cart.setIcon(new ImageIcon(new ImageIcon("src/starbucks/trolley.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        cart.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            homePage.dispose();
            CartScreen cart = new CartScreen();
        }
    });
        add(cart,BorderLayout.EAST);
        log.add(account,BorderLayout.EAST);
        log.add(logout,BorderLayout.WEST);
        log.setBackground(Color.black);
        add(log);
        
    }
    
}
