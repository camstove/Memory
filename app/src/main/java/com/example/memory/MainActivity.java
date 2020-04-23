package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button> picks = new ArrayList<Button>(2);
    ArrayList<Button> picked = new ArrayList<Button>(Board.NUM_BUTTONS);
    Board board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = Menu.board;
        ResetCards();
    }

    public void ClickButton(Button btn){
        board.Flip(btn);
        btn.setEnabled(false);
        btn.setText("cardFront");
        picks.add(btn);
    }

    public void CheckWin(){
        TextView tv = (TextView)findViewById(R.id.textView);
        Button b = (Button)findViewById(R.id.button);
        if(picked.size()==Board.NUM_BUTTONS){
            tv.setText("Victory!");
            b.setVisibility(View.VISIBLE);
            b.setClickable(true);
            //ResetButtons();
        }
    }

    public void Clicked(View v){
        Button btn = (Button)v; //cast view to btn object
        //int index = buttons.indexOf(btn); // get index of btn object for images
        //First pick
        if(picks.isEmpty()){
            ClickButton(btn);
        }else if(picks.size()==1 ) {
            ClickButton(btn);
            if (board.CheckMatch(picks)) {
                picked.addAll(picks);
                picks.clear();
            }
            CheckWin();
        }else{
            ResetPicks();
        }
    }


    public void ResetPicks(){
        for(int i=0;i<picks.size();i++){
            picks.get(i).setEnabled(true);
            picks.get(i).setText("cardBack");
            picks.get(i).setBackgroundResource(board.GetCardBack());
        }
        picks.clear();
    }

    public void ResetCards(){
        ArrayList<Integer> buttons = board.GetButtonList();
        Button b;
        for(int i=0;i<buttons.size();i++){
            b = (Button)findViewById(buttons.get(i));
            b.setEnabled(true);
            b.setText("cardBack");
            b.setTextSize(0.0f);
            b.setBackgroundResource(board.GetCardBack());
        }
    }

    public void ResetGame(View v){
        picks.clear();
        picked.clear();
        Button b = (Button)findViewById(R.id.button);
        b.setClickable(false);
        b.setVisibility(View.INVISIBLE);
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText("");
        ResetCards();
    }


};
