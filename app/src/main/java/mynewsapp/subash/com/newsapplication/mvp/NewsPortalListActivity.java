package mynewsapp.subash.com.newsapplication.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import mynewsapp.subash.com.newsapplication.R;
import mynewsapp.subash.com.newsapplication.mvp.model.Article;
import mynewsapp.subash.com.newsapplication.mvp.model.NewsItem;

public class NewsPortalListActivity extends AppCompatActivity implements ApiInterface.NewsView {

    public String TAG = getClass().getSimpleName();
    RecyclerView recyclerView;
    NewsPresenter newsPresenter;
    String sourceID;
    String API_KEY = "1c25b96ca7c1491c861479c742cbdfb0";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.portal_news_list);
        recyclerView = findViewById(R.id.recycler_view);

        sourceID = getIntent().getStringExtra("source_id");

        newsPresenter = new NewsPresenter(this);
        newsPresenter.getNewsData(sourceID, API_KEY);


    }

    @Override
    public void SuccessGettingData(NewsItem item) {

        Log.d(TAG, "SuccessGettingData: " + item.getArticles().size());
        List<Article> articles = item.getArticles();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new NewsPortalAdapter(NewsPortalListActivity.this, articles));
        savingDataOffline(item);

    }

    private void savingDataOffline(NewsItem items) {


        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        /*List<Article> articles = items.getArticles();
*/

      /* for (int i =0 ; i < articles.size() ; i++)
       {
           Article article = articles.get(i);
           ContentValues values  = new ContentValues();
           values.put(ContentProviderContract.TaskColumns.NEWS_TITLE ,  article.getTitle());
           values.put(ContentProviderContract.TaskColumns.NEWS_DESCRIPTION , article.getDescription());
           values.put(ContentProviderContract.TaskColumns.NEWS_SOURCE , String.valueOf(article.getSource()));
           values.put(ContentProviderContract.TaskColumns.NEWS_AUTHOR , article.getAuthor());
           values.put(ContentProviderContract.TaskColumns.NEWS_PUBLISHEDAT , article.getPublishedAt());
           values.put(ContentProviderContract.TaskColumns.NEWS_URL , article.getUrl() );
           values.put(ContentProviderContract.TaskColumns.NEWS_URLTOIMAGE , article.getUrlToImage());


         getContentResolver().insert(NewsProvider.CONTENT_URI , values);

           Toast.makeText(this , " Uri found" , Toast.LENGTH_SHORT).show();
       }*/
  /*      for (int i = 0; i < articles.size(); i++) {

            Article article = realm.createObject(Article.class);
            article.setTitle(article.getTitle());
            article.setDescription(article.getDescription());
            article.setAuthor(article.getAuthor());
            article.setPublishedAt(article.getPublishedAt());
            article.setUrl(article.getUrlToImage());
            article.setSource(article.getSource());
            article.setUrlToImage(article.getUrlToImage());
        }
  */    realm.insertOrUpdate(items);
        realm.commitTransaction();
        RealmResults<NewsItem> newsItems = realm.where(NewsItem.class).findAll();
        Log.d(TAG, "savingDataOffline: "+newsItems.get(0).getArticles().get(0).getTitle());
        NewsProvider newsProvider = new NewsProvider(this, items);

    }


    @Override
    public void onErrorGettingData(String error) {
        Toast.makeText(this, "Error recurring the data ", Toast.LENGTH_SHORT).show();

    }
}
