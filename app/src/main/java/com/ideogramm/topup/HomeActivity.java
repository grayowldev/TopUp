package com.ideogramm.topup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class HomeActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout,rechargeInput;
    private TextView textView;
    private AutoCompleteTextView acDropdown;
    private String network,rechargeCode;
    private Button rechargeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textInputLayout = findViewById(R.id.text_input_layout);
        rechargeInput = findViewById(R.id.home_rechargeInput);
        acDropdown = findViewById(R.id.ac_dropdown);
        rechargeBtn = findViewById(R.id.home_rechargeBtn);

        //testing
        textView = findViewById(R.id.textView2);

        String[] networkList = {
                "MTN",
                "Tigo",
                "Glo",
                "Vodafone",
                "Tmobile"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                HomeActivity.this,
                R.layout.dropdown_item,
                networkList
        );

        acDropdown.setAdapter(adapter);

        rechargeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                network = textInputLayout.getEditText().getText().toString();
                rechargeCode = rechargeInput.getEditText().getText().toString();


                 if (!network.isEmpty() && !rechargeCode.isEmpty()){
//                     textView.setText(rechargeCode);
                     String processNum = "tel:" + getProcessNumber("Ghana",network) + "#";
                     Intent callIntent = new Intent(Intent.ACTION_CALL);
                     callIntent.setData(Uri.parse(processNum));
                     startActivity(callIntent);

                 }else {
                     Toast.makeText(getApplicationContext(), "please enter your network & recharge code.", Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }

    private String getProcessNumber(String country, String network) {
        if (country.equals("MTN")){
            return "*125*";
        }else {
            Toast.makeText(getApplicationContext(), network + " is currently unsupported", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}