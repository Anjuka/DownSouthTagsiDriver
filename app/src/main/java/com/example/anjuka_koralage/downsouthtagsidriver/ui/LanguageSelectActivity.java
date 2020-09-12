package com.example.anjuka_koralage.downsouthtagsidriver.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anjuka_koralage.downsouthtagsidriver.R;

import java.util.Locale;

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

        //set Language
        loadLocal();

        btn_sinhala.setOnClickListener(this);
        btn_english.setOnClickListener(this);
        btn_tamil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sinhala:

                //Set Sinhala Language
                setLocal("si");
                recreate();
                moveOn();

                break;

            case R.id.btn_tamil:

                //Set Tamil Language
                setLocal("ta");
                recreate();
                moveOn();

                break;

            case R.id.btn_english:

                //Set English Language
                setLocal("en");
                recreate();
                moveOn();

                break;
        }
    }

    private void moveOn() {

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void setLocal(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext()
                .getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("settings", Activity.MODE_PRIVATE).edit();
        editor.putString("Selected_Lang", lang);
        editor.apply();

    }

    public void loadLocal() {
        SharedPreferences preferences = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("Selected_Lang", "");
        setLocal(language);
    }
}
