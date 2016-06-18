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



        ideeën.add(new Idee(Sander,"Meer mensen op de fiets","tegenwoordig komen teveel mensen met de auto terwijl ze ook met de fiets kunnen","er moeten meer mensen met de fiets komen",Idee.IDEE,R.drawable.fiets));
        ideeën.add(new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", "Mogelijk om het koeler te maken op de 2e verdieping?", Idee.KLACHT,  R.drawable.heet));
        ideeën.add(new Idee(Sander,"Meer mensen op de fiets","tegenwoordig komen teveel mensen met de auto terwijl ze ook met de fiets kunnen","er moeten meer mensen met de fiets komen",Idee.IDEE,R.drawable.fiets));
        ideeën.add(new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", "Mogelijk om het koeler te maken op de 2e verdieping?", Idee.KLACHT,  R.drawable.heet));
        ideeën.add(new Idee(Sander,"Meer mensen op de fiets","tegenwoordig komen teveel mensen met de auto terwijl ze ook met de fiets kunnen","er moeten meer mensen met de fiets komen",Idee.IDEE,R.drawable.fiets));
        ideeën.add(new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", "Mogelijk om het koeler te maken op de 2e verdieping?", Idee.KLACHT,  R.drawable.heet));
        ideeën.add(new Idee(Sander,"Meer mensen op de fiets","tegenwoordig komen teveel mensen met de auto terwijl ze ook met de fiets kunnen","er moeten meer mensen met de fiets komen",Idee.IDEE,R.drawable.fiets));
        ideeën.add(new Idee(David, "Te warm op de 2e verdieping", "Het is te warm op de 2e verdieping kan daar misschien wat aan gedaan worden?", "Mogelijk om het koeler te maken op de 2e verdieping?", Idee.KLACHT,  R.drawable.heet));

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
     * getter
     * @return ideeën
     */
    public ArrayList<Idee> getIdeeën() {
        return ideeën;
    }

}
