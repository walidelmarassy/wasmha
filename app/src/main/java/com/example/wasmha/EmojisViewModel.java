
package com.example.wasmha;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EmojisViewModel extends AndroidViewModel {
    private EmojiDao emojidao;
   private EmojiRoomDatabase emojiDB;
    private LiveData<List<Emoji>> mEmojiLists;
    public EmojisViewModel(@NonNull Application application) {
        super(application);
        emojiDB=EmojiRoomDatabase.getDatabase(application);
        emojidao=emojiDB.emojiDao();
        mEmojiLists=emojidao.getAllEmoji();


    }
    LiveData<List<Emoji>>getAllEmoji(){
        return mEmojiLists;
    }
    public void emojiinsert(Emoji emoji) {
    new InsertAsyncTask(emojidao).execute(emoji);


    }
    private class OperationsAsyncTask extends AsyncTask<Emoji, Void, Void> {

        EmojiDao mAsyncTaskDao;

        OperationsAsyncTask(EmojiDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Emoji... notes) {
            return null;
        }
    }
    private class InsertAsyncTask extends EmojisViewModel.OperationsAsyncTask {

        InsertAsyncTask(EmojiDao emojiDao) {
            super(emojiDao);
        }

        @Override
        protected Void doInBackground(Emoji... notes) {
            mAsyncTaskDao.insert(notes[0]);
            return null;
        }
    }


}
