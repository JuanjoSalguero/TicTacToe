package psp.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        // IDs player one and player two
        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        // ID start button
        Button startGameButton = findViewById(R.id.startGameButton);
        // StartGame button listener
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getPlayerOneName = playerOne.getText().toString();
                String getPlayerTwoName = playerTwo.getText().toString();

                // If any player name is empty, it will not start and toast message
                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                    Toast.makeText(AddPlayers.this, "Please enter player name", Toast.LENGTH_SHORT).show();
                } else { // If the names are filled, game will start (go to game activity)
                    Intent play = new Intent(AddPlayers.this, GameActivity.class);
                    play.putExtra("playerOne", getPlayerOneName);
                    play.putExtra("playerTwo", getPlayerTwoName);
                    startActivity(play);
                }
            }
        });
    }
}