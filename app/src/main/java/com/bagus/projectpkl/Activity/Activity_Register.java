package com.bagus.projectpkl.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bagus.projectpkl.R;

public class Activity_Register extends AppCompatActivity {

    private Button btn_SingIn;
    private TextView tvSignUp;
    private EditText edEmail, edPassword, edFirst_name, edUsername, edIduser, edKodecab, edNnamacab, edKodeao, edNmaLembaga1, getEdNmaLembaga2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register);

        btn_SingIn = findViewById(R.id.btn_login);
        tvSignUp = findViewById(R.id.btn_register);

        btn_SingIn.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_Register.this, activity_login.class);
            startActivity(intent);
        });
        tvSignUp.setOnClickListener(v -> userSignUp());
        Intent intent = new Intent(Activity_Register.this, activity_login.class);
        startActivity(intent);
    }
    private void userSignUp() {
        String id = edIduser.getText().toString().trim();
        String firstname = edFirst_name.getText().toString().trim();
        String username = edUsername.getText().toString().trim();
        String password = edPassword.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        String namacab = edNnamacab.getText().toString().trim();

        if (email.isEmpty()) {
            edEmail.setError("Email is required");
            edEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edEmail.setError("Enter a valid email");
            edEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            edPassword.setError("Password required");
            edPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            edPassword.setError("Password should be atleast 6 character long");
            edPassword.requestFocus();
            return;
        }

        if (username.isEmpty()) {
            edUsername.setError("Username required");
            edUsername.requestFocus();
            return;
        }

        if (firstname.isEmpty()) {
            edFirst_name.setError("first required");
            edFirst_name.requestFocus();
            return;
        }
        if (namacab.isEmpty()) {
            edFirst_name.setError("nama cabang required");
            edFirst_name.requestFocus();
            return;
        }

    }
}