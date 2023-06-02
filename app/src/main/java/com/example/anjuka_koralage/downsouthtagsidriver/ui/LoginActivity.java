package com.example.anjuka_koralage.downsouthtagsidriver.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.anjuka_koralage.downsouthtagsidriver.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Unbinder unbinder;

    @BindView(R.id.llregister)
    LinearLayout llregister;
    @BindView(R.id.et_userName)
    TextInputLayout et_userName;
    @BindView(R.id.et_password)
    TextInputLayout et_password;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    private String userName;
    private String passWord;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);
        llregister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llregister:

                Intent intent_register = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent_register);
                break;

            case R.id.btnLogin:

                //get data values from user inputs
                userName = et_userName.getEditText().getText().toString();
                passWord = et_password.getEditText().getText().toString();

                //login existing user
                userLoging(userName, passWord);


        }
    }

    private void userLoging(String userName, String passWord) {

        //Validate Login Info
        if (!validateUsername() | !validatePassword()) {
            return;
        } else {
            isUser(userName, passWord);
        }
    }

    //registered user validation
    private void isUser(String userName, String passWord) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        Query checkUser = reference.orderByChild("user_name").equalTo(userName);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    et_userName.setError(null);
                    et_userName.setErrorEnabled(false);
                    String passwordFromDB = dataSnapshot.child(userName).child("password").getValue(String.class);
                    Log.d("LoginActivity", "onDataChange: " + passwordFromDB);
                    if (passwordFromDB.equals(passWord)){
                        et_password.setError(null);
                        et_password.setErrorEnabled(false);
                        progressDialog.dismiss();
                        moveOn();
                    }
                    else {
                        progressDialog.dismiss();
                        et_password.setError("Wrong Password");
                        et_password.requestFocus();
                    }
                }
                else {

                    progressDialog.dismiss();
                    et_userName.setError("No such User exist");
                    et_userName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


    }

    //activity navigation
    private void moveOn() {
        Intent loginIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(loginIntent);
    }

    //userName validation
    private Boolean validateUsername() {
        String val = et_userName.getEditText().getText().toString();
        if (val.isEmpty()) {
            et_userName.setError("Field cannot be empty");
            return false;
        } else {
            et_userName.setError(null);
            et_userName.setErrorEnabled(false);
            return true;
        }
    }

    //password validation
    private Boolean validatePassword() {
        String val = et_password.getEditText().getText().toString();
        if (val.isEmpty()) {
            et_password.setError("Field cannot be empty");
            return false;
        } else {
            et_password.setError(null);
            et_password.setErrorEnabled(false);
            return true;
        }
    }
}
