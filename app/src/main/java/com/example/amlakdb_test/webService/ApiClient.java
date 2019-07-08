package com.example.amlakdb_test.webService;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String base_URL = "http://192";
    private static Retrofit retrofit = null;

    public static Retrofit getclint() {
        if (retrofit == null) {
            retrofit = new Builder().baseUrl(base_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
