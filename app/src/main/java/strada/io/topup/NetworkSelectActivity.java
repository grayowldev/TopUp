package strada.io.topup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NetworkSelectActivity extends AppCompatActivity {
    Button tmobileNetBtn,
            airtelNetBtn,
            mtnNetBtn,
            tigoNetBtn,
            gloNetBtn,
            expressoNetBtn,
            vodafoneNetBtn;

    //SharedPreferences sharedPreferences = getSharedPreferences("network prefs", MODE_PRIVATE);
    //SharedPreferences.Editor editor = sharedPreferences.edit();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_select);

        tmobileNetBtn = (Button) findViewById(R.id.tmobile_netBtn);


    }

    //  OnClicks
    public void onClick(View view){
        if (view.getId() == R.id.tmobile_netBtn){
            SharedPreferences sharedPreferences = getSharedPreferences("network prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("network name", "Tmobile");
            editor.commit();

            startActivity(new Intent(NetworkSelectActivity.this, HomeActivity.class));
        }

        else if (view.getId() == R.id.tmo2_btn){
            SharedPreferences sharedPreferences = getSharedPreferences("network prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("network name", "Tmo2");
            editor.commit();

            startActivity(new Intent(NetworkSelectActivity.this, HomeActivity.class));
        }

    }

}
