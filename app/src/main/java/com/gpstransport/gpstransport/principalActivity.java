package com.gpstransport.gpstransport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class principalActivity extends AppCompatActivity {

    public EditText txtBienvenida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_principal);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        txtBienvenida = (EditText) findViewById(R.id.txtBienvenida);

        Intent in = getIntent();
        setTitle(in.getStringExtra("usuario"));
        txtBienvenida.setText("Bienvenid@");
    }


}
