//package com.bagus.projectpkl.Adapter;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.util.DisplayMetrics;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.RatingBar;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bagus.projectpkl.Data.ProductModel;
//import com.loopj.android.image.SmartImageView;
//import com.softwaresimko.markettingapp.R;
//import com.softwaresimko.model.ProductModel;
//
//import java.text.NumberFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.bagus.projectpkl.Activity.SaldotabActivity.SHARED_PREFS;
//import static com.softwaresimko.marketingapp.MainActivity.SHARED_PREFS;
//
//public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Holdr> {
//    List<ProductModel> data = new ArrayList<ProductModel>();
//
//    private float mWidth, mHeight;
//    private Context context;
//
//    public ProductAdapter(Context context, List<ProductModel> data, Context ctx) {
//        this.context=context;
//        this.data = data;
//        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
//        mWidth = dm.widthPixels / ctx.getResources().getDimension(R.dimen.drawer_layout_width);
//        //mHeight = dm.heightPixels / ctx.getResources().getDimension(R.dimen.grid_height);
//        mHeight = mWidth;
//    }
//
//    @Override
//    public Holdr onCreateViewHolder(ViewGroup p1, int p2) {
//        return new Holdr(LayoutInflater.from(p1.getContext()).inflate(R.layout.item_myproduct, null));
//    }
//
//    @Override
//    public void onBindViewHolder(final Holdr holdr, int pos) {
//
//        final ProductModel cat = data.get(pos);
//        holdr.name.setText(cat.name);
//        holdr.img.setImageUrl(cat.img);
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    public class Holdr extends RecyclerView.ViewHolder {
//        TextView name, price, priceold, discount, store;
//        SmartImageView img;
//        RatingBar ratingbar;
//
//        public Holdr(final View view) {
//            super(view);
//            //Untuk Menghubungkan dan Mendapakan Context dari MainActivity
//            context = view.getContext();
//
//            view.post(new Runnable() {
//                @Override
//                public void run() {
//                    ViewGroup.LayoutParams lp = view.getLayoutParams();
//                    lp.height = (int) mHeight;
//                    lp.width = (int) mWidth;
//                    view.setLayoutParams(lp);
//                }
//            });
//            name = view.findViewById(R.id.itemproductTextViewName);
//            img = view.findViewById(R.id.itemproductImageView1);
//
//            //SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
//            //SharedPreferences.Editor editor = sharedPreferences.edit();
//            view.findViewById(R.id.itemLinearLayout).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent();
//                    SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
//                    switch (getAdapterPosition()) {
//                        case 0 :
////                                intent = new Intent(context, TagihanActivity.class);
////                                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//                            break;
//                        case 1 :
////                                intent = new Intent(context, SaldodepActivity.class);
////                                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//
//                            break;
//                        case 2 :
////                                intent = new Intent(context, SaldokreActivity.class);
////                                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//                            break;
//                        case 3 :
////                                intent = new Intent(context, RinciantabActivity.class);
////                                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//                            break;
//                        case 4 :
////                                intent = new Intent(context, RinciankreActivity.class);
////                                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//                            break;
//                        case 5 :
////                                intent = new Intent(context, PointActivity.class);
////                                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
//                            break;
//                    }
//                }
//            });
//        }
//    }
//
//    private static String _priceFormat(String s) {
//        double parsed = Double.parseDouble(s);
//        String formatted = NumberFormat.getCurrencyInstance().format(parsed);
//        return formatted;
//    }
//
//    private void showDialog(String message) {
//        AlertDialog.Builder builder= new AlertDialog.Builder( context,R.style.AlertDialogTheme);
//        View view = LayoutInflater.from(context).inflate(R.layout.layout_error_dialog,null);
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
//
//        alertDialog.show();
//    }
//}
