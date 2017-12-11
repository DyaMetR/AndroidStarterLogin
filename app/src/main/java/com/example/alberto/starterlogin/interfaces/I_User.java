package com.example.alberto.starterlogin.interfaces;

import com.example.alberto.starterlogin.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alberto on 05/12/2017.
 */

public interface I_User {
    @GET("servicios/servicios.php")
    Call<User> login(
            @Query("opcion") String option,
            @Query("rif") String rif,
            @Query("clave") String clave
    );

}
