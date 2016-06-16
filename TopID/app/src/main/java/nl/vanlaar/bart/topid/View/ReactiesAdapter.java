package nl.vanlaar.bart.topid.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nl.vanlaar.bart.topid.Model.Comment;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.R;

/**
 * Adapter voor reacties
 */
public class ReactiesAdapter extends ArrayAdapter<Comment> {

    public ReactiesAdapter(Context context, int ideePositie) {
        super(context, 0, IdeeënLijst.getInstance().getIdeeën().get(ideePositie).getComments());
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

        Comment comment = getItem(position);
        imageView.setImageResource(comment.getUserPicture());
        userName.setText(comment.getUserName());
        date.setText(comment.getDate());
        reactie.setText(comment.getComment());
        return convertView;
    }
}
