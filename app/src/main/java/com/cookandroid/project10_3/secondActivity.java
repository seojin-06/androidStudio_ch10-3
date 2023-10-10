package com.cookandroid.project10_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class secondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent inIntent = getIntent();
        String calc = inIntent.getStringExtra("Calc");

        int calValue = 0;
        switch (calc) {
            case "+":
                calValue = inIntent.getIntExtra("Num1", 0)
                        + inIntent.getIntExtra("Num2", 0);
                break;
            case "-":
                calValue = inIntent.getIntExtra("Num1", 0)
                        - inIntent.getIntExtra("Num2", 0);
                break;
            case "*":
                calValue = inIntent.getIntExtra("Num1", 0)
                        * inIntent.getIntExtra("Num2", 0);
                break;
            case "/":
                calValue = inIntent.getIntExtra("Num1", 0)
                        / inIntent.getIntExtra("Num2", 0);
                break;
        }

        final int hapValue = calValue;

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", hapValue);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }
}
