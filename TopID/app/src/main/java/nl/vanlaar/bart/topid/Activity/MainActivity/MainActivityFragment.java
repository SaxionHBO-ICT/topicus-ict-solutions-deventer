package nl.vanlaar.bart.topid.Activity.MainActivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.IdeeënAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ArrayList<Idee> ideeën = IdeeënLijst.getIdeeënLijst();

    public MainActivityFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lvIdeeën = (ListView) view.findViewById(R.id.lvIdeeën);

        IdeeënAdapter adapter = new IdeeënAdapter(getContext(),R.layout.fragment_main, ideeën);
        lvIdeeën.setAdapter(adapter);
        return  view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
}
