package psp.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    CheckBox hard;
    String hardMode = "no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hard = (CheckBox) findViewById(R.id.hardCheckBox);
    }

    public void multiplayerGame(View view){
        Intent gameActivity = new Intent(this, PlayersWindow.class);
        startActivity(gameActivity);
    }

    public void singleplayerGame(View view){
        if (hard.isChecked()){
            hardMode = "yes";
            Intent intent = new Intent(this, SingleplayerGame.class);
            intent.putExtra("hardMode", hardMode);
            startActivity(intent);
        } else{
            Intent singleMode = new Intent(this, SingleplayerGame.class);
            hardMode = "no";
            singleMode.putExtra("hardMode", hardMode);
            startActivity(singleMode);
        }
    }

    public void exit(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Message to show in the dialog
        builder.setMessage("Are you sure you want to exit TicTacToe?")
                .setCancelable(false)
                // Yes option, close de app
                .setPositiveButton("Yes", (dialogInterface, i) -> finish())
                // No option, closes de dialog
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}