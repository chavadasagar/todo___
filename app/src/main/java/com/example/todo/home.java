package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class home extends AppCompatActivity {

    ListView all_task;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        all_task = (ListView)findViewById(R.id.all_task);
        add = (Button) findViewById(R.id.home_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_task = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(add_task);
                finish();
            }
        });
    }
}