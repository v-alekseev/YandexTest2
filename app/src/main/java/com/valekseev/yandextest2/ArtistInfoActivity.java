package com.valekseev.yandextest2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import 	android.net.Uri;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ArtistInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
 */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Uri url = Uri.parse("http://avatars.yandex.net/get-music-content/be7f0f49.p.74614/1000x1000");

        Picasso.with(this)
                // .load("http://avatars.yandex.net/get-music-content/be7f0f49.p.74614/1000x1000")
                .load("http://avatars.yandex.net/get-music-content/40598113.p.1150/1000x1000")
                .placeholder(R.drawable.ic_stat_name)
                 .into(imageView);

        TextView style = (TextView) findViewById(R.id.textView);
        style.setText("genres, rap");
        TextView songs = (TextView) findViewById(R.id.textView2);
        songs.setText("33 tracks 11 albums");
        TextView description = (TextView) findViewById(R.id.textView4);
        description.setText("музыкальная группа, основанная в 2009 году Сергеем Приказчиковым и исполняющая песни на стыке таких жанров, как поп-соул, регги, фанк и даже рэп.");
    }


}
