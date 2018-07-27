package mynewsapp.subash.com.newsapplication.EventBus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import mynewsapp.subash.com.newsapplication.R;

public class EventBusActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button sendButton;
    private EditText messageBox;
    private android.support.v4.app.FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
       sendButton = findViewById(R.id.send_Button);
       messageBox = findViewById(R.id.message_box);
       sendButton.setOnClickListener(this);
       fragmentManager = getSupportFragmentManager();
      fragmentManager.beginTransaction().add(R.id.first_fragment, new FirstFragment()).add(R.id.second_fragment, new SecondFragment()).commit();

    }

    @Override
    public void onClick(View v) {
        String message = messageBox.getText().toString().trim();
        EventBus.getDefault().post(new MessageEvent(message));

    }
}
