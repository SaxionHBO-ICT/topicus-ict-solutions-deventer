package Model;

import java.util.ArrayList;

/**
 * IdeeënLijst is een model class die een lijst van ideeën bijhoud.
 * Gemaakt dmv een singleton
 */
public class IdeeënLijst {
    private static IdeeënLijst instance = new IdeeënLijst();
    private ArrayList<Idee> ideeën = new ArrayList<>();

    /*
    private constructor
     */
    private IdeeënLijst() {
        ideeën = new ArrayList<>();
    }

    /*
    public methode om de instantie van IdeeënLijst te vragen
     */
    public static IdeeënLijst getInstance() {
        if(instance == null){
            instance = new IdeeënLijst();
        }
        return instance;
    }

    /*
    voeg een idee toe aan de lijst
     */
    public void addIdee(Idee idee){
        ideeën.add(idee);
    }

    //get de ideeën
    public ArrayList<Idee> getIdeeën(){
        ArrayList<Idee> array = new ArrayList<>(ideeën);
        return array;
    }

}
