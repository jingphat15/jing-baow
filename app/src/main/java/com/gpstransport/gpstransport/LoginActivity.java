package com.gpstransport.gpstransport;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gpstransport.gpstransport.Negocio.Usuario;
import com.gpstransport.gpstransport.Repositorios.LoginRepositorio;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    public EditText txtNombre;
    public EditText txtPass;
    public Button btIngresar;

    ProgressDialog pDialog;
    ArrayList<Usuario> arrayUsuario;
    String usuario;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_login);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtPass = (EditText) findViewById(R.id.txtPass);
        btIngresar = (Button) findViewById(R.id.btLogin);

        btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = txtNombre.getText().toString();
                pass = txtPass.getText().toString();
                new getDatosLogin().execute();
            }
        });
    }




    public class getDatosLogin extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Muestra Cuadro de cargando
            pDialog = new ProgressDialog(LoginActivity.this);
            pDialog.setMessage("Validando... ");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            LoginRepositorio login = new LoginRepositorio();
            arrayUsuario = login.obtenerUsuarios();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();

            Boolean estado = false;

            for (Usuario usuarioActual: arrayUsuario) {
                if (usuario.equalsIgnoreCase(usuarioActual.getCuenta()) && pass.equals(usuarioActual.getPassword())) {
                    estado= true;
                    break;
                }
            }

            if (estado) {
                Intent in = new Intent(getApplicationContext(), principalActivity.class);
                in.putExtra("usuario", usuario);
                startActivity(in);

            } else {
                Toast.makeText(LoginActivity.this, "Contrasena incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
