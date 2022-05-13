package com.example.register_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class REGISTER extends AppCompatActivity implements View.OnClickListener{
   EditText email,password;
   Button sign;
   ProgressBar pr;
   TextView log;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_e_g_i_s_t_e_r);
        sign=findViewById(R.id.button2);
        email=(EditText)findViewById(R.id.editTextTextEmailAddress2);
        password=(EditText)findViewById(R.id.editTextTextPassword2);
        sign.setOnClickListener(this);
       mAuth=FirebaseAuth.getInstance();
       pr=findViewById(R.id.progressBar);
       log=findViewById(R.id.textView4);
       log.setOnClickListener(this);
       pr.setVisibility(View.GONE);
    }
  public void register()
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
     pr.setVisibility(View.VISIBLE);
      mAuth.createUserWithEmailAndPassword(emails,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()) {
                  Intent in=new Intent(REGISTER.this,MainActivity.class);
                  in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                  Toast.makeText(REGISTER.this, "USER REGISTERED", Toast.LENGTH_SHORT).show();
                  pr.setVisibility(View.GONE);
                  startActivity(in);
              }
              else
              {

                  if(task.getException() instanceof FirebaseAuthUserCollisionException)
                  {
                      Toast.makeText(REGISTER.this, "USER WITH THIS EMAIL ALREADY EXISTS", Toast.LENGTH_SHORT).show();
                  }

                  else {
                      Toast.makeText(REGISTER.this, "USER NOT REGISTERED, SOME ERROR OCCURRED", Toast.LENGTH_SHORT).show();
                  }
                  pr.setVisibility(View.GONE);
              }
          }
      });

  }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button2:
                register();
                break;
            case R.id.textView4:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}