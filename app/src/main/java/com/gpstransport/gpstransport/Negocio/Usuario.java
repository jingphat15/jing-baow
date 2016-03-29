package com.gpstransport.gpstransport.Negocio;

/**
 * Created by MiguelAngel on 19/03/2016.
 */
public class Usuario {
    private String cuenta;
    private String password;

    public Usuario(String cuenta, String password) {
        this.cuenta = cuenta;
        this.password = password;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
