package com.example.retrofitpost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    private List<Post> items;

    public MahasiswaAdapter(List<Post> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post item = items.get(position);
        holder.txtidsiswa.setText(item.getId_siswa());
        holder.txtnama.setText(item.getNama());
        holder.txtalamat.setText(item.getAlamat());
        holder.txtjeniskelamin.setText(item.getJenis_kelamin());
        holder.txtnotelp.setText(item.getNo_telp());
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtidsiswa, txtnama, txtalamat, txtjeniskelamin, txtnotelp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtidsiswa = (TextView) itemView.findViewById(R.id.id_siswa);
            txtnama = (TextView) itemView.findViewById(R.id.nama);
            txtalamat = (TextView) itemView.findViewById(R.id.alamat);
            txtjeniskelamin = (TextView) itemView.findViewById(R.id.jk);
            txtnotelp = (TextView) itemView.findViewById(R.id.noTelp);
        }
    }

}
