package com.example.anjuka_koralage.downsouthtagsidriver.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.anjuka_koralage.downsouthtagsidriver.R;
import com.example.anjuka_koralage.downsouthtagsidriver.models.User;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Unbinder unbinder;

    @BindView(R.id.lllogin)
    LinearLayout lllogin;
    @BindView(R.id.btn_registeration)
    Button btn_registeration;
    @BindView(R.id.et_user_F_name)
    TextInputLayout et_user_F_name;
    @BindView(R.id.et_user_L_name)
    TextInputLayout et_user_L_name;
    @BindView(R.id.et_user_dob)
    TextInputLayout et_user_dob;
    @BindView(R.id.nic)
    TextInputLayout et_nic;
    @BindView(R.id.gender)
    TextInputLayout et_gender ;
    @BindView(R.id.sec_mobile)
    TextInputLayout sec_mobile;
    @BindView(R.id.address)
    TextInputLayout et_address;
    @BindView(R.id.home_town)
    TextInputLayout et_home_town;
    @BindView(R.id.et_userName)
    TextInputLayout et_userName;
    @BindView(R.id.password)
    TextInputLayout et_password;
    @BindView(R.id.password_re)
    TextInputLayout et_password_re;

    private String f_name;
    private String l_name;
    private String bod;
    private String email;
    private String nic;
    private String gender;
    private String mobiel_number;
    private String home_town;
    private String address;
    private String userName;
    private String password;
    private String password_re;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        unbinder = ButterKnife.bind(this);

        lllogin.setOnClickListener(this);
        btn_registeration.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lllogin:

                Intent intent_login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent_login);

                break;

            case R.id.btn_registeration:

                //get input register values
                f_name = et_user_F_name.getEditText().getText().toString();
                l_name = et_user_L_name.getEditText().getText().toString();
                userName = et_userName.getEditText().getText().toString();
                bod = et_user_dob.getEditText().getText().toString();
                nic = et_nic.getEditText().getText().toString();
                gender = et_gender.getEditText().getText().toString();
                mobiel_number = sec_mobile.getEditText().getText().toString();
                address = et_address.getEditText().getText().toString();
                home_town = et_home_town.getEditText().getText().toString();
                password = et_password.getEditText().getText().toString();
                password_re = et_password_re.getEditText().getText().toString();

                userRegister(f_name, l_name, bod, nic, gender,mobiel_number, address, home_town, userName, password, password_re);


                break;
        }
    }

    private void userRegister(String f_name, String l_name, String bod, String nic, String gender, String mobile_number, String address, String home_town, String userName, String password, String password_re) {

        FirebaseDatabase   rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("user");

        User user = new User(f_name, l_name, userName, bod, nic, gender, mobile_number, address, home_town, password);
        reference.child(userName).setValue(user);

    }
}
