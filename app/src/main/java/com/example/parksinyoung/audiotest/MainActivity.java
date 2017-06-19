package com.example.parksinyoung.audiotest;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
        Switch switchMusic;
        MediaPlayer MusicPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchMusic=(Switch)findViewById(R.id.switch_music);
        MusicPlayer = MediaPlayer.create(R.id.raw);
        switchMusic.setOnClickListener(neme);
    }
}
