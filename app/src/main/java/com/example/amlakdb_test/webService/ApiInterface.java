package com.example.amlakdb_test.webService;

import com.example.amlakdb_test.model.to.FileResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("ادامه Http")
    Call<FileResponse> getFiles();
}
