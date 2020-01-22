package com.example.wasmha;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = User.class,version = 1,exportSchema = false)

public abstract class UserRoomDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    private static volatile UserRoomDatabase userRoomInstance;

    static UserRoomDatabase getDatabase(final Context context) {
        if (userRoomInstance == null) {
            synchronized (UserRoomDatabase.class) {
                if (userRoomInstance == null){
                    userRoomInstance = Room.databaseBuilder(context.getApplicationContext(), UserRoomDatabase.class, "User_database").build();

            }
        }
    }
        return userRoomInstance;
    }

}


