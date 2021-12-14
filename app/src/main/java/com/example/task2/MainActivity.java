package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.task2.Fragments.Fragment1;
import com.example.task2.Fragments.Fragment2;

public class MainActivity extends AppCompatActivity implements Fragment2.Fragment2Listener {

    Fragment1 fragment1;
    Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // add fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragment1 = new Fragment1();
        fragmentManager.beginTransaction().add(R.id.blue_fragment_container, fragment1).commit();
        fragment2 = new Fragment2();
        fragmentManager.beginTransaction().add(R.id.green_fragment_container, fragment2).commit();

    }

    @Override
    public void onInputASent(String input) {
        fragment1.addNewValueToList(input);
    }

    @Override
    public void delCheckedData() {

        fragment1.deleteValues(fragment1.getCheckedData());
        fragment1.refreshList();
    }
}