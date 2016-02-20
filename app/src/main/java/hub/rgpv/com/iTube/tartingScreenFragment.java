package hub.rgpv.com.iTube;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rgpv.com.iTube.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class tartingScreenFragment extends Fragment {


    tartingScreen activity=null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (tartingScreen) activity;
    }

    public tartingScreenFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view =  inflater.inflate(R.layout.fragment_tarting_screen, container, false);
   View close = view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.closeActivity();

            }
        });
        return  view;
    }
}
