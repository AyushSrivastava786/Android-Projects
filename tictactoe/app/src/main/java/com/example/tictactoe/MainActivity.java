package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    int chaal=1,ev=0;
    boolean activestate=true;
    int count=0,ct=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playertap(View view) {
        ct = 0;
        if (activestate == false || count == 9) {
            activestate = true;
            ct = 1;
            reset();


        }

        count++;
        if (ct == 0&&count<=9) {

            ImageView img = (ImageView) view;
            int tap = Integer.parseInt((img.getTag()).toString());

            if (count <= 9 && ct == 0 && gamestate[tap] == 2) {
                img.setTranslationY(-1000f);
                if (chaal == 1) {
                    img.setImageResource(R.drawable.x);
                    chaal = 0;
                    gamestate[tap] = 1;
                    TextView status = findViewById(R.id.statusbar);
                    status.setText("Y's turn. Tap to play.");

                } else {
                    img.setImageResource(R.drawable.zero);
                    chaal = 1;
                    gamestate[tap] = 0;
                    TextView status = findViewById(R.id.statusbar);
                    status.setText("X's turn. Tap to play.");
                }
                img.animate().translationYBy(1000f).setDuration(300);

                for (int[] winposi : winpos) {
                    if (gamestate[winposi[0]] == gamestate[winposi[1]] && (gamestate[winposi[1]] == gamestate[winposi[2]]) && gamestate[winposi[0]] != 2)
                     {
                        count = 0;
                        ct = 1;

                        if (gamestate[winposi[0]] == 1) {
                            TextView status = findViewById(R.id.statusbar);
                            status.setText("X WON, he will get thullu, tap to reset");


                        } else {
                            TextView status = findViewById(R.id.statusbar);
                            status.setText("Y WON, he will get thullu, tap to reset");
                        }
                        activestate = false;

                    }
                    if(count==9)
                    {
                        TextView status=findViewById(R.id.statusbar);
                        status.setText("KHICHDI PAK GYI.TAP KARO RESET KE LIYE");
                        activestate=false;
                    }
                }

            }


        }

    }

    public void reset()
    { count=0;
       activestate=true;
       for(int i=0;i<9;i++)
       {
           gamestate[i]=2;
       }
       chaal=1;
        TextView status=findViewById(R.id.statusbar);
        status.setText("X's turn. Tap to play.");

        ((ImageView)(findViewById(R.id.imageView0))).setImageResource(0);
        ((ImageView)(findViewById(R.id.imageView1))).setImageResource(0);
        ((ImageView)(findViewById(R.id.imageView2))).setImageResource(0);
        ((ImageView)(findViewById(R.id.imageView3))).setImageResource(0);
        ((ImageView)(findViewById(R.id.imageView4))).setImageResource(0);
        ((ImageView)(findViewById(R.id.imageView5))).setImageResource(0);
        ((ImageView)(findViewById(R.id.imageView6))).setImageResource(0);
        ((ImageView)(findViewById(R.id.imageView7))).setImageResource(0);
        ((ImageView)(findViewById(R.id.imageView8))).setImageResource(0);

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}