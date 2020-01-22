package com.example.wasmha;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {
    private UserDao userDao;
    private UserRoomDatabase userDB;
    private LiveData<List<User>>mUserLists;
    public UsersViewModel(@NonNull Application application) {

        super(application);
        userDB=UserRoomDatabase.getDatabase(application);
        userDao=userDB.userDao();
        mUserLists=userDao.getAllUsers();

    }

    LiveData<List<User>>getAllUsers(){
        return mUserLists;
    }


    public void insert(User user) {
        new InsertAsyncTask(userDao).execute(user);


    }

    private class OperationsAsyncTask extends AsyncTask<User, Void, Void> {

        UserDao mAsyncTaskDao;

        OperationsAsyncTask(UserDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(User... notes) {
            return null;
        }
    }

    private class InsertAsyncTask extends OperationsAsyncTask {

        InsertAsyncTask(UserDao mUserDao) {
            super(mUserDao);
        }

        @Override
        protected Void doInBackground(User... notes) {
            mAsyncTaskDao.insert(notes[0]);
            return null;
        }
    }
}
