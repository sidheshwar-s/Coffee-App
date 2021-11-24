/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.homePage.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import starbucks.homePage.models.CoffeeModel;
import starbucks.productScreen.ProductScreen;

/**
 *
 * @author sidhesh
 */
public class items extends JPanel{
    
    private final coffeeItem cappuccino ;
    private final coffeeItem expresso ;
    private final coffeeItem honeyAlmond;
    private final coffeeItem pumpkinSpiceLatte;
    private final coffeeItem caffeMocha ;
    private final coffeeItem hotChocolate ;
    private final coffeeItem caramelApplceSpice ;
    public static CoffeeModel cappuccinoModel  = new CoffeeModel(
                    "src/starbucks/cappuccino.jpg",
                    120,"Cappuccino",
                    "Dark, rich espresso",
            "<html>Dark, rich espresso lies in wait under a smoothed and stretched layer of <br/>thick milk foam. An alchemy of barista artistry and craft.<html/>",
            Map.of("calories", "140","fat","5g","cholesterol","20mg","sodium","120mg","protein","9g","caffeine","150mg")
            );
    public  static CoffeeModel expressoModel = new CoffeeModel("src/starbucks/expresso.jpg",
                    150,
                    "Expresso",
                    "<html>Espresso Roast <br/>with rich flavor<html/>",
            "<html>Our smooth signature Espresso Roast with rich flavor and caramelly<br/>sweetness is at the very heart of everything we do.<html/>",
            Map.of("calories", "10","fat","0g","cholesterol","0mg","sodium","0mg","protein","1g","caffeine","150mg")
            ) ;
    public  static CoffeeModel honeyAlmondModel = new CoffeeModel("src/starbucks/honey almond.jpg",
                    140,"Honey Almondmilk Flat White",
                    "<html>Blonde Espresso Roast<br/> with a hint of honey<html/>",
                    "<html>This flat white intentionally pairs almondmilk and Starbucks® Blonde Espresso Roast <br/>with a hint of honey, making a perfect amount of creamy, nutty sweetness.<html/>",
                    Map.of("calories", "120","fat","4g","cholesterol","0mg","sodium","100mg","protein","2g","caffeine","150mg"));
    public  static CoffeeModel pumpkinSpiceLatteModel  = new CoffeeModel("src/starbucks/pumpkinSpiceLatte.jpg",
                    180,"Pumpkin Spice Latte",
                    "<html>Pumpkin spice topped<br/>with whipped cream",
                    "<html>Our signature espresso and steamed milk with the celebrated flavor combination<br/> of pumpkin, cinnamon, nutmeg and clove. Enjoy it topped with whipped cream <br/>and real pumpkin-pie spices.<html/>",
                    Map.of("calories", "390","fat","14g","cholesterol","50mg","sodium","230mg","protein","14g","caffeine","150mg")
                    );
    public  static CoffeeModel caffeMochaModel = new CoffeeModel("src/starbucks/caffeMocha.jpg",
                    100,"Caffe Mocha",
                    "<html>Expresso combined with<br/>bittersweat mocha sauce<html/>",
                    "<html>Our rich, full-bodied espresso combined with bittersweet mocha sauce and <br/>steamed milk, then topped with sweetened whipped cream. <br/>The classic coffee drink that always sweetly satisfies.<html/>",
                    Map.of("calories", "370","fat","15g","cholesterol","45mg","sodium","150mg","protein","14g","caffeine","175mg")
                    ) ;
    public  static CoffeeModel hotChocolateModel =  new CoffeeModel("src/starbucks/hotChocolate.jpg",
                    200,"Hot Chocolate Drink",
                    "<html>Steamed milk topped<br/>with chocolate-flavoured drizzle<html/>",
                    "<html>Steamed milk and mocha sauce topped with sweetened whipped cream and <br/>a chocolate-flavored drizzle. A timeless classic made to sweeten your spirits..<html/>",
                    Map.of("calories", "370","fat","16g","cholesterol","50mg","sodium","150mg","protein","14g","caffeine","250mg")
                    );
    public  static CoffeeModel caramelApplceSpiceModel = new CoffeeModel("src/starbucks/caramelAppleSpice.jpg",
                    170,
                    "Caramle Apple Spice",
                    "<html>Steamed apple juice complemented <br/>with cinnamon syrup<html/>",
                    "<html>Steamed apple juice complemented with cinnamon syrup, whipped cream and <br/>a caramel sauce drizzle.<html?",
                    Map.of("calories", "380","fat","8g","cholesterol","25mg","sodium","35mg","protein","1g","caffeine","0mg")
                    );

   
  
    public items(JFrame homePage) {
        cappuccino = new coffeeItem(
            homePage,cappuccinoModel
            );
        expresso = new coffeeItem(
            homePage, expressoModel
            );
        honeyAlmond = new coffeeItem(
                homePage,honeyAlmondModel
            );
        pumpkinSpiceLatte = new coffeeItem(
                homePage,pumpkinSpiceLatteModel
            );
        caffeMocha = new coffeeItem(
                homePage,caffeMochaModel
            );
        hotChocolate = new coffeeItem(
                homePage,hotChocolateModel
           );
        caramelApplceSpice = new coffeeItem(
                homePage,caramelApplceSpiceModel
            );
        
        Border boxborder = getBorder();
        Border boxMargin = new EmptyBorder(20,20,20,20);
        setBorder(new CompoundBorder(boxborder, boxMargin));
        setBackground(new Color(0xff0C1015));
        
        cappuccino.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            homePage.dispose();
            JFrame productScreen = new ProductScreen(cappuccinoModel);
        }
    });
        
         expresso.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            homePage.dispose();
            JFrame productScreen = new ProductScreen(expressoModel);
        }
    });
         
           honeyAlmond.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            homePage.dispose();
            JFrame productScreen = new ProductScreen(honeyAlmondModel);
        }
    });
           
               pumpkinSpiceLatte.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            homePage.dispose();
            JFrame productScreen = new ProductScreen(pumpkinSpiceLatteModel);
        }
    });
               
         caffeMocha.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            homePage.dispose();
            JFrame productScreen = new ProductScreen(caffeMochaModel);
        }
    });
         
            hotChocolate.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            homePage.dispose();
            JFrame productScreen = new ProductScreen(hotChocolateModel);
        }
    });
            
            caramelApplceSpice.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            homePage.dispose();
            JFrame productScreen = new ProductScreen(caramelApplceSpiceModel);
        }
    });
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
