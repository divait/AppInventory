package co.divait.appinventory.app_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.divait.appinventory.R;
import co.divait.appinventory.entities.AppObject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by divait on 11/01/2017.
 *
 * The adapter for the list of Apps.
 */

public class AppsListAdapter extends RecyclerView.Adapter<AppsListAdapter.ViewHolder> {

    private List<AppObject> apps;
    private AppItemListener itemListener;

    public AppsListAdapter(List<AppObject> apps, AppItemListener itemListener) {
        setList(apps);
        this.itemListener = itemListener;
    }

    private void setList(List<AppObject> apps) {
        this.apps = checkNotNull(apps);
    }

    public void replaceData(List<AppObject> apps) {
        setList(apps);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_apps, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(apps.get(position).getName());
        holder.summary.setText(apps.get(position).getSummary());
        holder.price.setText(holder.itemView.getContext().getString(R.string.price, Float.toString(apps.get(position).getPrice())));
        holder.artist.setText(apps.get(position).getArtist());
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView summary;
        public TextView price;
        public TextView artist;
        public ImageView image;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.text_list);
            summary = (TextView) v.findViewById(R.id.text_list_summary);
            price = (TextView) v.findViewById(R.id.text_list_price);
            artist = (TextView) v.findViewById(R.id.text_list_creator);
            image = (ImageView)v.findViewById(R.id.image_list);

        }
    }

    public interface AppItemListener {

        void onAppClick(AppObject clickedApp);
    }
}
