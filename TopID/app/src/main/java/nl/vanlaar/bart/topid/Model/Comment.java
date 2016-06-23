package nl.vanlaar.bart.topid.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Sander on 25-5-2016.
 * Comment object class.
 */
public class Comment {
    private String userName;
    private String ideeName;
    private String comment;
    private int userPicture; // int voor local testing moet Bitmap worden als het uit DB wordt gehaald.
    private User user;
    private String date;


    /**
     * een lege constructor
     */
    public Comment() {
    }

    /**
     * een constructer
     * @param userName
     * @param ideeName
     * @param comment
     * @param userPicture
     */
    public Comment(String userName, String ideeName, String comment, int userPicture) {
        this.userName = userName;
        this.ideeName = ideeName;
        this.comment = comment;
        this.userPicture = userPicture;
        setComment_Datum();
    }

    /**
     * een constructor
     * @param userName
     * @param comment
     * @param userPicture
     * @param user
     */
    public Comment(String userName, String comment, int userPicture, User user) {
        this.userName = userName;
        this.comment = comment;
        this.userPicture = userPicture;
        this.user = user;
    }


    //getters en setters
    public String getDate() {
        return date;
    }
    public User getUser() {
        return user;
    }
    public String getUserName() {
        return userName;
    }
    public String getIdeeName() {
        return ideeName;
    }
    public String getComment() {
        return comment;
    }
    public int getUserPicture() {
        return userPicture;
    }
    public void setComment_Datum(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm", Locale.GERMANY);
        this.date =  sdf.format(new Date());
    }
}
