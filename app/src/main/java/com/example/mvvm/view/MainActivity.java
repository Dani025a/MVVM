package com.example.mvvm.view;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mvvm.R;
import com.example.mvvm.model.Model;

public class MainActivity extends AppCompatActivity {

private Model model = new Model();

    private EditText textInput;
    private TextView textDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = (EditText) findViewById(R.id.textInput);
        textDisplay = (TextView) findViewById(R.id.textDisplay);

        textInput.setText(model.getText());
        textDisplay.setText(model.getText());

    }
    public void editText(View view) {
        String text = textInput.getText().toString();
        model.setText(text);
        textDisplay.setText(text);
    }
}