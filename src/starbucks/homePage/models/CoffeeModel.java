/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.homePage.models;

/**
 *
 * @author sidhesh
 */
public class CoffeeModel {
    public  final String imageUrl;
    public final int price;
    public final String coffeeName;
    public final String description;
    
  
    public CoffeeModel(String imageUrl, int price, String coffeeName, String description) {
        this.imageUrl = imageUrl;
        this.price = price;
        this.coffeeName = coffeeName;
        this.description = description;
    }
}
