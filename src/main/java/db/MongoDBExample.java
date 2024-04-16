package db;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import models.ContactModel;
import org.bson.Document;


public class MongoDBExample {

    public static void main(String[] args) {
        addNewEntity();
    }
    public static void addNewEntity(){

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("mycollection");

        Document document = new Document("name","Alice").append("Age", 25)
                .append("email", EmailGenerator.generateEmail(5,5,3));

      /*  ContactModel contactModel = new ContactModel(NameAndLastNameGenerator.generateName()
                ,NameAndLastNameGenerator.generateLastName(), EmailGenerator.generateEmail(3,3,3),
                PhoneNumberGenerator.generatePhoneNumber(), AddressGenerator.generateAddress(), "decr");*/

        // Document document1 = new Document("contact",contactModel);

        collection.insertOne(document);
        //collection.insertOne(document1);

    }
}