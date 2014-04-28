package notes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.helloworld1.R;
import com.example.notes.Note;
import com.example.notes.Singleton;

/**
 * Created by student on 4/28/14.
 */
public class TestAdapter extends BaseAdapter {

    private Context mContext;

    @Override
    public int getCount() {
        return Singleton.getInstance().getNotesList().size();
    }

    @Override
    public Note getItem(int i) {
        return Singleton.getInstance().getNotes().get(i);
    }

    @Override
    public long getItemId(int i) {
        return Singleton.getInstance().getNotes().get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = View.inflate(mContext, R.layout.list_item, viewGroup);
        }
        Holder holder = (Holder)view.getTag();
        if(holder == null) {
            holder = new Holder();
            holder.tvTitle = (TextView) view.findViewById(R.id.textViewTitle);
            holder.tvDescription = (TextView) view.findViewById(R.id.textViewContent);
            holder.btnDelete = (Button) view.findViewById(R.id.login_button);
            view.setTag(holder);
        }
        holder.tvTitle.setText(getItem(i).getTitle());
        return null;
    }


    public static class Holder {
        public TextView tvTitle;
        public TextView tvDescription;
        public Button btnDelete;
    }



}
