package com.android.project.first.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.project.first.R;
import com.android.project.first.model.Prontuario;

import java.util.List;

public class AdapterProntuarios extends RecyclerView.Adapter<AdapterProntuarios.MyViewHolder> {

    private final List<Prontuario> prontuarios;

    public AdapterProntuarios(List<Prontuario> prontuarios) {
        this.prontuarios = prontuarios;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Prontuario prontuario = prontuarios.get(position);

        holder.nome.setText(prontuario.getNome());
        holder.idade.setText(prontuario.getIdade().toString());
        holder.temperatura.setText(prontuario.getTemperatura().toString());
        holder.dorCabeca.setText(prontuario.getPeriodoDorCabeca().toString());
        holder.tosse.setText(prontuario.getPeriodoTosse().toString());
        holder.situacao.setText(prontuario.getSituacao().getSituacao());
        holder.tempoViagem.setText(prontuario.getPeriodoViagem().toString());

    }

    @Override
    public int getItemCount() {
        return prontuarios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView idade;

        TextView temperatura;

        TextView dorCabeca;

        TextView tosse;

        TextView situacao;

        TextView tempoViagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNome);
            idade = itemView.findViewById(R.id.textIdade);
            temperatura = itemView.findViewById(R.id.textTempCorporal);
            dorCabeca = itemView.findViewById(R.id.textDorCabeca);
            tosse = itemView.findViewById(R.id.textTosse);
            situacao = itemView.findViewById(R.id.textSituacao);
            tempoViagem = itemView.findViewById(R.id.textViagem);

        }
    }


}
