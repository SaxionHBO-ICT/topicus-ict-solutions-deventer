package nl.vanlaar.bart.topid.Model;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.R;

/**
 * Een lijst van ideeën/vragen met een singelton constructor
 */
public class IdeeënLijst {
    private static IdeeënLijst instance = new IdeeënLijst();
    private ArrayList<Idee> ideeën = new ArrayList<>();

    private IdeeënLijst() {
        //dummy data
        User Sander = new User("Sander" , R.drawable.sander, 30);
        User David = new User("David", R.drawable.david, 8);

        Idee idee = new Idee(Sander, "Meer mensen op de fiets", "tegenwoordig komen teveel mensen met de auto terwijl ze ook met de fiets kunnen", 50, "te weinig mensen komen met de fiets", "9 jan", false, 2, CommentList.getInstance().getComments(), R.drawable.fiets);
        Idee idee2 = new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", 40, "Mogelijk om het cooler te maken op de 2e verdieping?", "9 jan", false, 1, null, R.drawable.heet);

        ideeën.add(idee);
        ideeën.add(idee2);
        ideeën.add(idee);
        ideeën.add(idee2);
        ideeën.add(idee);
        ideeën.add(idee2);
        ideeën.add(idee);
        ideeën.add(idee2);

    }

    public static IdeeënLijst getInstance() {
        if (instance == null) {
            instance = new IdeeënLijst();
        }
        return instance;
    }

    /*
    voegt een idee toe
     */
    public void addIdee(Idee idee) {
        ideeën.add(idee);
    }


    /*
    sorteer bij idee
     */
    public ArrayList<Idee> sortByIdee() {
        ArrayList<Idee> unsortedArray = new ArrayList<>(ideeën);
        ArrayList<Idee> sortedArray = new ArrayList<>();

        for (Idee idee : unsortedArray) {
            if (idee.getSoortIdee().equalsIgnoreCase("idee")) {
                sortedArray.add(idee);
            }
        }

        return sortedArray;
    }

    /*
    sorteer bij klacht
     */
    public ArrayList<Idee> sortByKlacht() {
        ArrayList<Idee> unsortedArray = new ArrayList<>(ideeën);
        ArrayList<Idee> sortedArray = new ArrayList<>();

        for (Idee idee : unsortedArray) {
            if (idee.getSoortIdee().equalsIgnoreCase("klacht")) {
                sortedArray.add(idee);
            }
        }
        return sortedArray;

    }

    /**
     * getter
     * @return ideeën
     */
    public ArrayList<Idee> getIdeeën() {
        ArrayList<Idee> array = new ArrayList<>(ideeën);
        return array;
    }

}
