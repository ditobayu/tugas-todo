package com.example.tugastodo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TodoAdapter adapter;

    private static Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://mgm.ub.ac.id/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Api service = retrofit.create(Api.class);
        Call<List<TodoItem>> call = service.getTodos();

        call.enqueue(new Callback<List<TodoItem>>() {
            @Override
            public void onResponse(Call<List<TodoItem>> call, Response<List<TodoItem>> response) {
                adapter = new TodoAdapter(response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<TodoItem>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
