package nl.vanlaar.bart.topid.Model;

/**
 * Created by Sander on 25-5-2016.
 */
public class Comment {
    private String userName;
    private String ideeName;
    private String comment;
    private int userPicture;

    public Comment(String userName, String ideeName, String comment, int userPicture) {
        this.userName = userName;
        this.ideeName = ideeName;
        this.comment = comment;
        this.userPicture = userPicture;
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
