package com.example.amlakdb_test.model.to;


import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FileResponse {
    @SerializedName("")
    private List<FileHa> Files;

    public List<FileHa> getFiles() {
        return this.Files;
    }

    public void setFiles(List<FileHa> files) {
        this.Files = files;
    }
}

