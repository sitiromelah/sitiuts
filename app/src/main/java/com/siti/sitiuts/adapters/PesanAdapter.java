package com.siti.sitiuts.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siti.sitiuts.R;
import com.siti.sitiuts.models.Order;

import java.util.List;

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.ViewHolder> {
    private List<Order> items;
    private OnItemPesanListener listener;

    public PesanAdapter(List<Order> items, OnItemPesanListener listener) {
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
        Order item = items.get(position);
        holder.bind(position, item);
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaText;
        TextView nomorText;
        TextView pesanText;
        TextView jumlahText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaText = itemView.findViewById(R.id.text_nama);
            nomorText = itemView.findViewById(R.id.text_nomor);
            pesanText = itemView.findViewById(R.id.text_pesan);
            jumlahText = itemView.findViewById(R.id.text_jumlah);
        }

        public void bind(final int index, final Order item) {
            namaText.setText(item.getNama());
            nomorText.setText(item.getNomor());
            pesanText.setText(item.getPesan());
            jumlahText.setText(item.getJumlah());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPesanClicked(index, item);
                }
            });
        }
    }
    public interface OnItemPesanListener {
        void onPesanClicked(int index, Order item);
    }
}
