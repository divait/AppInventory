package co.divait.appinventory.app_list;

import android.support.annotation.NonNull;

import java.util.List;

import co.divait.appinventory.entities.AppObject;
import co.divait.appinventory.utils.BasePresenter;
import co.divait.appinventory.utils.BaseView;

/**
 * Created by divait on 10/01/2017.
 */

public interface AppListContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showApps(List<AppObject> apps);

        void showAppDetailsUi(Long id);

        void showNoApps();
    }

    interface Presenter extends BasePresenter {

        void loadApps(boolean forceUpdate);

        void showApps(List<AppObject> apps);

        void openAppDetails(@NonNull AppObject requestedApp); // TODO
    }
}
