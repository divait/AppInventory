package co.divait.appinventory.app_list;

import android.support.annotation.NonNull;

import co.divait.appinventory.entities.AppObject;

/**
 * Created by divait on 11/01/2017.
 *
 *
 */

public class AppListPresenter implements AppListContract.Presenter {
    @Override
    public void loadApps(boolean forceUpdate) {
        // TODO Load apps
    }

    @Override
    public void openAppDetails(@NonNull AppObject requestedApp) {
        // TODO open App Details
    }

    @Override
    public void start() {
        // TODO onStart
    }
}
