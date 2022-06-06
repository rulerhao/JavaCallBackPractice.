package com.rulhouse.brycework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayMusic pm = new PlayMusic();
        pm.setMusicStateListener(musicStateListener);
        pm.playMusic();
    }

    PlayMusic.MusicStateListener musicStateListener = new PlayMusic.MusicStateListener() {
        @Override
        public void onStart() {
            Log.d("TestPlayMusic", "onStart");
        }

        @Override
        public void onFinish() {
            Log.d("TestPlayMusic", "onFinish");
        }
    };
}