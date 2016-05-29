package nl.vanlaar.bart.topid.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import nl.vanlaar.bart.topid.Model.Comment;
import nl.vanlaar.bart.topid.R;

/**
 * Created by bart on 29-5-2016.
 */
public class ReactiesAdapter extends ArrayAdapter<Comment> {

    public ReactiesAdapter(Context context, int resource, int textViewResourceId, Comment[] objects) {
        super(context, resource, textViewResourceId, objects);




    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_reaction, parent, false);
        }
        return convertView;
    }
}
