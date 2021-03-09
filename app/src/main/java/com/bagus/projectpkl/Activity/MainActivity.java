package com.bagus.projectpkl.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.bagus.projectpkl.Adapter.MemberAdapter;
import com.bagus.projectpkl.Data.DataMember;
import com.bagus.projectpkl.R;
import com.bagus.projectpkl.Respons.ResponseMember;
import com.bagus.projectpkl.api.Client;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Context context;
    MemberAdapter adapter;
    private List<DataMember> mItems = new ArrayList<>();
    Button btnceksaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//         setUpRecyclerView();
        // fillExampleList();
        btnceksaldo = findViewById(R.id.cek_saldo);
        btnceksaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainActivity.this, SaldotabActivity.class));
            }
        });
    }
    private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new MemberAdapter(mItems, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
    private void fillExampleList() {
        Client.getApi().member().enqueue(new Callback<ResponseMember>() {
            @Override
            public void onResponse(Call<ResponseMember> call, Response<ResponseMember> response) {
                mItems =response.body().getData();
                recyclerView.setAdapter(new MemberAdapter(mItems,getApplicationContext()));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseMember> call, Throwable t) {
                Toast.makeText(MainActivity.this,"koneksi eror", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return true;
    }
}