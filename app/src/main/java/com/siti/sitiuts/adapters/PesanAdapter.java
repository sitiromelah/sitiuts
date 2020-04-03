package com.siti.sitiuts.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siti.sitiuts.R;
import com.siti.sitiuts.models.Pesan;

import java.util.List;

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.ViewHolder> {
    private List<Pesan> items;
    private OnItemPesanListener listener;

    public PesanAdapter(List<Pesan> items, OnItemPesanListener listener) {
        this.items = items;
        this.listener = listener;

    }
    @NonNull
    @Override
    public PesanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesanAdapter.ViewHolder holder, int position) {
        Pesan item = items.get(position);
        holder.bind(position, item);
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaPemesan;
        TextView nomorMeja;
        TextView pesanKopi;
        TextView jumlahPesanan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaPemesan = itemView.findViewById(R.id.text_nama);
            nomorMeja = itemView.findViewById(R.id.text_nomor);
            pesanKopi = itemView.findViewById(R.id.text_pesan);
            jumlahPesanan = itemView.findViewById(R.id.text_jumlah);
        }

        public void bind(final int index, final Pesan item) {
            namaPemesan.setText(item.getNama());
            nomorMeja.setText(item.getNomor());
            pesanKopi.setText(item.getPesan());
            jumlahPesanan.setText(item.getJumlah());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPesanClicked(index, item);
                }
            });
        }
    }
    public interface OnItemPesanListener {
        void onPesanClicked(int index, Pesan item);
    }
}
