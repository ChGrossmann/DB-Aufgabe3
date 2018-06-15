package ch.teko.grossmac.db4.a3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.teko.grossmac.db4.a3.beans.Product;

public class SearchProductDao {

    public List<Product> searchProducts(String searchString) {

        Product product;
        
        List<Product> products = new ArrayList<>();
        
        try {
            Connection connection = DBConnection.connect();

            String sql = "SELECT * FROM artikelliste WHERE bezeichnung LIKE "
                    + "'%" + searchString + "%'";

            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery(sql);
             

            while (set.next()) {
                product = new Product();
                product.setProductNumber(set.getInt("artikelnummer"));
                product.setProductName(set.getString("bezeichnung"));
                product.setProductValue(set.getInt("menge"));
                product.setProductUnit(set.getString("einheit"));
                product.setProductPrice(set.getDouble("preis"));

                products.add(product);
                
              
            }
            
            set.close();
            statement.close();
            connection.close();
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return products;
        
    }

}
