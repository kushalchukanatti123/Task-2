package com.example.task2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Frag1Adapter extends RecyclerView.Adapter<Frag1Adapter.ViewHolder>{



    private Frag1RecyClickInterface frag1RecyClickInterface;
    ArrayList<String> elements;
    ArrayList<String> checkedList;

    public Frag1Adapter(Frag1RecyClickInterface frag1RecyClickInterface,ArrayList<String> elements) {
        this.frag1RecyClickInterface = frag1RecyClickInterface;
        this.elements = elements;
        this.checkedList = checkedList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag1_recy_item_lyt, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(elements.get(position));
        holder.checkBox.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CheckBox checkBox;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.recy_item_txt_id);
            checkBox = itemView.findViewById(R.id.recy_item_checkbox_id);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    frag1RecyClickInterface.onItemClick(getAdapterPosition(),elements.get(getAdapterPosition()),b);
                }
            });
        }
    }
}
