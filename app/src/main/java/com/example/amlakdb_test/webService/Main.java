package com.example.amlakdb_test.webService;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.example.amlakdb_test.model.to.FileResponse;
import com.example.amlakdb_test.R;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        FileRequest();
    }

    private void FileRequest() {
        ((ApiInterface) ApiClient.getclint().create(ApiInterface.class)).getFiles().enqueue(new Callback<FileResponse>() {
            public void onResponse(Call<FileResponse> call, Response<FileResponse> response) {
                if (response.isSuccessful()) {
                    for (Object next : ((FileResponse) response.body()).getFiles()) {
                        Log.i("activity_hint", "");
                    }
                }
            }

            public void onFailure(Call<FileResponse> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(Main.this.getApplicationContext(), " ارتباط اینترنت وصل نیست ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
