package com.example.jack.kubratest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PostsActivity extends AppCompatActivity {

    TextView tvHeader;
    String nameOfPerson;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        Bundle b = getIntent().getExtras();
        nameOfPerson = "name";
        if (b != null) {
            nameOfPerson = b.getString("name");
        }

        tvHeader = findViewById(R.id.tvPostsHeader);
        tvHeader.setText("Posts by " + nameOfPerson);
    }
}