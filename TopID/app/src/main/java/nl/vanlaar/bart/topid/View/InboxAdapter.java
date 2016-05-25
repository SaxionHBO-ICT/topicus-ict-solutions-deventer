package nl.vanlaar.bart.topid.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nl.vanlaar.bart.topid.Model.Comment;
import nl.vanlaar.bart.topid.Model.CommentList;
import nl.vanlaar.bart.topid.R;

/**
 * Created by Sander on 25-5-2016.
 */
public class InboxAdapter extends ArrayAdapter<Comment> {

    public InboxAdapter(Context context) {
        super(context, 0, CommentList.getInstance().getComments());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_inbox, parent, false);
        }
        TextView inboxMessage = (TextView) convertView.findViewById(R.id.tv_inbox_message);
        TextView inboxComment = (TextView) convertView.findViewById(R.id.tv_inbox_comment);
        ImageView inboxUserImage = (ImageView) convertView.findViewById(R.id.iv_inbox_user);

        Comment comment = getItem(position);
        inboxMessage.setText(comment.getUserName() + " reageerde op je post:  " + comment.getIdeeName());
        inboxComment.setText(comment.getComment());
        inboxUserImage.setImageResource(comment.getUserPicture());

        return convertView;
    }
}
