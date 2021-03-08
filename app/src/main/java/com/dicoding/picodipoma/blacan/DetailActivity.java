package com.dicoding.picodipoma.blacan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

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
        setContentView(R.layout.activity_detail);

        tvJudul = findViewById(R.id.tv_judul);
        tvGenre = findViewById(R.id.tv_genre);
        tvPh = findViewById(R.id.tv_ph);
        tvTanggal = findViewById(R.id.tv_tanggal);
        tvOverview = findViewById(R.id.tv_deskripsi);
        imgCover = findViewById(R.id.img_photo);
        tvRating = findViewById(R.id.tv_rating);
        tvWaktu = findViewById(R.id.tv_time);
        tvAktor = findViewById(R.id.tv_aktor);

        DataA dataA = getIntent().getParcelableExtra(EXTRA_MOVIE);
        assert dataA != null;
        tvJudul.setText(dataA.getJudul());
        tvGenre.setText(dataA.getGenre());
        tvPh.setText(dataA.getPh());
        tvTanggal.setText(dataA.getTanggal());
        tvOverview.setText(dataA.getOverview());

        Glide.with(this)
                .load(dataA.getPhoto())
                .apply(new RequestOptions().override(450, 650))
                .into(imgCover);

        tvRating.setText(dataA.getRating());
        tvWaktu.setText(dataA.getWaktu());
        tvAktor.setText(dataA.getAktor());
    }
}
