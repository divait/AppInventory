package co.divait.appinventory.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import co.divait.appinventory.R;
import co.divait.appinventory.utils.Parser;

public class SplashActivity extends AppCompatActivity implements Parser.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Parser.getData(this, this);
    }

    @Override
    public void onApps(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTitle(String title) {
        Toast.makeText(this, title, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRights(String rights) {
        Toast.makeText(this, rights, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
