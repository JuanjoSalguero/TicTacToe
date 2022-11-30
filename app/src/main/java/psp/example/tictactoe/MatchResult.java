package psp.example.tictactoe;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MatchResult extends Dialog {

    private final String message;
    private final MultiplayerGame multiplayerGame;
    private final SingleplayerGame singleplayerGame;

    public MatchResult(@NonNull Context context, String message, MultiplayerGame multiplayerGame) {
        super(context);
        this.message = message;
        this.multiplayerGame = multiplayerGame;
        this.singleplayerGame = null;
    }

    public MatchResult(@NonNull Context context, String message, SingleplayerGame singleplayerGame) {
        super(context);
        this.message = message;
        this.singleplayerGame = singleplayerGame;
        this.multiplayerGame = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_result);

        TextView messageText = findViewById(R.id.messageText);
        Button rematch = findViewById(R.id.startAgainButton);

        messageText.setText(message);

        rematch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //multiplayerGame.restartMatch();
                singleplayerGame.restartMatch();
                dismiss();
            }
        });
    }
}