package com.android.project.first.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.android.project.first.enums.SituacaoEnum;
import com.android.project.first.model.Prontuario;
import com.android.project.first.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {
    private DBHelper dbHelper;
    private SQLiteDatabase dataBase;

    public ProntuarioDAO(Context context){
        dbHelper = new DBHelper(context);
        dataBase = dbHelper.getWritableDatabase();
    }

    public void inserir(Prontuario prontuario)  {

        ContentValues values = new ContentValues();

        values.put("nome", prontuario.getNome());
        values.put("idade", prontuario.getIdade());
        values.put("tempCorporal",prontuario.getTemperatura());
        values.put("periodoTosse", prontuario.getPeriodoTosse());
        values.put("periodoDorCabeca", prontuario.getPeriodoDorCabeca());
        values.put("tempoViagem", prontuario.getPeriodoViagem());
        values.put("situacao", prontuario.getSituacao().getSituacao());

        dataBase.insert("prontuarios",null, values);

    }
    public List<Prontuario> listarPorSituacao(String situacao) {

        List<Prontuario> prontuarios = new ArrayList<Prontuario>();

        String sql = "SELECT * FROM prontuarios WHERE situacao ="+ "'" + situacao + "'";

        Cursor cursor = dataBase.rawQuery(sql,null);

        while(cursor.moveToNext()){

            Prontuario prontuario = new Prontuario();

            prontuario.setId(cursor.getInt(0));
            prontuario.setNome(cursor.getString(1));
            prontuario.setIdade(cursor.getInt(2));
            prontuario.setTemperatura(cursor.getInt(3));
            prontuario.setPeriodoTosse(cursor.getInt(4));
            prontuario.setPeriodoDorCabeca(cursor.getInt(5));
            prontuario.setPeriodoViagem(cursor.getInt(6));
            prontuario.setSituacao(stringConverterToEnum(cursor.getString(7)));

            prontuarios.add(prontuario);

        }

        return prontuarios;
    }
    private SituacaoEnum stringConverterToEnum(String situacao){

        if(situacao.equals(SituacaoEnum.EM_TRATAMENTO.getSituacao())){
            return SituacaoEnum.EM_TRATAMENTO;
        }else if(situacao.equals(SituacaoEnum.QUARENTENA.getSituacao())){
            return SituacaoEnum.QUARENTENA;
        }else{
            return SituacaoEnum.LIBERADO;
        }
    }

    public boolean buscaNome(String nome) {

        String sql = "SELECT nome FROM prontuarios WHERE nome =" + "'" + nome + "'";

        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            if(cursor.getString(0).equals(nome)){
                return true;
            }
        }
        return false;
    }
}
