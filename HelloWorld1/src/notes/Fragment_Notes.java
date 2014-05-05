package notes;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.example.helloworld1.R;
import com.example.notes.Singleton;

/**
 * Created by student on 4/28/14.
 */
public class Fragment_Notes extends Fragment{
    private static final String TITLE = "Title";
    private static final String DESCRIPTION = "Description";

     ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_notes,null);



        listView=(ListView)v.findViewById(R.id.listView);





        SimpleAdapter listViewAdapter = new SimpleAdapter(getActivity(),
                Singleton.getInstance().getNotesList(), R.layout.list_item,
                new String[] { TITLE, DESCRIPTION }, new int[] { R.id.textViewTitle,
                R.id.textViewContent });
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("List listener", "Hello");
            }
        });

        return v;
    }





}
