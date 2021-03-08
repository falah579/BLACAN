package com.dicoding.picodipoma.blacan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MoviAdapter extends RecyclerView.Adapter<MoviAdapter.CardViewViewHolder> {

    private ArrayList<DataA> listMovie;

    public MoviAdapter(ArrayList<DataA> list){
        this.listMovie = list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public MoviAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flim, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        DataA dataA = listMovie.get(position);

        holder.tvJudul.setText(dataA.getJudul());
        holder.tvGenre.setText(dataA.getGenre());
        holder.tvPh.setText(dataA.getPh());
        holder.tvTahun.setText(dataA.getTahun());
        holder.tvDeskripsi.setText(dataA.getOverview());

        Glide.with(holder.itemView.getContext())
                .load(listMovie.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvRating.setText(dataA.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvJudul, tvGenre, tvPh, tvTahun, tvTanggal , tvDeskripsi, tvRating, tvWaktu, tvAktor;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvGenre = itemView.findViewById(R.id.tv_genre);
            tvPh = itemView.findViewById(R.id.tv_ph);
            tvTahun = itemView.findViewById(R.id.tv_tahun);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvWaktu = itemView.findViewById(R.id.tv_time);
            tvAktor = itemView.findViewById(R.id.tv_aktor);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(DataA dataA);
    }
}
