package com.isptec.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    ArrayList<String > stringArrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @SuppressLint({"SetTextI18n", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringArrayList);

        ((ListView) findViewById(R.id.list_item)).setAdapter(adapter);

        findViewById(R.id.add_btn).setOnClickListener((arg)-> this.showAddDialog());

    }

    private void showAddDialog(){

        Dialog dialog = new Dialog(MainActivity.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.activity_create_task);

        EditText editText = dialog.findViewById(R.id.task_description);
        Button btn = dialog.findViewById(R.id.create_task_btn);

        btn.setOnClickListener((r)->{
            stringArrayList.add(editText.getText().toString());
            adapter.notifyDataSetChanged();
            dialog.dismiss();
        });

        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.30);
        Objects.requireNonNull(dialog.getWindow()).setLayout(width,height);
        dialog.show();
    }

}