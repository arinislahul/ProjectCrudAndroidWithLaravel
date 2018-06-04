package com.arini.laravel.network;

import com.arini.laravel.model.Mahasiswa;
import com.arini.laravel.model.MahasiswaResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MahasiswaService {
    @GET("mahasiswa")
    Call<MahasiswaResult>getMahasiswas();

    @GET("mahasiswa/{id}")
    Call<MahasiswaResult>getMahasiswas(@Path("id")int id);

    @POST("mahasiswa")
    Call<String>setMahasiswa(@Body Mahasiswa mahasiswa);

    @DELETE("mahasiswa/{id}")
    Call<String>hapusMahasiswa(@Path("id")int id);
}
