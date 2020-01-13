package com.example.wasmha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.PrivateKey;

public class insertionActivity extends AppCompatActivity {
    public static final String User_ADDED="new_user";
    private  UsersViewModel usersViewModel;
    private EditText newuser;
    Button userbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion);
      usersViewModel= ViewModelProviders.of(this).get(UsersViewModel.class);
      newuser=findViewById(R.id.insertuser);
      userbutton=(Button)findViewById(R.id.save);

      userbutton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent resultintent=new Intent();
              if (TextUtils.isEmpty(newuser.getText())){
                  setResult(RESULT_CANCELED,resultintent);
              }
              else {
                  String user=newuser.getText().toString();
                  resultintent.putExtra(User_ADDED,user);
                  setResult(RESULT_OK,resultintent);
              }
              finish();

          }
      });


    }
}
