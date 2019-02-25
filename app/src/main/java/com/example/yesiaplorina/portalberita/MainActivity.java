package com.example.yesiaplorina.portalberita;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yesiaplorina.portalberita.Adapter.BeritaAdapter;
import com.example.yesiaplorina.portalberita.Network.ConfigRetrofit;
import com.example.yesiaplorina.portalberita.Pojo.BeritaItem;
import com.example.yesiaplorina.portalberita.Pojo.ResponseBerita;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //1 deklarasi



    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.casting

        recyclerView = findViewById(R.id.recyclerview);

        sendRequest();
    }

    private void sendRequest() {

        //3
        ConfigRetrofit.getInstanceee().getDataBerita().enqueue(new Callback<ResponseBerita>() {

            //ketika respon keservernya berhasil
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                if (response!=null){
                    boolean status = response.body().isStatus();
                    List<BeritaItem> ListDataBerita = response.body().getBerita();

                    //cek kalo true
                    if (status){
                        setUpListBerita(ListDataBerita);
                    }
                }
            }
            //Responnya gagal
            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

            }
        });
    }

    private void setUpListBerita(List<BeritaItem> ListDataBerita) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //panggil adapternya
        BeritaAdapter adapter=new BeritaAdapter(this, ListDataBerita);
        recyclerView.setAdapter(adapter);

    }

}
