package com.radioesieaclub.recapp.Controller;

import com.radioesieaclub.recapp.Model.RestArticleReponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestRECApi {
    @GET("get_articles/")
    Call<List<RestArticleReponse>> getArticles();
}
