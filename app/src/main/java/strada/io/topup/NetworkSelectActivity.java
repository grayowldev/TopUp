package strada.io.topup;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_select);

        tmobileNetBtn = (Button) findViewById(R.id.tmobile_netBtn);

    }

    //  OnClicks

}
