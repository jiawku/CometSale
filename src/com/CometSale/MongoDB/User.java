package com.CometSale.MongoDB;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.CometSale.obj.userDetails;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;



public class User {
    
    public static void push(userDetails inputUser){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClientURI connectionString = new MongoClientURI("mongodb://Team5:UTDteam5@ds139124.mlab.com:39124/cometsale");
        MongoClient mongo = new MongoClient(connectionString);
        MongoDatabase database = mongo.getDatabase("cometsale").withCodecRegistry(pojoCodecRegistry);
        
        MongoCollection<userDetails> collection = database.getCollection("user",userDetails.class);
      
        collection.insertOne(inputUser);
        mongo.close();
    }
}
