package com.example.retrofitpost;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST("mahasiswa")
    Call<Post>createPost(@Body Post post);
    @GET("mahasiswa")
    Call<List<Post>> getPost();



}
