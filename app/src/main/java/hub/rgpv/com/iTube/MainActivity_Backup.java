package hub.rgpv.com.iTube;

import android.support.v7.app.AppCompatActivity;

public class MainActivity_Backup extends AppCompatActivity {
//
//    Boolean selected_all = true;
//    private ArrayList<ArrayList<ENTITY>> SongList = new  ArrayList<ArrayList<ENTITY>>();
//
//    class Adapter_recycler extends RecyclerView.Adapter<Adapter_recycler._ViewHolder>
//    {
//        @Override
//        public _ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            Log.d("created" , "1");
//            View view = LayoutInflater.from(MainActivity_Backup.this).inflate(R.layout.entity , null);
//            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//            return new _ViewHolder( view) ;
//        }
//
//
//
//        @Override
//        public void onBindViewHolder(final _ViewHolder holder, final int position) {
//
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    holder.checkBox.performClick();
//
//
////                    Download ( SongList.get(position).get(1).value );
//
//
//
//                    Intent intent = new Intent(MainActivity_Backup.this , Downloader.class);
//                    intent.putExtra("VIDEO" , "");
//
//                    intent.putExtra("AUDIO" , "" + SongList.get(position).get(1).value);
//                    intent.putExtra("TITLE" , "" +title);
//
//                    intent.setFlags(Service.START_STICKY);
//                    startService(intent);
//                    finish();
//
//
//                }
//            });
//            holder.title.setText("" +  SongList.get(position).get(0).value  );
//
//
//
//
//
//            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
////                    songs.get(position).setChecked(isChecked);
////                    Log.d("updated content" , songs.toString());
////
//
//
//                }
//            });
////            holder.icon.setText( songs.get(position  ).title.substring(0,1) );
////            holder.title.setText( songs.get(position).title );
////            holder.checkBox.setChecked(songs.get(position).checked   );
////
//
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return  (( SongList.size() == 0 )? 0 :SongList.size()  ) ;
//        }
//
//        class _ViewHolder extends RecyclerView.ViewHolder
//        {
//            TextView icon,title;
//            CheckBox checkBox;
//
//            public _ViewHolder(View itemView) {
//
//                super(itemView);
//                icon = (TextView) itemView.findViewById(R.id.icon);
//                title = (TextView) itemView.findViewById(R.id.title);
//                checkBox = (CheckBox) itemView.findViewById(R.id.cb);
//
//            }
//        }
//
//    }
//
//
//    RecyclerView recyclerView;
//    Adapter_recycler adapter;
//    void init()
//    {
//        adapter =    new Adapter_recycler();
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//
//    }
//
//    class parsePage extends AsyncTask<String,String,String>
//    {
//
//        String url;
//
//        public parsePage(String url)
//        {
//            this.url = url;
//            songs = new ArrayList<Song>();
////            songs.add(new Song("0" ,"Download All"));
//        }
//        private String readStream(InputStream in) {
//            BufferedReader reader = null;
//            StringBuffer response = new StringBuffer();
//            try {
//                reader = new BufferedReader(new InputStreamReader(in));
//                String line = "";
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
////                    Log.d("body" ,line);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            return response.toString();
//        }
//
//        ArrayList<Song> songs ;
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            String Code="";
//
//            try
//            {
//
//                DESCODE_FINAL  =    getCodeDecryptor();
//
//
//
//            }
//            catch (Exception e)
//            {
//                DESCODE_FINAL  ="";
//            }
//
//            Log.d("ADADA" , "DS");
//            String Data = "";
//            URL url = null;
//            HttpURLConnection urlConnection = null;
//            try {
//                url = new URL(this.url);
//
//                urlConnection = (HttpURLConnection) url
//
//                        .openConnection();
//                urlConnection.setRequestProperty("User-Agent" , "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.103 Safari/537.36");
//
//
//                InputStream in = urlConnection.getInputStream();
//
//
//                Data =   readStream(in);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                Log.d("baba" , "error" + e );
//
//            } finally {
//                urlConnection.disconnect();
//                Log.d("baba" , "DSADSA" + Data + " " + url);
//          SongList =         parseShared(Data);
//
//            }
//
//            return   Data;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//
//
//            progressDialog.dismiss();
//            adapter.notifyDataSetChanged();
//
//
//        }
//        ProgressDialog progressDialog;
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            progressDialog =    ProgressDialog.show(MainActivity_Backup.this , "Downloading..." ,"Please wait");
//
//        }
//    }
//    ArrayList<ArrayList<ENTITY>> DATAS_MAIN;
//
//    public static Map<String, List<String>> splitQuery(String url) throws UnsupportedEncodingException, UnsupportedEncodingException {
//        final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
//        final String[] pairs = url.split("&");
//        for (String pair : pairs) {
//            final int idx = pair.indexOf("=");
//            final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
//            if (!query_pairs.containsKey(key)) {
//                query_pairs.put(key, new LinkedList<String>());
//            }
//            final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
//            query_pairs.get(key).add(value);
//        }
//        return query_pairs;
//    }
//    ArrayList<ArrayList<ENTITY>>  parseShared(String text)
//    {
//
//
//
//        String tmp = "ytplayer.config =";
//
//        int pos1 = text.indexOf(tmp) + tmp.length();
//
//
//        int pos2 =text.indexOf(";ytplayer.load" , pos1) ;
//
//        String jsonData= text.substring( pos1 , pos2 );
//        Log.d("result" , jsonData);
//
//        try {
//            JSONObject obj = new JSONObject(jsonData);
//
//            JSONObject  obj2  = obj.getJSONObject("args");
//            String adaptive_fmts  = obj2.getString("adaptive_fmts");
//            String url_encoded_fmt_stream_map = obj2.getString("url_encoded_fmt_stream_map");
//
//            String[] video_audio = url_encoded_fmt_stream_map.split(",");
//
//            ArrayList< Map<String, List<String>>> mappers = new ArrayList<>();
//            ArrayList< Map<String, String>> sweeper = new ArrayList<>();
//
//            Map<String, List<String>> bumchick;
//            for(int i = 0; i<video_audio.length; i++) {
//                bumchick = splitQuery((video_audio[i]));
//                mappers.add(bumchick);
//            }
//
//
//
//
//            for(   Map<String, List<String>> tmpo : mappers  )
//            {
//
//                HashMap<String, String> bombard = new HashMap<>();
//
//
//                String key = "itag";
//                String value = "";
//
//
//                if(tmpo.containsKey("itag") )
//                    value = tmpo.get("itag").get(0);
//                else
//                    value = "";
//
//                bombard.put(key , value);
//
//
//                     key = "url";
//                if(tmpo.containsKey("url") )
//                    value =  tmpo.get("url").get(0);
//                else
//                    value = "";
//                bombard.put(key , value);
//
//
//                     key = "sig";
//                if(tmpo.containsKey("sig") )
//                    value = tmpo.get("sig").get(0);
//                else
//                    value = "";
//                bombard.put(key , value);
//
//
//                key = "s";
//                if(tmpo.containsKey("s") )
//                    value = tmpo.get("s").get(0);
//
//                else
//                    value = "";
//                bombard.put(key , value);
//
//                String signature = decpher(value);
//                bombard.put("signature" , signature);
//
//
//                bombard.put("encoded_url" , bombard.get("url") + "&signature=" + signature);
//
//
//
//
//                key = "quality";
//                if(tmpo.containsKey("quality") )
//                    value = tmpo.get("quality").get(0);
//                else
//                    value = "";
//                bombard.put(key , value);
//
//
//
//                key = "type";
//                if(tmpo.containsKey("type") )
//                    value = tmpo.get("type").get(0);
//                else
//                    value = "";
//                bombard.put(key , value);
//
//
//
//                key = "mime";
//                if(tmpo.containsKey("mime") )
//                    value =  tmpo.get("mime").get(0);
//                else
//                    value = "";
//                bombard.put(key , value);
//
//
//                key = "container";
//                if(tmpo.containsKey("container") )
//                    value =  tmpo.get("container").get(0);
//                else
//                    value = "";
//                bombard.put(key , value);
//
//
//
//
//
//
//
//
//
//
//
//        sweeper.add(bombard);
//
//
//            }
//
//
//
//
//
//
//
//             title = obj2.getString("title");
//
////            getSupportActionBar().setSubtitle(title);
//
//
//
////            adaptive_fmts =URLDecoder.decode(adaptive_fmts, "UTF-8");
//            String[] keys = adaptive_fmts.split(",");
//
//
//
//
//  DATAS_MAIN = new ArrayList<>();
//
//
//            for ( int i=0; i<keys.length;i++ )
//            {
//                 ArrayList<ENTITY> DATAS = new ArrayList<>();
//
//                String tmp2 = keys[i];
//                String[] temp =tmp2.split("&" );
//                String signature = "";
//                String url = "";
//                String quality_label ="";
//                String type ="";
//                String bitrate ="";
//                for ( int ii=0; ii<temp.length;ii++ )
//                {
//
////                    temp[ii] =  URLDecoder.decode( temp[ii] , "UTF-8");
//
//
//                    String[] temp2 =temp[ii].split("=" ,2 );
//
//                    String KEY = ( temp2[0] );
//                    String VALUE = URLDecoder.decode ( temp2[1] , "UTF-8" );
//
//                    if(KEY.equals("quality_label"))
//                    {
//
//                        quality_label = VALUE;
//                    }
//
//                    else     if(KEY.equals("bitrate"))
//                    {
//
//                        bitrate = VALUE;
//
//                        DATAS.add( new ENTITY(KEY , VALUE));
//
//
//
//                    }
//                    else     if(KEY.equals("type"))
//                    {
//
//                        type = VALUE;
//
//                        DATAS.add( new ENTITY("signature" , signature));
//
//
//
//                    }
//                else     if(KEY.equals("s"))
//                    {
//                        signature  = decpher(VALUE);
//
////                     signature = decpher("EEC7EC794424A641BF80ABC7334B9783ECAA8369AF49.08EDE8E5E2E8690E15B01521232F00224BCD5581581");
//
//
//                        DATAS.add( new ENTITY("signature" , signature));
//
//
//
//                    }
//                    else    if(KEY.equals("url"))
//                    {
//
//                      url = VALUE;
//
//                    }
//                    else
//                    {
//
//                        DATAS.add( new ENTITY(KEY , VALUE));
//
//
//
//
//                    }
//
//                }
//
//
//
//
//                url += "&signature=" + signature;
//
//
//
//                String[] Type = type.split(";", 2)[0].split("/", 2);
//                Type[1] = Type[1].split(";", 1)[0];
//
//                bitrate = "" + (Integer.parseInt(bitrate) / 1000 );
//                String TITLE = ((quality_label.length()==0)? (bitrate  +"Kbps") : quality_label) + " " + Type[0] + " " + Type[1];
//
//
//                DATAS.add( 0 , new ENTITY("quality_label" , TITLE) ) ;
//
//                DATAS.add( 1,  new ENTITY("encoded_url" , url));
//
//
//
//if( Type[1].trim().toLowerCase().equals("mp4"))
//
//
//
//
//                DATAS_MAIN.add(DATAS);
//
//
//
//
//            }
//
//            Log.d("result" , adaptive_fmts  + "");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d("result" , "Catch 0 + e");
//        }
//
//        return  DATAS_MAIN;
//
//    }
//
//
//
//
//
//    String decpher(String str)
//    {
//
//
//
////      return  tr(str);
//
////        codeExec( DESCODE_FINAL, fun_name, paramters);
//
//        String decided= codeExec( DESCODE_FINAL, fun_name, str);
//
//        return  decided;
//
//
//
//    }
//
//    String tr(String str)
//    {
//        ArrayList<String> a =new   ArrayList<String>(   (Arrays.asList( str.split("") ) ) );
//a.remove(0);
//        a = vY( a , 1 );
//        a = Ey(a , 41);
//        a = vY(a,3);
//        a = W9(a,69);
//        a =Ey(a,29);
//        a =vY(a,3);
//        a =W9(a,53);
//        String out = "";
//        for(String s : a)
//        {
//            out+= s;
//
//        }
//
//        return  out;
//
//
//
//    }
//
//    ArrayList<String>  vY( ArrayList<String> list , int pos )
//    {
//        for(int i=0;i<pos;i++)
//            list.remove(0);
//        return  list;
//
//
//    }
//
//    ArrayList<String>  W9( ArrayList<String> list , int pos )
//    {
//
//        String c = list.get(0);
//
//        list.set(0,   list.get( pos % list.size()  ) );
//
//        list.set(pos, c  );
//
//        return  list;
//
//
//
//    }
//
//    ArrayList<String> Ey(ArrayList<String> boom,int pos)
//    {
//
//        Collections.reverse( boom);
//        return  boom;
//
//
//    }
//
//    String title = "";
//    private String readStream(InputStream in) {
//        BufferedReader reader = null;
//        StringBuffer response = new StringBuffer();
//        try {
//            reader = new BufferedReader(new InputStreamReader(in));
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
////                    Log.d("body" ,line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return response.toString();
//    }
//
//    ArrayList<String>DecFinder = new ArrayList<>();
//
//    ArrayList<String> ObjectFinder( String line)
//    {
//
//        String pattern = "([\\w]*)\\.([\\w]*[^\\(]*)(\\([^\\)]*\\))";
//
////        pattern +="|";
////        pattern += ;
//
//
//
//        // Create a Pattern object
//        Pattern r = Pattern.compile(pattern);
//
//
//
//        // Now create matcher object.
//        Matcher m = r .matcher(line);
//
//        ArrayList<String> str = new ArrayList<>();
//int cnt = 0;
//        while (m.find()) {
//            String shakalawa = m.group(2) + m.group(3);
//
//            DecFinder.add("\n"+ shakalawa + ";");
//            String s = m.group(2);
//
//str.add(s);
//            // s now contains "BAR"
//            System.out.print(s);
//        }
//
//
//
//        str.remove(0);
//        str.remove(str.size() - 1);
//        DecFinder.remove(0);
//        DecFinder.remove(DecFinder.size() - 1);
//
//
//
//
//
//        return str;
//
//    }
//
//    String  FunctionFinder(String name , String line)
//    {
//
//        String pattern = "[\\s]*" +name+"[^:]*:[\\s]*function[^\\(]*\\([^)]*\\)[^\\{]*\\{[^\\}]*\\}";
//
////        pattern +="|";
////        pattern += ;
//
//
//
//        // Create a Pattern object
//        Pattern r = Pattern.compile(pattern);
//
//
//
//        // Now create matcher object.
//        Matcher m = r .matcher(line);
//         m.find() ;
//            String s = m.group();
//
//           s = s.replace(":" , "=");
//
//
//            // s now contains "BAR"
//            System.out.print(s);
//
//        return  s;
//
//
//    }
//    String fun_name ="";
//String DESCODE_FINAL = "";
//    String paramters  ="";
//    String codeExec(String code , String funName , String param)
//    {
//
//
//        Object[] params = new Object[] { ""+param };
//        org.mozilla.javascript.Context rhino = org.mozilla.javascript.Context.enter();
//        rhino.setOptimizationLevel(-1);
//        Scriptable scope = rhino.initStandardObjects();
//        rhino.evaluateString(scope, code, "JavaScript", 1, null);
//        Object obj = scope.get(funName, scope);
//        if (obj instanceof Function) {
//            Function jsFunction = (Function) obj;
//            Object jsResult = jsFunction.call(rhino, scope, scope, params);
//            String result =  org.mozilla.javascript.Context.toString(jsResult);
//
//
//            return  result;
//
//        }
//        else {
//
//            return "";
//        }
//    }
//
//    String getCodeDecryptor() throws  Exception{
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//        URL url = null;
//        try {
//            url = new URL("https://s.ytimg.com/yts/jsbin/player-en_US-vflpN2vEY/base.js");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            return  "";
//        }
//
//        HttpURLConnection urlConnection = null;
//        try {
//            urlConnection = (HttpURLConnection) url
//
//                    .openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return  "";
//        }
//        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.103 Safari/537.36");
//
//
//        InputStream in = null;
//        try {
//            in = urlConnection.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return  "";
//        }
//
//        String Data = readStream(in);
//        String line = Data;
//        String pattern = ".sig\\|\\|(\\w+)\\(\\w+.\\w+\\)";
//
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(line);
//        while (m.find()) {
//            String s = m.group(1);
//            fun_name = s;
//            System.out.print(s);
//        }
//        pattern = fun_name + "=function\\((\\w+)\\)[^\\{]*\\{" + "([^\\}]*)";
//        pattern += "|";
//        pattern += fun_name + ":function\\((\\w+)\\)[^\\{]*\\{" + "([^\\}]*)";
//        r = Pattern.compile(pattern);
//        m = r.matcher(line);
//        String FUNCTION = "";
//        m.find();
//        {
//            FUNCTION += fun_name + " = function ( " + m.group(1) + " )\n{";
//            String s = m.group(2);
//            paramters = m.group(1);
//            ArrayList<String> boom = ObjectFinder(s);
//            for (String sr : boom)
//                FUNCTION += "\n" + FunctionFinder(sr, line) + ";\n";
//
//            FUNCTION += paramters + "=" + paramters + ".split('')\n";
//            for (String ar : DecFinder)
//                FUNCTION += "" + ar + "";
//
//            FUNCTION += "\n" + paramters + "=" + paramters + ".join(\"\")\n";
//            FUNCTION += "return " + paramters + ";";
//            FUNCTION += "\n}";
//
//        }
//        return  FUNCTION;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//
//
//
//
//
//
//
//
//
//
//
//        Intent intent = getIntent();
//
//        String action = intent.getAction();
//        String type = intent.getType();
//
//
//
//                String sharedText = "https://www.youtube.com/watch?v=-Yu_2nyOP5o";
//           //     sharedText = sharedText.substring(   sharedText.indexOf("v=") + 2 , sharedText.length()  );
//                if (sharedText != null) {
//                    Log.d("sharedText" , sharedText);
//                    // Update UI to reflect text being shared
//                   new parsePage(sharedText).execute();
//                }
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
////               Download ( SongList.get(0).get(1).value );
//
//
//
//                Intent intent = new Intent(MainActivity_Backup.this , Downloader.class);
//                intent.putExtra("AUDIO" , "" + SongList.get( SongList.size() - 1 ).get( 1 ).value);
//                intent.putExtra("VIDEO" , "" + SongList.get( 1  ).get(  1 ).value);
//                intent.putExtra("TITLE" , "" +title);
//
//
//
//
//
//
////                intent.setFlags(Service.START_STICKY);
//                startService(intent);
//
//                finish();
////
////                ArrayList<String> titles = new ArrayList<String>();
////                ArrayList<String> track_id = new ArrayList<String>();
////                for(Song song : songs)
////                {if(!song.checked)
////                    continue;
////                    titles.add(song.title);
////                    track_id.add(song.song_id);
////                }
////                if(track_id.size()==0)
////                {
////                    Toast.makeText(MainActivity.this, "Please select song(s)",1000).show();
////                    return;
////                }
////                intent.putStringArrayListExtra("track_id" ,track_id );
////
////                intent.putStringArrayListExtra("title" ,titles );
////
////                startService(intent);
////                finish();
////                try {
////                    Object sbservice = getSystemService( "statusbar" );
////                    Class<?> statusbarManager = Class.forName( "android.app.StatusBarManager" );
////                    Method showsb;
////                    if (Build.VERSION.SDK_INT >= 17) {
////                        showsb = statusbarManager.getMethod("expandNotificationsPanel");
////                    }
////                    else {
////                        showsb = statusbarManager.getMethod("expand");
////                    }
////                    showsb.invoke( sbservice );
////                }
////                catch (Exception e)
////                {
////
////                }
//            }
//        });
//
//        init();
//    }
//
//
//
//
//
//    private static final Class<?>[] mSetForegroundSignature = new Class[] {
//            boolean.class};
//    private static final Class<?>[] mStartForegroundSignature = new Class[] {
//            int.class, Notification.class};
//    private static final Class<?>[] mStopForegroundSignature = new Class[] {
//            boolean.class};
//
//    private NotificationManager mNM;
//    private Method mSetForeground;
//    private Method mStartForeground;
//    private Method mStopForeground;
//    private Object[] mSetForegroundArgs = new Object[1];
//    private Object[] mStartForegroundArgs = new Object[2];
//    private Object[] mStopForegroundArgs = new Object[1];
//
//    void invokeMethod(Method method, Object[] args) {
//        try {
//            method.invoke(this, args);
//        } catch (InvocationTargetException e) {
//            // Should not happen.
//            Log.w("ApiDemos", "Unable to invoke method", e);
//        } catch (IllegalAccessException e) {
//            // Should not happen.
//            Log.w("ApiDemos", "Unable to invoke method", e);
//        }
//    }
//
//    /**
//     * This is a wrapper around the new startForeground method, using the older
//     * APIs if it is not available.
//     */
//    void startForegroundCompat(int id, Notification notification) {
//        // If we have the new startForeground API, then use it.
//        if (mStartForeground != null) {
//            mStartForegroundArgs[0] = Integer.valueOf(id);
//            mStartForegroundArgs[1] = notification;
//            invokeMethod(mStartForeground, mStartForegroundArgs);
//            return;
//        }
//
//        // Fall back on the old API.
//        mSetForegroundArgs[0] = Boolean.TRUE;
//        invokeMethod(mSetForeground, mSetForegroundArgs);
//        mNM.notify(id, notification);
//    }
//
//    /**
//     * This is a wrapper around the new stopForeground method, using the older
//     * APIs if it is not available.
//     */
//    void stopForegroundCompat(int id) {
//        // If we have the new stopForeground API, then use it.
//        if (mStopForeground != null) {
//            mStopForegroundArgs[0] = Boolean.TRUE;
//            invokeMethod(mStopForeground, mStopForegroundArgs);
//            return;
//        }
//
//        // Fall back on the old API.  Note to cancel BEFORE changing the
//        // foreground state, since we could be killed at that point.
//        mNM.cancel(id);
//        mSetForegroundArgs[0] = Boolean.FALSE;
//        invokeMethod(mSetForeground, mSetForegroundArgs);
//    }
//
//void Download(String url)
//{
//
//
//    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
//    request.setDescription("Some descrition");
//    request.setTitle("Some title");
//// in order for this if to run, you must use the android 3.2 to compile your app
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//        request.allowScanningByMediaScanner();
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//    }
//    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "song.mp3");
//
//// get download service and enqueue file
//    DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//    manager.enqueue(request);
//
//}
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
