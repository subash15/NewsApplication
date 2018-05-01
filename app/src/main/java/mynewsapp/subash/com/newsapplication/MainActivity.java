package mynewsapp.subash.com.newsapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    String API_KEY = "1c25b96ca7c1491c861479c742cbdfb0"; // my news Api key here
    String NEWS_SOURCE = "bbc-news";
    ListView listNews;
    ProgressBar loader;
    ListNewsAdapter adapter;

    boolean isloading = false;


    ArrayList<HashMap<String, String>> datalist = new ArrayList<HashMap<String, String>>();
    static final String KEY_AUTHOR = "author";
    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_URL = "url";
    static final String KEY_TIME = "time";
    static final String KEY_URLTOIMAGE = "urlToImage";
    static final String KEY_PUBLISHEDAT = "publishedAt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listNews = findViewById(R.id.list_news);
        loader = findViewById(R.id.progress_news_list);
        listNews.setEmptyView(loader);
        if (Function.isNetworkAvailable(getApplicationContext())) {
            //
            DownloadNews downloadNews = new DownloadNews();
            downloadNews.execute();

        } else {
            Toast.makeText(getApplicationContext(), " No Internet Connection ", Toast.LENGTH_SHORT).show();
        }

    }


    class DownloadNews extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... args) {
            String xml = "";
            String urlParameters = "";
            xml = Function.executeGet("https://newsapi.org/v2/top-headlines?sources=" + NEWS_SOURCE + "&apiKey=" + API_KEY, urlParameters);
            return xml;
        }

        @Override
        protected void onPostExecute(String xml) {
            if (xml != null) {  // Just checking if not empty
                try {
                    JSONObject jsonResponse = new JSONObject(xml);
                    JSONArray jsonArray = jsonResponse.optJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put(KEY_AUTHOR, jsonObject.optString(KEY_AUTHOR).toString());
                        map.put(KEY_TITLE, jsonObject.optString(KEY_TITLE).toString());
                        map.put(KEY_DESCRIPTION, jsonObject.optString(KEY_DESCRIPTION));
                        map.put(KEY_URL, jsonObject.optString(KEY_URL).toString());
                        map.put(KEY_URLTOIMAGE, jsonObject.optString(KEY_URLTOIMAGE).toString());
                        map.put(KEY_PUBLISHEDAT, jsonObject.optString(KEY_PUBLISHEDAT));
                        datalist.add(map);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "unexpected error", Toast.LENGTH_LONG).show();
                }

                adapter = new ListNewsAdapter(MainActivity.this, datalist);

                listNews.setAdapter(adapter);
                listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                        intent.putExtra("url", datalist.get(+position).get(KEY_URL));
                        startActivity(intent);
                    }
                });


            } else {
                Toast.makeText(getApplicationContext(), " No news found ", Toast.LENGTH_SHORT).show();
            }


        }
    }

}



