package edu.ysu.restaurantclient.connectfour;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import edu.ysu.restaurantclient.R;
import android.widget.EditText;

public class GameBoardActivity extends AppCompatActivity implements View.OnClickListener {

    public final Board game = new Board();
    private final Button[][] button = new Button[7][6];
    private EditText winnerDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        winnerDisplay = this.findViewById(R.id.WinnerTextBox);
        game.InitializeGame();      //initialize game_board

        returnToWelcomeScreen();

        //initialize buttons

        //column 1
        button[0][0] = findViewById(R.id.button0);     button[0][0].setOnClickListener(this);
        button[0][1] = findViewById(R.id.button7);     button[0][1].setOnClickListener(this);
        button[0][2] = findViewById(R.id.button14);    button[0][2].setOnClickListener(this);
        button[0][3] = findViewById(R.id.button21);    button[0][3].setOnClickListener(this);
        button[0][4] = findViewById(R.id.button28);    button[0][4].setOnClickListener(this);
        button[0][5] = findViewById(R.id.button35);    button[0][5].setOnClickListener(this);

        //column 2
        button[1][0] = findViewById(R.id.button1);     button[1][0].setOnClickListener(this);
        button[1][1] = findViewById(R.id.button8);     button[1][1].setOnClickListener(this);
        button[1][2] = findViewById(R.id.button15);    button[1][2].setOnClickListener(this);
        button[1][3] = findViewById(R.id.button22);    button[1][3].setOnClickListener(this);
        button[1][4] = findViewById(R.id.button29);    button[1][4].setOnClickListener(this);
        button[1][5] = findViewById(R.id.button36);    button[1][5].setOnClickListener(this);

        //column 3
        button[2][0] = findViewById(R.id.button2);     button[2][0].setOnClickListener(this);
        button[2][1] = findViewById(R.id.button9);     button[2][1].setOnClickListener(this);
        button[2][2] = findViewById(R.id.button16);    button[2][2].setOnClickListener(this);
        button[2][3] = findViewById(R.id.button23);    button[2][3].setOnClickListener(this);
        button[2][4] = findViewById(R.id.button30);    button[2][4].setOnClickListener(this);
        button[2][5] = findViewById(R.id.button37);    button[2][5].setOnClickListener(this);

        //column 4
        button[3][0] = findViewById(R.id.button3);    button[3][0].setOnClickListener(this);
        button[3][1] = findViewById(R.id.button10);   button[3][1].setOnClickListener(this);
        button[3][2] = findViewById(R.id.button17);   button[3][2].setOnClickListener(this);
        button[3][3] = findViewById(R.id.button24);   button[3][3].setOnClickListener(this);
        button[3][4] = findViewById(R.id.button31);   button[3][4].setOnClickListener(this);
        button[3][5] = findViewById(R.id.button38);   button[3][5].setOnClickListener(this);

        //column 5
        button[4][0] = findViewById(R.id.button4);     button[4][0].setOnClickListener(this);
        button[4][1] = findViewById(R.id.button11);    button[4][1].setOnClickListener(this);
        button[4][2] = findViewById(R.id.button18);    button[4][2].setOnClickListener(this);
        button[4][3] = findViewById(R.id.button25);    button[4][3].setOnClickListener(this);
        button[4][4] = findViewById(R.id.button32);    button[4][4].setOnClickListener(this);
        button[4][5] = findViewById(R.id.button39);    button[4][5].setOnClickListener(this);

        //column 6
        button[5][0] = findViewById(R.id.button5);     button[5][0].setOnClickListener(this);
        button[5][1] = findViewById(R.id.button12);    button[5][1].setOnClickListener(this);
        button[5][2] = findViewById(R.id.button19);    button[5][2].setOnClickListener(this);
        button[5][3] = findViewById(R.id.button26);    button[5][3].setOnClickListener(this);
        button[5][4] = findViewById(R.id.button33);    button[5][4].setOnClickListener(this);
        button[5][5] = findViewById(R.id.button40);    button[5][5].setOnClickListener(this);

        //column 7
        button[6][0] = findViewById(R.id.button6);     button[6][0].setOnClickListener(this);
        button[6][1] = findViewById(R.id.button13);    button[6][1].setOnClickListener(this);
        button[6][2] = findViewById(R.id.button20);    button[6][2].setOnClickListener(this);
        button[6][3] = findViewById(R.id.button27);    button[6][3].setOnClickListener(this);
        button[6][4] = findViewById(R.id.button34);    button[6][4].setOnClickListener(this);
        button[6][5] = findViewById(R.id.button41);    button[6][5].setOnClickListener(this);

    }

    private void returnToWelcomeScreen(){
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        int column = 0;

        if(id == R.id.button0 || id == R.id.button7 || id == R.id.button14 || id == R.id.button21 || id == R.id.button28 || id == R.id.button35) {
            game.positionChip(column, button);
            game.determineWin();
            winnerDisplay.setText(game.displayWinner());
            game.switchTurns();
               }

        else if(id == R.id.button1 || id == R.id.button8 || id == R.id.button15 || id == R.id.button22 || id == R.id.button29 || id == R.id.button36) {
            column = 1;
            game.positionChip(column, button);
            game.determineWin();
            winnerDisplay.setText(game.displayWinner());
            game.switchTurns();

        }

        else if(id == R.id.button2 || id == R.id.button9 || id == R.id.button16 || id == R.id.button23 || id == R.id.button30 || id == R.id.button37) {
            column = 2;
            game.positionChip(column, button);
            game.determineWin();
            winnerDisplay.setText(game.displayWinner());
            game.switchTurns();
        }

        else if(id == R.id.button3 || id == R.id.button10 || id == R.id.button17 || id == R.id.button24 || id == R.id.button31 || id == R.id.button38) {
            column = 3;
            game.positionChip(column, button);
            game.determineWin();
            winnerDisplay.setText(game.displayWinner());
            game.switchTurns();

        }

        else if(id == R.id.button4 || id == R.id.button11 || id == R.id.button18 || id == R.id.button25 || id == R.id.button32 || id == R.id.button39) {
            column = 4;
            game.positionChip(column, button);
            game.determineWin();
            winnerDisplay.setText(game.displayWinner());
            game.switchTurns();

        }

        else if(id == R.id.button5 || id == R.id.button12 || id == R.id.button19 || id == R.id.button26 || id == R.id.button33 || id == R.id.button40) {
            column = 5;
            game.positionChip(column, button);
            game.determineWin();
            winnerDisplay.setText(game.displayWinner());
            game.switchTurns();
        }

        else if(id == R.id.button6 || id == R.id.button13 || id == R.id.button20 || id == R.id.button27 || id == R.id.button34 || id == R.id.button41) {
            column = 6;
            game.positionChip(column, button);
            game.determineWin();
            winnerDisplay.setText(game.displayWinner());
            game.switchTurns();
        }
    }

}
