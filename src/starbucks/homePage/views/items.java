/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.homePage.views;

import java.awt.Color;
import java.awt.GridLayout;
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
public class items extends JPanel{
    
    private final coffeeItem cappuccino = new coffeeItem(new CoffeeModel("src/starbucks/cappuccino.jpg",120,"Cappuccino","Dark, rich espresso"));
    private final coffeeItem expresso = new coffeeItem(new CoffeeModel("src/starbucks/expresso.jpg",150,"Expresso","<html>Espresso Roast <br/>with rich flavor<html/>"));
    private final coffeeItem honeyAlmond = new coffeeItem(new CoffeeModel("src/starbucks/honey almond.jpg",140,"<html>Honey Almondmilk Flat White<html/>","<html>Blonde Espresso Roast<br/> with a hint of honey<html/>"));
    private final coffeeItem pumpkinSpiceLatte = new coffeeItem(new CoffeeModel("src/starbucks/pumpkinSpiceLatte.jpg",180,"<html>Pumpkin Spice Latte<html/>","<html>Pumpkin spice topped<br/>with whipped cream"));
    private final coffeeItem caffeMocha = new coffeeItem(new CoffeeModel("src/starbucks/caffeMocha.jpg",100,"<html>Caffe Mocha<html/>","<html>Expresso combined with<br/>bittersweat mocha sauce<html/>"));
    private final coffeeItem hotChocolate = new coffeeItem(new CoffeeModel("src/starbucks/hotChocolate.jpg",200,"<html>Hot Chocolate Drink<html/>","<html>Steamed milk topped<br/>with chocolate-flavoured drizzle<html/>"));
    private final coffeeItem caramelApplceSpice = new coffeeItem(new CoffeeModel("src/starbucks/caramelAppleSpice.jpg",170,"<html>Caramle Apple Spice<html/>","<html>Steamed apple juice complemented <br/>with cinnamon syrup<html/>"));

   
  
    public items() {
        Border boxborder = getBorder();
        Border boxMargin = new EmptyBorder(20,20,20,20);
        setBorder(new CompoundBorder(boxborder, boxMargin));
        setBackground(new Color(0xff0C1015));
        
        add(cappuccino);
        add(expresso);
        add(honeyAlmond);
        add(pumpkinSpiceLatte);
        add(caffeMocha);
        add(hotChocolate);
        add(caramelApplceSpice);
                    
        setLayout(new GridLayout(2,4,10,10));
        setVisible(true);
    }
}
