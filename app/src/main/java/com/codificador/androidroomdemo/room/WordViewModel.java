package com.codificador.androidroomdemo.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.codificador.androidroomdemo.model.Word;
import java.util.List;

public class WordViewModel extends AndroidViewModel{
    private WordRepository wordRepository;
    private LiveData<List<Word>> allWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        allWords = wordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insertWord(Word word){
        wordRepository.insertWord(word);
    }

    public void deleteAll(){
        wordRepository.deleteAll();
    }
}