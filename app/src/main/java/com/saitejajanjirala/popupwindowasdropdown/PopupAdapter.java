package com.saitejajanjirala.popupwindowasdropdown;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopupAdapter extends RecyclerView.Adapter<PopupAdapter.PopupViewHolder>{
    private Context mcontext;
    private ArrayList<String> marraylist;
    clicklistener mlistener;
    public interface clicklistener{
        public void onpopupitemclicked(int position);
    }
    public void popupclicked(clicklistener listener){
        mlistener=listener;
    }
    PopupAdapter(Context context, ArrayList<String> arrayList){
        this.mcontext=context;
        this.marraylist=arrayList;
    }
    @NonNull
    @Override
    public PopupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.textviewforpopup,parent,false);
        return new PopupViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull PopupViewHolder holder, final int position) {
        holder.textView.setText(marraylist.get(position));
    }

    @Override
    public int getItemCount() {
        return marraylist.size();
    }

    public static class  PopupViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public PopupViewHolder(@NonNull View itemView, final clicklistener listener) {
            super(itemView);
            textView=itemView.findViewById(R.id.pouptexts);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onpopupitemclicked(position);
                        }
                    }
                }
            });
        }
    }
}
