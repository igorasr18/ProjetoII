// initializing library 


// importing files for reading JSON   
import java.io.BufferedReader;
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;  
import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;  
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON; 

public class ConnectionMongoDb {  
	
	JSONParser parser = new JSONParser();
	  String line = null;
	  String fileName = "D:\\Projeto II\\Exports\\zips.JSON";
	  ArrayList<JSONObject> json=new ArrayList<JSONObject>();
	  JSONObject obj;
	  MongoClient mongo;
	  DB db;
	  DBCollection collection;
	
	public void readfromfile() {
		try {  
		   FileReader fileReader = new FileReader(fileName);

	       BufferedReader bufferedReader = new BufferedReader(fileReader);
	       
	       createConnection();

	       while((line = bufferedReader.readLine()) != null) {
	           obj = (JSONObject) new JSONParser().parse(line);
	           json.add(obj);
	       }
	       bufferedReader.close();
	       insertReadData();
			  
			  
		  } catch (FileNotFoundException e) {  
			  e.printStackTrace();  
		  } catch (IOException e) {  
			  e.printStackTrace();  
		  } catch (ParseException e) {  
			  e.printStackTrace();  
		  }  
	}
	
	public void createConnection() {
	    mongo = new MongoClient("localhost", 27017);
	  
	    db = mongo.getDB("test");
	  
	    collection = db.getCollection("citys");
	    collection.drop();
	    
	}
	
	public void findAll() {
	    DBCursor cursor = collection.find();
	    int i = 1;
	    try {
	       while(cursor.hasNext()) {
	           System.out.println(i + " " +cursor.next());
	           i++;
	       }
	    } finally {
	       cursor.close();
	    }
	}
	
	public void insertReadData() {
		Iterator<JSONObject> iterator = json.iterator();
        while (iterator.hasNext()) {
        	DBObject objeto = (DBObject) JSON.parse(iterator.next().toString());
            collection.insert(objeto);
        }
	}
	
	public void select1Item(String campo, String id) {
		BasicDBObject dbo = new BasicDBObject();
		dbo.put(campo, id);
		
		DBCursor cursor = collection.find(dbo);
	    
	     int i = 1;
	    try {
	       while(cursor.hasNext()) {
	           System.out.println(i + " " +cursor.next());
	           i++;
	       }
	    } finally {
	       cursor.close();
	    }
	    
	}
}