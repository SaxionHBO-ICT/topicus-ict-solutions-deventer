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

                String email_adres = request.queryParams("email_adres");
                String Gebruiker_plaatje_url = request.queryParams("gebruiker_plaatje_url");
                int postcount = Integer.parseInt(request.queryParams("postcount"));

                User user = new User();
            //    user.setName(name);
                user.setEmail_adres(email_adres);
                user.setName(name);
                if(request.queryParams("postcount") != null){
                    user.setPostcount(postcount);
                }
                user.setPostcount(postcount);
                System.out.println(user.getName());
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

                String title = request.queryParams("idee_title");
                String text = request.queryParams("idee_text");
                String samenvatting = request.queryParams("idee_samenvatting");
                String email_gebruiker = request.queryParams("email_adres_gebruiker");
                String idee_plaatje_url = request.queryParams("idee_plaatje_url");
                boolean idee_anoniem = Boolean.parseBoolean(request.queryParams("idee_anoniem"));
                int idee_points = Integer.parseInt(request.queryParams("idee_points"));
                int idee_cat = Integer.parseInt(request.queryParams("idee_cat"));

//http://localhost:1234/idee?idee_title=Hans&idee_text= hoi&idee_samenvatting=hoii&email_adres_gebruiker=henk@live.nl&idee_anoniem=false&idee_points=0&idee_cat=1
                Idee idee = new Idee(title,samenvatting,idee_cat, email_gebruiker,text, idee_anoniem,idee_points);

                if(idee_plaatje_url!= null) {
                    idee.setIdee_plaatje_url(idee_plaatje_url);
                }

                System.out.println(idee.getEmail_adres_gebruiker());
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

//querybuilder
// ormlite.com documentation getting started
//mysql connector
//Gson library // in app en  deze.

//nyds


//githup/nyds - dev -
//orm core & orm jdbc