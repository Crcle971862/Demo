package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.Rv);

        Call<Datamodel> details=Demoapi.getApi().getdetails();
        details.enqueue(new Callback<Datamodel>() {
            @Override
            public void onResponse(Call<Datamodel> call, Response<Datamodel> response) {
                Datamodel datamodel= response.body();
                Adapter adapter=new Adapter(MainActivity.this,datamodel.getData());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Datamodel> call, Throwable t) {

            }
        });

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }
}