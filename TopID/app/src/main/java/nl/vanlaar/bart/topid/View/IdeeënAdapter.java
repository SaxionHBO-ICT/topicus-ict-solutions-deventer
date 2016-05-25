package nl.vanlaar.bart.topid.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.R;

/**
 * Created by bart on 18-5-2016.
 */
public class IdeeënAdapter extends ArrayAdapter<Idee> {
    private ArrayList<Idee> ideeën = IdeeënLijst.getIdeeënLijst();

    public IdeeënAdapter(Context context, int resource, ArrayList<Idee> objects) {
        super(context, resource,objects);
        objects = ideeën;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listlayout,parent,false);
        }
        TextView naamListItem = (TextView) convertView.findViewById(R.id.tvNaamListItem);
        TextView samenvattingListItem = (TextView) convertView.findViewById(R.id.tvSAMENVATINGLISTITEM);
        TextView postDate = (TextView) convertView.findViewById(R.id.tvPostDate);
        ImageView image = (ImageView) convertView.findViewById(R.id.ivImageListItem);

        Idee idee = getItem(position);
        naamListItem.setText("Meer fietsen naar het werk");
        samenvattingListItem.setText("meer mensen zouden op de fiets moeten dat is veel beter.......");
        postDate.setText("23 april");
        image.setImageResource(R.drawable.trollface);
        return  convertView;
    }
}
