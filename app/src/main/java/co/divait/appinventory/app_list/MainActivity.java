package co.divait.appinventory.app_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import co.divait.appinventory.R;
import co.divait.appinventory.events.DataSaveEvent;
import co.divait.appinventory.utils.ActivityUtils;
import co.divait.appinventory.utils.Data;

public class MainActivity extends AppCompatActivity {
    private AppListPresenter appsPresenter;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppListFragment appsFragment =
                (AppListFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (appsFragment == null) {
            // Create the fragment
            appsFragment = AppListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), appsFragment, R.id.container);
        }

        data = new Data(this);

        // Create the presenter
        appsPresenter = new AppListPresenter(
                data, appsFragment);

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    // This method will be called when Data Saved event is call.
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataSaveEvent(DataSaveEvent event) {
        appsPresenter.showApps(data.getDataSaved());
    }
}
