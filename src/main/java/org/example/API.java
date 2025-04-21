package org.example;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.Map;

public interface API {

    @GET("collections/todos/records")
    Call<Map<String, Object>> getTasks();

}
