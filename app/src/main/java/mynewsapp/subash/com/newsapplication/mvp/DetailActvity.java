package mynewsapp.subash.com.newsapplication.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import mynewsapp.subash.com.newsapplication.R;

public class DetailActvity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatails_recyclerviewdata);
        webView = findViewById(R.id.webviewdata);
        webView.getSettings().getJavaScriptEnabled();
        String url =  getIntent().getStringExtra("url");
        webView.loadUrl(url);

    }
}
