package strada.io.topup;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.support.design.R.id.normal;

public class HomeActivity extends AppCompatActivity {
    Strada controller = new Strada();
    Button checkBalBtn, addBalBtn, selNetBtn;
    String userCode;

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

        selNetBtn = (Button) findViewById(R.id.select_netBtn);
        selNetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, NetworkSelectActivity.class));
            }
        });

        addBalBtn = (Button) findViewById(R.id.add_balBtn);
        addBalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(HomeActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.adder_dialog, null);
                final EditText balCodeEdit = (EditText) mView.findViewById(R.id.balCode_edit);
                Button addBalDiaBtn = (Button) mView.findViewById(R.id.addBal_diaBtn);

                addBalDiaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(balCodeEdit.getText().toString().isEmpty()){
                            Snackbar snackbar = Snackbar.make(view,"Please enter your Top Up code",Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                        else {
                            addBalance(userNetwork,balCodeEdit.getText().toString());
                        }

                    }
                });

                alertBuilder.setView(mView);
                AlertDialog dialog = alertBuilder.create();
                dialog.show();
            }
        });
    }

    public void checkBalance(String network){
        String checkBalCode = controller.getCheckBalCode(network);
        startCallFunction(checkBalCode);
    }

    public void addBalance(String network, String addCode){
        String addBalCode = controller.getAddBalCode(network,Integer.parseInt(addCode));
        startCallFunction(addBalCode);
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
