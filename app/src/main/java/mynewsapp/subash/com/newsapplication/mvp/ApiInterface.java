package mynewsapp.subash.com.newsapplication.mvp;

import java.util.List;

import io.reactivex.Observable;
import mynewsapp.subash.com.newsapplication.mvp.model.Article;
import mynewsapp.subash.com.newsapplication.mvp.model.NewsItem;
import mynewsapp.subash.com.newsapplication.mvp.model.Post;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    public static final String API_KEY = "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=1c25b96ca7c1491c861479c742cbdfb0";

    public static final String BASE_URL = "https://newsapi.org/v2/";

    public static final String BASE_URL_POST_METHOD = "http://jsonplaceholder.typicode.com/";

     @GET("top-headlines")
     Observable<Response<NewsItem>>  getNewsItemData(@Query("sources") String sources , @Query("apiKey") String apiKey );

     @POST("posts")
     @FormUrlEncoded
     Call<Post> savePost(@Field("title") String title , @Field("body") String body , @Field("userId") long userId);


     interface  NewsView{

         void  SuccessGettingData(NewsItem item);
         void  onErrorGettingData(String error);


     }

     interface  NewsPresenter{
         void getNewsData(String sourceId , String apiKey);

     }

     interface  NewsListener {
         void  onSuccessGettingDataInteractor(NewsItem newsItem);
         void  onErrorGetttingDataInteractor(String error);

     }

     interface NewsInteractor{
         void getDataFromApi(String sourceId, String apiKey);

     }

}
