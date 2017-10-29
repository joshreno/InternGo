package com.joshuareno.interngo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AttackActivity extends AppCompatActivity {

    Internship opponent;
    Internship current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack);

        Intent intent = getIntent();
        opponent = (Internship)intent.getSerializableExtra("Opponent");
        current = MainActivity.user.getFirstInternship();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), opponent.getLogoID());
        Icon icon = Icon.createWithBitmap(bitmap);
        ImageView opponentView = (ImageView) findViewById(R.id.opponentImage);
        opponentView.setImageIcon(icon);

        ProgressBar opponentProgress = (ProgressBar) findViewById(R.id.opponentProgress);
        opponentProgress.setMax(opponent.getMaxHealth());
        opponentProgress.setProgress(opponent.getHealth());

        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("You send out your " +
                        current.getCompany() + " internship!");
            }
        }, 2000);

        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), current.getLogoID());
                Icon icon = Icon.createWithBitmap(bitmap);
                ImageView yourView = (ImageView) findViewById(R.id.yourImage);
                yourView.setImageIcon(icon);

                ProgressBar yourProgress = (ProgressBar) findViewById(R.id.yourProgress);
                yourProgress.setMax(current.getMaxHealth());
                yourProgress.setProgress(current.getHealth());
                yourProgress.setVisibility(View.VISIBLE);

                TextView attackText = (TextView) findViewById(R.id.attacksText);
                attackText.setVisibility(View.VISIBLE);

                Button attackButton1 = (Button) findViewById(R.id.attack1);
                attackButton1.setText(current.getAttacks()[0].getName());
                attackButton1.setVisibility(View.VISIBLE);

                Button attackButton2 = (Button) findViewById(R.id.attack2);
                attackButton2.setText(current.getAttacks()[1].getName());
                attackButton2.setVisibility(View.VISIBLE);

                Button resumeButton = (Button) findViewById(R.id.resume);
                resumeButton.setVisibility(View.VISIBLE);
            }
        }, 3000);

        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("");
            }
        }, 5000);
    }

    public void useAttack1(View view) {
        String description = current.getAttacks()[0].attack(opponent);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(description);

        

        Button attackButton1 = (Button) findViewById(R.id.attack1);
        attackButton1.setEnabled(false);
        Button attackButton2 = (Button) findViewById(R.id.attack2);
        attackButton2.setEnabled(false);
        Button resumeButton = (Button) findViewById(R.id.resume);
        resumeButton.setEnabled(false);

        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                String description = opponent.generateAttack(current);
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(description);
            }
        }, 5000);

        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("");

                Button attackButton1 = (Button) findViewById(R.id.attack1);
                attackButton1.setEnabled(true);
                Button attackButton2 = (Button) findViewById(R.id.attack2);
                attackButton2.setEnabled(true);
                Button resumeButton = (Button) findViewById(R.id.resume);
                resumeButton.setEnabled(true);
            }
        }, 10000);
    }

    public void useAttack2(View view) {
        String description = current.getAttacks()[1].attack(opponent);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(description);

        Button attackButton1 = (Button) findViewById(R.id.attack1);
        attackButton1.setEnabled(false);
        Button attackButton2 = (Button) findViewById(R.id.attack2);
        attackButton2.setEnabled(false);
        Button resumeButton = (Button) findViewById(R.id.resume);
        resumeButton.setEnabled(false);

        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                String description = opponent.generateAttack(current);
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(description);
            }
        }, 5000);

        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("");

                Button attackButton1 = (Button) findViewById(R.id.attack1);
                attackButton1.setEnabled(true);
                Button attackButton2 = (Button) findViewById(R.id.attack2);
                attackButton2.setEnabled(true);
                Button resumeButton = (Button) findViewById(R.id.resume);
                resumeButton.setEnabled(true);
            }
        }, 10000);
    }

    public void submitResume(View view) {
        boolean success = opponent.catchSuccess();
        if (success) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("You submit your resume. You successfully catch a " +
                    opponent.getCompany() + " internship!");
        } else {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("You submit your resume. You are unsuccessful at catching a " +
                    opponent.getCompany() + " internship.");
        }

        Button attackButton1 = (Button) findViewById(R.id.attack1);
        attackButton1.setEnabled(false);
        Button attackButton2 = (Button) findViewById(R.id.attack2);
        attackButton2.setEnabled(false);
        Button resumeButton = (Button) findViewById(R.id.resume);
        resumeButton.setEnabled(false);
    }
}
