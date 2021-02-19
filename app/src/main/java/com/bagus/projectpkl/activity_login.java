package com.bagus.projectpkl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.bagus.projectpkl.api.client;
import com.bagus.projectpkl.model.DataUser;
import com.bagus.projectpkl.model.ResponseLogin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class activity_login extends AppCompatActivity {

    private ProgressDialog pDialog;
    private Context mContext;
    private EditText edLogin;
    private EditText edPass;
    private TextView tvDaftar;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;
        edLogin = findViewById(R.id.etEmail);
        edPass = findViewById(R.id.etPassword);
        tvDaftar = findViewById(R.id.tvDaftar);
        btnLogin = findViewById(R.id.btn_login);

        tvDaftar.setOnClickListener(v -> startActivity(new Intent(activity_login.this,
                Activity_Register.class)));

    }

    public void login(View view) {
        //proses login
        String email = edLogin.getText().toString().trim();
        String password = edPass.getText().toString().trim();

        JSONArray jsonArray = new JSONArray();
        JSONObject obj = null;
        obj = new JSONObject();
        try {
            obj.put("username",email );
            obj.put("password",password );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(obj);

        pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Tunggu!! sedang proses...");
        pDialog.setCancelable(false);
        pDialog.show();
        pDialog.setCanceledOnTouchOutside(true);

        Call<ResponseLogin> resMaster;
        resMaster = client.getApi().login(jsonArray.toString());
        resMaster.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                pDialog.hide();
                if (response.isSuccessful()){
                    if (response.body().getStatus()) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        DataUser userData = response.body().getData();
                        Toast.makeText(getApplicationContext(), "Login berhasil",
                                Toast.LENGTH_SHORT).show();

                    }

                    return;
                }else{
                    Toast.makeText(getApplicationContext(), "koneksi gagal", Toast.LENGTH_SHORT).show();
                    //return false;
                }

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                pDialog.hide();
                Toast.makeText(getApplicationContext(), "Upps!! Koneksi sedang bermasalah..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}