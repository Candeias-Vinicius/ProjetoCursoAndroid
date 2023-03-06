package com.android.project.first.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.project.first.R;
import com.android.project.first.adapter.AdapterProntuarios;
import com.android.project.first.dao.ProntuarioDAO;
import com.android.project.first.enums.SituacaoEnum;
import com.android.project.first.model.Prontuario;

import java.util.List;

public class TratamentoFragment extends Fragment {

    private RecyclerView recyclerViewTratamento;

    public TratamentoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tratamento, container, false);


            recyclerViewTratamento = view.findViewById(R.id.recyclerViewTratamento);
            AdapterProntuarios adapter = new AdapterProntuarios(list());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerViewTratamento.setLayoutManager(layoutManager);
            recyclerViewTratamento.setHasFixedSize(true);
            recyclerViewTratamento.setAdapter(adapter);

        return view;
    }
    public List<Prontuario> list() {

        ProntuarioDAO dataBase = new ProntuarioDAO(getActivity());
        return dataBase.listarPorSituacao(SituacaoEnum.EM_TRATAMENTO.getSituacao());

    }
}