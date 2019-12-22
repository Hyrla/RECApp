package com.radioesieaclub.recapp.View;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.google.gson.Gson;
import com.radioesieaclub.recapp.Controller.ArticleController;
import com.radioesieaclub.recapp.View.ArticleAdapter;
import com.radioesieaclub.recapp.Model.RestArticleReponse;
import com.radioesieaclub.recapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_bottom_navigation) BottomNavigationView bottomNavigationView;

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
        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.articleRecyclerView);
        controller = new ArticleController(this);
        controller.onCreate();
        getWindow().setExitTransition(new Slide(Gravity.LEFT));
        getWindow().setEnterTransition(new Slide(Gravity.RIGHT));
        this.configureBottomView();
    }

    private void configureBottomView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> updateMainFragment(item.getItemId()));
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
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
        }

    }

    private Boolean updateMainFragment(Integer integer){
        switch (integer) {
            case R.id.action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

}
