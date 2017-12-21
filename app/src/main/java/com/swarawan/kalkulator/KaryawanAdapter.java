package com.swarawan.kalkulator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by rioswarawan on 12/20/17.
 */

public class KaryawanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<KaryawanModel> semuaKaryawan;

    public KaryawanAdapter(List<KaryawanModel> semuaKaryawan) {
        this.semuaKaryawan = semuaKaryawan;
    }

    /**
     * Definisi View Holder, kemudian dipasang ke Adapter
     * menggunakan method ini.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_karyawan, parent, false);
        return new KaryawanViewHolder(view);
    }

    /**
     * ViewHolder diisikan dengan data, menggunakan method ini.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        KaryawanViewHolder viewHolder = (KaryawanViewHolder) holder;
        KaryawanModel model = semuaKaryawan.get(position);

        viewHolder.labelNama.setText(model.nama);
        viewHolder.labelEmail.setText(model.email);

        Glide.with(context)
                .load(model.image)
                .into(viewHolder.imageKaryawan);
    }

    /**
     * Definisi total data yang akan di render ke RecyclerView
     */
    @Override
    public int getItemCount() {
        return semuaKaryawan.size();
    }

    class KaryawanViewHolder extends RecyclerView.ViewHolder {

        ImageView imageKaryawan;
        TextView labelNama;
        TextView labelEmail;

        public KaryawanViewHolder(View itemView) {
            super(itemView);

            imageKaryawan = itemView.findViewById(R.id.image_karyawan);
            labelNama = itemView.findViewById(R.id.label_nama);
            labelEmail = itemView.findViewById(R.id.label_email);
        }
    }
}
