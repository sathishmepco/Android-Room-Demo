package com.codificador.androidroomdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.codificador.androidroomdemo.databinding.*;
import com.codificador.androidroomdemo.model.Word;

public class NewWordActivity extends AppCompatActivity {

    ActivityNewWordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_word);
        initComponents();
    }

    private void initComponents(){
        setSupportActionBar(binding.toolbar);
        binding.setEvent(this);
    }

    public void onSave(){
        Word word = new Word();
        word.setWordName(binding.contentLayout.editTextWordName.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("word",word);
        setResult(RESULT_OK,intent);
        finish();
    }
}