package com.example.hdeaguila.pushnotifications.restAPI;

import com.example.hdeaguila.pushnotifications.restAPI.model.UsuarioRespuesta;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Field;


/**
 * Created by hd.eaguila on 25/07/2016.
 */
public interface Endpoints {
    @FormUrlEncoded
    @POST(ConstantesRestAPI.KEY_POST_ID_TOKEN)
    Call<UsuarioRespuesta> registrarTokenID(@Field("token") String token);

}
