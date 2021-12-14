package com.example.task2.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.task2.Frag1RecyClickInterface;
import com.example.task2.R;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    EditText editText;
    Button addBtn,delBtn;
    private Fragment2Listener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_2_lyt, container, false);
        editText = v.findViewById(R.id.frag_2_edtxt);
        addBtn = v.findViewById(R.id.frag_2_add_btn);
        delBtn = v.findViewById(R.id.frag_2_del_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = editText.getText().toString();
                editText.setText("");
                if(!TextUtils.isEmpty(txt)){
                    listener.onInputASent(txt);
                }else {
                    Toast.makeText(getContext(),"Empty text",Toast.LENGTH_SHORT).show();
                }
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.delCheckedData();

            }
        });

        return v;
    }
    public interface Fragment2Listener{
        void onInputASent(String input);
        void delCheckedData();

    }
    public interface Fragment2Listener2{
        ArrayList<String> getCheckedData();
        void refreshList();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment2Listener){
            listener = (Fragment2Listener) context;
        }else {
            throw new RuntimeException(context.toString()+" must implement fragment 2 listenr");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


}