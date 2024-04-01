package com.example.tugasday_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParfumAdapter extends RecyclerView.Adapter<ParfumAdapter.ViewHolder> {

    private RecyclerViewClickListener listener;

    private ArrayList<ParfumModel> dataItem;

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView namaParfum;
        ImageView gambarParfum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            namaParfum = itemView.findViewById(R.id.nama_parfum);
            gambarParfum = itemView.findViewById(R.id.gambar_parfum);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            listener.onClick(v,getAdapterPosition());
        }
    }

    ParfumAdapter(Context context, ArrayList<ParfumModel> dataItem, RecyclerViewClickListener listener){
        this.context = context;
        this.dataItem = dataItem;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ParfumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParfumAdapter.ViewHolder holder, int position) {
        TextView namaParfum = holder.namaParfum;
        ImageView gambarParfum = holder.gambarParfum;


        namaParfum.setText(dataItem.get(position).getNamaParfum());
        gambarParfum.setImageResource(dataItem.get(position).getGambarParfum());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }



    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}