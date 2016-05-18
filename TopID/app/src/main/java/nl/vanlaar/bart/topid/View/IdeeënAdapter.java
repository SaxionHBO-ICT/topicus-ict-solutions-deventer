package nl.vanlaar.bart.topid.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;

/**
 * Created by bart on 18-5-2016.
 */
public class IdeeënAdapter extends ArrayAdapter<Idee> {
    private ArrayList<Idee> ideeën = IdeeënLijst.getIdeeënLijst();

    public IdeeënAdapter(Context context, int resource, int textViewResourceId, ArrayList<Idee> objects) {
        super(context, resource, textViewResourceId, objects);
        objects = ideeën;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
           // convertView = LayoutInflater.from(getContext()).inflate()
        }
        return  convertView;
    }
}
