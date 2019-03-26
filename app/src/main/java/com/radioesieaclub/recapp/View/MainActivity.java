package com.radioesieaclub.recapp.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.radioesieaclub.recapp.Controller.ArticleController;
import com.radioesieaclub.recapp.View.ArticleAdapter;
import com.radioesieaclub.recapp.Model.RestArticleReponse;
import com.radioesieaclub.recapp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArticleController controller;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.articleRecyclerView);
        controller = new ArticleController(this);
        controller.onCreate();
    }

    public void ShowList(List<RestArticleReponse> listArticle){
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ArticleAdapter(listArticle, new ArticleListener());
        recyclerView.setAdapter(mAdapter);
    }

    public class ArticleListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,ContenuArticleActivity.class);
            int itemPostition = recyclerView.getChildLayoutPosition(v);
            Gson gson = new Gson();
            intent.putExtra("Article", gson.toJson(controller.getArticles().get(itemPostition)));
            startActivity(intent);
        }

    }

}
