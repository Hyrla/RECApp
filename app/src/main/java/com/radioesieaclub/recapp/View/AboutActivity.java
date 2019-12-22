package com.radioesieaclub.recapp.View;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.radioesieaclub.recapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        System.out.println(bottomNavigationView.getSelectedItemId());
        bottomNavigationView.setSelectedItemId(R.id.action_about);
        this.configureBottomView();
    }

    private void configureBottomView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> updateAboutFragment(item.getItemId()));
    }

    private Boolean updateAboutFragment(Integer integer){
        switch (integer) {
            case R.id.action_articles:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
