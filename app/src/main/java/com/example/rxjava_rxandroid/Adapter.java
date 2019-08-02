package com.example.rxjava_rxandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public  class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public Adapter(List<Contact> list) {
        this.list = list;
    }

    List<Contact>list;


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int i) {
        Contact coutry=list.get(i);
        viewHolder.txt.setText(coutry.getName());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt=itemView.findViewById(R.id.textView);
        }
    }
}
