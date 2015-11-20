package com.android.imran.cse_dictionary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class WordDefinitionDetailActivity extends AppCompatActivity {
    TextView wordTextView;
    TextView definitionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_definition_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wordTextView=(TextView) findViewById(R.id.wordTextView);
        definitionTextView=(TextView) findViewById(R.id.definitionTextView);

        Log.d("DICTIONARY", "third activity started");



        wordTextView.setText(getIntent().getStringExtra("word"));
        definitionTextView.setText(getIntent().getStringExtra("definition"));
    }

}
