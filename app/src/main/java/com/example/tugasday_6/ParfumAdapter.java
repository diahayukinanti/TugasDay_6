package com.example.tugasday_6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParfumAdapter extends RecyclerView.Adapter<ParfumAdapter.ViewHolder> {

    private ArrayList<ParfumModel> parfumModel;

    public ParfumAdapter(ArrayList<ParfumModel> parfumModel){
        this.parfumModel = parfumModel;
    }

    @NonNull
    @Override
    public ParfumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ParfumAdapter.ViewHolder holder, int position) {
        holder.namaParfum.setText(parfumModel.get(position).getNamaParfum());
        holder.gambarParfum.setImageResource(parfumModel.get(position).getGambarParfum());

    }

    @Override
    public int getItemCount() {
        return parfumModel.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ParfumModel model);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements com.example.tugasday_6.ViewHolder {
        TextView namaParfum;
        ImageView gambarParfum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaParfum = itemView.findViewById(R.id.nama_parfum);
            gambarParfum = itemView.findViewById(R.id.gambar_parfum);
            itemView.setOnClickListener((View.OnClickListener) this);

        }
        @Override
        public void onClick(View v) {
            if (listener != null){
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION){
                    listener.onItemClick(parfumModel.get(position));
                }
            }
        }

    }
}