package co.divait.appinventory.utils;

import android.content.Context;
import android.content.SharedPreferences;

import co.divait.appinventory.R;
import co.divait.appinventory.entities.AppObject;

/**
 * Created by divait on 9/01/2017.
 *
 * Manage all the Data form the app.
 */

public class Data implements Parser.Callback {

    private Context context;

    public Data(Context context) {
        this.context = context;
    }

    public void getDataFromServer() {
        Parser.getData(context, this);
    }


    @Override
    public void onApps(AppObject[] apps) {
        for(AppObject appObject : apps) {
            appObject.save();
        }
    }

    @Override
    public void onTitle(String title) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(context.getString(R.string.data_title), title);
        editor.apply();
    }

    @Override
    public void onRights(String rights) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(context.getString(R.string.data_title), rights);
        editor.apply();
    }

    @Override
    public void onError(String error) {

    }

    private SharedPreferences getPreferences() {

        return context.getSharedPreferences(
                context.getString(R.string.data_file_key), Context.MODE_PRIVATE);
    }
}
