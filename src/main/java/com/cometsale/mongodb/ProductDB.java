package com.cometsale.mongodb;

import java.util.ArrayList;
import com.cometsale.model.ProductDetails;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;

public class ProductDB extends GenericClassDB {

    public static void push(ProductDetails inputProduct) {
        GenericClassDB.push(inputProduct);
    }


    public static ArrayList<ProductDetails> find(String searchString, String searchAttribute) {
        return (ArrayList<ProductDetails>) GenericClassDB.find(ProductDetails.class,searchString,searchAttribute);
    }
    
//    public static ArrayList<ProductDetails> find(String searchString, String searchAttribute) {
//        return (ArrayList<ProductDetails>) GenericClassDB.find(ProductDetails.class,searchString,searchAttribute);
//    }
//    
    
    
    public static void update(String searchString, String searchAttribute,String updateString,String updateAttribute) {
        GenericClassDB.update(ProductDetails.class,searchString,searchAttribute,updateString,updateAttribute);
    }
    
    public static void uniqueConstraint() {
    	MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //push the object

        MongoCollection<ProductDetails> collection = database.getCollection("ProductDetails",ProductDetails.class);
    	
    	collection.createIndex(Indexes.ascending("productID"));
    	  //close the connection.
        closeConnection(mongoClient);
    }
    
    public static boolean productIDinDB(String inputID) {
    	ArrayList<ProductDetails> result=find(inputID, "productID");
    	if(result.isEmpty()) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
}
