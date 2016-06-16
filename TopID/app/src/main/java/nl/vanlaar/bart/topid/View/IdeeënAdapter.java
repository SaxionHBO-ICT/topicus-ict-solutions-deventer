package nl.vanlaar.bart.topid.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.R;

/**
 * De adapter voor ideeën
 */
public class IdeeënAdapter extends ArrayAdapter<Idee> {
    private Idee idee;

    public IdeeënAdapter(Context context, int resource, ArrayList<Idee> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listlayout, parent, false);
        }

        //koppel views aan ids
        TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSAMENVATINGLISTITEM);
        TextView title = (TextView) convertView.findViewById(R.id.tvNaamListItem);
        TextView posterName = (TextView) convertView.findViewById(R.id.tvPosterName);
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivImageListItem);

        idee = getItem(position);
        Log.d("idee", idee.getTitle()
        );
        tvSummary.setText(idee.getSummaryText());
        title.setText(idee.getTitle());
        //als het idee anoniem geplaatst is dan geeft je hem anonieme data mee
        if (idee.getAnonymous()) {
            ivPoster.setImageResource(R.drawable.anoniem);
            posterName.setText("Anoniem");
        } else {
            posterName.setText(idee.getPoster().getName());
            ivPoster.setImageResource(idee.getPoster().getTempImage()); // temp non bitmap image
        }
        return convertView;
    }
}
