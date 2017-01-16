package co.divait.appinventory.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import co.divait.appinventory.R;
import co.divait.appinventory.app_list.MainActivity;
import co.divait.appinventory.events.DataSaveEvent;
import co.divait.appinventory.utils.Data;
import co.divait.appinventory.utils.Parser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        (new Data(this)).getDataFromServer();
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
        if(!event.isSave) {
            Toast.makeText(this, event.message, Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(this, MainActivity.class);
        // intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        overridePendingTransition(android.R.anim.accelerate_decelerate_interpolator, android.R.anim.decelerate_interpolator);
        startActivity(intent);
        finish();
    }
}
