package study;

import sun.security.krb5.internal.PAData;

import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2 + 3 * 4 / 2 = 10
 */
public class StringCalculator {

    public double calculate(StringExtractor expression) {
        Queue<Character> operator = expression.getOperator();
        Queue<Double> operand = expression.getOperand();

        double result = operand.poll();

        while(operator.size() > 0) {
            result = calculateResult(operator.poll(), operand.poll(), result);
        }
        return result;
    }

    private double calculateResult(char operator, double operand, double result) {
        Operator from = Operator.from(operator);
        return from.apply(result, operand);
    }

}

