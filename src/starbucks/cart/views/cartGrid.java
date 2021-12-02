/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.cart.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import javax.swing.JPanel;
import starbucks.Starbucks;
import starbucks.database.Database;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import starbucks.Globals.Globals;
import starbucks.homePage.models.CoffeeModel;
import starbucks.cart.views.CoffeeItem;

/**
 *
 * @author arun
 */
public class cartGrid extends JPanel{
    
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

    public CoffeeModel getCoffee(String coffeeName) {
        if(null == coffeeName) {
            return caramelApplceSpiceModel;
        } else return switch (coffeeName) {
            case "Cappuccino" -> cappuccinoModel;
            case "Expresso" -> expressoModel;
            case "Honey Almondmilk Flat White" -> honeyAlmondModel;
            case "Pumpkin Spice Latte" -> pumpkinSpiceLatteModel;
            case "Caffe Mocha" -> caffeMochaModel;
            case "Hot Chocolate Drink" -> hotChocolateModel;
            default -> caramelApplceSpiceModel;
        };
    }
    
    public cartGrid() {
        try {
            Globals.total_price = 0;
            Database db = Starbucks.db;
            Connection con = db.connection;
            PreparedStatement query = con.prepareStatement("SELECT * from cart WHERE user_id = ?");
            query.setInt(1,Globals.user_id);
            ResultSet result = query.executeQuery();
            while(result.next()) {
                String coffeeName = result.getString("product_name");
                int quantity = result.getInt("quantity");
                CoffeeModel coffee = getCoffee(coffeeName);
                add(new CoffeeItem(coffee));
                Globals.total_price += (coffee.price*quantity);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
       
        setLayout(new GridLayout(10,1,10,10));
        setBackground(new Color(0xff0C1015));
        setVisible(true);

    }

   
}
