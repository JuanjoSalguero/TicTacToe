package psp.example.tictactoe;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MPMatchResult extends Dialog {

    // Variables
    private final String message;
    private final MultiplayerGame multiplayerGame;

    // Constructor
    public MPMatchResult(@NonNull Context context, String message, MultiplayerGame multiplayerGame) {
        super(context);
        this.message = message;
        this.multiplayerGame = multiplayerGame;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpmatch_result);

        TextView messageText = findViewById(R.id.messageText);
        Button rematch = findViewById(R.id.startAgainButton);

        // Set a message to the alert
        messageText.setText(message);

        // Listener to restart the match
        rematch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplayerGame.restartMatch();
                dismiss();
            }
        });
    }
}