package mynewsapp.subash.com.newsapplication.mvp;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mynewsapp.subash.com.newsapplication.mvp.model.NewsItem;
import mynewsapp.subash.com.newsapplication.mvp.retrofit.RetrofitManager;
import retrofit2.Response;
import retrofit2.Retrofit;


public class NewsDataModel  implements  ApiInterface.NewsInteractor {

    ApiInterface.NewsListener newsListener;
    RetrofitManager retrofitManager;

    public NewsDataModel(ApiInterface.NewsListener newsListener) {
        this.newsListener = newsListener;
        retrofitManager = new RetrofitManager();
    }

    @Override
    public void getDataFromApi(String sourceId, String apiKey) {
        Retrofit retrofit    =  retrofitManager.getRetrofitClient(" https://newsapi.org/v2/");
        Log.d("lala", "getDataFromApi: "+retrofit);

       ApiInterface apiInterface   =  retrofit.create(ApiInterface.class);

        Observable<Response<NewsItem>> observable = apiInterface.getNewsItemData(sourceId, apiKey);

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).
                subscribe(new Observer<Response<NewsItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(Response<NewsItem> newsItemResponse) {
                        newsListener.onSuccessGettingDataInteractor(newsItemResponse.body());

                    }

                    @Override
                    public void onError(Throwable e) {
                        newsListener.onErrorGetttingDataInteractor(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });




    }
}
