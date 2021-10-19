package edu.ysu.restaurantclient.connectfour;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import edu.ysu.restaurantclient.R;

 public class WelcomeActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_welcome);

         toGame();
         returnToMain();

     }

    private void returnToMain(){
    Button returnButton = findViewById(R.id.exit_button);
            returnButton.setOnClickListener(v -> finish());

    }

     private void toGame() {
         Button gameButton = findViewById(R.id.start_button);
         gameButton.setOnClickListener(v -> startActivity(new Intent(WelcomeActivity.this, GameBoardActivity.class)));
     }

 }

