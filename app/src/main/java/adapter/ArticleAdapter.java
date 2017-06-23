package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xordroid.androidwebservice.R;

import java.util.List;

import model.Article;
import util.Constant;

/**
 * Created by PUNIT SHARMA on 6/23/2017.
 * Email: mailpunitsharma@gmail.com
 * Website: www.xordroid.com
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<Article> articles;
    private Context context;

    public ArticleAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ViewHolder holder, int position) {

        Article article = articles.get(position);
        holder.tv_title.setText(article.getTitle());
        holder.tv_posted_on.setText(article.getCreated_at());

        Picasso.with(context).load(Constant.IMAGE_URL+article.getImage())
                .error(R.drawable.diamond)
                .placeholder(R.drawable.diamond)
                .into(holder.img_articel);

    }



    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_articel;
        TextView tv_posted_on, tv_title;
        RelativeLayout rl_article;

        public ViewHolder(View itemView) {
            super(itemView);
            img_articel = (ImageView) itemView.findViewById(R.id.img_articel);
            tv_posted_on = (TextView) itemView.findViewById(R.id.tv_posted_on);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            rl_article = (RelativeLayout) itemView.findViewById(R.id.rl_article);
        }
    }
}
