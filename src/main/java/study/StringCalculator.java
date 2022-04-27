package study;

import java.util.Arrays;

public class StringCalculator {
    public double add(String value) {
        String[] operand = value.replaceAll("[\\s]","")
                                .replaceAll("[^\\d]", " ")
                                .split(" ");
        String[] operator = value.replaceAll("[\\s\\d]", "")
                                 .split("");

        int sum = 0;

        for (int i = 0; i < operator.length; i++) {
            if(i == 0) {
                sum = operandFactory(Integer.parseInt(operand[i]), Integer.parseInt(operand[i + 1]), operator[i]);
            } else {
                sum = operandFactory(sum, Integer.parseInt(operand[i + 1]), operator[i]);
            }
        }

        return sum;
    }

    private int operandFactory(int operand, int value, String operator) {
        if (operator.equals("+")) {
            return plus(operand, value);
        } else if(operator.equals("-")) {
            return miuns(operand, value);
        } else if(operator.equals("*")) {
            return multiply(operand, value);
        } else {
            return division(operand, value);
        }
    }

    int plus(int operand, int value) {
        return operand + value;
    }
    int miuns(int operand, int value) {
        return operand - value;
    }
    int multiply(int operand, int value) {
        return operand * value;
    }
    int division(int operand, int value) {
        return operand / value;
    }
}
