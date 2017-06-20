package com.example.parksinyoung.audiotest;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ListView list;
    Button butPlay,butStop,butpause;
    TextView textMusic;
    ProgressBar progress;
    MediaPlayer mediaPlayer;
    String[] musics ={"shape of you","faded","ddd"};
    int[] musicResIds={R.raw.letmeloveyou,R.raw.rockabye,R.raw.shapeofyou};
    int selectedMusicId;
    boolean selectePauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= (ListView)findViewById(R.id.List_music);
        butPlay=(Button)findViewById(R.id.but_play);
        butStop=(Button)findViewById(R.id.but_stop);
        butpause=(Button)findViewById(R.id.but_pause);
        progress=(ProgressBar)findViewById(R.id.progress_music);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,musics);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setItemChecked(0,true);
        selectedMusicId=musicResIds[0];
        mediaPlayer= MediaPlayer.create(this,selectedMusicId);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMusicId=musicResIds[i];
            }
        });

        butPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(selectePauseButton) {
                    mediaPlayer.start();
                    selectePauseButton=false;
                } else{
                    mediaPlayer=MediaPlayer.create(MainActivity.this,selectedMusicId);
                }
                mediaPlayer.start();
                progress.setVisibility(view.VISIBLE);
            }
        });
        butStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                progress.setVisibility(View.INVISIBLE);
            }
        });
        butpause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectePauseButton=true;
                mediaPlayer.pause();
                progress.setVisibility(View.INVISIBLE);
            }
        });
    }
    @Override
    protected void onStop(){
        super.onStop();
        mediaPlayer.stop();
    }
}