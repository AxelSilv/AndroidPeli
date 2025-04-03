package org.axel.androidgame.fragments;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.axel.androidgame.R;

public class FightMonstersActivity extends AppCompatActivity {

    private Button showMonsterButton;
    private Button bossFightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_monsters);

        Button returnButton = findViewById(R.id.ReturnButton);
        showMonsterButton = findViewById(R.id.ShowMonsterFragmentButton);
        bossFightButton = findViewById(R.id.BossFightFragmentButton);

        returnButton.setOnClickListener(v -> finish());

        showMonsterButton.setOnClickListener(v -> loadFragment(new ShowMonsterFragment()));

        bossFightButton.setOnClickListener(v -> loadFragment(new BossFightFragment()));
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FightMonstersFrame, fragment);
        transaction.commit();
    }

    public void activityBossFightButton() {
        bossFightButton.setEnabled(true);
    }

}