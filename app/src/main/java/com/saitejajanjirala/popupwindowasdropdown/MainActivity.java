package com.saitejajanjirala.popupwindowasdropdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView editText;
    ArrayList<String> arraylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.text);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openpopup();
            }
        });

    }
    public void openpopup(){
        arraylist=new ArrayList<>();
        final PopupWindow popupWindow=new PopupWindow(this);
        for(int i=2020;i>=1900;i--){
            arraylist.add(i+"");
        }
        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        @SuppressLint("InflateParams") View view= layoutInflater.inflate(R.layout.popuplayout,null,false);
        RecyclerView recyclerview=view.findViewById(R.id.recyclerview);
        PopupAdapter madapter=new PopupAdapter(this,arraylist);
        LinearLayoutManager layoutmanager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setAdapter(madapter);
        popupWindow.setContentView(view);
        madapter.popupclicked(new PopupAdapter.clicklistener() {
            @Override
            public void onpopupitemclicked(int position) {
                editText.setText(arraylist.get(position));
                popupWindow.dismiss();
                Log.i("year",arraylist.get(position));
            }
        });
        popupWindow.showAsDropDown(editText,0,0, Gravity.CENTER_HORIZONTAL);
    }
}
