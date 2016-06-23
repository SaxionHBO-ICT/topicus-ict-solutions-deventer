package nl.vanlaar.bart.topid.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import nl.vanlaar.bart.topid.Model.Comment;
import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.User;

/**
 * Created by bart on 13-6-2016.
 * Parser die werkt d.m.v. de Gson library.
 */
public class JSONParser {
private static Gson gson = new GsonBuilder().create();

    public static String userToJson(User user){
        return new Gson().toJson(user);
    }

    public static String ideeToJson(Idee idee){
        return new Gson().toJson(idee);
    }

    public static String ideeënToJson(List<Idee> ideeën){
        return new Gson().toJson(ideeën);
    }

    public static String commentToJson(Comment comment){
        return new Gson().toJson(comment);
    }

    public static ArrayList<Idee> jsonToIdeeënLijst(JSONArray array){
        ArrayList<Idee> lijst = new ArrayList<>();



        for(int i = 0; i <array.length();i++){
            Idee idee = new Idee();
            try {
                String jsonstring = array.get(i).toString();
                idee = gson.fromJson(jsonstring,Idee.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            lijst.add(idee);
        }
            return  lijst;
    }
}
