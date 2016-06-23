package nl.vanlaar.bart.topid.Model;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.R;

/**
 * Een lijst van ideeën/opmerkingen met een singleton constructor
 */
public class IdeeënLijst {
    private static IdeeënLijst instance = new IdeeënLijst();
    private ArrayList<Idee> ideeën = new ArrayList<>();
    private ArrayList<Idee> klachten = new ArrayList<>();

    //dummy user
    private User ingelogteUser = new User("Gabe", R.drawable.gabenewell, 40);

    private IdeeënLijst() {
        //dummy data
        User Sander = new User("Sander" , R.drawable.sander, 30);
        User David = new User("David", R.drawable.david, 8);

        Idee meerMensenOpDeFiets = new Idee(Sander,"Meer mensen op de fiets","tegenwoordig komen teveel mensen met de auto terwijl ze ook met de fiets kunnen","er moeten meer mensen met de fiets komen",Idee.IDEE,R.drawable.fiets);
        Comment comment = new Comment("Sander", "<eer mensen op de fiets", "Goed idee!", R.drawable.sander);
        meerMensenOpDeFiets.addComment(comment);
        meerMensenOpDeFiets.addComment(comment);
        meerMensenOpDeFiets.addComment(comment);

        ideeën.add(meerMensenOpDeFiets);
        klachten.add(new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", "Mogelijk om het koeler te maken op de 2e verdieping?", Idee.KLACHT,  R.drawable.heet));
        ideeën.add(meerMensenOpDeFiets);
        klachten.add(new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", "Mogelijk om het koeler te maken op de 2e verdieping?", Idee.KLACHT,  R.drawable.heet));
        ideeën.add(meerMensenOpDeFiets);
        klachten.add(new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", "Mogelijk om het koeler te maken op de 2e verdieping?", Idee.KLACHT,  R.drawable.heet));
        ideeën.add(meerMensenOpDeFiets);
        klachten.add(new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", "Mogelijk om het koeler te maken op de 2e verdieping?", Idee.KLACHT,  R.drawable.heet));


        ingelogteUser.addVolgendIdee(meerMensenOpDeFiets);
    }

    public static IdeeënLijst getInstance() {
        if (instance == null) {
            instance = new IdeeënLijst();
        }
        return instance;
    }

    /*
    voegt een idee/klacht toe
     */
    public void addIdee(Idee idee) {
        ideeën.add(idee);
    }

    public void addKlacht (Idee klacht){
        klachten.add(klacht);
    }




    private ArrayList<Idee> sortByDate(ArrayList<Idee> ideeën){
        ArrayList<Idee> gesorteerdeIdeeën = ideeën;
        boolean aangepast = true;
        while (aangepast) {
            int changeCounter = 0;
            for (int i = 0; i < gesorteerdeIdeeën.size(); i++) {
                if (gesorteerdeIdeeën.get(i).getidee_Datum().compareTo(gesorteerdeIdeeën.get(i + 1).getidee_Datum()) > 1) {
                    Idee idee = gesorteerdeIdeeën.get(i);
                    gesorteerdeIdeeën.remove(i);
                    gesorteerdeIdeeën.add(i + 1, idee);
                    changeCounter++;
                }
            }
            if (changeCounter == 0){
                aangepast = false;
            }
        }
        return gesorteerdeIdeeën;
    }

    /**
     * getters
     * @return ideeën/klachten
     */
    public ArrayList<Idee> getIdeeën() {
        return ideeën;
    }
    public ArrayList<Idee> getKlachten(){
        return klachten;
    }
    public User getIngelogteUser() {
        return ingelogteUser;
    }
}
