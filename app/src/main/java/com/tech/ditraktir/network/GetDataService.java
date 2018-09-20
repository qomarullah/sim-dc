package com.tech.ditraktir.network;

import com.tech.ditraktir.model.Project;
import com.tech.ditraktir.model.GenericResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mfstech on 30/08/18.
 */

public interface GetDataService {

    @GET("getTraktir.php")
    Call<Project> getTraktir();

    @GET("submitTraktir.php")
    Call<GenericResponse> submitTraktir(
            @Query("id") Integer id,
            @Query("total") Integer total);
    @GET("getProject")
    Call<Project> getProject();

}