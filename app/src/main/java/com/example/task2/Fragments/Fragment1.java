package com.example.task2.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task2.Frag1Adapter;
import com.example.task2.Frag1RecyClickInterface;
import com.example.task2.R;
import com.example.task2.viewmodels.Frag1ViewModel;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements Frag1RecyClickInterface, Fragment2.Fragment2Listener2 {

    RecyclerView recyclerView;
    private Frag1ViewModel frag1ViewModel;
    Frag1Adapter adapter;
    ArrayList<String> list;
    private Fragment2.Fragment2Listener2 listener;
    ArrayList<String> checkedList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_1_lyt, container, false);

        recyclerView = v.findViewById(R.id.frag_1_recy_lyt);



        frag1ViewModel = ViewModelProviders.of(this).get(Frag1ViewModel.class);

        frag1ViewModel.init();
        frag1ViewModel.getFacilities().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> decodeHouseDetails) {
                if(adapter==null){
                    initRecyclerView();
                }
                adapter.notifyDataSetChanged();
            }
        });




        return v;
    }



    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter = new Frag1Adapter(this,frag1ViewModel.getFacilities().getValue());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int pos, String text, boolean checked) {
        checkedList.add(text);
        Toast.makeText(getContext()," pos "+pos+" txt "+text+" checked "+checked,Toast.LENGTH_SHORT).show();
    }


    public void addNewValueToList(String s){
        frag1ViewModel.addNewValue(s);
        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(frag1ViewModel.getFacilities().getValue().size()-1);
    }

    public void deleteValues(ArrayList<String> delList){
        for(String s : delList){
            frag1ViewModel.deleteVal(s);
        }
        checkedList.clear();

        adapter.notifyDataSetChanged();
    }


    @Override
    public ArrayList<String> getCheckedData( ) {
        return checkedList;
    }

    @Override
    public void refreshList() {
        checkedList.clear();
        adapter.notifyDataSetChanged();
    }
}