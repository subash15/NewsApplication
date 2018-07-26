package mynewsapp.subash.com.newsapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Intro_Welcome_FirstTime extends AppCompatActivity {
   private ViewPager viewPager;
   private LinearLayout dotLayout;
   private TextView[] dots;
   private  int[] layouts;
   private Button btnSkip , btnNext;
   private  PrefManager prefManager;
   private  MyViewPagerAdapter myViewPagerAdapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // checking for first time launch before calling the setContentView()
//      prefManager = new PrefManager(this);
//      if (!prefManager.isFirstTimeLaunch()){
//          launchHomeScreen();
//          finish();
//      }
//        // Making notification bar  or status bar transparent
//       if (Build.VERSION.SDK_INT >= 21){
//          getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN);
//       }
//
//     setContentView(R.layout.intro_home_screen);
//
//       viewPager = findViewById(R.id.view_pager);
//       dotLayout = findViewById(R.id.layoutDots);
//       btnNext   = findViewById(R.id.btn_next);
//       btnSkip   = findViewById(R.id.btn_skip);
//        // layout of all welcome  sliders  add few more if you want
//        layouts = new int[]{
//                R.layout.welcome_slide1,
//                R.layout.welcome_slide2,
//                R.layout.welcome_slide3,R.layout.welcome_slide4
//        };
//        // adding button dots
//        addBottomDots(0);
//
//        // making the notification bar transparent
//        changeStatusBarColor();
//
//        //setting up the adapter
//         myViewPagerAdapter = new MyViewPagerAdapter(layouts,this);
//         viewPager.setAdapter(myViewPagerAdapter);
//         viewPager.addOnPageChangeListener(viewPagerChangeListener);
//
//
//        btnSkip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                launchHomeScreen();
//            }
//        });
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // checking for the last page
//                // if it is last page home screen will be launched
//
//                int current = getItem(+1);
//                if (current < layouts.length){
//                    // move to next Screen
//                    viewPager.setCurrentItem(current);
//                }
//                else {
//                    launchHomeScreen();
//                }
//            }
//        });
//
//    }
//
//    // initializing OnPageChangeListener
//    ViewPager.OnPageChangeListener  viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//            addBottomDots(position);
//            // changing the next button  text 'NEXT' / 'Got it'
//            if (position ==  layouts.length -1){
//                // last page make button text to Got it
//                btnNext.setText(getString(R.string.start));
//                btnSkip.setVisibility(View.GONE);
//            }
//            else {
//                //still pages are left
//                btnNext.setText(getString(R.string.next));
//                btnSkip.setVisibility(View.VISIBLE);
//            }
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    };
//
//
//    private void addBottomDots(int currentPage) {
//        dots  =  new TextView[layouts.length];
//        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
//        int[]  colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
//
//        dotLayout.removeAllViews();
//
//        for (int i =0 ; i< dots.length ; i++){
//            dots[i] = new TextView(this);
//            dots[i].setText(Html.fromHtml("&#8226;"));
//            dots[i].setTextSize(35);
//            dots[i].setTextColor(colorsInactive[currentPage]);
//            dotLayout.addView(dots[i]);
//        }
//        if (dots.length > 0){
//            dots[currentPage].setTextColor(colorsActive[currentPage]);
//        }
//    }
//    private  int getItem(int i){
//        return  viewPager.getCurrentItem()+i;
//    }
//
//
//    private void  launchHomeScreen() {
//        prefManager.setFirstTimeLaunch(false);
//        Intent intent = new Intent(Intro_Welcome_FirstTime.this, WelcomeActivity.class);
//        startActivity(intent);
//    }
//
//
//
//
//    /** making the notification bar transparent **/
//    private void changeStatusBarColor() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
//    }


}
