/**
 * Created by bart on 8-6-2016.
 */

import Controller.DatabaseHelper;
import Controller.JSONParser;
import Model.Comment;
import Model.Idee;
import Model.User;
import com.google.gson.Gson;
import com.j256.ormlite.table.DatabaseTable;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.xml.crypto.Data;

import java.util.ArrayList;

import static spark.Spark.*;

public class Main {
    // initializing JSONparser
    private static JSONParser parser = new JSONParser();

    private static Comment comment = new Comment("henk", "henk", "henk", "henk");

    //initializing DatabaseHelper
    private static DatabaseHelper dbHelper = DatabaseHelper.getInstance();

    // response codes:
    //https://developer.mozilla.org/en-US/docs/Web/HTTP/Response_codes

    public static void main(String[] args) {
        port(1234);

        post("/user", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                String name = request.params("name");
                String email_adres = request.params("email_adres");
                String Gebruiker_plaatje_url = request.params("Gebruiker_plaatje_url");
                int postcount = Integer.parseInt(request.params("postcount"));

                User user = new User();
            //    user.setName(name);
                user.setEmail_adres(email_adres);
                user.setGebruiker_plaatje_url(Gebruiker_plaatje_url);
                if (dbHelper.addUserToDatabase(user)) {
                    response.status(201);
                    return "User toegevoegt aan DB";
                } else {
                    response.status(403);
                    return "Error adding User";
                }

            }
        });

        get("/user/:emailadres", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                User user = dbHelper.getUserByEmail(request.params(":emailadres"));

                if (user != null) {
                    response.status(200);
                    return parser.userToJson(user);
                } else {
                    response.status(404);
                    return "user not found";
                }
            }
        });

        post("/Idee", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {

                Idee idee = new Idee();

                if (dbHelper.addIdeeToDatabase(idee)) {
                    response.status(201);
                    return "idee succesvol gepost/geupdate";

                } else {
                    response.status(403);
                    return "idee onsuccesvol gepost";
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