package com.example.laptopshope;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class laptopAdapter extends RecyclerView.Adapter<laptopAdapter.Holderlaptop> {

    Context context;
    ArrayList<laptop> laptops = new ArrayList<>();

    public laptopAdapter(Context context, ArrayList<laptop> laptops) {
        this.context = context;
        this.laptops = laptops;
    }

    @NonNull
    @Override
    public Holderlaptop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_laptop,parent,false);
        Holderlaptop holderlaptop = new Holderlaptop(view);
        return holderlaptop;
    }

    @Override
    public void onBindViewHolder(@NonNull Holderlaptop holder, int position) {

       holder.tx_brand.setText(laptops.get(position).getBrand());
       holder.tx_price.setText(laptops.get(position).getPrice() + "");
       holder.rate.setRating(laptops.get(position).getRate());
       Picasso.get().load(laptops.get(position).getImg()).into(holder.img);
       holder.btn_back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
       holder.btn_order.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

    }

    @Override
    public int getItemCount() {
        return laptops.size();
    }

    public class Holderlaptop extends RecyclerView.ViewHolder{

      TextView tx_brand,tx_price;
      RatingBar rate;
      ImageView img;
      Button btn_back,btn_order;
        public Holderlaptop(@NonNull View itemView) {
            super(itemView);

            tx_brand = itemView.findViewById(R.id.tx_brand);
            tx_price = itemView.findViewById(R.id.tx_price);
             rate = itemView.findViewById(R.id.Rate);
             img = itemView.findViewById(R.id.img);
             btn_back = itemView.findViewById(R.id.btn_back);
             btn_order = itemView.findViewById(R.id.btn_order);


        }
    }
}
