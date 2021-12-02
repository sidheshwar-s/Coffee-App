/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.homePage.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import starbucks.homePage.models.CoffeeModel;
import starbucks.productScreen.ProductScreen;


public class coffeeItem extends JPanel{
    
    JLabel coffeeImage;
    JLabel coffeeName;
    JLabel coffeeDesc;
    JPanel coffeDetails;
    JLabel coffeePrice;
    JButton addToCart = new JButton("+");
    
    public coffeeItem(JFrame homePage,CoffeeModel coffee) {
       setBackground(new Color(0xff252A34));
       setLayout(new BorderLayout());
      
       coffeeImage = new JLabel();
       coffeeName = new JLabel(coffee.coffeeName);
       coffeeName.setForeground(Color.white);
       coffeeName.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 18));
       coffeeDesc = new JLabel(coffee.description);
       coffeeDesc.setForeground(Color.white);
       coffeeDesc.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 15));
       coffeePrice = new JLabel("<html>₹ "+coffee.price+"</html>");
       coffeePrice.setForeground(Color.white);
       coffeePrice.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 20));
       coffeeImage.setIcon(new ImageIcon(new ImageIcon(coffee.imageUrl).getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT)));
       coffeeImage.setVisible(true);
       coffeDetails = new JPanel();
       coffeDetails.setSize(30,20);
       coffeDetails.setBackground(new Color(0xff252A34));
       coffeDetails.setLayout(new GridLayout(4,1));
        Border boxborder = coffeeImage.getBorder();
        Border boxMargin = new EmptyBorder(10,10,10,10);
        coffeeImage.setBorder(new CompoundBorder(boxborder, boxMargin));
        Border detailsborder = coffeDetails.getBorder();
        Border detailsMargin = new EmptyBorder(10,10,10,10);
        addToCart.setBackground(new Color(0xffD27842));
        addToCart.setSize(30,30);
        addToCart.setOpaque(true);
        addToCart.setFont(new Font("Arial",Font.PLAIN,23));
        addToCart.setFocusPainted(false);
        addToCart.addActionListener(new ActionListener (){
           @Override
           public void actionPerformed(ActionEvent e) {
               homePage.dispose();
               ProductScreen productscreeen = new ProductScreen(coffee);
           }
            
        });
        
        coffeDetails.setBorder(new CompoundBorder(detailsborder, detailsMargin));
        coffeDetails.add(coffeeDesc);
        coffeDetails.add(coffeePrice);
        coffeDetails.add(addToCart);
        Border titleborder = coffeeImage.getBorder();
        Border titleMargin = new EmptyBorder(20,0,0,0);
        coffeeName.setBorder(new CompoundBorder(titleborder, titleMargin));
        add(coffeeName,BorderLayout.NORTH);
        add(coffeeImage,BorderLayout.WEST);
        add(coffeDetails,BorderLayout.CENTER);

       setVisible(true);

    }   
}
