package org.axel.androidgame.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.axel.androidgame.R;

public class MainActivity extends AppCompatActivity {

    private TextView playerScoreText;
    private Button fightMonsterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerScoreText = findViewById(R.id.PlayerScoreText);
        fightMonsterButton = findViewById(R.id.FightMonsterActivityButton);

        int score = GameManager.getInstance().getPlayer().getScore();
        playerScoreText.setText("Pisteet: " + score);

        fightMonsterButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FightMonstersActivity.class);
            startActivity(intent);
        });
    }

    protected void onResume() {
        super.onResume();
        int score = GameManager.getInstance().getPlayer().getScore();
        playerScoreText.setText("Pisteet: "+score);
    }

}