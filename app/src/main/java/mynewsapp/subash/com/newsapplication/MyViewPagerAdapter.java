package mynewsapp.subash.com.newsapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Crazyartist on 3/12/2018.
 */

public class MyViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private int[] layouts;
    private Context context;


    public  MyViewPagerAdapter ( int [] layouts , Context context){
        this.layouts =layouts;
        this.context=context;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layouts[position] , container, false);
        container.addView(view);
        return view;
    }



    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
