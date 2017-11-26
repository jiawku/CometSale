package com.cometsale.mongodb;

import java.util.ArrayList;

import com.cometsale.model.Student;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;

public class UserDB extends GenericClassDB {

    public static void push(Student inputUser) {
        GenericClassDB.push(inputUser);
    }


    public static ArrayList<Student> find(String searchString, String searchAttribute) {
        return (ArrayList<Student>) GenericClassDB.find(Student.class,searchString,searchAttribute);
    }
    
    public static void update(String searchString, String searchAttribute,String updateString,String updateAttribute) {
        GenericClassDB.update(Student.class,searchString,searchAttribute,updateString,updateAttribute);
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

        MongoCollection<Student> collection = database.getCollection("Student",Student.class);
    	
    	collection.createIndex(Indexes.ascending("netID"));
    	  //close the connection.
        closeConnection(mongoClient);
    }
}
