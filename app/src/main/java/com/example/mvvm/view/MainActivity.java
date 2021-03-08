package com.example.mvvm.view;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mvvm.R;

public class MainActivity extends AppCompatActivity {

    private ViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observeViewModel();

        EditText textInput = (EditText) findViewById(R.id.textInput);
        textInput.setText(viewModel.getPresentableData().getValue());

    }
    private void observeViewModel() {
        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        final Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView outputView = (TextView) findViewById(R.id.textDisplay);
                outputView.setText(s);
            }
        };

        viewModel.getPresentableData().observe(this, stringObserver);
    }

    public void enterInput(View view) {
        EditText inputText = (EditText) findViewById(R.id.textInput);

        String input = inputText.getText().toString();
        viewModel.setData(input);
    }
}