package hub.rgpv.com.iTube;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rgpv.com.iTube.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class template_qs_frag_tv extends Fragment {

    String quality,size;


    public template_qs_frag_tv() {



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quality =  getArguments().getString("quality");
        size =  getArguments().getString("size");

        try{

            size = String.format("%.2f",(Float.parseFloat(size ) /1000000) , 2) +" MB";
        }
        catch (Exception e)
        {
            size = "";
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view =  inflater.inflate(R.layout.ll_qs , null);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(quality + "\n" + size);

        return view;
    }
}
