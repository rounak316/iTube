package hub.rgpv.com.iTube;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rgpv.com.iTube.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class failedLoadingData extends Fragment {

    public failedLoadingData() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.failedrag, container, false);
    }
}
