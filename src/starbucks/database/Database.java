/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.database;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sidhesh
 */
public class Database {
    public Connection connection = null;
    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/starbucks","postgres", "Sidhesh#2002");
            System.out.println("Sucessfully connected");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
