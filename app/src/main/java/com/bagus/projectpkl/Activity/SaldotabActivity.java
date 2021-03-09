package com.bagus.projectpkl.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import android.app.AlertDialog;
import android.widget.Toast;


import com.bagus.projectpkl.Adapter.MemberAdapter;
import com.bagus.projectpkl.R;
import com.bagus.projectpkl.Data.DataMember;
import com.bagus.projectpkl.Respons.ResponseMember;
import com.bagus.projectpkl.api.Client;
import com.google.android.material.bottomappbar.BottomAppBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SaldotabActivity extends AppCompatActivity {

    Toolbar toolbar;
    private MemberAdapter retrofitAdapter;
    private RecyclerView rv;
    private TextView tv,mypesan,mytotal;
    TextView greetText;
    public int mystatus = 0;
    private LinearLayout llroot,pesan,total;
    private BottomAppBar navigasi;
    public static final String SHARED_PREFS = "sharedPrefs";
    private ProgressDialog pDialog;
    ResponseMember member;
    List<DataMember> mItems = new ArrayList<>();
    private MemberAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldotab);

        View card = getLayoutInflater().inflate(R.layout.item_card, null);
        rv = card.findViewById(R.id.cardListView1);
        tv = card.findViewById(R.id.cardTextView1);
        pesan = card.findViewById(R.id.cardNotFound);
        mypesan = card.findViewById(R.id.mypesanTextView);
        rv.setNestedScrollingEnabled(false);
        tv.setText("Daftar Rekening Simpanan");

        mytotal = findViewById(R.id.tvtotal);
        total = findViewById(R.id.itemcardView1);
        navigasi = findViewById(R.id.navigation);
        navigasi.setVisibility(View.VISIBLE);
//        setUpRecyclerView();

        prepareHistory();

        SharedPreferences sharedPreferences = this.getSharedPreferences(SHARED_PREFS,
                Context.MODE_PRIVATE);
        JSONArray jsonArray = new JSONArray();
        JSONObject obj = null;
        obj = new JSONObject();
        try {
            obj.put("nohp", sharedPreferences.getString(jsonArray.toString(), ""));
            obj.put("modul", "TAB");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(obj);

//        Tampilkan daftar rekening tabungan
        loadmymember(llroot, jsonArray.toString());

    }
//    private void setUpRecyclerView() {
//        rv = findViewById(R.id.recycler_view);
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        mAdapter = new MemberAdapter(mI   tems, this);
//        rv.setAdapter(mAdapter);
//        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    private void prepareHistory(){
        mAdapter = new MemberAdapter(mItems);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(mAdapter);
    }

    private void loadmymember(LinearLayout llroot, String myjson) {

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading");
        pDialog.setCancelable(false);
        pDialog.show();

        Client.getApi().member().enqueue(new Callback<ResponseMember>() {
            @Override
            public void onResponse(Call<ResponseMember> call, Response<ResponseMember> response) {
                pDialog.hide();
                if (response.isSuccessful()) {
                    member=response.body();
                    if (member.getStatus()) {
                        mItems.clear();
                        mItems.addAll(Collections.singleton((DataMember) member.getData()));
                        mAdapter.notifyDataSetChanged();


//                        ResponseMember resource = member;
                        List<DataMember> datumList = member.getData();
                        int i = 0;
                        double ntotal = 0;
                        for (DataMember datum : datumList){
                            ntotal += Double.parseDouble(datum.getProduk());
                            i++;
                        }
                        mytotal.setText("Total Simpanan : Rp."+String.format("%,.2f", ntotal));
                    }
                }else{
                    pesan.setVisibility(View.VISIBLE);
                    mypesan.setText("Rekening Simpanan");
                }
            }

            @Override
            public void onFailure(Call<ResponseMember> call, Throwable t) {
                Toast.makeText(SaldotabActivity.this,"Koneksi eror periksa internet",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;

        public SimpleDividerItemDecoration(Context context) {
            mDivider = context.getResources().getDrawable(R.drawable.bground);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }

    public static Drawable setTint(Drawable d, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(d);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

    public void close_app() {
        System.exit(0);
    }


}
