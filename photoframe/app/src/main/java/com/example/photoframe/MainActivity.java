package com.example.photoframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   ImageView vr;
   TextView tr;
   String[] names={"building","bulb","pebble","chips","google"};
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void next(View v)
    {

       String str="pic"+count;
       int t=this.getResources().getIdentifier(str,"id",getPackageName());
       vr=(ImageView)findViewById(t);
       vr.setAlpha(0f);
        if(count==4)
            count=0;
        else
            count++;

         str="pic"+count;
         t=this.getResources().getIdentifier(str,"id",getPackageName());
        vr=(ImageView)findViewById(t);
        vr.setAlpha(1f);

        tr=findViewById(R.id.textView2);
        tr.setText(names[count]);
    }


    public void prev(View v)
    {

        String str="pic"+count;
        int t=this.getResources().getIdentifier(str,"id",getPackageName());
        vr=(ImageView)findViewById(t);
        vr.setAlpha(0f);
        if(count==0)
            count=4;
        else
            count--;

        str="pic"+count;
        t=this.getResources().getIdentifier(str,"id",getPackageName());
        vr=(ImageView)findViewById(t);
        vr.setAlpha(1f);


        tr=findViewById(R.id.textView2);
        tr.setText(names[count]);


    }



}