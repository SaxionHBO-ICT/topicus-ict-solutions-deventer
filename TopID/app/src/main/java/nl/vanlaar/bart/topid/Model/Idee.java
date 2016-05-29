package nl.vanlaar.bart.topid.Model;

import java.util.Date;

/**
 * Created by bart on 18-5-2016.
 */
public class Idee {
    private User poster;
    private String mainText;
    private int plaatje;
    private int postPoints;
    private String summaryText;
    private Date postDate;
    private boolean anonymous;
    private static final int KLACHT = 1;
    private static final int IDEE = 2;


    public Idee(User poster, String text, int plaatje) {
        this.poster = poster;
        this.mainText = text;
        this.plaatje = plaatje;
        this.postPoints = 0;
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

    public int getPlaatje() {
        return plaatje;
    }

    public void setPlaatje(int plaatje) {
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

    public static int getKLACHT() {
        return KLACHT;
    }

    public static int getIDEE() {
        return IDEE;
    }
}
