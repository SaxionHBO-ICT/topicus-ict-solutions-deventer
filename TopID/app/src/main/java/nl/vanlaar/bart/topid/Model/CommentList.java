package nl.vanlaar.bart.topid.Model;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.R;

/**
 * Een lijst van comments met een singleton constructor
 */
public class CommentList {
    private static CommentList instance;
    private ArrayList<Comment> comments;

    /**
     * een constructor
     */
    private CommentList(){
        comments = new ArrayList<>();

        //toevoegen van dummy data

        Comment comment = new Comment("Henk", "Meer fietsen", "Ik vind ook dat meer mensen op de fiets moeten!", R.drawable.david);
        Comment comment2 = new Comment("Henk", "Meer fietsen", "Minder auto's en meer fietsen!", R.drawable.sander);

        comments.add(comment);
        comments.add(comment2);
        comments.add(comment);
        comments.add(comment2);
        comments.add(comment);
        comments.add(comment2);
        comments.add(comment);
        comments.add(comment2);
    }

    /**
     * haal de instantie van de lijst op
     * @return de instantie van CommentList
     */
    public static CommentList getInstance(){
        if (instance == null){
            instance = new CommentList();
        }
        return instance;
    }



    /*
    Voegt een comment toe dmv de waarden van een comment
     */
    public void addComment(String userName, String ideeName, String comment, int userPic){
        Comment commentAdded = new Comment(userName, ideeName, comment, userPic);
        comments.add(commentAdded);
    }

    /*
    haal de lijst met comments op
     */
    public ArrayList<Comment> getComments() {
        ArrayList<Comment> commentss = new ArrayList<>(comments);
        return commentss;
    }
}
