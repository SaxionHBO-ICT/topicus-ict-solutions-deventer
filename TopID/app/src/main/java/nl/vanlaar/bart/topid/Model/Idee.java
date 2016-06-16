package nl.vanlaar.bart.topid.Model;

import android.graphics.Bitmap;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;

/**
 * Een idee(kan ook een vraag zijn)
 */
public class Idee {
    private User poster;
    private String title;
    private String mainText;
    private Bitmap plaatje;
    private int postPoints;
    private String summaryText;
    private String postDate;
    private boolean anonymous;
    private int soortIdee;
    private ArrayList<Comment> comments = new ArrayList<>();
    private int tempPlaatje; // temp plaatje voor int.

    //voor soortIdee
    public static final int KLACHT = 1;
    public static final int IDEE = 2;

    /*
    lege constructor
     */
    public Idee() {
    }

    /*
    een constructor
     */

    public Idee(User poster, String title, String mainText, int postPoints, String summaryText, String postDate, boolean anonymous, int soortIdee, ArrayList<Comment> comments, int tempPlaatje) {
        this.poster = poster;
        this.title = title;
        this.mainText = mainText;
        this.postPoints = postPoints;
        this.summaryText = summaryText;
        this.postDate = postDate;
        this.anonymous = anonymous;
        this.soortIdee = soortIdee;
        this.comments = comments;
        this.tempPlaatje = tempPlaatje;
    }

    //getters en setters
    public int getTempPlaatje() {
        return tempPlaatje;
    }

    public void setTempPlaatje(int tempPlaatje) {
        this.tempPlaatje = tempPlaatje;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
    public boolean getAnonymous() {
        return anonymous;
    }

    /*
    voegt een comment toe aan het idee
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }



}



