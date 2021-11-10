package org.o7planning.magickapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Beast> beastList;
    Context context;

    public RecycleViewAdapter(List<Beast> beastList, Context context) {
        this.beastList = beastList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_beast,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_beastName.setText(beastList.get(position).getName());
        holder.tv_beastDesc.setText(beastList.get(position).getDescription());
        Glide.with(context).load(beastList.get(position).getImageURL()).into(holder.iv_beastPic);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BestiaryPage.class);
                intent.putExtra("beast_name",beastList.get(position).getName());
                intent.putExtra("image_url",beastList.get(position).getImageURL());
                intent.putExtra("beast_description",beastList.get(position).getDescription());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {

        return beastList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_beastPic;
        TextView tv_beastName;
        TextView tv_beastDesc;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_beastPic = itemView.findViewById(R.id.img_beast);
            tv_beastName = itemView.findViewById(R.id.tv_beastName);
            tv_beastDesc = itemView.findViewById(R.id.tv_beastDesc);
            parentLayout = itemView.findViewById(R.id.line_beast_layout);
        }
    }

}
