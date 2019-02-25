package com.example.yesiaplorina.portalberita.Network;

import android.media.session.MediaSession;

import com.example.yesiaplorina.portalberita.Pojo.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("tampil_berita.php")
    Call<ResponseBerita> getDataBerita();
}
