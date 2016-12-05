package pl.tubis.boardgamer.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pl.tubis.boardgamer.R;

/**
 * Created by mike on 01.12.2016.
 */

public class PasswordActivity extends AppCompatActivity {

    private Button buttonSend;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonBack = (Button) findViewById(R.id.back_button);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }

        });
    }
}
