package com.android.project.first.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.project.first.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
    }
    public void abrirTelaCadastro(View view){
        Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intent);
    }
    public void abrirTelaProntuarios(View view){
        Intent intent = new Intent(MainActivity.this, ProntuariosActivity.class);
        startActivity(intent);
    }


}