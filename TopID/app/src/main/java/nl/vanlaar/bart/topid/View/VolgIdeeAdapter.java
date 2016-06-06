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
import nl.vanlaar.bart.topid.R;

/**
 * Created by johan on 6-6-2016.
 */
public class VolgIdeeAdapter extends ArrayAdapter<Idee> {

    public VolgIdeeAdapter(Context context, int resource, ArrayList<Idee> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listlayout, parent, false);
        }
        TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSAMENVATINGLISTITEM);
        TextView title = (TextView) convertView.findViewById(R.id.tvNaamListItem);
        TextView posterName = (TextView) convertView.findViewById(R.id.tvPosterName);
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivImageListItem);


        Idee idee = getItem(position);

        tvSummary.setText(idee.getSummaryText());
        title.setText(idee.getTitle());
        posterName.setText(idee.getPoster().getName());
        ivPoster.setImageResource(idee.getPoster().getProfileImage());

        return convertView;
    }
}