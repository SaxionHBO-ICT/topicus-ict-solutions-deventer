package nl.vanlaar.bart.topid.Model;

/**
 * Created by Sander on 25-5-2016.
 */
public class Comment {
    private String userName;
    private String ideeName;
    private String comment;
    private Idee parentIdee;
    private int userPicture;
    private User user;
    private String date;

    public Comment(String userName, String ideeName, String comment, int userPicture, String date) {
        this.userName = userName;
        this.ideeName = ideeName;
        this.comment = comment;
        this.userPicture = userPicture;
        this.date = date;
    }

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
