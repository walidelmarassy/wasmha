package com.example.wasmha;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static final int NEW_USER_ACTIVITY_REQUEST_CODE =1 ;
    private  String TAG=this.getClass().getSimpleName();
    private UsersViewModel usersViewModel;
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView= findViewById(R.id.recylerview);
        userListAdapter=new UserListAdapter(this);
     recyclerView.setAdapter(userListAdapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,insertionActivity.class);
                startActivityForResult(intent,NEW_USER_ACTIVITY_REQUEST_CODE);

            }
        });
        usersViewModel= ViewModelProviders.of(this).get(UsersViewModel.class);
        usersViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userListAdapter.setUsers(users);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==NEW_USER_ACTIVITY_REQUEST_CODE&&resultCode==RESULT_OK){
            final String user_id= UUID.randomUUID().toString();
            User user=new User(user_id,data.getStringExtra(insertionActivity.User_ADDED));
            usersViewModel.insert(user);
            Toast.makeText(this, "datasaved", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "notsaved", Toast.LENGTH_SHORT).show();
        }

    }
}
