package com.radioesieaclub.recapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.radioesieaclub.recapp.Model.RestArticleReponse;
import com.radioesieaclub.recapp.R;
import com.squareup.picasso.Picasso;

public class ContenuArticleActivity extends AppCompatActivity {

    private TextView txtArticle;
    private TextView auteur;
    private TextView date;
    private ImageView imgArticle;
    private RestArticleReponse articleReponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenu_article);

        Intent intent = getIntent();

        txtArticle = findViewById(R.id.textArticle);
        imgArticle = findViewById(R.id.ImageArticle);
        auteur = findViewById(R.id.Auteur);
        date = findViewById(R.id.date);


        Gson gson = new Gson();
        articleReponse = gson.fromJson(intent.getStringExtra("Article"),RestArticleReponse.class);

        Picasso.get()
                .load("http://radioesieaclub.com/media/"+articleReponse.getPhoto())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(0,512)
                .into(imgArticle);

        txtArticle.setText(articleReponse.getContenu());
        auteur.setText(articleReponse.getAuteur());
        date.setText(articleReponse.getDate());

        getWindow().setExitTransition(new Slide(Gravity.LEFT));
        getWindow().setEnterTransition(new Slide(Gravity.RIGHT));

    }
}
