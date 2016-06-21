package Controller;

import Model.Comment;
import Model.Idee;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

/**
 * JsonParser dmv Gson
 */
public class JSONParser {

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
}
