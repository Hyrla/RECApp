package com.radioesieaclub.recapp.Controller;

import android.util.Log;

import com.radioesieaclub.recapp.Model.RestArticleReponse;
import com.radioesieaclub.recapp.View.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleController {
    private MainActivity view;
    private List<RestArticleReponse> articles;
    private RestRECApi api = ApiManager.getInstance();

    public ArticleController(MainActivity view) {
        this.view = view;
    }

    public void onCreate() {
        Call<List<RestArticleReponse>> call = api.getArticles();
        call.enqueue(new Callback<List<RestArticleReponse>>() {
            @Override
            public void onResponse(Call<List<RestArticleReponse>> call, Response<List<RestArticleReponse>> response) {
                articles = response.body();
                view.ShowList(articles);
            }

            @Override
            public void onFailure(Call<List<RestArticleReponse>> call, Throwable t) {
                Log.d("ERROR", "Failure, no API response");
            }
        });
    }

    public List<RestArticleReponse> getArticles() {
        return articles;
    }
}
