package com.ideogramm.topup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

public class HomeActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private AutoCompleteTextView acDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textInputLayout = findViewById(R.id.text_input_layout);
        acDropdown = findViewById(R.id.ac_dropdown);

        String[] networkList = {
                "MTN",
                "Tigo",
                "Glo",
                "Vodafone"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                HomeActivity.this,
                R.layout.dropdown_item,
                networkList
        );

        acDropdown.setAdapter(adapter);
    }


}