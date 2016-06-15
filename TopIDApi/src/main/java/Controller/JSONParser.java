package Controller;

import Model.Comment;
import Model.Idee;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;

/**
 * Created by bart on 13-6-2016.
 */
public class JSONParser {

    public static String userToJson(User user){
        return new Gson().toJson(user);
    }

    public static String ideeToJson(Idee idee){
        return new Gson().toJson(idee);
    }

    public static String ideeënToJson(ArrayList<Idee> ideeën){
        return new Gson().toJson(ideeën);
    }

    public static String commentToJson(Comment comment){
        return new Gson().toJson(comment);
    }
}
