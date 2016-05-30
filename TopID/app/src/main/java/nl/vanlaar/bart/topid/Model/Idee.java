package nl.vanlaar.bart.topid.Model;

import android.graphics.Bitmap;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bart on 18-5-2016.
 */
public class Idee {
    private User poster;
    private String title;
    private String mainText;
    private Bitmap plaatje;
    private int postPoints;
    private String summaryText;
    private Date postDate;
    private boolean anonymous;
    private int soortIdee;
    private ArrayList<Comment> comments = new ArrayList<>();


    private int tempPlaatje; // temp plaatje voor int.


    public static final int KLACHT = 1;
    public static final int IDEE = 2;


    public Idee(User poster, String text, Bitmap plaatje) {
        this.poster = poster;
        this.mainText = text;
        this.plaatje = plaatje;
        this.postPoints = 0;
    }
    public Idee(User poster, String text, int plaatje) {
        this.poster = poster;
        this.mainText = text;
        this.tempPlaatje = plaatje;
        this.postPoints = 0;
    }

    public Idee(String mainText, String summaryText) {
        this.mainText = mainText;
        this.summaryText = summaryText;
    }

    public Idee(String title, String mainText, String summaryText) {
        this.poster = poster;
        this.title = title;
        this.mainText = mainText;
        this.summaryText = summaryText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSoortIdee() {
        if(this.soortIdee == KLACHT){
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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }
    public Bundle toBundle(){
        Bundle b = new Bundle();
        b.putBundle("User",this.poster.toBundle());







        return  b;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
}


