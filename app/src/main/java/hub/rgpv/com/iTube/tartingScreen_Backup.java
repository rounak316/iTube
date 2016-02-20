package hub.rgpv.com.iTube;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.rgpv.com.iTube.R;

public class tartingScreen_Backup extends AppCompatActivity {


    void loadQualitySelector()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.come , R.anim.go).replace(R.id.parent ,new qualitySelector() ).commit();

            }
        }, 100);
    }

    void selectMode()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.come , R.anim.go).replace(R.id.parent ,new selectMode() ).commit();

            }
        }, 100);
    }

    void showLoading()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.come , R.anim.go).replace(R.id.parent ,new tartingScreenFragment() ).commit();

            }
        }, 100);
    }

    void showError()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.come , R.anim.go).replace(R.id.parent ,new failedLoadingData() ).commit();

            }
        }, 100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarting_screen);






    }


    @Override
    protected void onStart() {
        super.onStart();




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadQualitySelector();
            }
        }, 1000);


    }

    void closeActivity()
    {
        finish();

    }

    void back()
    {
        getFragmentManager().popBackStack();

    }


    String AUDIO  = "";
    String VIDEO = "";




}
