/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.productScreen.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import starbucks.homePage.HomePage;
import starbucks.homePage.models.CoffeeModel;

/**
 *
 * @author sidhesh
 */
public class productTopHeader extends JPanel{
    public productTopHeader(CoffeeModel coffee) {
        setSize(200,200);
        setLayout(new BorderLayout());
        setBackground(new Color(0xff0C1015));
        JLabel coffeeImage = new JLabel();
        JLabel coffeeName = new JLabel(coffee.coffeeName);
        JLabel coffeeDesc = new JLabel(coffee.productDescription);
        JPanel details = new JPanel();
        details.setLayout(new GridLayout(3,1));
        coffeeDesc.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 20));
        coffeeDesc.setForeground(Color.WHITE);
        coffeeName.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 40));
        coffeeName.setForeground(Color.white);
        Border nameBorder = coffeeName.getBorder();
        Border nameMargin = new EmptyBorder(20,20,10,10);
        coffeeName.setBorder(new CompoundBorder(nameBorder,nameMargin));
        coffeeImage.setIcon(new ImageIcon(new ImageIcon(coffee.imageUrl).getImage().getScaledInstance(350,350, Image.SCALE_DEFAULT)));
        coffeeImage.setVisible(true);
        Border boxborder = coffeeImage.getBorder();
        Border boxMargin = new EmptyBorder(20,20,20,20);
        coffeeImage.setBorder(new CompoundBorder(boxborder, boxMargin));
        JLabel nutrition = new JLabel("Nutrition Details");
        nutrition.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 28));
        nutrition.setForeground(Color.WHITE);
        details.add(coffeeDesc);
        details.setBackground(new Color(0xff0C1015));
        details.setVisible(true);
        details.add(nutritionLabel("<html>Calories - "+coffee.nutritionValues.get("calories")+"<br/>"+
                "Total Fat - "+coffee.nutritionValues.get("fat")+"<br/>"+
                "Cholesterol - "+coffee.nutritionValues.get("cholesterol")+"<br/>"+
                "Sodium - "+coffee.nutritionValues.get("sodium")+"<br/>"+
                "Protein - "+coffee.nutritionValues.get("protein")+"<br/>"+
                "Caffeine - "+coffee.nutritionValues.get("caffeine")+"<br/>"+
                "<br/><html/>"));
     
      JPanel bottomRow = new JPanel();
        setBackground(new Color(0xff0C1015));
        bottomRow.setBackground(new Color(0xff0C1015));
        bottomRow.setLayout(new FlowLayout());
        
        
        // back button
        Border backButtonBorder = new EmptyBorder(10,20,10,20);
        Border backButtonMargin = new EmptyBorder(10,40,10,40);
        
        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 18));
        backButton.setForeground(Color.white);
        backButton.setVisible(true);
        backButton.setBackground(new Color(0xff252A34));
        backButton.setBounds(50,80,190,30);
        backButton.setBorder(new CompoundBorder(backButtonBorder,backButtonMargin));
         backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                HomePage homepage = new HomePage();
                }
        }
       );
        
        JButton small = new JButton("Small");
        small.setFocusPainted(false);
        small.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 18));
        small.setForeground(Color.white);
        small.setVisible(true);
        small.setBackground(new Color(0xff252A34));
        Border smallBorder = new EmptyBorder(10,20,10,20);
        Border smallMargin = new EmptyBorder(10,40,10,40);
        small.setBorder(new CompoundBorder(smallBorder,smallMargin));
        
        JButton medium = new JButton("Medium");
        medium.setFocusPainted(false);
        medium.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 18));
        medium.setForeground(Color.white);
        medium.setVisible(true);
        medium.setBackground(new Color(0xff252A34));
        medium.setBorder(new CompoundBorder(smallBorder,smallMargin));
        
        JButton large = new JButton("Large");
        large.setFocusPainted(false);
        large.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 18));
        large.setForeground(Color.white);
        large.setVisible(true);
        large.setBackground(new Color(0xff252A34));
        large.setBorder(new CompoundBorder(smallBorder,smallMargin));
        
        JLabel space = new JLabel("              ");
        
        JButton order = new JButton("Place Order");
        order.setFocusPainted(false);
        order.setFont(new Font("Arial Black", Font.PLAIN, 18));
        order.setForeground(Color.white);
        order.setVisible(true);
        order.setBackground(new Color(0xff6ECEA6));
        order.setBorder(new CompoundBorder(smallBorder,smallMargin));
        
        bottomRow.add(small);
        bottomRow.add(space);
        bottomRow.add(medium);
        bottomRow.add(space);
        bottomRow.add(large);
        for(int i=0;i<15;i++) {
            bottomRow.add(space);
        }
        bottomRow.add(order);
        bottomRow.setVisible(true);
        
        
        add(bottomRow,BorderLayout.SOUTH);
        add(coffeeName,BorderLayout.NORTH);
        add(coffeeImage,BorderLayout.WEST);
        add(backButton);
        add(details,BorderLayout.CENTER);
        
    }
    
    private JLabel nutritionLabel(String text) {
        JLabel label = new JLabel(text);
        Border labelborder = label.getBorder();
        Border labelMargin = new EmptyBorder(10,0,0,0);
        label.setBorder(new CompoundBorder(labelborder,labelMargin));
        label.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 16));
        label.setForeground(Color.white);
        return label;
    }
}
