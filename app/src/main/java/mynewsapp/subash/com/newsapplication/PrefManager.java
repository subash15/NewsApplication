package mynewsapp.subash.com.newsapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Crazyartist on 3/12/2018.
 */

public class PrefManager {
   SharedPreferences pref;
   SharedPreferences.Editor editor;
   Context _context;

   // shared pref mode
    int PRIVATE_MODE = 0;

// shared preferences file name
    private  static final String PREF_NAME = "Intro-welcome";
    private  static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context){
        this._context = context;
        pref = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setFirstTimeLaunch(boolean isFirstTime){
       editor.putBoolean(IS_FIRST_TIME_LAUNCH , isFirstTime);
       editor.commit();
    }

    public boolean isFirstTimeLaunch(){

        return pref.getBoolean(IS_FIRST_TIME_LAUNCH,true);

    }

}
