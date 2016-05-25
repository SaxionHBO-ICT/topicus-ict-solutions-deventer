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
            new Idee("henk","kdmakdsadnsajkdnsajkdnsajda", R.drawable.trollface);
            new Idee("henk","kdmakdsadnsajkdnsajkdnsajda", R.drawable.trollface);
            new Idee("henk","kdmakdsadnsajkdnsajkdnsajda", R.drawable.trollface);
            new Idee("henk","kdmakdsadnsajkdnsajkdnsajda", R.drawable.trollface);
            new Idee("henk","kdmakdsadnsajkdnsajkdnsajda", R.drawable.trollface);
            new Idee("henk","kdmakdsadnsajkdnsajkdnsajda", R.drawable.trollface);
            new Idee("henk","kdmakdsadnsajkdnsajkdnsajda", R.drawable.trollface);
        }
        return ideeënLijst;
    }

    private IdeeënLijst() {
    }
}
