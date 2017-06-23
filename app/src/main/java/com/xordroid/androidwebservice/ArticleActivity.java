package com.xordroid.androidwebservice;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import fragment.ArticleListFragment;
import util.BaseActivity;

/**
 * Created by PUNIT SHARMA on 6/23/2017.
 * Email: mailpunitsharma@gmail.com
 * Website: www.xordroid.com
 */

public class ArticleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null)
            setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Articles");

        getSupportFragmentManager().beginTransaction().add(R.id.container,new ArticleListFragment()).commit();

        /*getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getSupportFragmentManager().getBackStackEntryCount()>0)
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                else
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        });*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponseHandler(JSONObject response, String requestCode) {

    }

    @Override
    public void onErrorHandler(VolleyError error) {

    }
}
