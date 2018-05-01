package mynewsapp.subash.com.newsapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    private static final int SPLASH_TIMER = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            // showing the splash screen with timer is useful when u want to showcase your applicaiton logo
            @Override
            public void run() {
                // this method will be executed once the timer is over and starts your application main activity
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                // closing the Welcome Activity
                finish();
            }
        }, SPLASH_TIMER);

    }
}
