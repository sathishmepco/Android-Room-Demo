package com.codificador.androidroomdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.codificador.androidroomdemo.R;
import com.codificador.androidroomdemo.databinding.*;
import com.codificador.androidroomdemo.model.Word;
import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    List<Word> words;
    LayoutInflater layoutInflater;

    public WordAdapter(Context context){
        words = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordItemBinding binding  = DataBindingUtil.inflate(layoutInflater, R.layout.word_item,parent,false);
        return new WordViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.bind(words.get(position));
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{
        WordItemBinding binding;
        public WordViewHolder(WordItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Word word){
            binding.textView.setText(word.getWordName());
        }
    }

    public void setWords(List<Word> list){
        words = list;
        notifyDataSetChanged();
    }
}
