package com.example.hdeaguila.pushnotifications.restAPI.model;

/**
 * Created by hd.eaguila on 25/07/2016.
 */
public class UsuarioRespuesta {

    private String id ;
    private String token ;

    UsuarioRespuesta(String id, String token){
        this.id = id;
        this.token = token;
    }

    UsuarioRespuesta(){

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
