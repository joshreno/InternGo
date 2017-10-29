package com.joshuareno.interngo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User("Ash");
        user.addInternship(new AmazonInternship(3));
    }

    public void testAttack(View view) {
        Intent intent = new Intent(this, AttackActivity.class);
        Internship opponent = new GMInternship(5);
        intent.putExtra("Opponent", opponent);
        startActivity(intent);
    }
}
