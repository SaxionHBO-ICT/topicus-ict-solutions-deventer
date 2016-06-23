package Model;

import java.util.ArrayList;

/**
 * CommentList is een class die een lijst van comments bij houdt.
 * Gemaakt dmv een singleton
 */
public class CommentList {
    private static CommentList instance;
    private ArrayList<Comment> comments;

    /*
    private constructor
     */
    private CommentList(){
        comments = new ArrayList<>();
    }

    /*
    methode om de instantie van CommentList te krijgen
     */
    public static CommentList getInstance(){
        if (instance == null){
            instance = new CommentList();
        }
        return instance;
    }

    /*
    voeg een comment toe
     */
    public void addComment(Comment comment){
        comments.add(comment);
    }

    /*
    get de comments
     */
    public ArrayList<Comment> getComments() {
        ArrayList<Comment> commentss = new ArrayList<>(comments);
        return commentss;
    }
}
