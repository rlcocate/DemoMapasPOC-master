package com.example.logonpf.demomapaspoc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.logonpf.demomapaspoc.R;
import com.example.logonpf.demomapaspoc.model.Linha;

import java.util.List;

public class LinhaAdapter extends RecyclerView.Adapter<LinhaAdapter.LinhaViewHolder> {

    private List<Linha> linhas;
    private OnItemClickListener listener;


    public LinhaAdapter(List<Linha> linhas, OnItemClickListener listener) {
        this.linhas = linhas;
        this.listener = listener;
    }

    @Override
    public LinhaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View meuLayout = inflater.inflate(R.layout.item_linha_metro,
                parent, false);

        return new LinhaViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(LinhaViewHolder holder, final int position) {

        holder.tvNomeLinha.setText(linhas.get(position).getCor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(linhas.get(position));
            }
        });
        /*Picasso.with(holder.itemView.getContext())
                .load(androids.get(position).getUrlImagem())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivLogo);*/
    }

    public void update(List<Linha> items) {
        linhas = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public class LinhaViewHolder extends RecyclerView.ViewHolder
            {

        public TextView tvNomeLinha;

        public LinhaViewHolder(View itemView) {
            super(itemView);
            tvNomeLinha = (TextView) itemView.findViewById(R.id.tvNomeLinha);
        }


    }

}