package com.cometsale.mongodb;

import java.util.ArrayList;
import com.cometsale.model.UserDetails;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;

public class UserDB extends GenericClassDB {

    public static void push(UserDetails inputUser) {
        GenericClassDB.push(inputUser);
    }


    public static ArrayList<UserDetails> find(String searchString, String searchAttribute) {
        return (ArrayList<UserDetails>) GenericClassDB.find(UserDetails.class,searchString,searchAttribute);
    }
    
    public static void update(String searchString, String searchAttribute,String updateString,String updateAttribute) {
        GenericClassDB.update(UserDetails.class,searchString,searchAttribute,updateString,updateAttribute);
    }
/*    public static <T> ArrayList<T> find(String inputString, String searchAttribute) {
        //get a client and database
        MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //push the object

        MongoCollection<UserDetails> collection = database.getCollection("UserDetails",UserDetails.class);
        ArrayList<T> output =  collection.find(eq(searchAttribute, inputString)).into(new ArrayList());
        
        //close the connection.
        closeConnection(mongoClient);
        
        return output;
    }*/
    
    public static void uniqueConstraint() {
    	MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //push the object

        MongoCollection<UserDetails> collection = database.getCollection("UserDetails",UserDetails.class);
    	
    	collection.createIndex(Indexes.ascending("netID"));
    	  //close the connection.
        closeConnection(mongoClient);
    }
}
