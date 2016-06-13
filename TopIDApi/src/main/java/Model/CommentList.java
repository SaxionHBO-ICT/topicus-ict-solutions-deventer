package Model;

import java.util.ArrayList;

/**
 * Created by Sander on 25-5-2016.
 */
public class CommentList {
    private static CommentList instance;
    private ArrayList<Comment> comments;

    private CommentList(){
        comments = new ArrayList<>();
    }

    public static CommentList getInstance(){
        if (instance == null){
            instance = new CommentList();
        }
        return instance;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
/*
    public void addComment(String userName, String ideeName, String comment, int userPic, String date){
        Comment commentAdded = new Comment(userName, ideeName, comment, userPic, date);
        addComment(commentAdded);
    }
*/
    public ArrayList<Comment> getComments() {
        ArrayList<Comment> commentss = new ArrayList<>(comments);
        return commentss;
    }
}
