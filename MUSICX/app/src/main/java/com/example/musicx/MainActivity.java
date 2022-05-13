package com.example.musicx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
  MediaPlayer mediaPlayer;
  AudioManager audioManager;
  SeekBar seekBar,seekBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this,R.raw.ilahi);

        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int max=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int prog=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        


        seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(max);
        seekBar.setProgress(prog);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void play(View v)
    {
        mediaPlayer.start();
    }
    public void stop(View v)
    {
        mediaPlayer.stop();
    }
    public void pause(View v)
    {
        mediaPlayer.pause();
    }

}