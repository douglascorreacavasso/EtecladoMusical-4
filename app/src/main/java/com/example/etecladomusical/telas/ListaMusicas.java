package com.example.etecladomusical.telas;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.etecladomusical.R;
import com.google.firebase.FirebaseApp;

public class ListaMusicas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lista_musicas);
        FirebaseApp.initializeApp(this);

    }
}
