package nl.vanlaar.bart.topid.Model;

import android.graphics.Bitmap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Een idee(kan ook een vraag zijn)
 */
public class Idee {
    private int idIdee;
    private User poster;
    private String idee_title;
    private String mainText;
    private Bitmap plaatje;
    private int postPoints;
    private String summaryText;
    private String idee_Datum;
    private boolean idee_anoniem;
    private int soortIdee;
    private ArrayList<Comment> comments;
    private int tempPlaatje; // temp plaatje voor int.

    //voor soortIdee
    public static final int KLACHT = 1;
    public static final int IDEE = 2;

    /**
     * lege constructor
     */
    public Idee() {
    }
    /**
     * een constructor
     */

    public Idee(User poster, String title, String text,String summaryText,  int soortIdee,int tempPlaatje) {
        this.poster = poster;
        this.idee_title = title;
        this.mainText = text;
        this.summaryText = summaryText;
        this.tempPlaatje = tempPlaatje;
        this.postPoints = 0;
        this.soortIdee = soortIdee;
        this.comments = new ArrayList<>();
    }

    //getters en setters
    public int getTempPlaatje() {
        return tempPlaatje;
    }

    public void setTempPlaatje(int tempPlaatje) {
        this.tempPlaatje = tempPlaatje;
    }

    public Idee(String title, String mainText, String summaryText) {
        this.idee_title = title;
        this.mainText = mainText;
        this.summaryText = summaryText;

    }

    public String getTitle() {
        return idee_title;
    }

    public void setTitle(String title) {
        this.idee_title = title;
    }

    public String getSoortIdee() {
        if (this.soortIdee == KLACHT) {
            return "klacht";
        }
        return "idee";
    }

    public void setSoortIdee(int soortIdee) {
        this.soortIdee = soortIdee;
    }

    public int getPostPoints() {
        return postPoints;
    }

    public void addPostPoint() {
        this.postPoints = +1;
    }

    public void setPostPoints(int postPoints) {
        this.postPoints = postPoints;
    }


    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Bitmap getPlaatje() {
        return plaatje;
    }

    public void setPlaatje(Bitmap plaatje) {
        this.plaatje = plaatje;
    }

    public String getPostDate() {
        return idee_Datum;
    }

    public void setPostDate(String postDate) {
        this.idee_Datum = postDate;
    }

    public void setAnonymous(boolean anonymous) {
        this.idee_anoniem = anonymous;
    }
    public boolean getAnonymous(){
    return idee_anoniem;
}

    public ArrayList<Comment> getComments() {
        return comments;
    }


    /*
    voegt een comment toe aan het idee
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public void setidee_Datum(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm", Locale.GERMANY);
        this.idee_Datum =  sdf.format(new Date());
    }

    public String getidee_Datum() {
        return idee_Datum;
    }

}



