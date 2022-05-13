package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   public static final String msg="com.example.restaurant.order";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void placeorder(View view)
    {

        Intent intent = new Intent(this,OrderActivity.class);
        EditText text1=findViewById(R.id.item1);
        EditText text2=findViewById(R.id.item2);
        EditText text3=findViewById(R.id.item3);

        String str="YOUR ORDER FOR "+text1.getText().toString()+", "+text2.getText().toString()+" & "+text3.getText().toString()+" has been successfully placed";

        intent.putExtra(msg,str);

        startActivity(intent);




    }
}