package com.android.project.first.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.android.project.first.R;
import com.android.project.first.fragment.LiberadoFragment;
import com.android.project.first.fragment.QuarentenaFragment;
import com.android.project.first.fragment.TratamentoFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class ProntuariosActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBarCustom();
        setContentView(R.layout.activity_prontuarios);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),FragmentPagerItems.with(this)
                .add("Liberados", LiberadoFragment.class)
                .add("Em Tratamento", TratamentoFragment.class)
                .add("Em Quarentena", QuarentenaFragment.class)
                .create());

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }

    public void actionBarCustom(){
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Pacientes");
    }
}