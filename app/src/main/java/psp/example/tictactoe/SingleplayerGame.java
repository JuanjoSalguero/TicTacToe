package psp.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SingleplayerGame extends AppCompatActivity {

    private boolean locked = false;

    private ImageView lock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_game);
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