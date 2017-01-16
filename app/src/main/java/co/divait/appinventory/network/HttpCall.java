package co.divait.appinventory.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by divait on 8/01/2017.
 *
 * Make all the http calls.
 */

public class HttpCall {
    private static final String MAIN_URL = "https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json";

    public interface Callback {
        void onSuccess(String response);
        void onError(String error);
    }

    private Context context;

    public HttpCall (Context context) {
        this.context = context;
    }

    public void getMainData(final Callback callback) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, MAIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError("Server Error.");
                    }
        });

        queue.add(stringRequest);
    }

}
