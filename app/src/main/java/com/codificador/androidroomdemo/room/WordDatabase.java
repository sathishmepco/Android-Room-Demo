package com.codificador.androidroomdemo.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import com.codificador.androidroomdemo.model.Word;

@Database(entities = {Word.class},version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase{
    public abstract WordDao getWordDao();
    private static WordDatabase instance;

    public static WordDatabase getInstance(Context context){
        if(instance == null){
            synchronized (WordDatabase.class){
                if(instance == null){
                    instance = Room.databaseBuilder(context,WordDatabase.class,"word_database")
                    .addCallback(roomCallback)
                    .build();
                }
            }
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
}