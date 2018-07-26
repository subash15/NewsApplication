package mynewsapp.subash.com.newsapplication.mvp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mynewsapp.subash.com.newsapplication.R;

public class DataAdapater extends RecyclerView.Adapter<DataAdapater.NewsItemViewHolder> {

    List<String> sourceTitleList;
    List<String> sourceIdList;
    Context context;

    public DataAdapater(Context context , List<String> sourceIdList, List<String> sourceTitleList) {
        this.sourceTitleList = sourceTitleList;
        this.sourceIdList = sourceIdList;
        this.context = context;
    }

    @Override
    public NewsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sourcelist_single_item ,parent , false);

        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsItemViewHolder holder, int position) {

        holder.sourceTitle.setText(sourceTitleList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , NewsPortalListActivity.class);
                intent.putExtra("source_id", sourceIdList.get(position));
                context.startActivity(intent);
            }
        });

        }

    @Override
    public int getItemCount() {
        return sourceTitleList.size();
    }

    public class NewsItemViewHolder  extends RecyclerView.ViewHolder{
        TextView sourceTitle , newsImageview , newsAuthor , newstitle , newsSource , newsDescription , newsImageUrl;

        public NewsItemViewHolder(View itemView) {
            super(itemView);
            sourceTitle = itemView.findViewById(R.id.source_name);
            newsImageview = itemView.findViewById(R.id.news_headline_image);
            newsAuthor  = itemView.findViewById(R.id.author);
            newsSource  = itemView.findViewById(R.id.source);
            newstitle = itemView.findViewById(R.id.title_news);
            newsDescription = itemView.findViewById(R.id.title_description);
            newsImageUrl  = itemView.findViewById(R.id.published_At);



        }
    }
}
