package com.example.calculator_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.util.NumberUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView calText;
    ArrayList<String> userInput = new ArrayList<String>();
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, plus, minus, multiply, divide, reset, equal, advance, modulus, pow, max, min;
    boolean inAdvanceView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calculator calculator = new Calculator();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calText = findViewById(R.id.calText);

        equal = findViewById(R.id.btnEqual);
        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int result = 0;
                if (userInput.size() % 2 == 0){
                    calText.append("= Not an Operator");
                }else {
                    try{
                        int op1 = Integer.parseInt(userInput.get(0));
                        int op2 = Integer.parseInt(userInput.get(2));
                        result = calculator.doOperation(op1, op2, userInput.get(1));
                        for (int i = 3; i<userInput.size(); i++){
                            result = calculator.doOperation(result, Integer.parseInt(userInput.get(i+1)), userInput.get(i));
                            i++;
                        }
                        calText.append("= " + String.valueOf(result));
                    }catch (NumberFormatException e){
                        calText.append("= Not an Operator");
                    }
                }
            }
        });

        reset = findViewById(R.id.btnC);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calText.setText("");
                userInput.clear();
            }
        });

        LinearLayout advancedView = (LinearLayout) findViewById(R.id.advancedView);
        advancedView.setVisibility(View.GONE);

        advance = findViewById(R.id.btnAdvance);
        advance.setText("ADVANCE - SCIENTIFIC");
        advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inAdvanceView = !inAdvanceView;
                if (inAdvanceView){
                    advance.setText("STANDARD");
                    advancedView.setVisibility(View.VISIBLE);
                }else{
                    advance.setText("ADVANCE - SCIENTIFIC");
                    advancedView.setVisibility(View.GONE);
                }
            }
        });
        b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.btn2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.btn3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.btn4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.btn5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.btn6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.btn7);
        b7.setOnClickListener(this);
        b8 = findViewById(R.id.btn8);
        b8.setOnClickListener(this);
        b9 = findViewById(R.id.btn9);
        b9.setOnClickListener(this);
        b0 = findViewById(R.id.btn0);
        b0.setOnClickListener(this);
        plus = findViewById(R.id.btnPlus);
        plus.setOnClickListener(this);
        minus = findViewById(R.id.btnMinus);
        minus.setOnClickListener(this);
        multiply = findViewById(R.id.btnMultiply);
        multiply.setOnClickListener(this);
        divide = findViewById(R.id.btnDivide);
        divide.setOnClickListener(this);
        modulus = findViewById(R.id.btnModulus);
        modulus.setOnClickListener(this);
        pow = findViewById(R.id.btnPow);
        pow.setOnClickListener(this);
        max = findViewById(R.id.btnMax);
        max.setOnClickListener(this);
        min = findViewById(R.id.btnMin);
        min.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        Button clickedBtn = (Button)view;
        if (id != R.id.btnEqual || id != R.id.btnC) {
            userInput.add(clickedBtn.getText().toString());
            calText.append(clickedBtn.getText().toString() + " ");
        }
        Log.d("week1", "Onclick fired");
    }
}