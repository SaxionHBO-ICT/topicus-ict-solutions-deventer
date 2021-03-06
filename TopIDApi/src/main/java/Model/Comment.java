package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Comment class
 */
@DatabaseTable(tableName = "Reactie")
public class Comment {
    private String userName;
    private String ideeName;
    private String comment;
    private Idee parentIdee;
    private int userPicture;
    private User user;
    private String date;
    private Integer reactieID;

    @DatabaseField(id = true)
    private int id_Reactie;
    @DatabaseField(canBeNull = false)
    private String Reactie_content;
    @DatabaseField(canBeNull = false)
    private String Reactie_datum;
    @DatabaseField(canBeNull = false)
    private String Gebtuiker_Gebruiker_id;
    @DatabaseField(canBeNull = false)
    private int Idee_idIdee;

    /*
    lege constructor
     */
    public Comment() {
    }

    /*
    een constructor
     */
    public Comment(String userName, String ideeName, String comment, String date) {
        this.userName = userName;
        this.ideeName = ideeName;
        this.comment = comment;
        this.userPicture = userPicture;
        this.date = date;
    }

    /*
    een constructor
     */
    public Comment(String userName, String comment, Idee parentIdee, int userPicture, User user) {
        this.userName = userName;
        this.comment = comment;
        this.parentIdee = parentIdee;
        this.userPicture = userPicture;
        this.user = user;
    }

    //getters en setters
    public Idee getParentIdee() {
        return parentIdee;
    }

    public void setParentIdee(Idee parentIdee) {
        this.parentIdee = parentIdee;
    }

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
}
