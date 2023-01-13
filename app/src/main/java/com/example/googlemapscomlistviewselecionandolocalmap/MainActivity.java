package com.example.googlemapscomlistviewselecionandolocalmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campAddress, campTitle, campLatitude, campLongitude;
    private Button btnAdd;
    private TextView txtInvisibility;
    private ListView listView;
    ArrayList<DadosLocal> listaLocal;
    ArrayAdapter<DadosLocal> adapter;
    double latitute, logitute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campAddress = findViewById(R.id.editEndereco);
        campTitle = findViewById(R.id.editTitulo);
        campLatitude = findViewById(R.id.editLatitude);
        campLongitude = findViewById(R.id.editLongitude);
        btnAdd = findViewById(R.id.btnAdd);
        txtInvisibility = findViewById(R.id.textInvisibility);
        listView = findViewById(R.id.listView);

        listaLocal = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaLocal
        );
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!campAddress.getText().toString().isEmpty()){
                    if (!campTitle.getText().toString().isEmpty()){
                        if(!campLatitude.getText().toString().isEmpty()){
                            if (!campLongitude.getText().toString().isEmpty()){

                                latitute = Double.parseDouble(campLatitude.getText().toString());
                                logitute = Double.parseDouble(campLongitude.getText().toString());

                                DadosLocal dl = new DadosLocal(campTitle.getText().toString(), campAddress.getText().toString(), latitute, logitute );
                                listaLocal.add(dl);
                                adapter.notifyDataSetChanged();

                                campLongitude.setText("");
                                campLatitude.setText("");
                                campAddress.setText("");
                                campTitle.setText("");

                            }else{
                                Toast.makeText(getApplicationContext(),
                                        "Preencher a longitute",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    "Preencher a latitude",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Preencher o título",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Preencher o endereço",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, GoogleMapsActivity.class);
                intent.putExtra("titulo", listaLocal.get(i).getTitulo());
                intent.putExtra("latitude", listaLocal.get(i).getLatitude());
                intent.putExtra("longitude", listaLocal.get(i).getLongitude());
                startActivity(intent);
            }
        });


    }
}