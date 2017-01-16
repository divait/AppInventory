package co.divait.appinventory.app_list;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import java.util.List;

import co.divait.appinventory.entities.AppObject;
import co.divait.appinventory.utils.Data;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by divait on 11/01/2017.
 *
 *
 */

public class AppListPresenter implements AppListContract.Presenter {

    private final Data data;

    private final AppListContract.View appsView;

    private boolean firstLoad = true;

    public AppListPresenter(@NonNull Data data, @NonNull AppListContract.View appsView) {
        this.data = checkNotNull(data, "tasksRepository cannot be null");
        this.appsView = checkNotNull(appsView, "tasksView cannot be null!");

        this.appsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadApps(false);
    }

    @Override
    public void loadApps(boolean forceUpdate) {
        loadApps(forceUpdate || firstLoad, true);
        firstLoad = false;
    }

    @Override
    public void showApps(List<AppObject> apps) {
        appsView.showApps(apps);
    }

    public void loadApps(boolean forceUpdate, final boolean showLoadingUI) {
        if(showLoadingUI) {
            appsView.setLoadingIndicator(true);
        }
        if(forceUpdate) {
            data.getDataFromServer();
        } else {
            appsView.showApps(data.getDataSaved());
            appsView.setLoadingIndicator(false);
        }
    }

    @Override
    public void openAppDetails(@NonNull AppObject requestedApp) {
        // TODO open App Details
    }
}
