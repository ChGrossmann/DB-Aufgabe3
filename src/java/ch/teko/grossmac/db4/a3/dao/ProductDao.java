package ch.teko.grossmac.db4.a3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.teko.grossmac.db4.a3.beans.Product;
import java.sql.PreparedStatement;

public class ProductDao {

    public List<Product> searchBezeichnungProducts(String searchString) {

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
                product.setProductNumber(set.getString("artikelnummer"));
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
    
    public List<Product> searchArtikelNrProducts(String searchString) {

        Product product;
        
        List<Product> products = new ArrayList<>();
        
        try {
            Connection connection = DBConnection.connect();

            String sql = "SELECT * FROM artikelliste WHERE artikelnummer LIKE "
                    + "'%" +  searchString +"%'";

            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery(sql);
             

            while (set.next()) {
                product = new Product();
                product.setProductNumber(set.getString("artikelnummer"));
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
    
        public List<Product> newProductDao(String newNumber, String newName, String newValue, String newUnit, String newPrice) {

        Connection connection;
        Product product;
        List<Product> newProduct = new ArrayList<>();
        
        try {
            connection = DBConnection.connect();

            String sql = "INSERT INTO artikelliste (artikelnummer, bezeichnung, menge, einheit, preis) VALUES (?, ?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newNumber);
            statement.setString(2, newName);
            statement.setInt(3, Integer.parseInt(newValue));
            statement.setString(4, newUnit.toUpperCase());
            statement.setDouble(5, Double.parseDouble(newPrice));
            
            statement.execute();
            
            statement.close(); 
            
            
            String sqlSelect = "SELECT * FROM artikelliste WHERE bezeichnung LIKE "
                  + "'"  + newName + "';" ;

            Statement statementSelect = connection.createStatement();

            ResultSet setSelect = statementSelect.executeQuery(sqlSelect);
            
            while (setSelect.next()) {
                product = new Product();
                product.setProductNumber(setSelect.getString("artikelnummer"));
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
