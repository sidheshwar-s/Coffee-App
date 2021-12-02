
package starbucks.cart;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import starbucks.cart.views.cartGrid;
import starbucks.cart.views.cartTopHeader;
import starbucks.cart.views.cartTotal;
import starbucks.homePage.HomePage;


public class CartScreen extends JFrame{
    
    JPanel screen = new JPanel();
    public CartScreen() {
        setTitle("Your Cart");
        JPanel backButtonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Lucida Sans Regular", Font.PLAIN, 18));
        backButton.setForeground(Color.white);
        backButton.setVisible(true);
        backButton.setBackground(new Color(0xff252A34));
         backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HomePage homepage = new HomePage();
                }
        }
       );
        setIconImage(new ImageIcon("src/starbucks/cup.png").getImage());
        getContentPane().setBackground(new Color(0xff0C1015));
        setLayout(new BorderLayout());
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
        backButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(backButton);
        backButtonPanel.setBackground(new Color(0xff0C1015));
        add(backButtonPanel,BorderLayout.NORTH);
        setVisible(true);
    }
}
