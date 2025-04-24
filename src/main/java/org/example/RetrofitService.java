package org.example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String BASE_URL = "http://192.168.11.164:8090/api/";
    API api;

    public RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }

    public void getTasks(SimpleDataCallback<ResponseTasks> callback){
        Call<ResponseTasks> call = api.getTasks();
        call.enqueue(new Callback<ResponseTasks>() {
            @Override
            public void onResponse(Call<ResponseTasks> call, Response<ResponseTasks> response) {
                if (response.isSuccessful()){
                    callback.load(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseTasks> call, Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }

    public void createTask(Task task, SimpleDataCallback<Task> callback){
        Call<Task> call = api.createTask(task);
        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                if (response.isSuccessful()){
                    callback.load(response.body());
                }
            }

            @Override
            public void onFailure(Call<Task> call, Throwable throwable) {

            }
        });
    }
}
