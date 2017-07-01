package strada.io.topup;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Strada controller = new Strada();
    Button checkBalBtn, addBalBtn;

    //SharedPreferences sharedPreferences = getSharedPreferences("network prefs", MODE_PRIVATE);
    //String userNetwork = sharedPreferences.getString("network name", null);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("network prefs", MODE_PRIVATE);
        final String userNetwork = sharedPreferences.getString("network name", null);

        checkBalBtn = (Button) findViewById(R.id.check_balBtn);
        checkBalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBalance(userNetwork);
            }
        });
    }

    public void checkBalance(String network){
        String checkBalCode = controller.getCheckBalCode(network);
        startCallFunction(checkBalCode);
    }

    public void startCallFunction(String functionCode) {
        if (!functionCode.equals(null)) {
            Uri functionUri = Uri.parse(functionCode);
            Intent functionIntent = new Intent(Intent.ACTION_CALL, functionUri);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(functionIntent);
        }
    }
}
