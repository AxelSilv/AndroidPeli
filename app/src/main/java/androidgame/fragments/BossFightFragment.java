package androidgame.fragments;

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

import androidgame.GameManager;
import androidgame.Monster;
import androidgame.Player;


public class BossFightFragment extends Fragment {

    private ImageView bossImage;
    private TextView bossText;
    private Button attackBossButton;

    private Monster boss;
    private Player player;
    private boolean healedOnce = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boss_fight, container, false);

        bossImage = view.findViewById(R.id.BossImage);
        bossText = view.findViewById(R.id.BossText);
        attackBossButton = view.findViewById(R.id.AttackBossButton);

        player = GameManager.getInstance().getPlayer();

        boss = new Monster(100, "Dark Overlord") {
            @Override
            public void takeDamage(int damage) {
                if (getLife() <= 0)
                    return;
                super.takeDamage(damage);

                if (!healedOnce && getLife() < (getMaxLife() / 2)) {
                    healedOnce = true;
                    try {
                        java.lang.reflect.Field lifeField = Monster.class.getDeclaredField("life");
                        lifeField.setAccessible(true);
                        lifeField.setInt(this, getMaxLife());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        updateBossView();

        attackBossButton.setOnClickListener(v -> {
            player.attack(boss);
            updateBossView();
        });

        return view;
    }

    private void updateBossView() {
        bossText.setText(boss.getName() + ": " + boss.getLife() + "/" + boss.getMaxLife());
        bossImage.setImageResource(R.drawable.mainboss);
    }
}