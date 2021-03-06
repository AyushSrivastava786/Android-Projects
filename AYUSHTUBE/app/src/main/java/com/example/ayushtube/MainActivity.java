package com.example.ayushtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView v=findViewById(R.id.videoView);
        v.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.peg);
        MediaController m= new MediaController(this);
        v.setMediaController(m);
        m.setAnchorView(v);
        v.start();
    }
}