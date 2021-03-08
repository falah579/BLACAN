package com.dicoding.picodipoma.blacan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailTvActivity extends AppCompatActivity {

    public static final String EXTRA_TV = "extra_tv";

    TextView tvJudul;
    TextView tvGenre;
    TextView tvPh;
    TextView tvTanggal;
    TextView tvOverview;
    ImageView imgCover;
    TextView tvRating;
    TextView tvWaktu;
    TextView tvAktor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        tvJudul = findViewById(R.id.tv_judul);
        tvGenre = findViewById(R.id.tv_genre);
        tvPh = findViewById(R.id.tv_ph);
        tvTanggal = findViewById(R.id.tv_tanggal);
        tvOverview = findViewById(R.id.tv_deskripsi);
        imgCover = findViewById(R.id.img_photo);
        tvRating = findViewById(R.id.tv_rating);
        tvWaktu = findViewById(R.id.tv_time);
        tvAktor = findViewById(R.id.tv_aktor);

        DataF dataF = getIntent().getParcelableExtra(EXTRA_TV);
        assert dataF != null;
        tvJudul.setText(dataF.getJudul());
        tvGenre.setText(dataF.getGenre());
        tvPh.setText(dataF.getPh());
        tvTanggal.setText(dataF.getTanggal());
        tvOverview.setText(dataF.getOverview());

        Glide.with(this)
                .load(dataF.getPhoto())
                .apply(new RequestOptions().override(450, 650))
                .into(imgCover);

        tvRating.setText(dataF.getRating());
        tvWaktu.setText(dataF.getWaktu());
        tvAktor.setText(dataF.getAktor());
    }
}
