package com.example.anjuka_koralage.downsouthtagsidriver.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anjuka_koralage.downsouthtagsidriver.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LanguageSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private Unbinder unbinder;

    @BindView(R.id.btn_sinhala)
    Button btn_sinhala;
    @BindView(R.id.btn_tamil)
    Button btn_tamil;
    @BindView(R.id.btn_english)
    Button btn_english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_select);
        unbinder = ButterKnife.bind(this);

        btn_sinhala.setOnClickListener(this);
        btn_english.setOnClickListener(this);
        btn_tamil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sinhala:

                Intent intent_sinhala = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent_sinhala);

                break;

            case R.id.btn_tamil:

                Intent intent_tamil = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent_tamil);

                break;

            case R.id.btn_english:

                Intent intent_english = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent_english);

                break;
        }
    }
}
