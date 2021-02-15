package com.bagus.projectpkl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bagus.projectpkl.retrofit.KoneksiAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class activity_login extends AppCompatActivity implements View.OnClickListener {
    private EditText edLogin;
    private EditText edPass;
    private TextView tvDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edLogin = findViewById(R.id.etEmail);
        edPass = findViewById(R.id.etPassword);
        tvDaftar = findViewById(R.id.tvDaftar);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.tvDaftar).setOnClickListener(this);

    }

    private void UserLogin(){
        String email = edLogin.getText().toString().trim();
        String password = edPass.getText().toString().trim();
        if (email.isEmpty()){
            edLogin.setError("Email is required");
            edLogin.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edLogin.setError("Enter a valid email");
            edLogin.requestFocus();
            return;
        }if (password.isEmpty()){
            edPass.setError("password required");
            edPass.requestFocus();
            return;
        }if (password.length() < 6) {
            edPass.setError("Password should be atleast 6 character long");
            edPass.requestFocus();
            return;
        }
        Call<LoginResponse> call = KoneksiAPI
                .endpoint().UserLogin(email, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (!loginResponse.isError()){
                    Toast.makeText(activity_login.this, loginResponse.getMessage(), Toast.LENGTH_LONG)
                            .show();
                }else{
                    Toast.makeText(activity_login.this, loginResponse.getMessage(), Toast.LENGTH_LONG)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                UserLogin();
                break;
            case R.id.tvDaftar:
                break;

        }
    }
}