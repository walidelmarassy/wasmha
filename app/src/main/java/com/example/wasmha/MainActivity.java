package com.example.wasmha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private UsersViewModel usersViewModel;
    private UserListAdapter userListAdapter;
    private EmojisViewModel emojisViewModel;
    private EditText newuser;
    private ConstraintLayout imagesconstraint;
    Button statusbutton;
    Button userbutton;
    ImageView loveimage,happyimage,sadimage,fantastic;

    int id=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CardView datacardview = findViewById(R.id.datacardview);
        RecyclerView recyclerView= findViewById(R.id.recylerview);
        userListAdapter=new UserListAdapter(this);
        imagesconstraint=findViewById(R.id.images);
        loveimage=findViewById(R.id.love);
        happyimage=findViewById(R.id.happy);
        sadimage=findViewById(R.id.sad);
        fantastic=findViewById(R.id.fanatastic);
        statusbutton=findViewById(R.id.savestatusbutton);
        newuser=findViewById(R.id.nameedittext);
        userbutton=(Button)findViewById(R.id.namesave);
        loveimage.setOnClickListener(this);
        happyimage.setOnClickListener(this);
        sadimage.setOnClickListener(this);
        fantastic.setOnClickListener(this);
         statusbutton.setOnClickListener(this);
     recyclerView.setAdapter(userListAdapter);
     //recyclerView.setAdapter(emojiListAdapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datacardview.setVisibility(View.VISIBLE);



            }
        });


        usersViewModel= ViewModelProviders.of(this).get(UsersViewModel.class);
        userbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(newuser.getText())){
                    Toast.makeText(MainActivity.this, "notsaved", Toast.LENGTH_SHORT).show();

                }
                else {
                    final String user_id= UUID.randomUUID().toString();
                    User user=new User(user_id,newuser.getText().toString());
                    usersViewModel.insert(user);
                    datacardview.setVisibility(View.GONE);
                }

            }

        });


        usersViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userListAdapter.setUsers(users);

            }
        });
        emojisViewModel= ViewModelProviders.of(this).get(EmojisViewModel.class);
        emojisViewModel.getAllEmoji().observe(this, new Observer<List<Emoji>>() {
            @Override
            public void onChanged(List<Emoji> emojis) {
                userListAdapter.setEmojis(emojis);

            }
        });



    }


    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.love:
                  //  Emoji emoji= Emoji(1,);
                    //emoji.setMemoji(R.drawable.love);
                   // emojisViewModel.emojiinsert(emoji);


                    break;
                case R.id.fanatastic:
                   // emoji.setMemoji(R.drawable.fanatsic);
                    //emojisViewModel.emojiinsert(emoji);
                    break;
                case R.id.happy:
                    id=3;
                    Toast.makeText(this, "z", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.sad:
                    id=4;
                    Toast.makeText(this, "n", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.savestatusbutton:
                    Toast.makeText(this, id+"aaaaaa", Toast.LENGTH_SHORT).show();
                    break;
            }

    }



}
