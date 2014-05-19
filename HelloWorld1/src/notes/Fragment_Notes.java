package notes;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.helloworld1.R;

/**
 * Created by student on 4/28/14.
 */
public class Fragment_Notes extends Fragment{
    private static final String TITLE = "Title";
    private static final String DESCRIPTION = "Description";

     ListView listView;

    TestAdapter listViewAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_notes,null);



        listView=(ListView)v.findViewById(R.id.listView);





        listViewAdapter = new TestAdapter();
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("List listener", "Hello");
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.i("adapter count:",String.valueOf(listViewAdapter.getCount()));
//        Log.i("List count:", String.valueOf(Singleton.getInstance().getNotesList().size()));
        listViewAdapter.notifyDataSetChanged();
    }
}
