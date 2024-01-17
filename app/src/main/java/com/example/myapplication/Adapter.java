package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {
    Context context;
    List<Datum> list;

    public Adapter(Context context, List<Datum> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewholder holder, int position) {
        Datum data=list.get(position);
        holder.Name.setText(data.getBorrower().getName());
        holder.Mobile.setText(data.getBorrower().getMobileNo()+"");
        holder.Toolname.setText(data.getTool().getName());
        holder.Toolid.setText(data.getTool().getSerialNo());
        Date d= (Date) data.getReceivedDate();
        String s="MMM dd yyyy";
        SimpleDateFormat sd=new SimpleDateFormat(s);
        String dateformatted=sd.format(d);
        holder.Date.setText(dateformatted);
        Glide.with(context).load(data.getTool().getFrontImage()).into(holder.Front_img);
        Glide.with(context).load(data.getTool().getBackImage()).into(holder.Back_Img);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView Name,Mobile,Toolname,Toolid,Status,Date;
        ImageView Front_img,Back_Img;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.name);
            Mobile=itemView.findViewById(R.id.mobile);
            Toolname=itemView.findViewById(R.id.toolname);
            Toolid=itemView.findViewById(R.id.toolid);
            Status=itemView.findViewById(R.id.status);
            Date=itemView.findViewById(R.id.date);
            Front_img=itemView.findViewById(R.id.font_img);
            Back_Img=itemView.findViewById(R.id.back_img);

        }
    }
}
