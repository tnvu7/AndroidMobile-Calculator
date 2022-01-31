package com.example.calculator_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView calText;
    Calculator calculator = new Calculator(this);
    Button advance;
    boolean inAdvanceView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer btnGroup[] = {
                R.id.btn1, R.id.btn2 , R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn0,
                R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide, R.id.btnModulus, R.id.btnPow, R.id.btnMax, R.id.btnMin,
                R.id.btnEqual, R.id.btnC
        };
        for (int i : btnGroup){
            findViewById(i).setOnClickListener(this);
        }

        calText = findViewById(R.id.calText);

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
    }
    @Override
    public void onClick(View view) {
        String str = ((Button)view).getText().toString();
        calculator.push(str);
    }
}