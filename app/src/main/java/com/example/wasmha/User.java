package com.example.wasmha;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class User {
    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    @ColumnInfo(name = "user")
    private String muser;

    public User(@NonNull String id, @NonNull String muser) {
        this.id = id;
        this.muser = muser;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getMuser() {
        return this.muser;
    }
}
