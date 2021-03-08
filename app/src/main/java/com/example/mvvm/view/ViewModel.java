package com.example.mvvm.view;

import androidx.lifecycle.MutableLiveData;
import com.example.mvvm.model.Model;

import java.util.Observable;
import java.util.Observer;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private MutableLiveData<String> presentableData = new MutableLiveData<>();
    private Model model = new Model();

    public ViewModel(){
        observeModel(model);
        presentableData.setValue(getTransformedData(model.getText()));
    }

    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof Model) {
                    String data = ((Model) o).getText();
                    presentableData.setValue(getTransformedData(data));
                }
            }
        });
    }
    private String getTransformedData(String text) {
        return text.toLowerCase();
    }

    public MutableLiveData<String> getPresentableData() {
        return presentableData;
    }

    public void setData(String text) { model.setText(text); }
}
