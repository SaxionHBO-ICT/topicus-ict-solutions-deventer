package nl.vanlaar.bart.topid.Model;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.R;

/**
 * Created by bart on 25-5-2016.
 */
public class IdeeënLijst {

    private static ArrayList<Idee> ideeënLijst;



    public static ArrayList<Idee> getIdeeënLijst() {
        if(ideeënLijst == null){
            ideeënLijst = new ArrayList<>();
            User user =  new User("Sander Groot Wesseldijk",R.drawable.sander);
            Idee idee = new Idee(user,"Meer fietsen", "Te veek mensen komen met de auto terwijl ze makkelijk met de fiets kunnen",R.drawable.fiets ,Idee.IDEE);
            Comment comment = new Comment("Henk", "meer fietsen", "Dit is geen slect idee", R.drawable.david, "9-18-2016 || 12:30");
            idee.setSummaryText("Te weinig mensen komen op de fiets");

            User user2 =  new User("David Sarkiskan",R.drawable.david);
            Idee idee2 = new Idee(user2,"Te warm", "Vaak is het te warm op de 2e verdieping tijdens de zomer maanden, is het misschien een idee om een airco aan te schaffen?", R.drawable.heet,Idee.KLACHT);
            idee2.setSummaryText("Op de 2e verdieping is het in de zomer maanden vaak te warm");
            idee2.setSoortIdee(Idee.KLACHT);


            Comment comment2 = new Comment("Sander", "Te warm", "Ja vooral in de vergader zalen", R.drawable.sander, "5-30-2016 || 16:57");
            CommentList.getInstance().addComment(comment);
            CommentList.getInstance().addComment(comment2);

            idee.addComment(comment);
            idee.addComment(comment);
            idee.addComment(comment2);
            idee2.addComment(comment2);

            idee.setSoortIdee(Idee.IDEE);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee2);
            ideeënLijst.add(idee2);
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
