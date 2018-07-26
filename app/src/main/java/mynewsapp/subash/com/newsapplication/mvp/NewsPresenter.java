package mynewsapp.subash.com.newsapplication.mvp;

import java.util.List;

import mynewsapp.subash.com.newsapplication.mvp.model.Article;
import mynewsapp.subash.com.newsapplication.mvp.model.NewsItem;

public   class NewsPresenter implements  ApiInterface.NewsPresenter , ApiInterface.NewsListener {

     ApiInterface.NewsView newsView;
     ApiInterface.NewsInteractor newsInteractor;


    public NewsPresenter( ApiInterface.NewsView view  ) {
        this.newsView = view;
        newsInteractor = new NewsDataModel(this);

    }

    @Override
    public void getNewsData(String source , String apiKey) {
        newsInteractor.getDataFromApi(source, apiKey);

    }


    @Override
    public void onSuccessGettingDataInteractor(NewsItem newsItem) {
        newsView.SuccessGettingData(newsItem);
    }

    @Override
    public void onErrorGetttingDataInteractor(String error) {
       newsView.onErrorGettingData(error);
    }
}
