package hub.rgpv.com.iTube;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.animation.AnimationUtils;

import android.widget.TextView;

import com.rgpv.com.iTube.R;

import org.json.JSONObject;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tartingScreen extends AppCompatActivity {





void startServing(int v , int a)
{

    Intent intent = new Intent(tartingScreen.this, Downloader.class);



    intent.putExtra("AUDIO", ( (a>=0)   ? SongList_AUDIO.get(a).get("encoded_url") : ""));
    intent.putExtra("VIDEO", "" + ( (v>=0)   ? SongList_VIDEO.get(v).get("encoded_url") : ""));
    intent.putExtra("TITLE", "" + title);

    startService(intent);
    finish();


}

    void loadQualitySelector(final int pos)
    {


                Fragment frag = new qualitySelector();
                Bundle bun = new Bundle();
                if(pos==0 || pos==1) {
                    bun.putStringArrayList("A", SongList_AUDIO_Q);

                    bun.putStringArrayList("AS", SongList_AUDIO_Q_S);
                }
                else {
                    bun.putStringArrayList("A", new ArrayList<String>());
                    bun.putStringArrayList("AS", new ArrayList<String>());

                }
                if(pos==1 || pos== 2) {
                    bun.putStringArrayList("V", SongList_VIDEO_Q);
                    bun.putStringArrayList("VS", SongList_VIDEO_Q_S);
                }
                else {
                    bun.putStringArrayList("V", new ArrayList<String>());

                    bun.putStringArrayList("VS", new ArrayList<String>());

                }
                frag.setArguments(bun);



                getSupportFragmentManager().beginTransaction().addToBackStack("quality").setCustomAnimations(R.anim.come , R.anim.go).replace(R.id.parent ,frag ).commit();


    }

    void selectMode()
    {

                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.come , R.anim.go).replace(R.id.parent ,new selectMode() ).commit();


    }

    void showLoading()
    {

                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.come , R.anim.go).replace(R.id.parent ,new tartingScreenFragment() ).commit();


    }

    void showError()
    {

                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.come , R.anim.go).replace(R.id.parent ,new failedLoadingData() ).commit();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarting_screen);
TITLE = (TextView) findViewById(R.id.title);

     init();



    }


    @Override
    protected void onStart() {
        super.onStart();




    }

    void closeActivity()
    {



        finish();


    }

    void back()
    {
        getFragmentManager().popBackStack();

    }




    String PASSING_AUDIO = "";
    String PASSING_VIDEO = "";


    private ArrayList<Map<String, String>> SongList = new ArrayList<>();

    private ArrayList<Map<String, String>> SongList_AUDIO = new ArrayList<>();

    private ArrayList<Map<String, String>> SongList_VIDEO = new ArrayList<>();


    private ArrayList<String> SongList_AUDIO_Q = new ArrayList<>();

    private ArrayList<String>  SongList_VIDEO_Q = new ArrayList<>();
    private ArrayList<String> SongList_AUDIO_Q_S = new ArrayList<>();

    private ArrayList<String>  SongList_VIDEO_Q_S = new ArrayList<>();
TextView TITLE;

    void init() {


            Intent intent = getIntent();

            String action = intent.getAction();
            String type = intent.getType();


            String sharedText ="";
            if (Intent.ACTION_SEND.equals(action) && type != null) {
                if ("text/plain".equals(type)) {

                    sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                    if (sharedText != null) {
                        // Update UI to reflect text being shared


                    }
                    else
                    {
                        sharedText = "https://www.youtube.com/watch?v=-Yu_2nyOP5o";



                    }


                }else {
                    sharedText = "https://www.youtube.com/watch?v=-Yu_2nyOP5o";

                }
            }
else
            {
                sharedText = "https://www.youtube.com/watch?v=-Yu_2nyOP5o";

            }







            new parsePage(sharedText).execute();





    }

    class parsePage extends AsyncTask<String, String, String> {

        String url;

        public parsePage(String url) {
            this.url = url;
            songs = new ArrayList<Song>();
//            songs.add(new Song("0" ,"Download All"));
        }

        private String readStream(InputStream in) {
            BufferedReader reader = null;
            StringBuffer response = new StringBuffer();
            try {
                reader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    response.append(line);
//                    Log.d("body" ,line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return response.toString();
        }

        ArrayList<Song> songs;
        Boolean success = false;

        @Override
        protected String doInBackground(String... params) {

            SongList = new ArrayList<>();

      SongList_AUDIO = new ArrayList<>();

           SongList_VIDEO = new ArrayList<>();
            SongList_AUDIO_Q = new ArrayList<>();

 SongList_VIDEO_Q = new ArrayList<>();
            SongList_AUDIO_Q_S = new ArrayList<>();
            SongList_VIDEO_Q_S = new ArrayList<>();



            Log.d("ADADA", "DS");
            String Data = "";
            URL url = null;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(this.url);

                urlConnection = (HttpURLConnection) url

                        .openConnection();
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.103 Safari/537.36");


                InputStream in = urlConnection.getInputStream();


                Data = readStream(in);



            } catch (Exception e) {
                e.printStackTrace();
                Log.d("baba", "error" + e);
                DESCODE_FINAL = "";

            } finally {//
                urlConnection.disconnect();
                Log.d("baba", "DSADSA" + Data + " " + url);
                try {
                    SongList = parseShared(Data);

                    for( Map<String, String> a : SongList)
                    {

                      if (    a.containsKey("CODEC") )
                        {

                          if (  a.get("CODEC").equals("AUDIO") ) {
                              SongList_AUDIO.add(a);

                              String quality =  a.get("quality");
                              quality = quality.   substring( 0 , quality.length() - 3 ) + "Kbps";



                              SongList_AUDIO_Q.add( (quality) );

                              SongList_AUDIO_Q_S.add(a.get("clen"));

                          }
                            else {
                              SongList_VIDEO.add(a);

                          String quality =  a.get("quality");

                              SongList_VIDEO_Q.add(  quality);

                              SongList_VIDEO_Q_S.add(a.get("clen"));

                          }







                        }

                    }
                    success = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    success = false;
                }

            }

            return Data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);



            TITLE.setText(title);
            TITLE.startAnimation(AnimationUtils.loadAnimation(tartingScreen.this , R.anim.come));


            if(isDestroyed())
                return;

            if(!success)
                showError();
            else
                selectMode();




        }



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showLoading();
        }
    }

    ArrayList<Map<String, String>> DATAS_MAIN;

    public static Map<String, List<String>> splitQuery(String url) throws UnsupportedEncodingException, UnsupportedEncodingException {
        final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
        final String[] pairs = url.split("&");
        for (String pair : pairs) {
            final int idx = pair.indexOf("=");
            final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
            if (!query_pairs.containsKey(key)) {
                query_pairs.put(key, new LinkedList<String>());
            }
            final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
            query_pairs.get(key).add(value);
        }
        return query_pairs;
    }

    ArrayList<Map<String, String>> parseShared(String text) throws Exception {


        String tmp = "ytplayer.config =";

        int pos1 = text.indexOf(tmp) + tmp.length();


        int pos2 = text.indexOf(";ytplayer.load", pos1);

        String jsonData = text.substring(pos1, pos2);
        Log.d("result", jsonData);

        try {
            JSONObject obj = new JSONObject(jsonData);
            JSONObject base_script_obj = obj.getJSONObject("assets");
            String base = base_script_obj.getString("js");


//       String tmp_base =      getSharedPreferences("db",1).getString("base" , null);
//
//
//            if(tmp_base.equals(base))
//            {
//
//
//
//            }


            if(base==null || base.length()<1 )

            {
                throw new Exception();
            }

            base = "https:" + base;

            DESCODE_FINAL = getCodeDecryptor(base);
            Log.d("bombard" , DESCODE_FINAL);
            JSONObject obj2 = obj.getJSONObject("args");
            title = obj2.getString("title");
            String adaptive_fmts = obj2.getString("adaptive_fmts");
            String url_encoded_fmt_stream_map = obj2.getString("url_encoded_fmt_stream_map");
            String[] video_audio = url_encoded_fmt_stream_map.split(",");
            ArrayList<Map<String, List<String>>> mappers = new ArrayList<>();
            DATAS_MAIN = new ArrayList<>();
            Map<String, List<String>> bumchick;
            for (int i = 0; i < video_audio.length; i++) {
                bumchick = splitQuery((video_audio[i]));
                ArrayList<String> temp = new ArrayList<>();
                temp.add("COMBO");
                bumchick.put("TYPE", temp);
            }
            video_audio = adaptive_fmts.split(",");
            for (int i = 0; i < video_audio.length; i++) {
                bumchick = splitQuery((video_audio[i]));
                ArrayList<String> temp = new ArrayList<>();
                temp.add("INDI");
                bumchick.put("TYPE", temp);
                mappers.add(bumchick);
            }

            for (Map<String, List<String>> tmpo : mappers) {
                HashMap<String, String> bombard = new HashMap<>();
                String key = "itag";
                String value = "";
                if (tmpo.containsKey("itag"))
                    value = tmpo.get("itag").get(0);
                else
                    value = "";
                bombard.put(key, value);

                key = "url";
                if (tmpo.containsKey("url"))
                    value = tmpo.get("url").get(0);
                else
                    value = "";
                bombard.put(key, value);


                key = "sig";
                if (tmpo.containsKey("sig"))
                    value = tmpo.get("sig").get(0);
                else
                    value = "";
                bombard.put(key, value);

                key = "clen";
                if (tmpo.containsKey(key))
                    value = tmpo.get(key).get(0);
                else
                    value = "";
                bombard.put(key, value);


                key = "s";
                if (tmpo.containsKey("s"))
                    value = tmpo.get("s").get(0);

                else
                    value = "";
                bombard.put(key, value);
                String signature = decpher(value);
                bombard.put("signature", signature);
                bombard.put("encoded_url", bombard.get("url") + "&signature=" + signature);

                key = "quality";
                if (tmpo.containsKey("quality"))
                    value = tmpo.get("quality").get(0);
                else {
                    value = "";

                    if (tmpo.containsKey("quality_label")) {
                        value = tmpo.get("quality_label").get(0);
                    } else {
                        if (tmpo.containsKey("bitrate")) {
                            try {
                                value = "" + (Long.parseLong(tmpo.get("bitrate").get(0)));
                            } catch (Exception e) {

                            }
                        }

                    }

                }
                bombard.put(key, value);

                key = "type";
                if (tmpo.containsKey("type")) {
                    value = tmpo.get("type").get(0);
                    value = value.split(";")[0];
                    bombard.put(key, value);
                    String[] TYPE_DEF = value.split("/");
                    if (!TYPE_DEF[1].trim().toLowerCase().equals("mp4"))
                        continue;
                    ;


                    if (TYPE_DEF[0].contains("video")) {

                        String chk = tmpo.get("TYPE").get(0);

                        if (chk.equals("COMBO")) {

                            // Combo AV

                            bombard.put("CODEC", "AUDIO/VIDEO");


                        } else {
                            bombard.put("CODEC", "VIDEO");

                            //Only Video

                        }


                    } else if (TYPE_DEF[0].contains("audio")) {

                        String chk = tmpo.get("TYPE").get(0);

                        bombard.put("CODEC", "AUDIO");


                    } else {


                    }


                } else {
                    value = "";
                    bombard.put(key, value);

                }


                key = "mime";
                if (tmpo.containsKey("mime"))
                    value = tmpo.get("mime").get(0);
                else
                    value = "";
                bombard.put(key, value);
                key = "container";
                if (tmpo.containsKey("container"))
                    value = tmpo.get("container").get(0);
                else
                    value = "";
                bombard.put(key, value);
                DATAS_MAIN.add(bombard);
            }

            Log.d("result", adaptive_fmts + "");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("result", "Catch 0 + e " + e);
            throw new Exception();
        }


        if(DATAS_MAIN.size()<=0)
            throw  new Exception();

        return DATAS_MAIN;
    }


    String decpher(String str) {

        String decided = codeExec(DESCODE_FINAL, fun_name, str);
        return decided;

    }

    String tr(String str) {
        ArrayList<String> a = new ArrayList<String>((Arrays.asList(str.split(""))));
        a.remove(0);
        a = vY(a, 1);
        a = Ey(a, 41);
        a = vY(a, 3);
        a = W9(a, 69);
        a = Ey(a, 29);
        a = vY(a, 3);
        a = W9(a, 53);
        String out = "";
        for (String s : a) {
            out += s;

        }

        return out;


    }

    ArrayList<String> vY(ArrayList<String> list, int pos) {
        for (int i = 0; i < pos; i++)
            list.remove(0);
        return list;


    }

    ArrayList<String> W9(ArrayList<String> list, int pos) {

        String c = list.get(0);

        list.set(0, list.get(pos % list.size()));

        list.set(pos, c);

        return list;


    }

    ArrayList<String> Ey(ArrayList<String> boom, int pos) {

        Collections.reverse(boom);
        return boom;


    }

    String title = "";

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
//                    Log.d("body" ,line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

    ArrayList<String> DecFinder = new ArrayList<>();

    ArrayList<String> ObjectFinder(String line) {

        String pattern = "([\\w]*)\\.([\\w]*[^\\(]*)(\\([^\\)]*\\))";

//        pattern +="|";
//        pattern += ;


        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);


        // Now create matcher object.
        Matcher m = r.matcher(line);

        ArrayList<String> str = new ArrayList<>();
        int cnt = 0;
        while (m.find()) {
            String shakalawa = m.group(2) + m.group(3);

            DecFinder.add("\n" + shakalawa + ";");
            String s = m.group(2);

            str.add(s);
            // s now contains "BAR"
            System.out.print(s);
        }


        str.remove(0);
        str.remove(str.size() - 1);
        DecFinder.remove(0);
        DecFinder.remove(DecFinder.size() - 1);


        return str;

    }

    String FunctionFinder(String name, String line) {

        String pattern = "[\\s]*" + name + "[\\s]*:[\\s]*function[^\\(]*\\([^)]*\\)[^\\{]*\\{[^\\}]*\\}";

        Pattern r = Pattern.compile(pattern);


        Matcher m = r.matcher(line);
        boolean  find =  m.find();
        Log.d("debug3"  , pattern+" "+ find);


        String s = m.group();

        s = s.replace(":", "=");


        System.out.print(s);

        return s;


    }

    String fun_name = "";
    String DESCODE_FINAL = "";
    String paramters = "";

    String codeExec(String code, String funName, String param) {


        Object[] params = new Object[]{"" + param};
        org.mozilla.javascript.Context rhino = org.mozilla.javascript.Context.enter();
        rhino.setOptimizationLevel(-1);
        Scriptable scope = rhino.initStandardObjects();
        rhino.evaluateString(scope, code, "JavaScript", 1, null);
        Object obj = scope.get(funName, scope);
        if (obj instanceof Function) {
            Function jsFunction = (Function) obj;
            Object jsResult = jsFunction.call(rhino, scope, scope, params);
            String result = org.mozilla.javascript.Context.toString(jsResult);


            return result;

        } else {

            return "";
        }
    }

    String getCodeDecryptor(String address) throws Exception {

        SharedPreferences sp = getSharedPreferences("db", 1);

       String sp_base =  sp.getString(address,   null);
        SharedPreferences.Editor editor =   sp.edit();

Log.d("address " , sp_base +"" );

        if(sp_base == null)
        {
            editor.clear().commit();


            URL url = null;
            try {
                url = new URL(address);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "";
            }

            HttpURLConnection urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) url

                        .openConnection();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.103 Safari/537.36");


            InputStream in = null;
            try {
                in = urlConnection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }

            String Data = readStream(in);

            editor.putString(address , Data).commit();

            String line = Data;
            String pattern = ".sig\\|\\|(\\w+)\\(\\w+.\\w+\\)";

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            while (m.find()) {
                String s = m.group(1);
                fun_name = s;
                System.out.print(s);
            }
            pattern = fun_name + "=function\\((\\w+)\\)[^\\{]*\\{" + "([^\\}]*)";
            pattern += "|";
            pattern += fun_name + ":function\\((\\w+)\\)[^\\{]*\\{" + "([^\\}]*)";
            r = Pattern.compile(pattern);
            m = r.matcher(line);
            String FUNCTION = "";
            m.find();
            {
                FUNCTION += fun_name + " = function ( " + m.group(1) + " )\n{";
                String s = m.group(2);
                paramters = m.group(1);
                ArrayList<String> boom = ObjectFinder(s);
                for (String sr : boom)
                    FUNCTION += "\n" + FunctionFinder(sr, line) + ";\n";

                FUNCTION += paramters + "=" + paramters + ".split('')\n";
                for (String ar : DecFinder)
                    FUNCTION += "" + ar + "";

                FUNCTION += "\n" + paramters + "=" + paramters + ".join(\"\")\n";
                FUNCTION += "return " + paramters + ";";
                FUNCTION += "\n}";

            }
            return FUNCTION;

        }
        else
        {
            editor.commit();


            String Data = sp_base;
            String line = Data;
            String pattern = ".sig\\|\\|(\\w+)\\(\\w+.\\w+\\)";

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            while (m.find()) {
                String s = m.group(1);
                fun_name = s;
                System.out.print(s);
            }
            Log.d("debug1" , fun_name);
            pattern = fun_name + "=function\\((\\w+)\\)[^\\{]*\\{" + "([^\\}]*)";
            pattern += "|";
            pattern += fun_name + ":function\\((\\w+)\\)[^\\{]*\\{" + "([^\\}]*)";
            r = Pattern.compile(pattern);
            m = r.matcher(line);
            String FUNCTION = "";
            m.find();
            {



                FUNCTION += fun_name + " = function ( " + m.group(1) + " )\n{";
                String s = m.group(2);
                paramters = m.group(1);
                ArrayList<String> boom = ObjectFinder(s);
                for (String sr : boom) {
                    FUNCTION += "\n" + FunctionFinder(sr, line) + ";\n";
                    Log.d("debug2" , sr);
                }




                FUNCTION += paramters + "=" + paramters + ".split('')\n";
                for (String ar : DecFinder)
                    FUNCTION += "" + ar + "";

                FUNCTION += "\n" + paramters + "=" + paramters + ".join(\"\")\n";
                FUNCTION += "return " + paramters + ";";
                FUNCTION += "\n}";

            }
            return FUNCTION;

        }




    }



    private Object[] mSetForegroundArgs = new Object[1];
    private Object[] mStartForegroundArgs = new Object[2];
    private Object[] mStopForegroundArgs = new Object[1];



}
