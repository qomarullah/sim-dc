package com.tech.sim.network;

import com.tech.sim.model.Category;
import com.tech.sim.model.Project;
import com.tech.sim.model.GenericResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mfstech on 30/08/18.
 */

public interface GetDataService {


    @GET("getproject")
    Call<Project> getProject();
    @GET("getcategory")
    Call<Category> getCategory(@Query("parent_id") int id, @Query("type") int type);

}