package com.example.gghangura.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private int[][] winningCombinations = new int[][] {
            new int[] {1, 2, 3}
            ,   new int[] {4, 5, 6}
            ,   new int[] {7, 8, 9}
            ,   new int[] {1, 4, 7}
            ,   new int[] {2, 5, 8}
            ,   new int[] {3, 6, 9}
            ,   new int[] {1, 5, 9}
            ,   new int[] {3, 5, 7}
    };

    //0 is circle, 1 is cross
    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void onImageClick(View v) {

        ImageButton imgBtn = (ImageButton) v;
        if (current == 0) {
            imgBtn.setImageDrawable(drawable.circle);
            current = 1;
        } else  {
            imgBtn.setImageDrawable(drawable.circle);
            current = 0;
        }
    }
}
