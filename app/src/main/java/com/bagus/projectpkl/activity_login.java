package com.bagus.projectpkl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bagus.projectpkl.retrofit.KoneksiAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class activity_login extends AppCompatActivity {
    private EditText edLogin;
    private EditText edPass;
    private TextView tvDaftar;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edLogin = (EditText) findViewById(R.id.etEmail);
        edPass = (EditText) findViewById(R.id.etPassword);
        tvDaftar =(TextView) findViewById(R.id.tvDaftar);
        btnLogin = (Button) findViewById(R.id.btn_login);

        tvDaftar.setOnClickListener(v -> startActivity(new Intent(activity_login.this, MainActivity.class)));
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

    }

}