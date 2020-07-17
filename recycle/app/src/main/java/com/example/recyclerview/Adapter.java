package com.example.recyclerview;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    List<com.example.recyclerview.Todo> data;
    private Context c;


    public Adapter(Context context, List<com.example.recyclerview.Todo> list) {
        this.data = new ArrayList<>();
        this.data = list;
        this.c = context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup vg, int i) {

        LayoutInflater inflater = LayoutInflater.from(c);

        View v = inflater.inflate(R.layout.card, vg, false);

        return new Holder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int i) {

        com.example.recyclerview.Todo t = data.get(i);
        holder.name.setText(t.getTopic());
        holder.intro.setText(t.getDesc());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Holder extends RecyclerView.ViewHolder {


        TextView name, intro;
        Button more;

        public Holder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            intro = itemView.findViewById(R.id.intro);
            more = itemView.findViewById(R.id.more);
        }
    }

}
