package fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.xordroid.androidwebservice.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import adapter.ArticleAdapter;
import listener.RecyclerClick_Listener;
import listener.RecyclerTouchListener;
import model.Article;
import response.ArticleResponse;
import util.BaseFragment;
import util.Constant;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by PUNIT SHARMA on 6/23/2017.
 * Email: mailpunitsharma@gmail.com
 * Website: www.xordroid.com
 */

public class ArticleListFragment extends BaseFragment {

    RecyclerView recycler_articles;
    List<Article> articles;
    private SharedPreferences sharedPreferences;
    public ArticleListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_article_list, container, false);
        initView(view);
        HashMap<String,String> params = new HashMap();
        params.put("authkey",sharedPreferences.getString("authkey","0"));
        executeGet(params, Constant.REQ_1,Constant.REQUEST_REQ_1);
        return view;
    }

    private void initView(View view) {
        sharedPreferences = getActivity().getSharedPreferences(Constant.SHARED_PREFERENCE,MODE_PRIVATE);
        recycler_articles = (RecyclerView) view.findViewById(R.id.recycler_articles);
        recycler_articles.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_articles.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recycler_articles, new RecyclerClick_Listener() {
            @Override
            public void onClick(View view, int position) {

                ArticleDetailFragment articleDetailFragment = new ArticleDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("article", articles.get(position) );
                articleDetailFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, articleDetailFragment).addToBackStack(null).commit();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public void onResponseHandler(JSONObject response, String requestCode) {
        if (requestCode.equalsIgnoreCase(Constant.REQ_2)){
            Gson gson = new Gson();
            ArticleResponse articlesResponse = gson.fromJson(response.toString(),ArticleResponse.class);
            if (articlesResponse.getStatus()==1){
                articles = articlesResponse.getData();
                recycler_articles.setAdapter(new ArticleAdapter(articles,getActivity()));
            }
            else {
                showMessage(articlesResponse.getMessage());
            }
        }
    }

    @Override
    public void onErrorHandler(VolleyError error) {

    }
}
