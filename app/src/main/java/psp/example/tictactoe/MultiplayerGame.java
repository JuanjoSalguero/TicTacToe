package psp.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MultiplayerGame extends AppCompatActivity {

    private final List<int[]> combinationList = new ArrayList<>();
    private int [] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;
    private boolean locked = false;
    private int scoreOne = 0;
    private int scoreTwo = 0;

    private TextView playerOneName, playerTwoName;
    private TextView playerOneScore, playerTwoScore;
    private LinearLayout playerOneLayout, playerTwoLayout;
    private ImageView buttonImage1, buttonImage2, buttonImage3, buttonImage4, buttonImage5, buttonImage6, buttonImage7, buttonImage8, buttonImage9;
    private ImageView lock;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_game);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        playerOneScore = findViewById(R.id.playerOneScore);
        playerTwoScore = findViewById(R.id.playerTwoScore);

        playerOneLayout = findViewById(R.id.playerOneLayout);
        playerTwoLayout = findViewById(R.id.playerTwoLayout);

        buttonImage1 = findViewById(R.id.buttonImage1);
        buttonImage2 = findViewById(R.id.buttonImage2);
        buttonImage3 = findViewById(R.id.buttonImage3);
        buttonImage4 = findViewById(R.id.buttonImage4);
        buttonImage5 = findViewById(R.id.buttonImage5);
        buttonImage6 = findViewById(R.id.buttonImage6);
        buttonImage7 = findViewById(R.id.buttonImage7);
        buttonImage8 = findViewById(R.id.buttonImage8);
        buttonImage9 = findViewById(R.id.buttonImage9);

        lock = (ImageView)findViewById(R.id.locked);

        combinationList.add(new int[] {0,1,2});
        combinationList.add(new int[] {3,4,5});
        combinationList.add(new int[] {6,7,8});
        combinationList.add(new int[] {0,3,6});
        combinationList.add(new int[] {1,4,7});
        combinationList.add(new int[] {2,5,8});
        combinationList.add(new int[] {2,4,6});
        combinationList.add(new int[] {0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);


        buttonImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0) && locked == false){
                    performAction((ImageView) view, 0);
                }
            }
        });

        buttonImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(1) && locked == false){
                    performAction((ImageView) view, 1);
                }
            }
        });

        buttonImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2) && locked == false){
                    performAction((ImageView) view, 2);
                }
            }
        });

        buttonImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3) && locked == false){
                    performAction((ImageView) view, 3);
                }
            }
        });

        buttonImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4) && locked == false){
                    performAction((ImageView) view, 4);
                }
            }
        });

        buttonImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5) && locked == false){
                    performAction((ImageView) view, 5);
                }
            }
        });

        buttonImage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6) && locked == false){
                    performAction((ImageView) view, 6);
                }
            }
        });

        buttonImage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7) && locked == false){
                    performAction((ImageView) view, 7);
                }
            }
        });

        buttonImage9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8) && locked == false){
                    performAction((ImageView) view, 8);
                }
            }
        });

    }

    private void performAction(ImageView  imageView, int selectedBoxPosition) {

        boxPositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.cross);
            if (checkResults()) {
                MatchResult resultDialog = new MatchResult(MultiplayerGame.this, playerOneName.getText().toString()
                        + " has won!", MultiplayerGame.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
                scoreOne++;
                playerOneScore.setText(Integer.toString(scoreOne));
            } else if(totalSelectedBoxes == 9) {
                MatchResult resultDialog = new MatchResult(MultiplayerGame.this, "Match Draw", MultiplayerGame.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.circle);
            if (checkResults()) {
                MatchResult resultDialog = new MatchResult(MultiplayerGame.this, playerTwoName.getText().toString()
                        + " has won!", MultiplayerGame.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
                scoreTwo++;
                playerTwoScore.setText(Integer.toString(scoreTwo));
            } else if(totalSelectedBoxes == 9) {
                MatchResult resultDialog = new MatchResult(MultiplayerGame.this, "Match Draw", MultiplayerGame.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            playerOneLayout.setBackgroundResource(R.drawable.blue_border);
            playerTwoLayout.setBackgroundResource(R.drawable.black_box);
        } else {
            playerTwoLayout.setBackgroundResource(R.drawable.blue_border);
            playerOneLayout.setBackgroundResource(R.drawable.black_box);
        }
    }

    private boolean checkResults(){
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++){
            final int[] combination = combinationList.get(i);
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }

    private boolean isBoxSelectable(int boxPosition){

        boolean response = false;

        if (boxPositions[boxPosition] == 0) {
            response = true;
        }

        return response;
    }

    // Method to restart match
    public void restartMatch(){
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0}; //9 zero
        playerTurn = 1;
        totalSelectedBoxes = 1;

        buttonImage1.setImageResource(R.drawable.reset_box);
        buttonImage2.setImageResource(R.drawable.reset_box);
        buttonImage3.setImageResource(R.drawable.reset_box);
        buttonImage4.setImageResource(R.drawable.reset_box);
        buttonImage5.setImageResource(R.drawable.reset_box);
        buttonImage6.setImageResource(R.drawable.reset_box);
        buttonImage7.setImageResource(R.drawable.reset_box);
        buttonImage8.setImageResource(R.drawable.reset_box);
        buttonImage9.setImageResource(R.drawable.reset_box);
    }

    // Method to reset match
    public void resetMatch(View view){
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0}; //9 zero
        playerTurn = 1;
        totalSelectedBoxes = 1;

        buttonImage1.setImageResource(R.drawable.reset_box);
        buttonImage2.setImageResource(R.drawable.reset_box);
        buttonImage3.setImageResource(R.drawable.reset_box);
        buttonImage4.setImageResource(R.drawable.reset_box);
        buttonImage5.setImageResource(R.drawable.reset_box);
        buttonImage6.setImageResource(R.drawable.reset_box);
        buttonImage7.setImageResource(R.drawable.reset_box);
        buttonImage8.setImageResource(R.drawable.reset_box);
        buttonImage9.setImageResource(R.drawable.reset_box);
    }

    // Method to go back
    public void goBack(View view){
        finish();
    }

    // Method to lock the match
    public void lockOrUnlock(View view){
        if (locked == false) {
            locked = true;
            lock.setImageResource(R.drawable.unlocked);
        }
        else{
            locked = false;
            lock.setImageResource(R.drawable.locked);
        }
    }
}