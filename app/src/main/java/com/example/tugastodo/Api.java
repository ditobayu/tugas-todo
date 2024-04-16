package com.example.tugastodo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("todo.php")
    Call<List<TodoItem>> getTodos();
}
