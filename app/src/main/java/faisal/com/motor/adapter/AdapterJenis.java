package faisal.com.motor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import faisal.com.motor.Detail_Pabrikan;
import faisal.com.motor.R;
import faisal.com.motor.models.JenisMotor;
import faisal.com.motor.models.Pabrikan;

/**
 * Created by Man. United on 14/11/2017.
 */

public class AdapterJenis extends RecyclerView.Adapter<AdapterJenis.JenisViewHolder> {
    public Context context;
    private List<JenisMotor> listJenis;

    public AdapterJenis(Context context, List<JenisMotor> listJenis) {
        this.context = context;
        this.listJenis = listJenis;
    }

    @Override
    public JenisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jenismotor,parent,false);
        return new AdapterJenis.JenisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JenisViewHolder holder, int position) {
        final JenisMotor jenis = listJenis.get(position);
        holder.namaJenis.setText(jenis.getJenisNamaMotor());

    }


    @Override
    public int getItemCount() {
        return listJenis.size();
    }


    public class JenisViewHolder extends RecyclerView.ViewHolder {
        public TextView namaJenis;
        public JenisViewHolder(View itemView) {
            super(itemView);
            namaJenis = itemView.findViewById(R.id.idNamaJenisMotor);//ambil dari id item pabrix
        }
    }
}
