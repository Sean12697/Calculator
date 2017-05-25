package com.example.seand.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private int num1 = 0;
    private String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void operation_onClick(View v) {
        TextView text = (TextView)findViewById(R.id.textView);
        EditText display = (EditText)findViewById(R.id.editText3);
        text.setText(text.getText() + " " + (((Button) v).getText().toString()) + " " + display.getText().toString());
        if (!op.equals("")) {
            equals_onClick(v);
        }

        num1 = Integer.parseInt(display.getText().toString());
        op = ((Button) v).getText().toString();
        display.setText("0");
    }

    public void equals_onClick(View v) {
        EditText display = (EditText)findViewById(R.id.editText3);

        int num2 = Integer.parseInt(display.getText().toString());
        int answer = 0;

        switch (op) {
            case "+": answer = num1 + num2;
                break;
            case "-": answer = num1 - num2;
                break;
            case "*": answer = num1 * num2;
                break;
            case "/": answer = num1 / num2;
                break;
        }

        num1 = 0;
        op = "";

        display.setText("" + answer);
        if (answer == 0) {
            TextView text = (TextView)findViewById(R.id.textView);
            text.setText("0");
        }
    }
}