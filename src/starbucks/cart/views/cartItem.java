/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.cart.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import starbucks.homePage.models.CoffeeModel;

/**
 *
 * @author sidhesh
 */
public class cartItem extends JPanel{
     JLabel coffeeImage;
    JLabel coffeeName;
    JLabel coffeeDesc;
    JPanel coffeDetails;
    JLabel coffeePrice;
    JLabel coffeeMoreInfo;
    CoffeeModel coffee = new CoffeeModel(
                    "src/starbucks/cappuccino.jpg",
                    120,"Cappuccino",
                    "Dark, rich espresso",
            "<html>Dark, rich espresso lies in wait under a smoothed and stretched layer of <br/>thick milk foam. An alchemy of barista artistry and craft.<html/>",
            Map.of("calories", "140","fat","5g","cholesterol","20mg","sodium","120mg","protein","9g","caffeine","150mg")
            );;
    
    JButton increaseQuantity = new JButton("+");
    JButton decreaseQuantity = new JButton("-");
    JLabel count;
    
    public cartItem() {
        setBackground(new Color(0xff252A34));
       setLayout(new BorderLayout());
       Border panelBorder = getBorder();
       Border panelMargin = new EmptyBorder(0,60,0,60);
       setBorder(new CompoundBorder(panelBorder,panelMargin));
       coffeeImage = new JLabel();
       coffeeName = new JLabel(coffee.coffeeName);
       coffeeName.setForeground(Color.white);
       coffeeName.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 18));
       coffeeDesc = new JLabel(coffee.description);
       coffeeDesc.setForeground(Color.white);
       coffeeDesc.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 15));
       coffeePrice = new JLabel("<html> Sub Total: ₹ "+coffee.price+"</html>");
       coffeePrice.setForeground(Color.white);
       coffeePrice.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 20));
       coffeeImage.setIcon(new ImageIcon(new ImageIcon(coffee.imageUrl).getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT)));
       coffeeImage.setVisible(true);
       coffeeMoreInfo = new JLabel(coffee.productDescription);
       coffeeMoreInfo.setForeground(Color.white);
       coffeeMoreInfo.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 18));
       coffeDetails = new JPanel();
       coffeDetails.setSize(30,20);
       coffeDetails.setBackground(new Color(0xff252A34));
       coffeDetails.setLayout(new GridLayout(4,1,50,0));
        Border boxborder = coffeeImage.getBorder();
        Border boxMargin = new EmptyBorder(10,10,10,10);
        coffeeImage.setBorder(new CompoundBorder(boxborder, boxMargin));
        Border detailsborder = coffeDetails.getBorder();
        Border detailsMargin = new EmptyBorder(10,10,10,10);
        coffeDetails.setBorder(new CompoundBorder(detailsborder, detailsMargin));
        coffeDetails.add(coffeeDesc);
        coffeDetails.add(coffeeMoreInfo);
        coffeDetails.add(coffeePrice);
        Border titleborder = coffeeImage.getBorder();
        Border titleMargin = new EmptyBorder(20,0,0,0);
        coffeeName.setBorder(new CompoundBorder(titleborder, titleMargin));
        add(coffeeName,BorderLayout.NORTH);
        add(coffeeImage,BorderLayout.WEST);
        add(coffeDetails,BorderLayout.CENTER);
        RoundedPanel quantity = new RoundedPanel(10,new Color(0xff0C1015));
        quantity.setOpaque(false);
        count = new JLabel("1");
        count.setFont(new Font("Arial",Font.PLAIN,23));
        count.setForeground(Color.white);
        increaseQuantity.setSize(30,30);
        increaseQuantity.setOpaque(true);
        increaseQuantity.setFont(new Font("Arial",Font.PLAIN,23));
        increaseQuantity.setFocusPainted(false);
        increaseQuantity.setBackground(new Color(0xff0C1015));
        increaseQuantity.setBorderPainted(false);
        increaseQuantity.setForeground(Color.white);
        decreaseQuantity.setSize(30,30);
        decreaseQuantity.setOpaque(true);
        decreaseQuantity.setFont(new Font("Arial",Font.PLAIN,23));
        decreaseQuantity.setFocusPainted(false);
        decreaseQuantity.setBackground(new Color(0xff0C1015));
        decreaseQuantity.setBorderPainted(false);
        decreaseQuantity.setForeground(Color.white);
        
        quantity.add(decreaseQuantity);
        quantity.add(count);
        quantity.add(increaseQuantity);
        coffeDetails.add(quantity);
        setVisible(true);
    }
    
    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }
}
