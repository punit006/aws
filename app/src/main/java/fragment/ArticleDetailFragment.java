package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.squareup.picasso.Picasso;
import com.xordroid.androidwebservice.R;


import org.json.JSONObject;

import model.Article;
import util.BaseFragment;
import util.Constant;

/**
 * Created by PUNIT SHARMA on 6/23/2017.
 * Email: mailpunitsharma@gmail.com
 * Website: www.xordroid.com
 */

public class ArticleDetailFragment extends BaseFragment {

    Article article;
    private TextView tv_content,tv_posted_on,tv_title;
    ImageView img_articel;

    public ArticleDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        article = (Article) getArguments().getSerializable("article");
        Log.d("article",article.toString());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article_detail, container, false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_posted_on = (TextView) view.findViewById(R.id.tv_posted_on);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        img_articel = (ImageView) view.findViewById(R.id.img_articel);
        tv_title.setText(article.getTitle());
        tv_posted_on.setText(article.getCreated_at());
        tv_content.setText(Html.fromHtml(article.getContent()));
        Picasso.with(getActivity()).load(Constant.IMAGE_URL+article.getImage())
                .error(R.drawable.diamond)
                .placeholder(R.drawable.diamond)
                .into(img_articel);
    }

    @Override
    public void onResponseHandler(JSONObject response, String requestCode) {

    }

    @Override
    public void onErrorHandler(VolleyError error) {

    }
}
