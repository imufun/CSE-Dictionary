package com.android.imran.cse_dictionary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    final static String SHARED_NAME_STRING="sharedp";
    final static String USER_NAME_STRING="user";

    Button button;
    EditText editText;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editText=(EditText) findViewById(R.id.userNameEditText);
        button=(Button) findViewById(R.id.enterButton);

        Log.d("DICTIONARY", "main activity started");


        sharedPreferences=getSharedPreferences(SHARED_NAME_STRING, MODE_PRIVATE);
        String userNameString=sharedPreferences.getString(USER_NAME_STRING, "");

        editText.setText(userNameString);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String string = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, DictionaryListActivity.class);
                intent.putExtra("user", string);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(USER_NAME_STRING, string);
                editor.commit();

                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
