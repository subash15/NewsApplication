package mynewsapp.subash.com.newsapplication.mvp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import mynewsapp.subash.com.newsapplication.mvp.model.Article;
import mynewsapp.subash.com.newsapplication.mvp.model.NewsItem;


public class NewsProvider extends ContentProvider  {


    public static final int TASK = 1;  // flag for the News data
    public static final int TASK_ID = 2;   // flag for the news row data
    public static final UriMatcher uriMatcher;
    static final String PROVIDER_NAME = "mynewsapp.subash.com.newsapplication.mvp.NewsProvider";
    static final String URL = "content://" + PROVIDER_NAME + "/news";
    static final Uri CONTENT_URI = Uri.parse(URL);
    private static final String TAG = NewsProvider.class.getSimpleName();
    private  Realm realm;

    static {

        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(ContentProviderContract.AUTHORITY, ContentProviderContract.TaskColumns.TABLE_NEWS, TASK);
/*
        uriMatcher.addURI(ContentProviderContract.AUTHORITY ,ContentProviderContract.TABLE_NEWS +"/#" , TASK_ID);
*/

    }

    public Context context;
    public NewsItem items;

    public  NewsProvider(){

    }


    public NewsProvider(NewsPortalListActivity context, NewsItem items) {
        this.items = items;
        this.context = context;

    }

    @Override
    public boolean onCreate() {
        // Initializing realm
        Realm.init(getContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        // Get Realm Instance
        Realm realm = Realm.getDefaultInstance();

        MatrixCursor myCursor = new MatrixCursor(new String[]{ ContentProviderContract.TaskColumns.NEWS_TITLE
                , ContentProviderContract.TaskColumns.NEWS_AUTHOR, ContentProviderContract.TaskColumns.NEWS_DESCRIPTION,
                ContentProviderContract.TaskColumns.NEWS_URL, ContentProviderContract.TaskColumns.NEWS_SOURCE, ContentProviderContract.TaskColumns.NEWS_PUBLISHEDAT, ContentProviderContract.TaskColumns.NEWS_URLTOIMAGE
        });

                  /*  RealmResults<Article> tasksRealmResults = realm.where(Article.class).findAll();
                    for (Article myTask : tasksRealmResults) {
                        Object[] rowData = new Object[]{myTask.getTitle(), myTask.getDescription(), myTask.getAuthor()
                                , myTask.getPublishedAt(), myTask.getSource(), myTask.getUrlToImage(),};
                        myCursor.addRow(rowData);
                        Log.v("RealmDB", myTask.toString());
                    }*/

        List<Article> articles = items.getArticles();

        Article  article = realm.where(Article.class).findFirst();
        Object[] rowData = new Object[]{ article.getTitle(), article.getAuthor(), article.getDescription(), article.getSource(),
                article.getPublishedAt(), article.getUrlToImage(), article.getUrl()};
        myCursor.addRow(rowData);
        Log.v("RealmDB", items.toString());
        realm.close();

        return myCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

          /*switch (URI_MATCHER.match(uri)) {
            case ITEM_LIST:
                return Items.CONTENT_TYPE;
            case ITEM_ID:
                return Items.CONTENT_ITEM_TYPE;
            case PHOTO_ID:
                return Photos.CONTENT_PHOTO_TYPE;
            case PHOTO_LIST:
                return Photos.CONTENT_TYPE;
            case ENTITY_ID:
                return ItemEntities.CONTENT_ENTITY_TYPE;
            case ENTITY_LIST:
                return ItemEntities.CONTENT_TYPE;
            default:
                return null;
        }*/

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

       /* int match = uriMatcher.match(uri);
        Uri returnUri;

        //Get Realm Instance
        Realm realm = Realm.getDefaultInstance();
        try {
            switch (match) {
                case TASK:
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            Number currId = realm.where(Article.class).max(TaskColumns._ID);
                            Integer nextId = (currId == null) ? 1 : currId.intValue() + 1;

                            Article myNewTask = realm.createObject(Article.class, nextId);
                            myNewTask.setTitle(values.get(TaskColumns.NEWS_TITLE).toString());
                            myNewTask.setDescription(values.get(TaskColumns.NEWS_DESCRIPTION).toString());
                            myNewTask.setUrl(values.get(TaskColumns.NEWS_URLTOIMAGE).toString());
                            myNewTask.setAuthor((String) values.get(TaskColumns.NEWS_AUTHOR));
                            myNewTask.setUrl((String) values.get(TaskColumns.NEWS_URL));
                            myNewTask.setPublishedAt((String) values.get(TaskColumns.NEWS_PUBLISHEDAT));
                        }
                    });
                    returnUri = ContentUris.withAppendedId(ContentProviderContract.CONTENT_URI, '1');
                    break;

                default:
                    throw new UnsupportedOperationException("Unknown uri: " + uri);
            }

            getContext().getContentResolver().notifyChange(uri, null);
        }finally {
            realm.close();
        }
        return returnUri;

*/
        return null;
    }


    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

   /* @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Realm realm = Realm.getDefaultInstance();
        Article newsArticle = null;
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case NEWS:
                selection = (selection == null) ? "1" : selection;

                RealmResults<Article> books = realm.where(Article.class).equalTo("title", newsArticle.getTitle()).findAll();
                realm.beginTransaction();
                books.deleteAllFromRealm();
                realm.commitTransaction();
                break;
            case NEWS_ID:
                Integer id = Integer.parseInt(String.valueOf(ContentUris.parseId(uri)));
                Article myTask = realm.where(Article.class).equalTo("task_id", id).findFirst();
                realm.beginTransaction();
                myTask.deleteFromRealm();
                count++;
                realm.commitTransaction();
                break;
            default:
                throw new IllegalArgumentException("Illegal delete URI");



        }
        return count;
    }*/

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {

/*
       Realm realm = Realm.getDefaultInstance();

        int match = uriMatcher.match(uri);

        int nrUpdated = 0;

        try {
            switch (match) {
                case TASK_ID:
                    Integer id = Integer.parseInt(uri.getPathSegments().get(1));
                    Article myTask = realm.where(Article.class).equalTo("task_id", id).findFirst();
                    realm.beginTransaction();
                    realm.copyToRealmOrUpdate(myTask);
                    nrUpdated++;
                    realm.commitTransaction();
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown uri: " + uri);
            }


        } finally {
            realm.close();
        }

        if (nrUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return nrUpdated;
*/
        return 0;
    }
}
