 package com.bagus.projectpkl.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bagus.projectpkl.Activity.MainActivity;
import com.bagus.projectpkl.Data.DataMember;
import com.bagus.projectpkl.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MyViewHolder>{
        private List<DataMember> historyList;
        private Context mContext;
        private int lastPosition=0;
        private View mView;
        private static final String SHARED_PREFS = "sharedPrefs";


    public MemberAdapter(List<DataMember> data, Context mContext) {
            this.historyList = data;
            this.mContext = mContext;
    }

    public MemberAdapter(List<DataMember> mItems) {
        this.historyList = mItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tagihan,parent,false);
        return new myViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            private View view;
            private TextView title1,title2,title3;
            private ImageView img;

            //private LinearLayout bg_transaksi;
            public MyViewHolder(View view) {
                super(view);
                mView=view;
                title1 = view.findViewById(R.id.itemcardView1);

            }

            public void bindItem(DataMember transaksi) {
                title1.setText(transaksi.getNamalembaga());
                img.setImageURI(Uri.parse("http://116.90.163.178:8000/sms_center/img/logo/"+
                        transaksi.getKodelembaga()+".png"));
            }
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindItem(historyList.get(position));
            setAnimation(mView, position);

        }

        @Override
        public int getItemCount() {
            return historyList.size();
        }

        private void setAnimation(View viewToAnimate,int position) {
            if (position > lastPosition) {
                lastPosition = position;
                Animation animation = AnimationUtils.loadAnimation(mView.getContext(), R.anim.slide_left_to_right);
                viewToAnimate.startAnimation(animation);
            }
        }

    private class myViewHolder extends MyViewHolder {
        public myViewHolder(View view) {
            super(view);
        }
    }
}
