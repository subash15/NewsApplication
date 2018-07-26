package mynewsapp.subash.com.newsapplication.mvp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import mynewsapp.subash.com.newsapplication.R;
import mynewsapp.subash.com.newsapplication.mvp.model.Article;

public class NewsPortalAdapter extends RecyclerView.Adapter<NewsPortalAdapter.MyViewHolder>{

    List<Article>  articleList;
    Activity context;


    public NewsPortalAdapter(Activity context , List<Article>  articleList) {
              this.articleList = articleList;
              this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_details_portal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
                 Article article = articleList.get(position);
                 holder.newsTitle.setText(article.getTitle());
                 holder.newsdescription.setText(article.getDescription());
                 holder.newsPubdate.setText(article.getPublishedAt());
                 Picasso.with(context).load(article.getUrlToImage()).into(holder.newsurlToImage);
                 Toast.makeText(context , " total number of news "+ getItemCount(), Toast.LENGTH_SHORT).show();
                 holder.itemView.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent intent = new Intent(context , DetailActvity.class);
                         intent.putExtra("url" , article.getUrl());
                         context.startActivity(intent);

                     }
                 });



    }

    @Override
    public int getItemCount() {
        return  articleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
         TextView newsTitle , newsdescription , newsauthor , newsUrl , newsPubdate;
         ImageView newsurlToImage;


        public MyViewHolder(View view) {
            super(view);

            newsTitle = view.findViewById(R.id.news_title);
            newsdescription = view.findViewById(R.id.title_description);
            newsauthor = view.findViewById(R.id.author);
            newsurlToImage = view.findViewById(R.id.news_headline_image);
            newsPubdate = view.findViewById(R.id.published_At);
            newsUrl = view.findViewById(R.id.news_link_url);

        }
    }
}
