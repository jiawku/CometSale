package com.cometsale.mongodb;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

import org.bson.Document;

import com.cometsale.model.Product;
import com.cometsale.model.Student;
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

    public static void push(Product inputProduct) {
        GenericClassDB.push(inputProduct);
    }


    public static ArrayList<Product> find(String searchString, String searchAttribute) {
        return (ArrayList<Product>) GenericClassDB.find(Product.class,searchString,searchAttribute);
    }
    
    public static ArrayList<Product> search(String query) {
    	
   	    
	    MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
    	
        ArrayList<Product> output = collection.find(Filters.text(query))
        									.projection(Projections.metaTextScore("score"))
        									.sort(Sorts.metaTextScore("score")).into(new ArrayList());
        
        closeConnection(mongoClient);
        return output;
    
    }
    
    public static ArrayList<Product> fetchAll() {
    	return fetchAll(25);
    }
    
    public static ArrayList<Product> fetchAll(int limit) {
    	
   	    
	    MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
    	
        ArrayList<Product> output =  collection.find().limit(limit).into(new ArrayList());
        int size = output.size();
        
        closeConnection(mongoClient);
        return output;
    
    }

    
    public static void update(String searchString, String searchAttribute,String updateString,String updateAttribute) {
        GenericClassDB.update(Product.class,searchString,searchAttribute,updateString,updateAttribute);
    }
    
    public static void uniqueConstraint() {
    	MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //push the object

        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
    	
    	collection.createIndex(Indexes.ascending("productID"));
    	collection.createIndex(Indexes.text("productDesc"));
    	  //close the connection.
        closeConnection(mongoClient);	
    }
    
    public static boolean productIDinDB(String inputID) {
    	ArrayList<Product> result=find(inputID, "productID");
    	if(result.isEmpty()) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
}
