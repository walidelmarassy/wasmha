package com.example.wasmha;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = Emoji.class,version = 2,exportSchema = false)


public abstract class EmojiRoomDatabase extends RoomDatabase {
    public abstract EmojiDao emojiDao();
    private static volatile EmojiRoomDatabase emojiRoomDatabase;
    static EmojiRoomDatabase getDatabase(final Context context) {
        if (emojiRoomDatabase == null) {
            synchronized (EmojiRoomDatabase.class) {
                if (emojiRoomDatabase == null){
                    emojiRoomDatabase = Room.databaseBuilder(context.getApplicationContext(), EmojiRoomDatabase.class, "Emoji_database").build();

                }
            }
        }
        return emojiRoomDatabase;
    }




}
