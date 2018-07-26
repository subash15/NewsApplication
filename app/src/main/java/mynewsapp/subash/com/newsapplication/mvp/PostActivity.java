package mynewsapp.subash.com.newsapplication.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mynewsapp.subash.com.newsapplication.R;
import mynewsapp.subash.com.newsapplication.mvp.model.Post;
import mynewsapp.subash.com.newsapplication.mvp.retrofit.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostActivity extends AppCompatActivity {
    private static final String BASE_URL_POST_METHOD = "http://jsonplaceholder.typicode.com/";
    ApiInterface apiService;
    TextView finalResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final EditText titleEt = findViewById(R.id.et_title);
        final EditText bodyEt  = findViewById(R.id.et_body);
        Button submitButton = (Button)findViewById(R.id.btn_submit);
       finalResponse  = findViewById(R.id.tv_response);

        Retrofit retrofit = new RetrofitManager().getRetrofitClient(BASE_URL_POST_METHOD);

        apiService = retrofit.create(ApiInterface.class);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEt.getText().toString().trim();
                String body  =  bodyEt.getText().toString().trim();
                if (!TextUtils.isEmpty(title) && TextUtils.isEmpty(body)){
                    sendPost(title , body);
                }
            }
        });


    }

    private void sendPost(String title, String body) {
        apiService.savePost(title , body ,1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()){
                    showResponse(response.body().toString());
                    Log.d("PostActivity.class" , "Post Submitted to Api " +response.body().toString() );
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("PostActivity.class" , "Unable to submit post to Api");

            }
        });

    }

    private void showResponse(String s) {
        if (finalResponse.getVisibility() == View.GONE){
            finalResponse.setVisibility(View.VISIBLE);
        }

    }


}
