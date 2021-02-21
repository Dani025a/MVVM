package com.example.mvvm.model;

import java.util.Observable;

public class Model extends Observable {
    private String text;

    public Model() {
        this.text = "Welcome";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        super.setChanged();
        super.notifyObservers();
    }
}
