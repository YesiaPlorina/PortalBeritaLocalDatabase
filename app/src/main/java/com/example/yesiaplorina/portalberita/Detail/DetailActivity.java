package com.example.yesiaplorina.portalberita.Detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.yesiaplorina.portalberita.Pojo.BeritaItem;
import com.example.yesiaplorina.portalberita.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    //1.deklarasi TODO DEKLARASI.
    public static final String EXTRA_OBJECT = "OBJECT";
    ImageView ivImageDetail;
    TextView tvTglDetail, tvPenulisDetail;
    WebView wbContentDetail;
   Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //2.casting
        ivImageDetail = findViewById(R.id.iv_images_detail);
        tvTglDetail = findViewById(R.id.tv_tgl_posting_detail);
        tvPenulisDetail = findViewById(R.id.tv_penulis_detail);
        wbContentDetail = findViewById(R.id.wv_content_detail);
        toolbar = findViewById(R.id.toolbarrr);


        getDataRecieviedDetail();
    }

    // 27. method hasil
    private void getDataRecieviedDetail() {

        //27.1
        BeritaItem objBerita = getIntent().getParcelableExtra(EXTRA_OBJECT);
        String isiBerita = objBerita.getIsiBerita();
        //27.3
        String image = objBerita.getFoto();
        //27.5
        String tgl = objBerita.getTanggalPosting();
        String penulis = objBerita.getPenulis();
        String judul = objBerita.getJudulBerita();
        //27.4
        Picasso.get().load(image).into(ivImageDetail);
        //27.11
        getSupportActionBar().setTitle(judul);

        wbContentDetail.getSettings().setJavaScriptEnabled(true);
        //27.2 show
        wbContentDetail.loadData(isiBerita, "text/html; charset=utf-8", "UTF-8");

        //27.8
        tvTglDetail.setText(tgl);
        tvPenulisDetail.setText(penulis);



    }
}
