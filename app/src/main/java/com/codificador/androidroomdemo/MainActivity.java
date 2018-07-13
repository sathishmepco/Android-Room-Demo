package com.codificador.androidroomdemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import com.codificador.androidroomdemo.adapter.WordAdapter;
import com.codificador.androidroomdemo.databinding.*;
import com.codificador.androidroomdemo.model.Word;
import com.codificador.androidroomdemo.room.WordViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordAdapter adapter;
    ActivityMainBinding binding;
    private static final int REQUEST_CODE_NEW_WORD = 1;

    private WordViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setEvent(this);
        initComponents();
    }

    private void initComponents(){
        setSupportActionBar(binding.toolbar);
        binding.contentLayout.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new WordAdapter(getApplicationContext());
        binding.contentLayout.recyclerView.setAdapter(adapter);
        viewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        viewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                adapter.setWords(words);
            }
        });
    }

    public void onFabClick(){
        Intent intent = new Intent(getApplicationContext(),NewWordActivity.class);
        startActivityForResult(intent,REQUEST_CODE_NEW_WORD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_NEW_WORD){
            if(resultCode == RESULT_OK){
                viewModel.insertWord((Word) data.getSerializableExtra("word"));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.actionDeleteAll){
            viewModel.deleteAll();
        }
        return super.onOptionsItemSelected(item);
    }
}