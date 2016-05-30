package nl.vanlaar.bart.topid.Model;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.R;

/**
 * Created by Sander on 25-5-2016.
 */
public class CommentList {
    private static CommentList instance;
    private ArrayList<Comment> comments;

    private CommentList(){
        comments = new ArrayList<>();
        addComment("Bert", "Meer fietsen", "Dit is een super gaaf idee", R.drawable.bert, "9-18-2016 || 2:30");
        addComment("Ernie", "Meer fietsen", "Maar ik fiets niet graag", R.drawable.ernie, "9-18-2016 || 2:30");
        addComment("Koekiemonster", "Meer koekjes", "nomnomnomnom", R.drawable.koekiemonster, "11-7-2016 || 15:27");
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

    public void addComment(String userName, String ideeName, String comment, int userPic, String date){
        Comment commentAdded = new Comment(userName, ideeName, comment, userPic, date);
        addComment(commentAdded);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
}
