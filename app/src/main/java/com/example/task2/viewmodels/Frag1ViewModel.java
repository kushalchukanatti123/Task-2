package com.example.task2.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.task2.Repositories.Frag1Repository;

import java.util.ArrayList;

public class Frag1ViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<String>> list = new MutableLiveData<ArrayList<String>>();
    private Frag1Repository frag1Repository;

    public Frag1ViewModel(Application application) {
        super(application);
    }

    public void init(){
        if(list != null){
            list= new MutableLiveData<>();
        }
        frag1Repository = Frag1Repository.getInstance();
        list = frag1Repository.getFacilities(this.getApplication());
    }

    public LiveData<ArrayList<String>> getFacilities() {
        if(list == null){
            list = new MutableLiveData<>();
        }
        return list;
    }

    public void addNewValue(String val){
        ArrayList<String> currList = list.getValue();
        currList.add(val);
        list.postValue(currList);
    }

    public void deleteVal(String val){
        ArrayList<String> currList = list.getValue();
        currList.remove(val);
        list.postValue(currList);
    }

}
