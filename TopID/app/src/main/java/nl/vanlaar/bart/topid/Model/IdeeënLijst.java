package nl.vanlaar.bart.topid.Model;

import java.util.ArrayList;

/**
 * Created by bart on 1-6-2016.
 */
public class IdeeënLijst {
    private static IdeeënLijst instance = new IdeeënLijst();
    private ArrayList<Idee> ideeën = new ArrayList<>();


    private IdeeënLijst() {
        ideeën = new ArrayList<>();
    }

    public static IdeeënLijst getInstance() {
        if(instance == null){
            instance = new IdeeënLijst();
        }
        return instance;
    }

    public void addIdee(Idee idee){
        ideeën.add(idee);
    }
    public ArrayList<Idee> getIdeeën(){
        ArrayList<Idee> array = new ArrayList<>(ideeën);
        return array;
    }

    public ArrayList<Idee> sortByIdee(){
        ArrayList<Idee> unsortedArray = new ArrayList<>(ideeën);
        ArrayList<Idee> sortedArray = new ArrayList<>();

        for(Idee idee : unsortedArray){
            if(idee.getSoortIdee().equalsIgnoreCase("idee")){
                sortedArray.add(idee);
            }
        }

        return sortedArray;
    }
    public ArrayList<Idee> sortByKlacht(){
        ArrayList<Idee> unsortedArray = new ArrayList<>(ideeën);
        ArrayList<Idee> sortedArray = new ArrayList<>();

        for(Idee idee : unsortedArray){
            if(idee.getSoortIdee().equalsIgnoreCase("klacht")){
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


}
