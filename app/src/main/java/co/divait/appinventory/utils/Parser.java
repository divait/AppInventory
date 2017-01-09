package co.divait.appinventory.utils;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.divait.appinventory.network.HttpCall;

/**
 * Created by divait on 8/01/2017.
 *
 * Parse the JSON Data to objects.
 */

public class Parser {

    public interface Callback {
        void onApps (String data);
        void onTitle (String title);
        void onRights (String rights);
        void onError (String error);
    }

    public static void getData(Context context, final Callback callback) {
        HttpCall httpCall = new HttpCall(context);
        httpCall.getMainData(new HttpCall.Callback() {

            @Override
            public void onSuccess(String response) {
                parseMainData(response, callback);
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

    private static void parseMainData(String response, Callback callback) {
        try {
            JSONObject json = new JSONObject(response);
            JSONObject feed = json.getJSONObject("feed");

            callback.onTitle(feed.getJSONObject("title").getString("label"));
            callback.onRights(feed.getJSONObject("rights").getString("label"));

            JSONArray apps = feed.getJSONArray("entry");
        } catch (JSONException e) {
            e.printStackTrace();
            callback.onError("Incorrect Data.");
        }
    }
}
