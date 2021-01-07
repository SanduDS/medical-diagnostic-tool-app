package com.example.mediapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecycleViewAdapter.ItemClickListener {
    RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // data to populate the RecyclerView with
        ArrayList<String> toolsName = new ArrayList<>();
        toolsName.add("20000401 Diagnostic set fibre optic");
        toolsName.add("20100201 Forceps artery cushing str.145mm");
        toolsName.add("20100102 Forceps artery CrilleCollerdeli.cvd.16cm");
        toolsName.add("20100102 Forceps atery crille collerdeli curved 16cm");
        toolsName.add("20100103 Forceps atery crille curved 140mm");
        toolsName.add("20100201 Forceps artery Cushing Straight 145mm");
        toolsName.add("20100202 Forceps artery Cushing curved 145mm");
        toolsName.add("20100301 Forceps atery dunhill curved 125mm");
        toolsName.add("20100454 Forceps artery Baby Mosquito Hartmann 10cm");
        toolsName.add("20100601 Forceps artery Moyinihan curved 145mm");
        toolsName.add("20101201 Forceps artery Birkett type 190mm");
        toolsName.add("20101301 Forceps artery Tonsil Neguss stainless steel curved 18cm");
        toolsName.add("20101701 Forceps atery baby mixter curved 180mm");
        toolsName.add("20101802 Clamp bulldog dieffenbach straight 38mm");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.azDicListRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecycleViewAdapter(this, toolsName);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


        EditText searchBarText=(EditText)findViewById(R.id.editTextSearchBar);
        searchBarText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (MainActivity.this).adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {

        String name= (String) adapter.getItem(position);

        if(name.equals("20000401 Diagnostic set fibre optic")){
            // Create a new intent to open the {@link ColorsActivity}
            Intent testIntent = new Intent(MainActivity.this, DiagnosticSetFibreOptic.class);

            // Start the new activity
            startActivity(testIntent);
        }else if(name.equals("20100201 Forceps artery cushing str.145mm")){
            // Create a new intent to open the {@link ColorsActivity}
            Intent testIntent = new Intent(MainActivity.this, forceps_artery_cushing_str_145mm.class);

            // Start the new activity
            startActivity(testIntent);
        }

        Toast.makeText(this, "You clicked " + adapter.getItem(position) , Toast.LENGTH_SHORT).show();
    }
}