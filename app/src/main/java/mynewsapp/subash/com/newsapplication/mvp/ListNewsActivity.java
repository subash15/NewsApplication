package mynewsapp.subash.com.newsapplication.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mynewsapp.subash.com.newsapplication.R;
import mynewsapp.subash.com.newsapplication.mvp.model.Article;
import mynewsapp.subash.com.newsapplication.mvp.model.NewsItem;

/* api key for news sources
https://newsapi.org/v2/sources?apiKey=1c25b96ca7c1491c861479c742cbdfb0*/
public class ListNewsActivity extends AppCompatActivity  implements  ApiInterface.NewsView{

    RecyclerView recyclerView;
    List<String> sourceTitleList = new ArrayList<>();
    List<String> sourceIdList = new ArrayList<>();
    List<Article>  articleList = new ArrayList<>();
    NewsPresenter newsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        recyclerView = findViewById(R.id.recyclerview_newslist);

        sourceTitleList = Arrays.asList("ABC News", "BBC News", "CBC News", "CNN News");
        sourceIdList = Arrays.asList("abc-news", "bbc-news", "cbc-news", "cnn");


        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new DataAdapater(this, sourceIdList, sourceTitleList));

    }


    @Override
    public void SuccessGettingData(NewsItem item) {
    List<Article> article = item.getArticles();


    }
    @Override
    public void onErrorGettingData(String error) {
        Toast.makeText(this , " Server Error ", Toast.LENGTH_SHORT).show();
    }
}
