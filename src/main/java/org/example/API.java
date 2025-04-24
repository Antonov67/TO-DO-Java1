package org.example;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @GET("collections/todos/records")
    Call<ResponseTasks> getTasks();

    @POST("collections/todos/records")
    Call<Task> createTask(@Body Task task);
}
