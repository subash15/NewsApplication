package mynewsapp.subash.com.newsapplication.EventBus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import mynewsapp.subash.com.newsapplication.R;


public class SecondFragment extends Fragment {

  private TextView  fragmentSecondTextview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
               View view = inflater.inflate(R.layout.fragment_second, container, false);
             fragmentSecondTextview = view.findViewById(R.id.second_fragment_textview);
             return view ;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onMessageReceived( MessageEvent messageEvent){
        Toast.makeText(getActivity() , "fragment second data displayed", Toast.LENGTH_SHORT).show();
        fragmentSecondTextview.setText(messageEvent.getMessage());
    }
}
