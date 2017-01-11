package co.divait.appinventory.app_list;

import android.support.v4.app.Fragment;

import java.util.List;

import co.divait.appinventory.entities.AppObject;

/**
 * Created by divait on 11/01/2017.
 *
 * The fragment of the Activity.
 */

public class AppListFragment extends Fragment implements AppListContract.View {


    @Override
    public void setLoadingIndicator(boolean active) {
        // TODO
    }

    @Override
    public void showApps(List<AppObject> apps) {
        // TODO
    }

    @Override
    public void showAppDetailsUi(Long id) {
        // TODO
    }

    @Override
    public void showNoApps() {
        // TODO
    }

    @Override
    public void setPresenter(AppListContract.Presenter presenter) {
        // TODO
    }
}
