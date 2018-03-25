package com.example.asus.primadi_1202154151_modul5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 3/25/2018.
 */

public class adapter extends RecyclerView.Adapter<adapter.holder> {
    private Context context;
    private List<AddData> daftar;
    int color;

    //konstruktor
    public adapter(Context konteks, List<AddData> list, int color) {
        this.context = konteks;
        this.daftar = list;
        this.color = color;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardviewlist, parent, false);
        holder viewholder = new holder(view);
        return viewholder;
    }
    //menyetting nilai yang didapatkan pada viewholder
    @Override
    public void onBindViewHolder(holder holder, int position) {
        AddData data = daftar.get(position);
        holder.list.setText(data.getTodo());
        holder.Description.setText(data.getDesc());
        holder.Priority.setText(data.getPrior());
        holder.cardv.setCardBackgroundColor(context.getResources().getColor(this.color));
    }

    @Override
    public int getItemCount() {
        return daftar.size();
    }
        //mendapatkan list dari adapter
        public AddData getData(int position){
            return daftar.get(position);
        }

        //untuk menghapus list
    public void deleteData(int i){
        //remove item yang terpilih
        daftar.remove(i);
        //memberi notifikasi item yang di remove
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, daftar.size());
    }
    class holder extends RecyclerView.ViewHolder{
        //deklarasi variable yang akan digunakan
        public TextView list, Description, Priority;
        public CardView cardv;
        public holder(View itemView){
            super(itemView);

            //mengakses id text view pada layout dan juga cardview
            list = itemView.findViewById(R.id.awal);
            Description = itemView.findViewById(R.id.deskripsi);
            Priority = itemView.findViewById(R.id.number);
            cardv = itemView.findViewById(R.id.cardlist);
        }
    }
}
