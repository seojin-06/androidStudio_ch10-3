package com.cookandroid.project10_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
                RadioGroup rGroup = (RadioGroup) findViewById(R.id.rGroup);
                Intent intent = new Intent(getApplicationContext(), secondActivity.class);

                int checkedRadioButtonId = rGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.rSum) {
                    intent.putExtra("Calc", "+");
                } else if (checkedRadioButtonId == R.id.rSub) {
                    intent.putExtra("Calc", "-");
                } else if (checkedRadioButtonId == R.id.rMul) {
                    intent.putExtra("Calc", "*");
                } else if (checkedRadioButtonId == R.id.rDiv) {
                    intent.putExtra("Calc", "/");
                }
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계 :" + hap, Toast.LENGTH_SHORT).show();
        }
    }
}