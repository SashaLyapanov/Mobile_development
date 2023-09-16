package com.labsmobilka.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle arguments = getIntent().getExtras();
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.buttonToThird);
        TextView textView1 = findViewById(R.id.text3);
        TextView textView2 = findViewById(R.id.text4);
        if (arguments != null) {
            String personName = arguments.getString("name");
            String resultOfCalculation = arguments.getString("result");
            textView1.setText(personName);
            textView2.setText(resultOfCalculation);
        }
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.buttonToThird) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        }
    }
}