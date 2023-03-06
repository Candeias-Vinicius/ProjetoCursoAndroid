package com.android.project.first.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.project.first.R;
import com.android.project.first.dao.ProntuarioDAO;
import com.android.project.first.model.Prontuario;
import com.android.project.first.enums.SituacaoEnum;

public class CadastroActivity extends AppCompatActivity {

    private EditText nome;
    private EditText idade;
    private EditText temp;
    private EditText periodoTosse;
    private EditText periodoDorCabeca;
    private EditText periodoViagem;
    private CheckBox viagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        actionBarCustom();
        nome = findViewById(R.id.editTextName);
        idade = findViewById(R.id.editTextAge);
        temp = findViewById(R.id.editTextTemp);
        periodoTosse = findViewById(R.id.editTextPeriodTosse);
        periodoDorCabeca  = findViewById(R.id.editTextPeriodDor);
        periodoViagem = findViewById(R.id.editTextPais);
        viagem = findViewById(R.id.checkbox_cadastro);

    }

    public void checkBoxText(View view){
        EditText editTextPais = findViewById(R.id.editTextPais);
        CheckBox checkBoxcadastro = findViewById(R.id.checkbox_cadastro);

        if(checkBoxcadastro.isChecked()){
            editTextPais.setVisibility(View.VISIBLE);
        }else{
            editTextPais.setVisibility(View.INVISIBLE);
        }
    }

    public void voltarParaInicio(View view){

        Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void cadastrarProntuario(View view){

        ProntuarioDAO dataBase = new ProntuarioDAO(this);
        Prontuario prontuario = new Prontuario();

        prontuario.setNome(nome.getText().toString());
        prontuario.setIdade(Integer.valueOf(idade.getText().toString()));
        prontuario.setTemperatura(Integer.valueOf(temp.getText().toString()));
        prontuario.setPeriodoTosse(Integer.valueOf(periodoTosse.getText().toString()));
        prontuario.setPeriodoDorCabeca(Integer.valueOf(periodoDorCabeca.getText().toString()));
        prontuario.setPeriodoViagem(validaCheckBox());
        prontuario.setSituacao(verificaSituacao(prontuario));

        if(!dataBase.buscaNome(prontuario.getNome())){
            dataBase.inserir(prontuario);
            Toast.makeText(this,"Prontuario cadastrado com sucesso !",Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "Paciente já cadastrado!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private SituacaoEnum verificaSituacao(Prontuario prontuario){

        if(prontuario.getPeriodoViagem()<=6 && prontuario.getPeriodoViagem()>0){
            prontuario.setSituacao(SituacaoEnum.QUARENTENA);
            if(prontuario.getPeriodoTosse()>5 && prontuario.getPeriodoDorCabeca()>5 && prontuario.getTemperatura()>37){
                prontuario.setSituacao(SituacaoEnum.EM_TRATAMENTO);
            } else if (prontuario.getIdade()>60 || prontuario.getIdade()<10) {
                if(prontuario.getTemperatura()>37 || prontuario.getPeriodoDorCabeca()>3 || prontuario.getPeriodoTosse()>5){
                    prontuario.setSituacao(SituacaoEnum.QUARENTENA);
                }
            } else if (prontuario.getIdade()>10 && prontuario.getIdade()<60 && prontuario.getTemperatura()>37 && prontuario.getPeriodoDorCabeca()>5 && prontuario.getPeriodoTosse()>5) {
                prontuario.setSituacao(SituacaoEnum.QUARENTENA);
            }
        }else{
            prontuario.setSituacao(SituacaoEnum.LIBERADO);
        }

        return prontuario.getSituacao();
    }

    private void actionBarCustom(){
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Cadastro de Prontuarios");
    }
    private Integer validaCheckBox (){
        Integer semanaViagem;
        if(!viagem.isChecked()){
            semanaViagem = 0;
        }else{
            semanaViagem = Integer.valueOf(periodoViagem.getText().toString());
        }
        return semanaViagem;
    }

}