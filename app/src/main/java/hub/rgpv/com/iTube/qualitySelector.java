package hub.rgpv.com.iTube;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rgpv.com.iTube.R;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class qualitySelector extends Fragment implements View.OnClickListener {


    @Override
    public void onClick(View vi) {

int a = -1;
        int v= -1;

        if(A.size() > 0)

       a =     vp_au.getCurrentItem();
        if(V.size() > 0)
          v=   vp_vi.getCurrentItem();


        activity.startServing( v , a );

        Log.d("VPVP" , "" + vp_au.getCurrentItem() + " __ " + vp_vi.getCurrentItem());


    }



    class Adapter extends FragmentStatePagerAdapter
    {


        ArrayList< String> List, listS;

        public Adapter(FragmentManager fm, ArrayList< String> list ,ArrayList< String> listS ) {
            super(fm);
            List = new ArrayList<>(list);
            this.listS = new ArrayList<>(listS);
        }

        @Override
        public Fragment getItem(int position) {


Fragment frag =new template_qs_frag_tv();
            Bundle bundle = new Bundle();
            bundle.putString("quality" , List.get(position));
            bundle.putString("size" , listS.get(position));


            frag.setArguments(bundle);

            return frag;
        }

        @Override
        public int getCount() {
            return List.size();
        }
    }



    public qualitySelector() {
    }


tartingScreen activity;
ArrayList<String> A , V, AS , VS;
    VP vp_au , vp_vi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     A =    getArguments().getStringArrayList("A");
      V =  getArguments().getStringArrayList("V");
        AS =    getArguments().getStringArrayList("AS");
        VS =  getArguments().getStringArrayList("VS");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.activity = (tartingScreen) activity;
    }
View close;
    View _l ,_r , _L , _R;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.qualityfinalfrag, container, false);


  _l = view.findViewById(R.id.left2);
        _r = view.findViewById(R.id.right2);
        _L = view.findViewById(R.id.left);
        _R = view.findViewById(R.id.right);


        _l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_vi.setCurrentItem(  vp_vi.getCurrentItem() - 1 );

            }
        });
        _r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_vi.setCurrentItem(  vp_vi.getCurrentItem() + 1 );

            }
        });

        _L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_au.setCurrentItem(  vp_au.getCurrentItem() - 1 );

            }
        });

        _R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_au.setCurrentItem(  vp_au.getCurrentItem() + 1 );

            }
        });



        View      close = view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        activity.closeActivity();

    }
});



      View AU =   view.findViewById(R.id.AU);
      View VI =   view.findViewById(R.id.VI);

  View download =       view.findViewById(R.id.download);
        View download_t =      view.findViewById(R.id.download_t);

if(A.size() <=0)
    AU.setVisibility(View.GONE);
        if(V.size() <=0)
            VI.setVisibility(View.GONE);

        vp_au = (VP) view.findViewById(R.id.vp);
        vp_vi = (VP) view.findViewById(R.id.vp2);
        vp_au.setFadingEdgeLength(0);
        vp_vi.setFadingEdgeLength(0);



        vp_au.setAdapter(new Adapter(getFragmentManager() , A , AS));

        vp_vi.setAdapter(new Adapter(getFragmentManager() , V , VS));

        download.setOnClickListener(this);
        download_t.setOnClickListener(this);
        return view;


    }
}
