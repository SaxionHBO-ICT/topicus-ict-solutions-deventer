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

    public Comment() {
    }

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
     * @param date
     */
    public Comment(String userName, String ideeName, String comment, int userPicture, String date) {
        this.userName = userName;
        this.ideeName = ideeName;
        this.comment = comment;
        this.userPicture = userPicture;
        this.date = date;
    }

    /**
     * een constructor
     * @param userName
     * @param comment
     * @param parentIdee
     * @param userPicture
     * @param user
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
