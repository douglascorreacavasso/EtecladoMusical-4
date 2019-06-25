package com.example.etecladomusical.telas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.etecladomusical.R;
import com.google.firebase.FirebaseApp;

public class MenuConfig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_config);
        FirebaseApp.initializeApp(this);

    }
}
