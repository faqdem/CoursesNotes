package notes;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.helloworld1.R;
import com.example.notes.Note;
import com.example.notes.Singleton;

/**
 * Created by student on 5/8/14.
 */
public class Fragment_NewNote extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_newnote,null);
        Button butt = (Button) v.findViewById(R.id.submitnote_button);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.submitnote_button)
                {
                    String title = ((EditText) (getView().findViewById(R.id.newnote_header))).getText().toString();
                    String text = ((EditText) (getView().findViewById(R.id.newnote_text))).getText().toString();

                    Singleton.getInstance().addNote(new Note(title,text));
                    getActivity().finish();
                }
            }
        });
        return v;


    }

}
