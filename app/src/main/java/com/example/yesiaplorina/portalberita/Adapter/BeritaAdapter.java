package com.example.yesiaplorina.portalberita.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yesiaplorina.portalberita.Detail.DetailActivity;
import com.example.yesiaplorina.portalberita.Network.ConfigRetrofit;
import com.example.yesiaplorina.portalberita.Pojo.BeritaItem;
import com.example.yesiaplorina.portalberita.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {

    //1
    Context ctx;

    //deklarasi list data berita
    List<BeritaItem> ListDataBerita;

    public BeritaAdapter(Context ctx, List<BeritaItem> listDataBerita) {
        this.ctx = ctx;
        ListDataBerita = listDataBerita;
    }


    @NonNull
    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //2
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_berita, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final BeritaAdapter.ViewHolder viewHolder, int i) {

        //get datanya sesuai dgn index nya & tampung dalam variabel

        final String judul = ListDataBerita.get(i).getJudulBerita();
        final String tgl = ListDataBerita.get(i).getTanggalPosting();
        final String penulis = ListDataBerita.get(i).getPenulis();
        final String isiBerita = ListDataBerita.get(i).getIsiBerita();
        final String image = ConfigRetrofit.IMAGES + ListDataBerita.get(i).getFoto();

        //dibuku 22 day 3
        viewHolder.tvJudul.setText(judul);
        viewHolder.tvTglTerbit.setText(tgl);
        viewHolder.tvPenulis.setText(penulis);

        Picasso.get().load(image).into(viewHolder.ivBerita);

        //26 dibuku
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO Set data yang mau dikirim

                BeritaItem objek = new BeritaItem();

                objek.setJudulBerita(judul);
                objek.setTanggalPosting(tgl);
                objek.setPenulis(penulis);
                objek.setIsiBerita(isiBerita);
                objek.setFoto(image);

                //TODO kirim data use intent

                Intent pindah= new Intent(ctx,DetailActivity.class);
                pindah.putExtra(DetailActivity.EXTRA_OBJECT, objek);
                ctx.startActivity(pindah);



            }
        });
    }


    @Override
    public int getItemCount() {
        if (ListDataBerita == null)
            return 0;
        return ListDataBerita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //3

        ImageView ivBerita;
        TextView tvJudul, tvTglTerbit, tvPenulis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //4
            ivBerita = itemView.findViewById(R.id.iv_berita);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvTglTerbit = itemView.findViewById(R.id.tv_tgl);
            tvPenulis = itemView.findViewById(R.id.tv_penulis);

        }
    }
}
