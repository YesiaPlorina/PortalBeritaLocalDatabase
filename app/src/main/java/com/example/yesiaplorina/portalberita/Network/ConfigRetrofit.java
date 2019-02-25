package com.example.yesiaplorina.portalberita.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    //TODO deklarasi alamat url
    public static String BASE_URL = "http://192.168.100.4/portal_berita-master/";
    public static String IMAGES = BASE_URL + "images/";

    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstanceee(){
        return setInit().create(ApiService.class);
    }
}
