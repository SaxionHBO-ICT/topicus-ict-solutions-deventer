package nl.vanlaar.bart.topid.Model;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.R;

/**
 * Created by bart on 25-5-2016.
 */
public class IdeeënLijst {
    private static ArrayList<Idee> ideeënLijst;
    //private static IdeeënLijst ourInstance = new IdeeënLijst();

    public static ArrayList<Idee> getIdeeënLijst() {
        if(ideeënLijst == null){
            ideeënLijst = new ArrayList<>();
            User user =  new User("naam",R.drawable.trollface);
            Idee idee = new Idee(user,"kdmakdsadnsajkdnsajkdnsajda", R.drawable.trollface);
            Comment comment = new Comment("Henk", "meer fietsen", "Dit is geen slect idee", R.drawable.david, "9-18-2016 || 12:30");
            idee.setSummaryText("dit is een samenvatting");
            Comment comment2 = new Comment("koekiemonster", "meer fietsen", "kan je fietsen eten?", R.drawable.david, "5-30-2016 || 16:57");
            idee.addComment(comment);
            idee.addComment(comment2);
            idee.addComment(comment);
            idee.addComment(comment2);
            idee.addComment(comment);
            idee.addComment(comment2);

            ideeënLijst.add(idee);
            idee.setSoortIdee(Idee.IDEE);
            ideeënLijst.add(idee);
            idee.setSoortIdee(Idee.KLACHT);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);


        }
        return ideeënLijst;
    }
    public static ArrayList<Idee> sortByIdee(){
        ArrayList<Idee> unSortedList = getIdeeënLijst();
        ArrayList<Idee> sortedList = new ArrayList<>();
        for(Idee idee : unSortedList){
            if(idee.getSoortIdee().equalsIgnoreCase("idee")){
                sortedList.add(idee);
            }
        }
        return sortedList;
    }

    public static ArrayList<Idee> sortByKlacht(){
        ArrayList<Idee> unSortedList = getIdeeënLijst();
        ArrayList<Idee> sortedList = new ArrayList<>();
        for(Idee idee : unSortedList){
            if(idee.getSoortIdee().equalsIgnoreCase("klacht")){
                sortedList.add(idee);
            }
        }
        return sortedList;
    }

    private IdeeënLijst() {
    }

}
