package com.example.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem); //binds the variable to the text
        btnSave = findViewById(R.id.btnSave);   //binds the variable to the button

        getSupportActionBar().setTitle("Edit Item");//sets the title of the activity within the app

        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        //clicked when the user is done editing
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create an intent which will contain the results
                Intent intent = new Intent();   //empty, because we will be using it as a shell to pass data

                //pass the dtaa (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //set the result of the intent
                setResult(RESULT_OK, intent);

                //finish activity, close the screen and go back
                finish();
            }
        });
    }
}