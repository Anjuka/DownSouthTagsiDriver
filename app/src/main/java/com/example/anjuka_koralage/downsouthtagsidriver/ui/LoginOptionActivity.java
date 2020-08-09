package com.example.anjuka_koralage.downsouthtagsidriver.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anjuka_koralage.downsouthtagsidriver.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginOptionActivity extends AppCompatActivity implements View.OnClickListener {

    private Unbinder unbinder;

    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.btn_register)
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_option);
        unbinder = ButterKnife.bind(this);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login:

                Intent intent_login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent_login);

                break;

            case R.id.btn_register:

                Intent intent_register = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent_register);
                break;
        }
    }
}
