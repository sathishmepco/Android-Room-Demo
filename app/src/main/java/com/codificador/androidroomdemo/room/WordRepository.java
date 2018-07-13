package com.codificador.androidroomdemo.room;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import com.codificador.androidroomdemo.model.Word;
import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    public WordRepository(Context context){
        WordDatabase database = WordDatabase.getInstance(context);
        wordDao = database.getWordDao();
        allWords = wordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insertWord(Word word){
        new InsertAsyncTask(wordDao).execute(word);
    }

    private static class InsertAsyncTask extends AsyncTask<Word,Void,Void> {
        private WordDao asyncTaskDao;
        public InsertAsyncTask(WordDao wordDao){
            asyncTaskDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            asyncTaskDao.insert(words[0]);
            return null;
        }
    }

    public void deleteAll(){
        new DeleteAllAsyncTask(wordDao).execute();
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        WordDao deleteAllDao;

        public DeleteAllAsyncTask(WordDao wordDao){
            this.deleteAllDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            deleteAllDao.deleteAll();
            return null;
        }
    }
}
