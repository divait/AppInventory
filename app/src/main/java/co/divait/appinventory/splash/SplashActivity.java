package co.divait.appinventory.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import co.divait.appinventory.R;
import co.divait.appinventory.utils.Data;
import co.divait.appinventory.utils.Parser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        (new Data(this)).getDataFromServer();
    }
}
