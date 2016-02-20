package hub.rgpv.com.iTube;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


import com.coremedia.iso.boxes.Container;

import com.googlecode.mp4parser.authoring.Movie;

import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;

import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.rgpv.com.iTube.R;


import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;

import java.util.ArrayList;




/**
 * Created by Prakhar on 17/01/2016.
 */public class Downloader extends Service {

    private NotificationManager notificationManager;
    private NotificationCompat.Builder mBuilder;

    void notificationFinish()
    {

        if(notificationManager!=null)
            notificationManager.cancel(1);

    }

    void Notification(String TITLE)
    {

        if(notificationManager!=null)

            notificationManager.cancel(1);


else
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        mBuilder = new NotificationCompat.Builder(this)
                .setAutoCancel(false)
                .setOngoing(true)
                .setContentTitle("" +TITLE)

                .setContentText("Starting Download Service")
                .setSubText("Please wait")


                .setSmallIcon(R.mipmap.ic_launcher);


        notificationManager.notify(1, mBuilder.build());

    }
int progress_prev = -1 ;
    void updateProgress(int progress , int outOf)
    {

        if(progress_prev == progress) {

            return;

        }
        progress_prev = progress;
        mBuilder.setSubText("Enqueued : " + Links.size() + "");
        mBuilder.setContentText("Downloading " + progress + "%");
mBuilder.setProgress(outOf, progress , false);
        notificationManager.notify(1, mBuilder.build());

    }
    void downloadCompleted(String file , String TITLE)
    {

        Log.d("Donload complet  not " , "ID " + file);

        String mimeType = file.substring(file.lastIndexOf(".")  );
        Log.d("TITLE" , file + " " + mimeType);
        if(mimeType.contains("mp4"))
            mimeType = "video/*";
        else if(mimeType.contains("mp3"))
            mimeType = "audio/*";
        else
            mimeType = "video/*";


Log.d("TITLE" , file + " " + mimeType + " " + TITLE);

        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile( new File(file )),mimeType);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent  pendingIntent= PendingIntent.getActivity(this , 0 , intent , 0);


        NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(this)


                .setContentTitle("" + TITLE)
//                .setOngoing(true)
//                .setAutoCancel(false)

                .setContentText("Download Completed")
                .setSubText("Click here to open")


                .setContentIntent(pendingIntent)

                .setSmallIcon(R.mipmap.ic_launcher);






        notificationManager.notify(app.notification_id++, mBuilder2.build());



    }

    void downloadFailed(String TITLE)
    {




        NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(this)


                .setContentTitle("" + TITLE)

                .setContentText("Download Failed")
                .setSubText("Make sure you have proper Internet connectivity")




                .setSmallIcon(R.mipmap.ic_launcher);






        notificationManager.notify(app.notification_id++, mBuilder2.build());



    }
    void setSyncing()
    {
        mBuilder.setContentText("Processing Video" );
        mBuilder.setSubText("Please wait");

        mBuilder.setProgress(100 , 100 , true);
        notificationManager.notify(1, mBuilder.build());

    }


    enum Codec_Type
    {
        AUDIO, VIDEO , AV, None
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class CodecLinks
    {
        String AUDIO = null;
        String VIDEO=null;
        String TITLE = "";

        public CodecLinks(@Nullable String VIDEO , @Nullable String AUDIO , @Nullable String TITLE)
        {
            this.AUDIO = AUDIO;
            this.VIDEO = VIDEO;
            this.TITLE = TITLE;
        }

    }

    ArrayList<CodecLinks> Links;


    boolean FIRST;



    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("create" , "OnCreated " + app.notification_id);
        if(app.notification_id==-1)
            app.notification_id = 2;


        Links = new ArrayList<>();
        FIRST = true;




    }

    String  CombineIt(Codec_Type type , String vid, String aud , String outputGileName) throws IOException {
        if(type == Codec_Type.AUDIO)
        {

            File fileToCopy = new File(aud);
            File newFile = new File(outputGileName);

            FileUtils.copyFile(fileToCopy, newFile);



        }
        else if(type == Codec_Type.VIDEO)
        {



            File fileToCopy = new File(vid);
            File newFile = new File(outputGileName);

            FileUtils.copyFile(fileToCopy, newFile);




        }
        else
        {
            Movie video = MovieCreator.build(vid);
            Movie audio = MovieCreator.build(aud);
            Movie av = new Movie();
            av.addTrack(  audio.getTracks().get(0) );
            av.addTrack(video.getTracks().get(0)  );
Log.d("baba bc " ,av.getTracks().get(0).getHandler() + " " + av.getTracks().get(1).getHandler()  );
            Container mp4file = new DefaultMp4Builder().build(av);
            FileChannel fc = new FileOutputStream(new File( outputGileName )).getChannel();
            mp4file.writeContainer(fc);
            fc.close();
        }

return outputGileName;



    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("create" , "onStart");
        String AUDIO = null, VIDEO = null,TITLE = null;
        try {
             AUDIO = intent.getStringExtra("AUDIO");
             VIDEO = intent.getStringExtra("VIDEO");
            TITLE = intent.getStringExtra("TITLE");
        }
        catch ( Exception e)
        {
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }

        Log.d("STATUS LINKS AUDIO" ,AUDIO + "")  ;
        Log.d("STATUS LINKS  VIDEO" ,VIDEO + "") ;


        if(Links != null) {
            Links.add(new CodecLinks(VIDEO, AUDIO , TITLE));
            Log.d("create " , "onStart " + Links.size());

        }

        if(FIRST)
        {
            FIRST = false;

        }
        else
            return super.onStartCommand(intent, flags, startId);

new Thread(new Runnable() {
    @Override
    public void run() {



        for(int i=0; i<Links.size() ;)
        {
            progress_prev = -1 ;
            String TITLE =  Links.get(i).TITLE;

            Notification( TITLE );

            CodecLinks Codec = Links.get(i);

            try {
              String OUTPUT =  DownloadFile(Codec);

                downloadCompleted( OUTPUT ,  TITLE  );

                Log.d("STATUS " , "SUCCESS  " + TITLE );
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("STATUS " , "CATCH  " +e );
                downloadFailed(TITLE);
            }





            Links.remove(0);
        }

        notificationFinish();
        stopSelf();

    }
}).start();












        return super.onStartCommand(intent, flags, startId);
    }


    String  DownloadFile( CodecLinks Codec) throws IOException {

        String outputFile= "" + Codec.TITLE;

        char[] path =  outputFile.toCharArray();

        Log.d("boomarang" , "-> " + outputFile);





        for(int i=0;i<path.length;i++)
        {


            if (! ((path[i] >= 48 && path[i] <= 57) || ( path[i]>=97 && path[i]<=122 ) || ( path[i]>=65 && path[i]<=90 )) )
            {

                path[i] = ' ';

            }






        }


            outputFile= String.valueOf( path);





        boolean A = false, V = false;


        if(Codec.AUDIO.length() >= 1 )
            A = true;
        if(Codec.VIDEO.length() >= 1 )
            V = true;

        Codec_Type type;
        if(A && V) {
            type = Codec_Type.AV;
            outputFile+= ".mp4";

        }
        else {
            if(A ) {
                type = Codec_Type.AUDIO;
                outputFile+= ".mp3";

            }

            else if(V ) {
                type = Codec_Type.VIDEO;
                outputFile+= ".mp4";

            }
            else {
                type = Codec_Type.None;
                outputFile += ".mp4";
            }

        }


Log.d("URLOfDOWNOADVIDEO" , Codec.VIDEO);

        Log.d("URLOfDOWNOADAUDIO" , Codec.AUDIO);

        Log.d("STATIS " , " " + type + " " + outputFile);

        if(  (Codec.AUDIO.length() >= 1 ) )
         {



            URL url = new URL(Codec.AUDIO);
            URLConnection connection = url.openConnection();
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            int fileLength = connection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output = new FileOutputStream( Environment.getExternalStorageDirectory() + "/temp_audio.mp3" );

            byte data[] = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                Bundle resultData = new Bundle();
                resultData.putInt("progress" ,(int) (total * 100 / fileLength));
                output.write(data , 0 , count);



                if(type == Codec_Type.AUDIO)
                {

                    updateProgress( (int) (total * 100 / fileLength) , 100);


                }
                else if(type == Codec_Type.VIDEO)
                {
                    updateProgress( (int) (total * 0 / fileLength) , 100);


                }
                else  if(type == Codec_Type.AV)
                {
                    updateProgress( (int) (total * 50 / fileLength) , 100);

                }

//                Log.d("create " , "write  " +total + "/" +fileLength );

//                    output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        }
        if( (Codec.VIDEO.length() >= 1 ) )
        {


            URL url = new URL(Codec.VIDEO);
            URLConnection connection = url.openConnection();
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            int fileLength = connection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output = new FileOutputStream( Environment.getExternalStorageDirectory() + "/temp_video.mp4" );

            byte data[] = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....


                output.write(data , 0 , count);
//                output.write(data);

                Log.d("create " , "write  " +total + "/" +fileLength );
                if(type == Codec_Type.AUDIO)
                {

                    updateProgress( (int) (total * 0 / fileLength) , 100);


                }
                else if(type == Codec_Type.VIDEO)
                {
                    updateProgress( (int) (total * 100 / fileLength) , 100);


                }
                else  if(type == Codec_Type.AV)
                {

                    updateProgress( 50 +(int) (total * 50 / fileLength) , 100 );


                }

            }

            output.flush();
            output.close();
            input.close();
        }


        Log.d("STATIS " , " " + type + " " + outputFile);

        setSyncing();


        String OUTPUT =   CombineIt( type ,Environment.getExternalStorageDirectory() + "/temp_video.mp4" , Environment.getExternalStorageDirectory() + "/temp_audio.mp3" ,   Environment.getExternalStorageDirectory() + "/" + outputFile );
return  OUTPUT;


    }
}