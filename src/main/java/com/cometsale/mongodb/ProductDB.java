package com.cometsale.mongodb;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

import org.bson.Document;

import com.cometsale.model.ProductDetails;
import com.cometsale.model.UserDetails;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class ProductDB extends GenericClassDB {

    public static void push(ProductDetails inputProduct) {
        GenericClassDB.push(inputProduct);
    }


    public static ArrayList<ProductDetails> find(String searchString, String searchAttribute) {
        return (ArrayList<ProductDetails>) GenericClassDB.find(ProductDetails.class,searchString,searchAttribute);
    }
    
    public static ArrayList<ProductDetails> search(String query) {
    	
   	    
	    MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<ProductDetails> collection = database.getCollection("ProductDetails",ProductDetails.class);
    	
        ArrayList<ProductDetails> output = collection.find(Filters.text(query))
        									.projection(Projections.metaTextScore("score"))
        									.sort(Sorts.metaTextScore("score")).into(new ArrayList());
        
        closeConnection(mongoClient);
        return output;
    
    }
    
    public static ArrayList<ProductDetails> fetchAll() {
    	return fetchAll(25);
    }
    
    public static ArrayList<ProductDetails> fetchAll(int limit) {
    	
   	    
	    MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<ProductDetails> collection = database.getCollection("ProductDetails",ProductDetails.class);
    	
        ArrayList<ProductDetails> output =  collection.find().limit(limit).into(new ArrayList());
        
        closeConnection(mongoClient);
        return output;
    
    }

    
    public static void update(String searchString, String searchAttribute,String updateString,String updateAttribute) {
        GenericClassDB.update(ProductDetails.class,searchString,searchAttribute,updateString,updateAttribute);
    }
    
    public static void uniqueConstraint() {
    	MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //push the object

        MongoCollection<ProductDetails> collection = database.getCollection("ProductDetails",ProductDetails.class);
    	
    	collection.createIndex(Indexes.ascending("productID"));
    	collection.createIndex(Indexes.text("productDesc"));
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
