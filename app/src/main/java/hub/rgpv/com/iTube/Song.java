package hub.rgpv.com.iTube;

/**
 * Created by Prakhar on 19/01/2016.
 */
public class Song {

    String title= "";
    String song_id = "";
    Boolean checked = true;

    public Song( String song_id , String title )
    {
        this.title = title;
        this.song_id = song_id;
    }

    void setChecked(Boolean bool)
    {
        checked = bool;
    }

}
