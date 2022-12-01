package psp.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleplayerGame extends AppCompatActivity implements View.OnClickListener {

    private int [] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int totalSelectedBoxes = 0;
    private boolean locked = false;
    private boolean playerWin, machineWin = false;
    private int scorePlayer = 0;
    private int scoreMachine = 0;
    private int random;

    private TextView playerScore, machineScore;
    private ImageView buttonImage1, buttonImage2, buttonImage3, buttonImage4,
            buttonImage5, buttonImage6, buttonImage7, buttonImage8, buttonImage9;
    private ImageView lock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_game);

        playerScore = findViewById(R.id.playerScore);
        machineScore = findViewById(R.id.machineScore);

        buttonImage1 = findViewById(R.id.buttonImage1);
        buttonImage2 = findViewById(R.id.buttonImage2);
        buttonImage3 = findViewById(R.id.buttonImage3);
        buttonImage4 = findViewById(R.id.buttonImage4);
        buttonImage5 = findViewById(R.id.buttonImage5);
        buttonImage6 = findViewById(R.id.buttonImage6);
        buttonImage7 = findViewById(R.id.buttonImage7);
        buttonImage8 = findViewById(R.id.buttonImage8);
        buttonImage9 = findViewById(R.id.buttonImage9);

        buttonImage1.setOnClickListener(this);
        buttonImage2.setOnClickListener(this);
        buttonImage3.setOnClickListener(this);
        buttonImage4.setOnClickListener(this);
        buttonImage5.setOnClickListener(this);
        buttonImage6.setOnClickListener(this);
        buttonImage7.setOnClickListener(this);
        buttonImage8.setOnClickListener(this);
        buttonImage9.setOnClickListener(this);

        lock = (ImageView)findViewById(R.id.locked);

        random = (int)(8 *Math.random()) + 1;
    }

    @Override
    public void onClick(View view) {

        boolean pressed = false;

        if (locked == false){
            switch (view.getId()){
                case R.id.buttonImage1:
                    if (boxPositions[0] == 0){
                        buttonImage1.setImageResource(R.drawable.cross);
                        boxPositions[0] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
                case R.id.buttonImage2:
                    if (boxPositions[1] == 0){
                        buttonImage2.setImageResource(R.drawable.cross);
                        boxPositions[1] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
                case R.id.buttonImage3:
                    if (boxPositions[2] == 0){
                        buttonImage3.setImageResource(R.drawable.cross);
                        boxPositions[2] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
                case R.id.buttonImage4:
                    if (boxPositions[3] == 0){
                        buttonImage4.setImageResource(R.drawable.cross);
                        boxPositions[3] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
                case R.id.buttonImage5:
                    if (boxPositions[4] == 0){
                        buttonImage5.setImageResource(R.drawable.cross);
                        boxPositions[4] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
                case R.id.buttonImage6:
                    if (boxPositions[5] == 0){
                        buttonImage6.setImageResource(R.drawable.cross);
                        boxPositions[5] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
                case R.id.buttonImage7:
                    if (boxPositions[6] == 0){
                        buttonImage7.setImageResource(R.drawable.cross);
                        boxPositions[6] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
                case R.id.buttonImage8:
                    if (boxPositions[7] == 0){
                        buttonImage8.setImageResource(R.drawable.cross);
                        boxPositions[7] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
                case R.id.buttonImage9:
                    if (boxPositions[8] == 0){
                        buttonImage9.setImageResource(R.drawable.cross);
                        boxPositions[8] = 1;
                        totalSelectedBoxes++;
                        pressed = true;
                    }
                    break;
            }
            if (pressed == true){
                winner();
                if (totalSelectedBoxes < 9 && playerWin == false && machineWin == false){
                    machineTurn();
                    winner();
                }
                checkResult();
            }
        }
    }

    // Method wich the machine random plays
    public void machineTurn(){
        random = (int)(9 * Math.random());
        if (boxPositions[random] == 0 && totalSelectedBoxes < 9){
            boxPositions[random] = 2;
            switch (random){
                case 0:
                    buttonImage1.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                case 1:
                    buttonImage2.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                case 2:
                    buttonImage3.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                case 3:
                    buttonImage4.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                case 4:
                    buttonImage5.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                case 5:
                    buttonImage6.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                case 6:
                    buttonImage7.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                case 7:
                    buttonImage8.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                case 8:
                    buttonImage9.setImageResource(R.drawable.circle);
                    totalSelectedBoxes++;
                    break;
                default:
                    break;
            }
        }else{
           machineTurn();
        }
    }

    // Check the result
    public void checkResult(){
        if (playerWin == true) {
            SPMatchResult spm = new SPMatchResult(SingleplayerGame.this, "You"
                    + " has won!", SingleplayerGame.this);
            spm.setCancelable(false);
            spm.show();
            scorePlayer++;
            playerScore.setText(Integer.toString(scorePlayer));
        } else if (machineWin == true) {
            SPMatchResult spm = new SPMatchResult(SingleplayerGame.this, "Machine"
                    + " has won!", SingleplayerGame.this);
            spm.setCancelable(false);
            spm.show();
            scoreMachine++;
            machineScore.setText(Integer.toString(scoreMachine));
        } else if (totalSelectedBoxes == 9){
            SPMatchResult spm = new SPMatchResult(SingleplayerGame.this, "Match Draw", SingleplayerGame.this);
            spm.setCancelable(false);
            spm.show();
        }
    }

    // Method to see if there is a winner
    public void winner(){
        // Player win possibilities
        if (boxPositions[0] == 1 && boxPositions[1] == 1 && boxPositions[2] == 1){
            playerWin = true;
        }
        if (boxPositions[3] == 1 && boxPositions[4] == 1 && boxPositions[5] == 1){
            playerWin = true;
        }
        if (boxPositions[6] == 1 && boxPositions[7] == 1 && boxPositions[8] == 1){
            playerWin = true;
        }
        if (boxPositions[0] == 1 && boxPositions[3] == 1 && boxPositions[6] == 1){
            playerWin = true;
        }
        if (boxPositions[1] == 1 && boxPositions[4] == 1 && boxPositions[7] == 1){
            playerWin = true;
        }
        if (boxPositions[2] == 1 && boxPositions[5] == 1 && boxPositions[8] == 1){
            playerWin = true;
        }
        if (boxPositions[0] == 1 && boxPositions[4] == 1 && boxPositions[8] == 1){
            playerWin = true;
        }
        if (boxPositions[2] == 1 && boxPositions[4] == 1 && boxPositions[6] == 1){
            playerWin = true;
        }

        // Machine win possibilities
        if (boxPositions[0] == 2 && boxPositions[1] == 2 && boxPositions[2] == 2){
            machineWin = true;
        }
        if (boxPositions[3] == 2 && boxPositions[4] == 2 && boxPositions[5] == 2){
            machineWin = true;
        }
        if (boxPositions[6] == 2 && boxPositions[7] == 2 && boxPositions[8] == 2){
            machineWin = true;
        }
        if (boxPositions[0] == 2 && boxPositions[3] == 2 && boxPositions[6] == 2){
            machineWin = true;
        }
        if (boxPositions[1] == 2 && boxPositions[4] == 2 && boxPositions[7] == 2){
            machineWin = true;
        }
        if (boxPositions[2] == 2 && boxPositions[5] == 2 && boxPositions[8] == 2){
            machineWin = true;
        }
        if (boxPositions[0] == 2 && boxPositions[4] == 2 && boxPositions[8] == 2){
            machineWin = true;
        }
        if (boxPositions[2] == 2 && boxPositions[4] == 2 && boxPositions[6] == 2){
            machineWin = true;
        }
    }

    // Method to restart match
    public void restartMatch(){
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0}; //9 zero
        totalSelectedBoxes = 0;
        playerWin = false;
        machineWin = false;

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
        totalSelectedBoxes = 0;
        playerWin = false;
        machineWin = false;

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