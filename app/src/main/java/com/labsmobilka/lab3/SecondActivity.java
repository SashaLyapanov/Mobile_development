package com.labsmobilka.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText name = findViewById(R.id.input_name);
        if (view.getId() == R.id.button2) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("name", name.getText().toString());
            startActivity(intent);
        }
    }

}