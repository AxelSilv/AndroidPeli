package org.axel.androidgame.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.axel.androidgame.R;


public class ShowMonsterFragment extends Fragment {

    private ImageView monsterImage;
    private TextView monsterNameText, monsterLifeText;
    private Button attackButton;

    private Monster monster;
    private Player player;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show_monster, container, false);

        monsterImage = view.findViewById(R.id.MonsterImage);
        monsterNameText = view.findViewById(R.id.MonsterNameText);
        monsterLifeText = view.findViewById(R.id.MonsterLifeText);
        attackButton = view.findViewById(R.id.AttackMonsterButton);

        GameManager gm = GameManager.getInstance();
        player = gm.getPlayer();
        monster = gm.generateMonster();

        updateMonsterView();

        attackButton.setOnClickListener(v -> {
            player.attack(monster);
            if (monster.getLife() <= 0) {
                monster = gm.generateMonster();
            }
            updateMonsterView();


            if (player.getScore() >= 100 && getActivity() instanceof FightMonstersActivity) {
                ((FightMonstersActivity) getActivity()).activityBossFightButton();
            }
        });

        return view;
    }

    private void updateMonsterView() {
        monsterNameText.setText(monster.getName());
        monsterLifeText.setText("Elämä: " + monster.getLife() + "/" + monster.getMaxLife());

        if (monster.getName().equalsIgnoreCase("Drac") || monster.getClass().getSimpleName().equals("Vampire")) {
            monsterImage.setImageResource(R.drawable.vampire);
        } else {
            monsterImage.setImageResource(R.drawable.skeleton);
        }
    }
}