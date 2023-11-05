package com.cloudserv.claims.DBService;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CollectionHandler {
    @Autowired
    private MongoClient mongoClient;
    public MongoDatabase database = null;
    @Value("${spring.data.mongodb.database}")
    String databaseName;

    @PostConstruct
    public void database(){
        database= mongoClient.getDatabase(databaseName);
        //return database;
    }
    public void insertDocument(String objectName, Document document){
        database.getCollection(objectName).insertOne(document);
    }
    public void insertDocuments(String objectName, List<Document> documents){
        database.getCollection(objectName).insertMany(documents);
    }

    public List<Document> fetchDocument(Class clazz, Bson bson){
        Iterable<Document> documents = database.getCollection("collection").find(bson);
        List<Document> docList=new ArrayList<>();
        if(documents!=null) {
         Iterator<Document> documentIterator= documents.iterator();
            while (documentIterator.hasNext()) {
                docList.add(documentIterator.next());
            }
        }
        return docList;

    }
    public  List<Document> findOne(String collection , Bson bson){
        Iterable<Document> documents = database.getCollection(collection).find();
        List<Document> docList=new ArrayList<>();
        if(documents!=null) {
            Iterator<Document> documentIterator= documents.iterator();
            while (documentIterator.hasNext()) {
                docList.add(documentIterator.next());
            }
        }
        return docList;
    }

}
