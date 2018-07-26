package mynewsapp.subash.com.newsapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Crazyartist on 3/13/2018.
 */

public class DetailsActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar loader;
    String url = "";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        url = getIntent().getStringExtra("url");
        Log.d("url",url);
        Toast.makeText(this,url,Toast.LENGTH_LONG).show();
        loader = findViewById(R.id.webView_loader);
        webView = findViewById(R.id.webView);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.loadUrl(url);

      /*  webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    loader.setVisibility(View.GONE);
                } else {
                    loader.setVisibility(View.VISIBLE);
                }
            }
        });*/


    }


}
