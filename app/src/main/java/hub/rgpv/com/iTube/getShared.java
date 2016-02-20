package hub.rgpv.com.iTube;

import android.support.v7.app.AppCompatActivity;

public class getShared extends AppCompatActivity {
//
//    String PASSING_AUDIO = "";
//    String PASSING_VIDEO = "";
//
//    Boolean selected_all = true;
//    private ArrayList<Map<String, String>> SongList = new ArrayList<>();
//
//    class Adapter_recycler extends RecyclerView.Adapter<Adapter_recycler._ViewHolder> {
//        @Override
//        public _ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            Log.d("created", "1");
//            View view = LayoutInflater.from(getShared.this).inflate(R.layout.entity, null);
//            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//            return new _ViewHolder(view);
//        }
//
//
//        @Override
//        public void onBindViewHolder(final _ViewHolder holder, final int position) {
//            holder.title.setText(SongList.get(position).get("type") + " " + SongList.get(position).get("quality"));
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    holder.checkBox.performClick();
//                    Intent intent = new Intent(getShared.this, Downloader.class);
//                    intent.putExtra("AUDIO", "");
//                    intent.putExtra("VIDEO", "" + SongList.get(position).get("encoded_url"));
//
//                    intent.putExtra("AUDIO", SongList.get(SongList.size() - 1).get("encoded_url"));
//
//                    intent.putExtra("TITLE", "" + title);
//                    intent.setFlags(Service.START_STICKY);
////                    startService(intent);
////                    finish();
//
//                }
//            });
//
//            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//
//                    if ( SongList.get(position).get("CODEC").equals("AUDIO")       )
//                    {
//
//                        PASSING_AUDIO = SongList.get(position).get("encoded_url");
//
//                    }
//                    else    if ( SongList.get(position).get("CODEC").equals("VIDEO") )
//                    {
//                        PASSING_VIDEO = SongList.get(position).get("encoded_url");
//
//
//                    }
//
//                }
//
//
//
//            });
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return ((SongList.size() == 0) ? 0 : SongList.size());
//        }
//
//        class _ViewHolder extends RecyclerView.ViewHolder {
//            TextView icon, title;
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
//
//    void init() {
//        adapter = new Adapter_recycler();
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//
//    }
//
//    class parsePage extends AsyncTask<String, String, String> {
//
//        String url;
//
//        public parsePage(String url) {
//            this.url = url;
//            songs = new ArrayList<Song>();
////            songs.add(new Song("0" ,"Download All"));
//        }
//
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
//        ArrayList<Song> songs;
//        Boolean success = false;
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            Log.d("ADADA", "DS");
//            String Data = "";
//            URL url = null;
//            HttpURLConnection urlConnection = null;
//            try {
//                url = new URL(this.url);
//
//                urlConnection = (HttpURLConnection) url
//
//                        .openConnection();
//                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.103 Safari/537.36");
//
//
//                InputStream in = urlConnection.getInputStream();
//
//
//                Data = readStream(in);
//
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                Log.d("baba", "error" + e);
//                DESCODE_FINAL = "";
//
//            } finally {//
//                urlConnection.disconnect();
//                Log.d("baba", "DSADSA" + Data + " " + url);
//                try {
//                    SongList = parseShared(Data);
//                    success = true;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    success = false;
//                }
//
//            }
//
//            return Data;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            progressDialog.dismiss();
//            adapter.notifyDataSetChanged();
//
//            if(!success)
//                finish();
//
//        }
//
//        ProgressDialog progressDialog;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            progressDialog = ProgressDialog.show(getShared.this, "Downloading...", "Please wait");
//        }
//    }
//
//    ArrayList<Map<String, String>> DATAS_MAIN;
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
//
//    ArrayList<Map<String, String>> parseShared(String text) throws Exception {
//
//
//        String tmp = "ytplayer.config =";
//
//        int pos1 = text.indexOf(tmp) + tmp.length();
//
//
//        int pos2 = text.indexOf(";ytplayer.load", pos1);
//
//        String jsonData = text.substring(pos1, pos2);
//        Log.d("result", jsonData);
//
//        try {
//            JSONObject obj = new JSONObject(jsonData);
//            JSONObject base_script_obj = obj.getJSONObject("assets");
//            String base = base_script_obj.getString("js");
//
//            if(base==null || base.length()<1 )
//
//            {
//                throw new Exception();
//            }
//
//            base = "https:" + base;
//
//            DESCODE_FINAL = getCodeDecryptor(base);
//            JSONObject obj2 = obj.getJSONObject("args");
//            title = obj2.getString("title");
//            String adaptive_fmts = obj2.getString("adaptive_fmts");
//            String url_encoded_fmt_stream_map = obj2.getString("url_encoded_fmt_stream_map");
//            String[] video_audio = url_encoded_fmt_stream_map.split(",");
//            ArrayList<Map<String, List<String>>> mappers = new ArrayList<>();
//            DATAS_MAIN = new ArrayList<>();
//            Map<String, List<String>> bumchick;
//
//
//            for (int i = 0; i < video_audio.length; i++) {
//                bumchick = splitQuery((video_audio[i]));
//
//                ArrayList<String> temp = new ArrayList<>();
//                temp.add("COMBO");
//
//
//                bumchick.put("TYPE", temp);
//
//                // Add AV STREAMS Streams
//
////                mappers.add(bumchick);
//
//
//            }
//
//            video_audio = adaptive_fmts.split(",");
//            for (int i = 0; i < video_audio.length; i++) {
//                // Add Dash Streams
//
//                bumchick = splitQuery((video_audio[i]));
//                ArrayList<String> temp = new ArrayList<>();
//                temp.add("INDI");
//
//
//                bumchick.put("TYPE", temp);
//
//                mappers.add(bumchick);
//
//
//            }
//
//
//            for (Map<String, List<String>> tmpo : mappers) {
//                HashMap<String, String> bombard = new HashMap<>();
//                String key = "itag";
//                String value = "";
//                if (tmpo.containsKey("itag"))
//                    value = tmpo.get("itag").get(0);
//                else
//                    value = "";
//                bombard.put(key, value);
//
//                key = "url";
//                if (tmpo.containsKey("url"))
//                    value = tmpo.get("url").get(0);
//                else
//                    value = "";
//                bombard.put(key, value);
//
//
//                key = "sig";
//                if (tmpo.containsKey("sig"))
//                    value = tmpo.get("sig").get(0);
//                else
//                    value = "";
//                bombard.put(key, value);
//
//
//                key = "s";
//                if (tmpo.containsKey("s"))
//                    value = tmpo.get("s").get(0);
//
//                else
//                    value = "";
//                bombard.put(key, value);
//                String signature = decpher(value);
//                bombard.put("signature", signature);
//                bombard.put("encoded_url", bombard.get("url") + "&signature=" + signature);
//
//                key = "quality";
//                if (tmpo.containsKey("quality"))
//                    value = tmpo.get("quality").get(0);
//                else {
//                    value = "";
//
//                    if (tmpo.containsKey("quality_label")) {
//                        value = tmpo.get("quality_label").get(0);
//                    } else {
//                        if (tmpo.containsKey("bitrate")) {
//                            try {
//                                value = "" + (Long.parseLong(tmpo.get("bitrate").get(0)));
//                            } catch (Exception e) {
//
//                            }
//                        }
//
//                    }
//
//                }
//                bombard.put(key, value);
//
//                key = "type";
//                if (tmpo.containsKey("type")) {
//                    value = tmpo.get("type").get(0);
//                    value = value.split(";")[0];
//                    bombard.put(key, value);
//                    String[] TYPE_DEF = value.split("/");
//                    if (!TYPE_DEF[1].trim().toLowerCase().equals("mp4"))
//                        continue;
//
//
//
//                    if (TYPE_DEF[0].contains("video")) {
//
//                        String chk = tmpo.get("TYPE").get(0);
//
//                        if (chk.equals("COMBO")) {
//
//                            // Combo AV
//
//                            bombard.put("CODEC", "AUDIO/VIDEO");
//
//
//                        } else {
//                            bombard.put("CODEC", "VIDEO");
//
//                            //Only Video
//
//                        }
//
//
//                    } else if (TYPE_DEF[0].contains("audio")) {
//
//                        String chk = tmpo.get("TYPE").get(0);
//
//                        bombard.put("CODEC", "AUDIO");
//
//
//                    } else {
//
//
//                    }
//
//
//                } else {
//                    value = "";
//                    bombard.put(key, value);
//
//                }
//
//
//                key = "mime";
//                if (tmpo.containsKey("mime"))
//                    value = tmpo.get("mime").get(0);
//                else
//                    value = "";
//                bombard.put(key, value);
//                key = "container";
//                if (tmpo.containsKey("container"))
//                    value = tmpo.get("container").get(0);
//                else
//                    value = "";
//                bombard.put(key, value);
//                DATAS_MAIN.add(bombard);
//            }
//
//            Log.d("result", adaptive_fmts + "");
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d("result", "Catch 0 + e");
//            throw new Exception();
//        }
//
//
//        if(DATAS_MAIN.size()<=0)
//            throw  new Exception();
//
//        return DATAS_MAIN;
//    }
//
//
//    String decpher(String str) {
//
//        String decided = codeExec(DESCODE_FINAL, fun_name, str);
//        return decided;
//
//    }
//
//    String tr(String str) {
//        ArrayList<String> a = new ArrayList<String>((Arrays.asList(str.split(""))));
//        a.remove(0);
//        a = vY(a, 1);
//        a = Ey(a, 41);
//        a = vY(a, 3);
//        a = W9(a, 69);
//        a = Ey(a, 29);
//        a = vY(a, 3);
//        a = W9(a, 53);
//        String out = "";
//        for (String s : a) {
//            out += s;
//
//        }
//
//        return out;
//
//
//    }
//
//    ArrayList<String> vY(ArrayList<String> list, int pos) {
//        for (int i = 0; i < pos; i++)
//            list.remove(0);
//        return list;
//
//
//    }
//
//    ArrayList<String> W9(ArrayList<String> list, int pos) {
//
//        String c = list.get(0);
//
//        list.set(0, list.get(pos % list.size()));
//
//        list.set(pos, c);
//
//        return list;
//
//
//    }
//
//    ArrayList<String> Ey(ArrayList<String> boom, int pos) {
//
//        Collections.reverse(boom);
//        return boom;
//
//
//    }
//
//    String title = "";
//
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
//    ArrayList<String> DecFinder = new ArrayList<>();
//
//    ArrayList<String> ObjectFinder(String line) {
//
//        String pattern = "([\\w]*)\\.([\\w]*[^\\(]*)(\\([^\\)]*\\))";
//
////        pattern +="|";
////        pattern += ;
//
//
//        // Create a Pattern object
//        Pattern r = Pattern.compile(pattern);
//
//
//        // Now create matcher object.
//        Matcher m = r.matcher(line);
//
//        ArrayList<String> str = new ArrayList<>();
//        int cnt = 0;
//        while (m.find()) {
//            String shakalawa = m.group(2) + m.group(3);
//
//            DecFinder.add("\n" + shakalawa + ";");
//            String s = m.group(2);
//
//            str.add(s);
//            // s now contains "BAR"
//            System.out.print(s);
//        }
//
//
//        str.remove(0);
//        str.remove(str.size() - 1);
//        DecFinder.remove(0);
//        DecFinder.remove(DecFinder.size() - 1);
//
//
//        return str;
//
//    }
//
//    String FunctionFinder(String name, String line) {
//
//        String pattern = "[\\s]*" + name + "[^:]*:[\\s]*function[^\\(]*\\([^)]*\\)[^\\{]*\\{[^\\}]*\\}";
//
//        Pattern r = Pattern.compile(pattern);
//
//
//        Matcher m = r.matcher(line);
//        m.find();
//        String s = m.group();
//
//        s = s.replace(":", "=");
//
//
//        System.out.print(s);
//
//        return s;
//
//
//    }
//
//    String fun_name = "";
//    String DESCODE_FINAL = "";
//    String paramters = "";
//
//    String codeExec(String code, String funName, String param) {
//
//
//        Object[] params = new Object[]{"" + param};
//        org.mozilla.javascript.Context rhino = org.mozilla.javascript.Context.enter();
//        rhino.setOptimizationLevel(-1);
//        Scriptable scope = rhino.initStandardObjects();
//        rhino.evaluateString(scope, code, "JavaScript", 1, null);
//        Object obj = scope.get(funName, scope);
//        if (obj instanceof Function) {
//            Function jsFunction = (Function) obj;
//            Object jsResult = jsFunction.call(rhino, scope, scope, params);
//            String result = org.mozilla.javascript.Context.toString(jsResult);
//
//
//            return result;
//
//        } else {
//
//            return "";
//        }
//    }
//
//    String getCodeDecryptor(String address) throws Exception {
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//        URL url = null;
//        try {
//            url = new URL(address);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            return "";
//        }
//
//        HttpURLConnection urlConnection = null;
//        try {
//            urlConnection = (HttpURLConnection) url
//
//                    .openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.103 Safari/537.36");
//
//
//        InputStream in = null;
//        try {
//            in = urlConnection.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
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
//        return FUNCTION;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        Intent intent = getIntent();
//
//        String action = intent.getAction();
//        String type = intent.getType();
//
//
//        String sharedText = "https://www.youtube.com/watch?v=-Yu_2nyOP5o";
//
//
//
//
//
//        if (Intent.ACTION_SEND.equals(action) && type != null) {
//            if ("text/plain".equals(type)) {
//
//                sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
//                if (sharedText != null) {
//                    // Update UI to reflect text being shared
//
//
//                }
//                else
//                {
//                    sharedText = "";
//                    finish();
//
//
//                }
//
//
//            }else {
//                finish();
//            }
//        }
//
//
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Intent intent = new Intent(getShared.this, Downloader.class);
//                intent.putExtra("AUDIO", PASSING_AUDIO);
//                intent.putExtra("VIDEO", "" + PASSING_VIDEO);
//                intent.putExtra("TITLE", "" + title);
//
//                startService(intent);
//
//                finish();
////
//            }
//        });
//
//        init();
//
//
//        if (sharedText != null) {
//            Log.d("sharedText", sharedText);
//            // Update UI to reflect text being shared
//            new parsePage(sharedText).execute();
//        }
//    }
//
//
//    private static final Class<?>[] mSetForegroundSignature = new Class[]{
//            boolean.class};
//    private static final Class<?>[] mStartForegroundSignature = new Class[]{
//            int.class, Notification.class};
//    private static final Class<?>[] mStopForegroundSignature = new Class[]{
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
//    void Download(String url) {
//
//
//        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
//        request.setDescription("Some descrition");
//        request.setTitle("Some title");
//// in order for this if to run, you must use the android 3.2 to compile your app
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            request.allowScanningByMediaScanner();
//            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//        }
//        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "song.mp3");
//
//// get download service and enqueue file
//        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//        manager.enqueue(request);
//
//    }
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
