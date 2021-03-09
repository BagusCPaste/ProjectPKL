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

import com.bagus.projectpkl.Adapter.MemberAdapter;
import com.bagus.projectpkl.Data.DataMember;
import com.bagus.projectpkl.R;
import com.bagus.projectpkl.Respons.ResponseMember;
import com.bagus.projectpkl.api.Client;
import com.google.android.gms.ads.AdRequest;
import com.google.android.material.bottomappbar.BottomAppBar;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SaldotabActivity extends AppCompatActivity {

    Toolbar toolbar;
    private MemberAdapter retrofitAdapter;
    private RecyclerView rv;
    private TextView tv,mypesan,mytotal;
//    SliderView slidermyanggota;
    TextView greetText;
    public int mystatus = 0;
    private LinearLayout llroot,pesan,total;
    private BottomAppBar navigasi;
    public static final String SHARED_PREFS = "sharedPrefs";
    private ProgressDialog pDialog;
    ResponseMember mymember;
    List<DataMember> datacat = new ArrayList<>();
    private MemberAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldotab);

        //AdView adview = (AdView) findViewById(R.id.adView);
        AdRequest adrequest = new AdRequest.Builder().build();
        //adview.loadAd(adrequest);

        toolbar = findViewById(R.id.toolbar);
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
        ImageView btn_back = findViewById(R.id.btn_back);
        navigasi.setVisibility(View.VISIBLE);

        //slidermyanggota = findViewById(R.id.imageSlider);
        greetText = findViewById(R.id.textView);
        greetText.setText("Saldo Simpanan");
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        llroot = findViewById(R.id.mainLinearLayout1);

        rv.addItemDecoration(new SimpleDividerItemDecoration(this));
        //rv.setAdapter(new MemberAdapter(modelRecyclerArrayList));
        rv.setLayoutManager(new GridLayoutManager(this, 1));
        llroot.addView(card);

        prepareHistory();

        SharedPreferences sharedPreferences = this.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        JSONArray jsonArray = new JSONArray();
        JSONObject obj = null;
        obj = new JSONObject();
        try {
            obj.put("nohp", sharedPreferences.getString(SPref.getWhatsApp(), ""));
            obj.put("modul", "TAB");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(obj);

        //Tampilkan daftar rekening tabungan
        loadmymember(llroot, jsonArray.toString());

        //jika menekan tombol back
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void prepareHistory(){
        mAdapter = new MemberAdapter(datacat);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(mAdapter);
    }

    private void loadmymember(LinearLayout root, String myjson) {

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading");
        pDialog.setCancelable(false);
        pDialog.show();

        final Call<ResponseMember> history= Client.getApi().member(myjson);
        history.enqueue(new Callback<ResponseMember>() {
            @Override
            public void onResponse(Call<ResponseMember> call, Response<ResponseMember> response) {
                pDialog.hide();
                if (response.isSuccessful()) {
                    mymember=response.body();
                    if (mymember.getStatus()) {
                        datacat.clear();
                        datacat.addAll(mymember.getData());
                        mAdapter.notifyDataSetChanged();

                        //ResponseMymember resource = mymember;
                        List<DataMember> datumList = mymember.getData();
                        int i = 0;
                        double ntotal = 0;
                        for (DataMember datum : datumList){
                            ntotal += Double.parseDouble(String.valueOf(datum.getSaldo()));
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
                pDialog.hide();
                Toast.makeText(SaldotabActivity.this,
                        "Upps!! Koneksi sedang bermasalah..", Toast.LENGTH_LONG).show();
            }
        });

    }

//    private void showDialog(String message) {
//        AlertDialog.Builder builder= new AlertDialog.Builder(this,R.style.AlertDialogTheme);
//        View view = LayoutInflater.from(this).inflate(R.layout.layout_error_dialog,null);
//        builder.setView(view);
//        ((TextView) view.findViewById(R.id.textTitle)).setText("INFORMASI");
//        ((TextView) view.findViewById(R.id.textMessage)).setText(message);
//        ((Button) view.findViewById(R.id.buttonYes)).setText("Okey");
//
//        final AlertDialog alertDialog = builder.create();
//        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });
//        alertDialog.show();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;

        public SimpleDividerItemDecoration(Context context) {
            mDivider = context.getResources().getDrawable(R.drawable.line_divider);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }
}
