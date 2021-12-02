
package starbucks.LOGINPAGE;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import starbucks.Globals.Globals;
import starbucks.SIGNUP.SIGNUP;
import starbucks.Starbucks;
import starbucks.database.Database;
import starbucks.homePage.HomePage;

/**
 *
 * @author abaru
 */
public class LoginPage {
    
    JFrame frame = new JFrame();
    JPanel credentialsPanel = new JPanel();
    JButton loginButton = new JButton("Login");
    JButton signUpButton = new JButton("Sign Up");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("EMAIL");
    JLabel userPasswordLabel = new JLabel("PASSWORD");
    JLabel signInfo = new JLabel("Already have an account?");
    JLabel image = new JLabel();
    JPanel imagePanel = new JPanel();
    
    
    public LoginPage(){
       
        userIDLabel.setBounds(50,100,950,100);
        userPasswordLabel.setBounds(50,250,1100,100);
        signInfo.setBounds(100, 500, 1000, 80);
        
        userIDLabel.setForeground(Color.white);
        userPasswordLabel.setForeground(Color.white);
        signInfo.setForeground(Color.white);
        userIDLabel.setFont(new Font(null,Font.PLAIN,30));
        userPasswordLabel.setFont(new Font(null,Font.PLAIN,30));
        signInfo.setFont(new Font(null,Font.ITALIC,20));
        
        userIDField.setBounds(250,140,300,25);
        userPasswordField.setBounds(250,290,300,25);
        loginButton.setBounds(400,390,100,40);
        signUpButton.setBounds(350,530,100,20);
        loginButton.addActionListener(new ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent evt) {
        Database db = Starbucks.db;
        Connection connection = db.connection;
        String email = userIDField.getText();
        String password = userPasswordField.getText();
        if(email.equals("") || password.equals(""))
        {
             JOptionPane.showMessageDialog(null, "All field are required", "Please enter all fields", JOptionPane.INFORMATION_MESSAGE);
             return;
        }
        try{
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM users WHERE email = ? and password = ? ",ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet result = stm.executeQuery();
            if(!result.first()) {
                JOptionPane.showMessageDialog(null, "Invalid email or password", "Error!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Globals.user_id  = result.getInt("id");
            frame.dispose();
            HomePage homePage = new HomePage();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Database error", "Error!", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
        }
    }  
        });
        loginButton.setFocusable(false);
        signUpButton.addActionListener(new ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.dispose();
                SIGNUP signup = new SIGNUP();
            }
        });
        signUpButton.setFocusable(false);
        
        credentialsPanel.add(userIDLabel);
        credentialsPanel.add(userPasswordLabel);
        credentialsPanel.add(signInfo);
        credentialsPanel.add(userPasswordField);
        credentialsPanel.add(userIDField);
        credentialsPanel.add(loginButton);
        credentialsPanel.add(signUpButton);
        credentialsPanel.setVisible(true);
        credentialsPanel.setBackground(Color.BLACK);
        credentialsPanel.setLayout(null);
        frame.setLayout(new GridLayout(1,2));
        frame.add(credentialsPanel);
        JLabel coffee_cup = new JLabel();
        coffee_cup.setIcon(new ImageIcon("src/starbucks/coffee-cu.jpg"));
        imagePanel.setBackground(Color.BLACK);
        coffee_cup.setVisible(true);
        imagePanel.add(coffee_cup);
        imagePanel.setVisible(true);
        frame.add(imagePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setBackground(Color.BLACK);
        
        frame.setVisible(true);
        frame.setTitle("LoginPage");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

   
                                         
    
}

   
