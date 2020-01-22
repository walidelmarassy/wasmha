package com.example.wasmha;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface EmojiDao {
    @Insert
    void insert(Emoji emoji);
    @Query("SELECT*FROM Emoji")
    LiveData<List<Emoji>>getAllEmoji();
}
