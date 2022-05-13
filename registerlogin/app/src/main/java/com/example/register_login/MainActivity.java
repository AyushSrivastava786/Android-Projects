package com.example.register_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
ProgressBar progressBar;
EditText email,password;

private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.textView2).setOnClickListener(this);
        mAuth= FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.GONE);
        email=(EditText)findViewById(R.id.editTextTextEmailAddress);
        password=(EditText)findViewById(R.id.editTextTextPassword);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.textView2).setOnClickListener(this);


    }

    public void logged()
    {
       String emails=email.getText().toString().trim();
       String pass=password.getText().toString().trim();
        if(emails.isEmpty())
        {
            email.setError("can't leave blank");
            email.requestFocus();
            return;
        }
        else if(pass.isEmpty())
        {  password.setError("can't leave blank");
            password.requestFocus();
            return;

        }
        else if(pass.length()<6)
        {
            password.setError("size should be minimum 6");
            password.requestFocus();
            return;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emails).matches())
        {
            email.setError("enter valid email");
            email.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(emails,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    Intent login=new Intent(MainActivity.this,loginpage.class);
                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(login);
                }
                else
                {

                    Toast.makeText(MainActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });




    }

    @Override
    public void onClick(View v) {
      switch(v.getId())
      {
          case R.id.textView2 :
              Intent intent =new Intent(this,REGISTER.class);
              startActivity(intent);
              break;
          case R.id.button:
              logged();
              break;
      }
    }
}