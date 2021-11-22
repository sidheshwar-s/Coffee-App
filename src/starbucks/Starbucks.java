
package starbucks;

import starbucks.LOGINPAGE.LoginPage;
import starbucks.SIGNUP.SIGNUP;
import starbucks.cart.CartScreen;
import starbucks.database.Database;
import starbucks.homePage.HomePage;


public class Starbucks {

    public static Database db = new Database();
    
    public static void main(String[] args) {
//          CartScreen cart = new CartScreen();
          LoginPage login = new LoginPage();
//            SIGNUP signup = new SIGNUP();
//                HomePage home = new HomePage();
            
    }
    
}
