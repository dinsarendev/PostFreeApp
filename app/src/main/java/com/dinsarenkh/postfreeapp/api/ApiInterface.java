package com.dinsarenkh.postfreeapp.api;

import com.dinsarenkh.postfreeapp.models.response.PostResponse;
import com.dinsarenkh.postfreeapp.models.response.PostsItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/posts")
    Call<PostResponse> getAllPosts();
    @GET("/posts/{id}")
    Call<PostsItem> getPostById(@Path("id") int id);
}
