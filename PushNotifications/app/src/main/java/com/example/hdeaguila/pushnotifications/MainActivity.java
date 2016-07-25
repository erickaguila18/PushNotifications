package com.example.hdeaguila.pushnotifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hdeaguila.pushnotifications.restAPI.Endpoints;
import com.example.hdeaguila.pushnotifications.restAPI.adapter.RestAPIAdapter;
import com.example.hdeaguila.pushnotifications.restAPI.model.UsuarioRespuesta;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarToken(View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(this,token,Toast.LENGTH_LONG).show();
        enviar(token);
    }

    public void enviar(String token){
        RestAPIAdapter restAPIAdapter =  new RestAPIAdapter();
        Endpoints endpoints = restAPIAdapter.establecerConexion();
        final Call<UsuarioRespuesta> usuarioRespuestaCall = endpoints.registrarTokenID(token);
        usuarioRespuestaCall.enqueue(new Callback<UsuarioRespuesta>() {
            @Override
            public void onResponse(Call<UsuarioRespuesta> call, Response<UsuarioRespuesta> response) {
                UsuarioRespuesta usuarioRespuesta = response.body();

                Log.d("LOG", usuarioRespuesta.getId());
                Log.d("LOG", usuarioRespuesta.getToken());
            }

            @Override
            public void onFailure(Call<UsuarioRespuesta> call, Throwable t) {
                Log.d("Failure","");
            }
        });
    }
}
