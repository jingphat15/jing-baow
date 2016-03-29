package com.gpstransport.gpstransport.Datos.Parseadores;

import android.util.Log;

import com.gpstransport.gpstransport.Negocio.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by MiguelAngel on 19/03/2016.
 */
public class LoginParser {

public static final String ETIQUETA_IDJASON="Usuarios";
public static final String ETIQUETA_CUENTA="usuario";
public static final String ETIQUETA_PASSWORD="pass";

    public static ArrayList<Usuario> getListaUsuarios (String jsonStr) {
        ArrayList<Usuario> retorno = new ArrayList<>();

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Obtiene el listado de objetos
                JSONArray contacts = jsonObj.getJSONArray(ETIQUETA_IDJASON);

                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);

                    String cuenta = c.getString(ETIQUETA_CUENTA);
                    String password = c.getString(ETIQUETA_PASSWORD);

                    Usuario usuario= new Usuario(cuenta,password);


                    retorno.add(usuario);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("Servicio Manejador", "No se pudo obtener ningun dato de la URL");
        }



        return  retorno;
    }



}
