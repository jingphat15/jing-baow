package com.gpstransport.gpstransport.Repositorios;

import com.gpstransport.gpstransport.Datos.Parseadores.LoginParser;
import com.gpstransport.gpstransport.Negocio.Usuario;
import com.gpstransport.gpstransport.ServicioWeb.Servicio;

import java.util.ArrayList;

/**
 * Created by MiguelAngel on 19/03/2016.
 */
public class LoginRepositorio {
    public static  final String URL="http://gpstransport.tiendarubiks.com";

    Servicio servicio=new Servicio();
    
    public ArrayList<Usuario> obtenerUsuarios(){

        String json= servicio.realizarPeticion(URL,1);

        ArrayList<Usuario> retornarUsuarios =  LoginParser.getListaUsuarios(json);
        return retornarUsuarios;
    }



}
