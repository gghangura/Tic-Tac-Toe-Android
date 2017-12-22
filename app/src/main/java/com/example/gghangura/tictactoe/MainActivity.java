package com.example.gghangura.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[][] winningCombinations = new int[][] {
            new int[] {0, 1, 2}
            ,   new int[] {3, 4, 5}
            ,   new int[] {6, 7, 8}
            ,   new int[] {0, 3, 6}
            ,   new int[] {1, 4, 7}
            ,   new int[] {2, 5, 8}
            ,   new int[] {0, 4, 8}
            ,   new int[] {2, 4, 6}
    };

    int[] gameCombination = new int[] {
            0,0,0,0,0,0,0,0,0
    };

    //0 is circle, 1 is cross
    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i <10;i ++) {
            String str = "imageButton" + i;
            int id = this.getResources().getIdentifier("imageButton" + i, "id", this.getPackageName());
            ImageButton imgBtn = (ImageButton) findViewById(id);
            imgBtn.setBackgroundResource(0);
        }
    }

    void onImageClick(View v) {

        ImageButton imgBtn = (ImageButton) v;

        int tag = Integer.parseInt((String) imgBtn.getTag());
        tag --;

        if (gameCombination[tag] == 0) {

            if (current == 0) {
                imgBtn.setImageResource(R.drawable.cross);
                current = 1;
                gameCombination[tag] = 1;
            } else  {
                imgBtn.setImageResource(R.drawable.circle);
                current = 0;
                gameCombination[tag] = 2;
            }
        }

        int win = checkWinning();
        if (win != 0) {
            Toast.makeText(this, "Win",
                    Toast.LENGTH_LONG).show();
        } else  {
            gameOver();
        }



    }

    int checkWinning () {
        int win = 0;
        for (int i =0; i < 8 ; i ++) {
            int[] winnArr = winningCombinations[i];
            if (gameCombination[winnArr[0]] == gameCombination[winnArr[1]] && gameCombination[winnArr[1]] == gameCombination[winnArr[2]] && gameCombination[winnArr[2]] == gameCombination[winnArr[0]] && gameCombination[winnArr[0]] != 0) {
                if (winnArr[0] == 1) {
                    win = 1;
                } else  {
                    win = 2;
                }
                toggleView(false);
                break;
            }
        }
        return win;
    }

    void gameOver() {
        boolean conti = false;
        for (int i =0; i < 8; i++) {
            if (gameCombination[i] == 0) {
                conti = true;
                break;
            }
        }
        if (!conti) {
            toggleView(false);
        }
    }

    void toggleView(Boolean bol) {
        for (int i = 1; i <10;i ++) {
            String str = "imageButton" + i;
            int id = this.getResources().getIdentifier("imageButton" + i, "id", this.getPackageName());
            ImageButton imgBtn = (ImageButton) findViewById(id);
            imgBtn.setEnabled(bol);
        }

        Button btn = (Button) findViewById(R.id.resetButton);

        btn.setEnabled(!bol);

    }

    void reset(View v) {
        for (int i = 1; i <10;i ++) {
            String str = "imageButton" + i;
            int id = this.getResources().getIdentifier("imageButton" + i, "id", this.getPackageName());
            ImageButton imgBtn = (ImageButton) findViewById(id);
            imgBtn.setBackgroundResource(0);
            imgBtn.setImageResource(R.drawable.white);
            imgBtn.setEnabled(true);
        }
        gameCombination = new int[] {
                0,0,0,0,0,0,0,0,0
        };



    }
}
