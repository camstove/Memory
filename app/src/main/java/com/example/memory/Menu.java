package com.example.memory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    public static Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void ModifyData(View v){
        board =  new Board(v.getId());
        Intent myIntent = new Intent(this,MainActivity.class);
        this.startActivity(myIntent);
    }
}
