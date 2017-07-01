package strada.io.topup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    Strada controller = new Strada();
    SharedPreferences frPrefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                frPrefs = getPreferences( MODE_PRIVATE);
                if (frPrefs.getBoolean("firstrun",true)){
                    startActivity(new Intent(SplashActivity.this,NetworkSelectActivity.class));

                    frPrefs.edit().putBoolean("firstrun",false).commit();
                }
                else {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }
            }
        },controller.SPLASH_TIME);
    }
}
