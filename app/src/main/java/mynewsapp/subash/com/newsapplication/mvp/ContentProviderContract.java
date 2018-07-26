package mynewsapp.subash.com.newsapplication.mvp;

import android.net.Uri;
import android.provider.BaseColumns;

public  final  class ContentProviderContract {



    public static final String AUTHORITY = "mynewsapp.subash.com.newsapplication.mvp.subashProvider";
    /**
     * The content URI for the top-level
     * lentitems authority.
     */
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY);

    public static final String TABLE_NEWS = "news";


    public static final class TaskColumns implements BaseColumns {
        //Task ID
       // public static final String _ID = "newsId";
        public static final String NEWS_TITLE = "title";
        public static final String NEWS_DESCRIPTION = "description";
        public static final String NEWS_AUTHOR = "author";
        public static final String NEWS_PUBLISHEDAT = "publishedAt";
        public static final String NEWS_URLTOIMAGE = "newsUrlToImage";
        public static final String NEWS_SOURCE = "signupDate";
        public static final String NEWS_URL = "newsUrl";


    }

}
