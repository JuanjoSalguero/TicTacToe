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
    private final MultiplayerGame gameActivity;

    public MatchResult(@NonNull Context context, String message, MultiplayerGame gameActivity) {
        super(context);
        this.message = message;
        this.gameActivity = gameActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_result);

        TextView messageText = findViewById(R.id.messageText);
        Button startAgainButton = findViewById(R.id.startAgainButton);

        messageText.setText(message);

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameActivity.restartMatch();
                dismiss();
            }
        });
    }
}