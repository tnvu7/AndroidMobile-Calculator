package com.example.calculator_a1;

public class Calculator {
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
