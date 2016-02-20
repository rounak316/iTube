package hub.rgpv.com.iTube;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.rgpv.com.iTube.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class selectMode extends Fragment {


    tartingScreen act;

    void animate_close(View[] ids , int pos)
    {

        for(int i=0;i<ids.length;i++) {
            View view = ids[i];
            view.startAnimation(AnimationUtils.loadAnimation(getActivity() , R.anim.goicons ));
        }

        act.loadQualitySelector(pos);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        act = (tartingScreen) activity;
    }

    public selectMode() {
    }
View a , av , v;
    View A , AV , V;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.selectmode, container, false);

        View close = view.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                act.closeActivity();

            }
        });

       a = view.findViewById(R.id.logo1);
        av =view.findViewById(R.id.logo2);
                v= view.findViewById(R.id.logo3);


        A = view.findViewById(R.id.aud);
        AV =view.findViewById(R.id.vid);
        V= view.findViewById(R.id.av);


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {

                View[] ids = new View[]{ av, v, AV , V };

                animate_close(ids , 0);




            }
        });

        av.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {

                View[] ids = new View[]{ a, v, A , V };

                animate_close(ids ,1);

            }
        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {

                View[] ids = new View[]{ av, a, AV ,A };

                animate_close(ids , 2);

            }
        });

        return view;


    }
}
