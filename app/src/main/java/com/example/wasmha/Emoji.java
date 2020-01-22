package com.example.wasmha;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Emoji")
public class Emoji {
    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    @ColumnInfo(name = "Emoji")
    private int memoji;

    public void setMemoji(int memoji) {
        this.memoji = memoji;
    }

    public Emoji(@NonNull String id, @NonNull int memoji) {
        this.id = id;
        this.memoji = memoji;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public int getMemoji() {
        return this.memoji;
    }


}
