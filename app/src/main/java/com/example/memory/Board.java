package com.example.memory;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class Board{
    public static final int NUM_BUTTONS = 12;

    public static final int [] FARM_LIST = {R.drawable.chicken,R.drawable.cow,
            R.drawable.duck,R.drawable.horse, R.drawable.mouse, R.drawable.sheep};

    public static final int [] SEA_LIST = {R.drawable.boat,R.drawable.dolphin,
            R.drawable.fish,R.drawable.lighthouse,R.drawable.shark,R.drawable.starfish};

    public static final int[] SPOOKY_LIST = {R.drawable.death,R.drawable.mask,
            R.drawable.pumpkin,R.drawable.skull,R.drawable.spider,R.drawable.zombie};

    public static final int FARM_BACK = R.drawable.tractor;
    public static final int SEA_BACK = R.drawable.anchor;
    public static final int SPOOKY_BACK = R.drawable.coffin;

    ArrayList<Integer> images = new ArrayList<Integer>(NUM_BUTTONS);
    ArrayList<Integer> buttons = new ArrayList<Integer>(NUM_BUTTONS);

    private int cardBack = 0;
    private int style = 0;

    public ArrayList<Integer> GetButtonList(){return buttons;}
    public int GetCardBack(){return cardBack;}
    public int GetStyle(){return style;}

    public Board(int style){
        InitButtonList();
        InitImageList(style);
        Collections.shuffle(images);
       // ResetCards();
    }

    public boolean CheckMatch(ArrayList<Button> picks){
        boolean match = false;
        int button1 = buttons.indexOf((picks.get(0)).getId());
        int image1 = images.get(button1);
        int button2 = buttons.indexOf((picks.get(1)).getId());
        int image2 = images.get(button2);
        if(image1==image2){
            match = true;
        }
        return match;
    }

    public void Flip(Button b){
        if(b.getText()=="cardBack"){
            int index = buttons.indexOf(b.getId());
            b.setBackgroundResource(images.get(index));
        }
    }



    public void InitButtonList(){
        buttons.add(R.id.button1);
        buttons.add(R.id.button2);
        buttons.add(R.id.button3);
        buttons.add(R.id.button4);
        buttons.add(R.id.button5);
        buttons.add(R.id.button6);
        buttons.add(R.id.button7);
        buttons.add(R.id.button8);
        buttons.add(R.id.button9);
        buttons.add(R.id.button10);
        buttons.add(R.id.button11);
        buttons.add(R.id.button12);
    }

    public void InitImageList(int style){
        switch(style){
            case R.id.farm:
                for(int i=0;i<2;i++){
                    for(int j=0;j<FARM_LIST.length;j++){
                        images.add(FARM_LIST[j]);
                    }
                }
                cardBack=FARM_BACK;
                break;
            case R.id.sea:
                for(int i=0;i<2;i++){
                    for(int j=0;j<SEA_LIST.length;j++){
                        images.add(SEA_LIST[j]);
                    }
                }
                cardBack=SEA_BACK;
                break;
            case R.id.spooky:
                for(int i=0;i<2;i++){
                    for(int j=0;j<SPOOKY_LIST.length;j++){
                        images.add(SPOOKY_LIST[j]);
                    }
                }
                cardBack = SPOOKY_BACK;
                break;
        }
    }
}
