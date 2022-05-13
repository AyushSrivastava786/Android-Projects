package com.example.home_maid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void client(View v)
    {
        Intent intent=new Intent(this,CLIENT.class);
        startActivity(intent);

    }
    public void provide(View view)
    {

        Intent intent=new Intent(this,provider.class);
        startActivity(intent);
    }
}