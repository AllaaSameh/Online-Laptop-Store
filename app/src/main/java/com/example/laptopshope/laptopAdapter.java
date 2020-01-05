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
        View view = LayoutInflater.from(context).inflate(R.layout.row_laptopgethome,parent,false);
        Holderlaptop holderlaptop = new Holderlaptop(view);
        return holderlaptop;
    }

    @Override
    public void onBindViewHolder(@NonNull Holderlaptop holder, int position) {

       holder.tx_brand.setText(laptops.get(position).getBrand());
       holder.rate.setRating(laptops.get(position).getRate());
       Picasso.get().load(laptops.get(position).getImg()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return laptops.size();
    }

    public class Holderlaptop extends RecyclerView.ViewHolder{

      TextView tx_brand;
      RatingBar rate;
      ImageView img;

      public Holderlaptop(@NonNull View itemView) {
            super(itemView);

            tx_brand = itemView.findViewById(R.id.tx_brandhome);
            rate = itemView.findViewById(R.id.rate_home);
            img = itemView.findViewById(R.id.img_home);
        }
    }
}
