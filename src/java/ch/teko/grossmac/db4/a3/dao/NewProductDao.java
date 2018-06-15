package ch.teko.grossmac.db4.a3.dao;

import java.sql.Connection;
import java.util.List;

import ch.teko.grossmac.db4.a3.beans.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NewProductDao {

    public List<Product> newProductDao(String newNumber, String newName, String newValue, String newUnit, String newPrice) {

        Connection connection;
        Product product;
        List<Product> newProduct = new ArrayList<>();
        
        try {
            connection = DBConnection.connect();

            String sql = "INSERT INTO artikelliste (artikelnummer, bezeichnung, menge, einheit, preis) VALUES (?, ?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(newNumber));
            statement.setString(2, newName);
            statement.setInt(3, Integer.parseInt(newValue));
            statement.setString(4, newUnit.toUpperCase());
            statement.setFloat(5, Float.parseFloat(newPrice));
            
            statement.execute();
            
            statement.close(); 
            
            
            String sqlSelect = "SELECT * FROM artikelliste WHERE bezeichnung LIKE "
                  + "'"  + newName + "';" ;

            Statement statementSelect = connection.createStatement();

            ResultSet setSelect = statementSelect.executeQuery(sqlSelect);
            
            while (setSelect.next()) {
                product = new Product();
                product.setProductNumber(setSelect.getInt("artikelnummer"));
                product.setProductName(setSelect.getString("bezeichnung"));
                product.setProductValue(setSelect.getInt("menge"));
                product.setProductUnit(setSelect.getString("einheit"));
                product.setProductPrice(setSelect.getFloat("preis"));

                newProduct.add(product);
            }
            
           
         setSelect.close();
         statementSelect.close();
         
         connection.close();
         

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return newProduct;

    }
}

    


