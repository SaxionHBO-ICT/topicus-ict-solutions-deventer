package nl.vanlaar.bart.topid.Model;

import java.util.ArrayList;

/**
 * Created by bart on 1-6-2016.
 */
public class IdeeënLijst {
    private static IdeeënLijst instance = new IdeeënLijst();
    private static ArrayList<Idee> ideeën = new ArrayList<>();


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

    public static ArrayList<Idee> sortByIdee(){
        ArrayList<Idee> unsortedArray = new ArrayList<>(ideeën);
        ArrayList<Idee> sortedArray = new ArrayList<>();

        for(Idee idee : unsortedArray){
            if(idee.getSoortIdee().equalsIgnoreCase("idee")){
                sortedArray.add(idee);
            }
        }

        return sortedArray;
    }
    public static ArrayList<Idee> sortByKlacht(){
        ArrayList<Idee> unsortedArray = new ArrayList<>(ideeën);
        ArrayList<Idee> sortedArray = new ArrayList<>();

        for(Idee idee : unsortedArray){
            if(idee.getSoortIdee().equalsIgnoreCase("klacht")){
                sortedArray.add(idee);
            }
        }
        return sortedArray;

    }


}
