package co.divait.appinventory.app_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.divait.appinventory.R;
import co.divait.appinventory.entities.AppObject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by divait on 11/01/2017.
 *
 * The fragment of the Activity.
 */

public class AppListFragment extends Fragment implements AppListContract.View {

    private AppsListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private AppListContract.Presenter presenter;

    private RecyclerView list;

    private AppsListAdapter.AppItemListener itemListener = new AppsListAdapter.AppItemListener(){
        @Override
        public void onAppClick(AppObject clickedApp) {

        }
    };

    public AppListFragment() {
        // Requires empty public constructor
    }

    public static AppListFragment newInstance() {
        return new AppListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listAdapter = new AppsListAdapter(new ArrayList<AppObject>(0), itemListener);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);


        list = (RecyclerView) root.findViewById(R.id.list);
        list.setHasFixedSize(true);
        // use a linear layout manager TODO
        layoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(layoutManager);

        list.setAdapter(listAdapter);

        return root;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        // TODO
    }

    @Override
    public void showApps(List<AppObject> apps) {
        listAdapter.replaceData(apps);
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
        this.presenter = checkNotNull(presenter);
    }
}
