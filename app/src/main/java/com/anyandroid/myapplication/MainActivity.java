package com.anyandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner colorSpinner1;
    private Spinner colorSpinner2;
    private TextView colorTextView;

    private String[] colorChoices = {"Rouge", "Jaune", "Vert"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        colorSpinner1 = findViewById(R.id.color_spinner1);
        colorSpinner2 = findViewById(R.id.color_spinner2);
        colorTextView = findViewById(R.id.color_textview);

        ArrayAdapter<String> colorAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colorChoices);
        colorAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner1.setAdapter(colorAdapter1);

        ArrayAdapter<String> colorAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colorChoices);
        colorAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner2.setAdapter(colorAdapter2);

        colorSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedColor = (String) parent.getItemAtPosition(position);
                updateColorTextView(selectedColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        colorSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedColor = (String) parent.getItemAtPosition(position);
                updateColorTextView(selectedColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void updateColorTextView(String selectedColor) {
        switch (selectedColor) {
            case "Rouge":
                colorTextView.setBackgroundColor(Color.RED);
                break;
            case "Jaune":
                colorTextView.setBackgroundColor(Color.YELLOW);
                break;
            case "Vert":
                colorTextView.setBackgroundColor(Color.GREEN);
                break;
        }
    }
}
/* app1
public class MainActivity extends AppCompatActivity {

    private Spinner colorSpinner;
    private TextView colorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorSpinner = findViewById(R.id.color_spinner);
        colorTextView = findViewById(R.id.color_textview);

        String[] colorChoices = getResources().getStringArray(R.array.color_choices);
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colorChoices);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorAdapter);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedColor = (String) parent.getItemAtPosition(position);
                switch (selectedColor) {
                    case "Rouge":
                        colorTextView.setBackgroundColor(Color.RED);
                        break;
                    case "Jaune":
                        colorTextView.setBackgroundColor(Color.YELLOW);
                        break;
                    case "Vert":
                        colorTextView.setBackgroundColor(Color.GREEN);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}

* */