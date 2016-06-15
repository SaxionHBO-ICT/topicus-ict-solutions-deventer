package Model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.types.DateTimeType;
import com.j256.ormlite.table.DatabaseTable;

import java.text.SimpleDateFormat;
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

    @DatabaseField(generatedId = true)
    private int idIdee;
    @DatabaseField(canBeNull = false)
    private String idee_titel;
    @DatabaseField(canBeNull = false)
    private String idee_samenvatting;
    @DatabaseField
    private String idee_datum;
    @DatabaseField(canBeNull = false)
    private int idee_cat;
    @DatabaseField(canBeNull = false)
    private String email_adres_gebruiker;
    @DatabaseField(canBeNull = false)
    private String idee_text;
    @DatabaseField
    private String idee_plaatje_url;
    @DatabaseField
    private boolean idee_anoniem;
    @DatabaseField
    private int idee_points;


    public Idee(String idee_title, String idee_samenvatting, int idee_cat, String email_Adress, String idee_text, boolean idee_anoniem, int idee_points) {
        this.idee_titel = idee_title;
        this.idee_samenvatting = idee_samenvatting;
        this.idee_cat = idee_cat;
        this.email_adres_gebruiker = email_Adress;
        this.idee_text = idee_text;
        this.idee_anoniem = idee_anoniem;
        this.idee_points = idee_points;
        this.idee_datum = generateDate();
    }



    public Idee() {
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }



    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public static int getKLACHT() {
        return KLACHT;
    }

    public static int getIDEE() {
        return IDEE;
    }

    public int getIdIdee() {
        return idIdee;
    }

    public void setIdIdee(int idIdee) {
        this.idIdee = idIdee;
    }

    public String getIdee_title() {
        return idee_titel;
    }

    public void setIdee_title(String idee_title) {
        this.idee_titel = idee_title;
    }

    public String getIdee_samenvatting() {
        return idee_samenvatting;
    }

    public void setIdee_samenvatting(String idee_samenvatting) {
        this.idee_samenvatting = idee_samenvatting;
    }



    public void setIdee_datum(String idee_datum) {
        this.idee_datum = idee_datum;
    }



    public void setIdee_cat(int idee_cat) {
        this.idee_cat = idee_cat;
    }

    public String getEmail_adres_gebruiker() {
        return email_adres_gebruiker;
    }

    public void setEmail_adres_gebruiker(String email_adres_gebruiker) {
        this.email_adres_gebruiker = email_adres_gebruiker;
    }

    public String getIdee_text() {
        return idee_text;
    }

    public void setIdee_text(String idee_text) {
        this.idee_text = idee_text;
    }

    public String getIdee_plaatje_url() {
        return idee_plaatje_url;
    }

    public void setIdee_plaatje_url(String idee_plaatje_url) {
        this.idee_plaatje_url = idee_plaatje_url;
    }

    public boolean isIdee_anoniem() {
        return idee_anoniem;
    }

    public void setIdee_anoniem(boolean idee_anoniem) {
        this.idee_anoniem = idee_anoniem;
    }



    public void setIdee_points(int idee_points) {
        this.idee_points = idee_points;
    }

    public String generateDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
        return sdf.format(new Date());
    }


    public void like(){
        idee_points++;
    }

    public int getIdee_points() {
        return idee_points;
    }

    public String getIdee_datum() {
        return idee_datum;
    }

    public int getIdee_cat() {
        return idee_cat;
    }

}



