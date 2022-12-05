package psp.example.tictactoe;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SPMatchResult extends Dialog {

    // Variables
    private final String message;
    private final SingleplayerGame singleplayerGame;

    // Constructor
    public SPMatchResult(@NonNull Context context, String message, SingleplayerGame singleplayerGame) {
        super(context);
        this.message = message;
        this.singleplayerGame = singleplayerGame;
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
                singleplayerGame.restartMatch();
                dismiss();
            }
        });
    }
}