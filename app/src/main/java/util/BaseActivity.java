package util;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by PUNIT SHARMA on 6/23/2017.
 * Email: mailpunitsharma@gmail.com
 * Website: www.xordroid.com
 */

public abstract class BaseActivity extends AppCompatActivity {

    public void executePost(HashMap<String, String> params, String url, final String requestcode) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("response", response.toString());
                onResponseHandler(response, requestcode);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onErrorHandler(error);
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void executeGet(HashMap<String, String> params, String url, final String requestcode) {

        StringBuilder builder = new StringBuilder();

        for (String key : params.keySet()) {
            Object value = params.get(key);
            if (value != null) {
                try {
                    value = URLEncoder.encode(String.valueOf(value), "UTF-8");
                    if (builder.length() > 0)
                        builder.append("&");
                    builder.append(key).append("=").append(value);
                } catch (UnsupportedEncodingException e) {
                }
            }
        }

        url += "?" + builder.toString();
        Log.d("param url", url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("response", response.toString());
                onResponseHandler(response, requestcode);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public abstract void onResponseHandler(JSONObject response, String requestCode);

    public abstract void onErrorHandler(VolleyError error);

    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
