package com.example.task2.Repositories;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class Frag1Repository {
    private static Frag1Repository instance;
    private ArrayList<String> dataset = new ArrayList<>();

    MutableLiveData<ArrayList<String>> data = new MutableLiveData<>();


    public static Frag1Repository getInstance(){
        if(instance==null){
            instance = new Frag1Repository();
        }

        return  instance;
    }

    //Fetching data
    public MutableLiveData<ArrayList<String>> getFacilities(Context c){
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        data.setValue(list);
        return data;
    }
}
