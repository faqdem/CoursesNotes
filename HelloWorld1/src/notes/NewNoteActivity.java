package notes;

import android.app.Activity;
import android.os.Bundle;
import com.example.helloworld1.R;

/**
 * Created by student on 5/8/14.
 */
public class NewNoteActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newnote);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.newnote_layout, new Fragment_NewNote()).commit();

        }


    }


}