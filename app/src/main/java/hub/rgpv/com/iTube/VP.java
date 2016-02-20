package hub.rgpv.com.iTube;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by prakhar on 2/13/2016.
 */
public class VP extends android.support.v4.view.ViewPager
{

    public VP(Context context) {
        super(context);
    }

    public VP(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void transformPage(View view, float position) {
        view.setTranslationX(view.getWidth() * -position);

        if(position <= -1.0F || position >= 1.0F) {
            view.setAlpha(0.0F);
        } else if( position == 0.0F ) {
            view.setAlpha(1.0F);
        } else {
            // position is between -1.0F & 0.0F OR 0.0F & 1.0F
            view.setAlpha(1.0F - Math.abs(position));
        }
    }
}