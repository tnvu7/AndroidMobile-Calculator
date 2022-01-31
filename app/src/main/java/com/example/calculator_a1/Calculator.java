package com.example.calculator_a1;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator{
    private ArrayList<String> userInput = new ArrayList<String>();
    MainActivity main;
    public Calculator(MainActivity mainAct){
        main = mainAct;
    }
    void push (String value){
        if (value.equals("=")){
            int response = calculate();
            if (response == -999){
                main.calText.append("= Not an Operator");
                Log.d("push", "inside -999");
            }else{
                main.calText.append("= " + String.valueOf(response));
            }
        }else if (value.equals("C")){
            userInput.clear();
            main.calText.setText("");
        }else{
            userInput.add(value);
            main.calText.append(value + " ");
        }
    }
    int calculate(){
        int result = 0;
        if (userInput.size() % 2 == 0){
            result = -999;
        }else {
            try{
                int op1 = Integer.parseInt(userInput.get(0));
                int op2 = Integer.parseInt(userInput.get(2));
                result = doOperation(op1, op2, userInput.get(1));
                for (int i = 3; i<userInput.size(); i++) {
                    result = doOperation(result, Integer.parseInt(userInput.get(i + 1)), userInput.get(i));
                    i++;
                }
            }catch (NumberFormatException e){
                result = -999;
            }
        }
        return result;
    }

    int doOperation(int op1, int op2, String todoOp){
        if (todoOp.equals("+")){
            return op1 + op2;
        }else if (todoOp.equals("-")) {
            return op1 - op2;
        }else if (todoOp.equals("*")) {
            return op1 * op2;
        }else if (todoOp.equals("/")) {
            return op1 / op2;
        }else if (todoOp.equals("%")) {
            return op1 % op2;
        }else if (todoOp.equals("POW")) {
            return (int) Math.pow(op1, op2);
        }else if (todoOp.equals("MAX")) {
            if (op1 > op2) return op1;
            else return op2;
        }else if (todoOp.equals("MIN")) {
            if (op1 < op2) return op1;
            else return op2;
        }else {
            throw new NumberFormatException();
        }
    }
}
