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
import com.sun.org.apache.xpath.internal.SourceTree;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.xml.crypto.Data;

import java.util.ArrayList;

import static spark.Spark.*;

public class Main {
    // initializing JSONparser
    private static JSONParser parser = new JSONParser();



    //initializing DatabaseHelper
    private static DatabaseHelper dbHelper = DatabaseHelper.getInstance();

    // response codes:
    //https://developer.mozilla.org/en-US/docs/Web/HTTP/Response_codes

    public static void main(String[] args) {
        port(1234);

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

        post("/user", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                String name = request.queryParams("name");
                System.out.println(name);
                String email_adres = request.queryParams("email_adres");
                String Gebruiker_plaatje_url = request.queryParams("Gebruiker_plaatje_url");
                int postcount = Integer.parseInt(request.queryParams("postcount"));

                User user = new User();
            //    user.setName(name);
                user.setEmail_adres(email_adres);
                user.setName(name);
                user.setPostcount(postcount);

                System.out.println(user.getEmail_adres() + user.getName()+ user.getPostcount());
                if(Gebruiker_plaatje_url != null) {
                    user.setGebruiker_plaatje_url(Gebruiker_plaatje_url);
                }
                if (dbHelper.addUserToDatabase(user)) {
                    response.status(201);
                    return "User toegevoegt aan DB";
                } else {
                    response.status(403);
                    return "Error adding User";
                }

            }
        });



        post("/idee", new Route() {
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

        /**
         * like een idee
         */
        put("/idee/like/:ididee/:iduser", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                User user = dbHelper.getUserByEmail(request.params(":emailadres"));
                Idee idee = dbHelper.getIdeeById(Integer.parseInt(request.params(":id")));
                if (dbHelper.updateIdeeInDatabase(idee))
            }
        });

        /**
         * get beste ideeën
         */
        get("ideeën/beste", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                ArrayList<Idee> ideeën = dbHelper.getBesteIdeeën(true);
                response.status(200);
                return JSONParser.ideeënToJson(ideeën);
            }
        });

        /**
         * get nieuwste ideeën
         */
        get("ideeën/nieuwste", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                ArrayList<Idee> ideeën = dbHelper.getNieuwsteIdeeën(true);
                response.status(200);
                return JSONParser.ideeënToJson(ideeën);
            }
        });

        get("klachten/beste", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                ArrayList<Idee> ideeën = dbHelper.getBesteIdeeën(false);
                response.status(200);
                return JSONParser.ideeënToJson(ideeën);
            }
        });

        get("klachten/nieuwste", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                ArrayList<Idee> ideeën = dbHelper.getNieuwsteIdeeën(false);
                response.status(200);
                return JSONParser.ideeënToJson(ideeën);
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