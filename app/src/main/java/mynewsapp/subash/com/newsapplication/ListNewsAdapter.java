package mynewsapp.subash.com.newsapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Crazyartist on 3/13/2018.
 */

public class ListNewsAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    public ListNewsAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data = d;
    }


   @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListNewsViewHolder holder = null;

        if (convertView == null) {
            holder = new ListNewsViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.row_list, parent, false);
            holder.galleryView = convertView.findViewById(R.id.news_headline_image);
            holder.author = convertView.findViewById(R.id.author);
            holder.title = convertView.findViewById(R.id.title_news);
            holder.details = convertView.findViewById(R.id.title_description);
            holder.time = convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ListNewsViewHolder) convertView.getTag();
        }
        holder.galleryView.setId(position);
        holder.author.setId(position);
        holder.title.setId(position);
        holder.title.setId(position);
        holder.details.setId(position);
        holder.time.setId(position);

        HashMap<String, String> song = new HashMap<String, String>();

        song = data.get(position);
        try {
            holder.author.setText(song.get(MainActivity.KEY_AUTHOR));
            holder.title.setText(song.get(MainActivity.KEY_TITLE));
            holder.details.setText(song.get(MainActivity.KEY_DESCRIPTION));
            holder.time.setText(song.get(MainActivity.KEY_TIME));

            if (song.get(MainActivity.KEY_URLTOIMAGE).toString().length() < 5) {
                holder.galleryView.setVisibility(View.GONE);
            } else {
                Picasso.with(activity).load(song.get(MainActivity.KEY_URLTOIMAGE).toString()).resize(300, 200).into(holder.galleryView);
            }
        } catch (Exception e) {

        }

        return convertView;
    }
}
