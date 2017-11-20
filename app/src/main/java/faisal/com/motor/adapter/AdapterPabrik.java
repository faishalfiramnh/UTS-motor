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
import faisal.com.motor.models.Pabrikan;

/**
 * Created by Man. United on 14/11/2017.
 */

public class AdapterPabrik extends RecyclerView.Adapter<AdapterPabrik.PabrikViewHolder>{
    private Context context;
    private List<Pabrikan>listPabrik;

    public AdapterPabrik(Context context, List<Pabrikan> listPabrik) {

        this.context = context;
        this.listPabrik = listPabrik;
    }


    @Override
    public PabrikViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pabrikan,parent,false);
        return new PabrikViewHolder(view);
    }


    @Override //iki kariii
    public void onBindViewHolder(PabrikViewHolder holder, int position) {
        final Pabrikan pabrik = listPabrik.get(position);
        holder.namaMerk.setText(pabrik.getMerk());
        holder.namaMerk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Detail_Pabrikan.class);
               i.putExtra("idPabrik",pabrik.getId());
               view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPabrik.size();
    }

    public class PabrikViewHolder extends RecyclerView.ViewHolder {
        public TextView namaMerk;
        public PabrikViewHolder(View itemView) {
            super(itemView);
            namaMerk = itemView.findViewById(R.id.idNamaMerk);//ambil dari id item pabrix
        }
    }
}
