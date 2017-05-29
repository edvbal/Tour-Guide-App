package com.example.android.project6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.project6.Fragments.ToDoFragment;

/**
 * Created by Edvinas on 27/05/2017.
 */

public class ToDoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ToDoFragment())
                .commit();
    }
}
