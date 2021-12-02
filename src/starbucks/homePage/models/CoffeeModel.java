/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks.homePage.models;

import java.util.Map;

/**
 *
 * @author arun
 */
public class CoffeeModel {
    public  final String imageUrl;
    public final int price;
    public final String coffeeName;
    public final String description;
    public final String size = "S";
    public final String productDescription;
    public final Map<String,String> nutritionValues;
    
  
    public CoffeeModel(String imageUrl, int price, String coffeeName, String description, String productDescription, Map<String,String> nutritionValue) {
        this.imageUrl = imageUrl;
        this.price = price;
        this.coffeeName = coffeeName;
        this.description = description;
        this.productDescription = productDescription;
        this.nutritionValues = nutritionValue;
    }
}
