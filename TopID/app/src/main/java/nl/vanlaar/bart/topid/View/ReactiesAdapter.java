package nl.vanlaar.bart.topid.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Comment;
import nl.vanlaar.bart.topid.R;

/**
 * Adapter voor reacties
 */
public class ReactiesAdapter extends ArrayAdapter<Comment> {
    private ArrayList<Comment> comments;


    public ReactiesAdapter(Context context, ArrayList<Comment> objects) {
        super(context, 0,objects);
        comments = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_reaction, parent, false);
        }
        //koppelen views aan ids
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_reaction_gebbruiker_plaatje);
        TextView userName = (TextView) convertView.findViewById(R.id.tv_reaction_gebruiker_naam);
        TextView date = (TextView) convertView.findViewById(R.id.tv_reaction_date);
        TextView reactie = (TextView) convertView.findViewById(R.id.tv_reaction_comment);

        Comment comment = comments.get(position);
        imageView.setImageResource(comment.getUserPicture());
        userName.setText(comment.getUserName());
        date.setText(comment.getDate());
        reactie.setText(comment.getComment());
        return convertView;
    }
}
