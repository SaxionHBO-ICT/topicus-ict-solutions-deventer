/**
 * Created by bart on 8-6-2016.
 */
import Controller.DatabaseHelper;
import Controller.JSONParser;
import Model.Comment;
import Model.User;
import com.google.gson.Gson;
import com.j256.ormlite.table.DatabaseTable;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.xml.crypto.Data;

import static spark.Spark.*;

public class Main {
    // initializing JSONparser
    private static JSONParser parser = new JSONParser();

    private static Comment comment = new Comment("henk","henk","henk","henk");

    //initializing DatabaseHelper
    private static DatabaseHelper dbHelper = DatabaseHelper.getInstance();

    public static void main(String[] args) {
        port(3307);
        Gson gson = new Gson();

       get("user/:emailadres", new Route() {
           @Override
           public Object handle(Request request, Response response) throws Exception {
               User user =  dbHelper.getUserByEmail(request.params(":emailadres"));

               if(user != null){
                   response.status(200);
                   return parser.userToJson(user);
               }
               else {
                   response.status(404);
                   return "user not found";
               }
           }
       });

    }
}


// ormlite.com documentation getting started
//mysql connector
//Gson library // in app en  deze.

//nyds












































//githup/nyds - dev -
//orm core & orm jdbc