package Model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bart on 18-5-2016.
 */
@DatabaseTable (tableName = "Idee")
public class Idee {
    private ArrayList<Comment> comments = new ArrayList<>();

    public static final int KLACHT = 1;
    public static final int IDEE = 2;

    @DatabaseField(id = true)
    private String idIdee;
    @DatabaseField(canBeNull = false)
    private String Idee_title;
    @DatabaseField(canBeNull = false)
    private String Idee_samenvatting;
    @DatabaseField(canBeNull = false)
    private String Idee_datum;
    @DatabaseField(canBeNull = false)
    private int Idee_cat;
    @DatabaseField(canBeNull = false)
    private String Email_Adress;
    @DatabaseField(canBeNull = false)
    private String Idee_text;
    @DatabaseField
    private String Idee_plaat_url;
    @DatabaseField
    private boolean Idee_anoniem;
    @DatabaseField(canBeNull = false)
    private int Idee_points;


    public Idee(String idIdee, String idee_title, String idee_samenvatting, String idee_datum, int idee_cat, String email_Adress, String idee_text, String idee_plaat_url, boolean idee_anoniem, int idee_points) {
        this.idIdee = idIdee;
        this.Idee_title = idee_title;
        this.Idee_samenvatting = idee_samenvatting;
        this.Idee_datum = idee_datum;
        this.Idee_cat = idee_cat;
        this.Email_Adress = email_Adress;
        this.Idee_text = idee_text;
        this.Idee_plaat_url = idee_plaat_url;
        this.Idee_anoniem = idee_anoniem;
        this.Idee_points = idee_points;
    }

    public Idee() {
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

}



