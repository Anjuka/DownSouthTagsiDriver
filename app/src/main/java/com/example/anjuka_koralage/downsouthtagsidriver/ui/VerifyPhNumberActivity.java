package com.example.anjuka_koralage.downsouthtagsidriver.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.anjuka_koralage.downsouthtagsidriver.R;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VerifyPhNumberActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @BindView(R.id.btn_verify)
    Button btn_verify;
    @BindView(R.id.et_opt)
    TextInputLayout et_opt;

    private String user_opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_ph_number);
        unbinder = ButterKnife.bind(this);

        user_opt = et_opt.getEditText().getText().toString();

    }
}
