package com.android.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnEquals, btnPlus, btnMinus, btnMultiply, btnDivide,
            btnDot, btnDeleteAll, btnPlusMinus, btnPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing control variables
        text = findViewById(R.id.text);

        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        btnDeleteAll = findViewById(R.id.btnDeleteAll);
        btnDot = findViewById(R.id.btnDot);
        btnPercent = findViewById(R.id.btnPercent);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);

        btnEquals = findViewById(R.id.btnEquals);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                String result = text.getText().toString();
                if (result.contentEquals("Error"))
                    clearTextView();
                text.setText(text.getText() + btn.getText().toString());
            }
        };

        btn0.setOnClickListener(onClickListener);
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);

        btnPlus.setOnClickListener(onClickListener);
        btnMinus.setOnClickListener(onClickListener);
        btnMultiply.setOnClickListener(onClickListener);
        btnDivide.setOnClickListener(onClickListener);

        btnPercent.setOnClickListener(onClickListener);
        btnDot.setOnClickListener(onClickListener);
        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expression expression = new Expression(text.getText().toString());
                if (expression.getSyntaxStatus()) {
                    String result = Double.toString(-1*expression.calculate()).replaceAll(".0$", "");
                    text.setText(result);
                } else
                    text.setText(R.string.error);
            }
        });

        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTextView();
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expression expression = new Expression(text.getText().toString());
                if (expression.getSyntaxStatus()) {
                    String result = Double.toString(expression.calculate()).replaceAll(".0$", "");
                    text.setText(result);
                } else
                    text.setText(R.string.error);
            }
        });
    }

    private void clearTextView() {
        text.setText("");
    }
}
