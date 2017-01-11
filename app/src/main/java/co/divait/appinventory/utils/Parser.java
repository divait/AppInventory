package co.divait.appinventory.utils;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.divait.appinventory.R;
import co.divait.appinventory.entities.AppObject;
import co.divait.appinventory.entities.JsonApp;
import co.divait.appinventory.network.HttpCall;

/**
 * Created by divait on 8/01/2017.
 *
 * Parse the JSON Data to objects.
 */

public class Parser {

    public interface Callback {
        void onApps (AppObject[] apps);
        void onTitle (String title);
        void onRights (String rights);
        void onError (String error);
    }

    public static void getData(final Context context, final Callback callback) {
        HttpCall httpCall = new HttpCall(context);
        httpCall.getMainData(new HttpCall.Callback() {

            @Override
            public void onSuccess(String response) {
                parseMainData(response, context, callback);
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

    private static void parseMainData(String response, Context context, Callback callback) {
        try {
            JSONObject json = new JSONObject(response);
            JSONObject feed = json.getJSONObject("feed");

            callback.onTitle(feed.getJSONObject("title").getString("label"));
            callback.onRights(feed.getJSONObject("rights").getString("label"));

            String apps = feed.getString("entry");

            Gson gson = new Gson();
            JsonApp[] appObj = gson.fromJson(apps, JsonApp[].class);

            callback.onApps(AppObject.fromJsonAppToAppObject(appObj));

        } catch (JSONException e) {
            e.printStackTrace();
            callback.onError(context.getString(R.string.error_parsing_data));
        }
    }
}
