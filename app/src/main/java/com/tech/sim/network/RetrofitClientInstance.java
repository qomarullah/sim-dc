package com.tech.sim.network;

import com.tech.sim.UnsafeOkHttpClient;

import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tech.sim.UnsafeOkHttpClient.getUnsafeOkHttpClient;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    //private static final String BASE_URL = "http://128.199.190.210:7000/ditraktir/v2/";
    private static final String BASE_URL = "http://128.199.190.210:7000/sim-dc/public/api/";

    static OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}