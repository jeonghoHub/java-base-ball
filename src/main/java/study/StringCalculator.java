package study;

import sun.security.krb5.internal.PAData;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2 + 3 * 4 / 2 = 10
 */
public class StringCalculator {

    public double calculate(String expression) {
        vaildation(expression);

        String[] operator = operatorExtraction(expression);
        String[] operand = operandExtraction(expression);

        double result = Double.parseDouble(operand[0]);

        for(int i = 0; i < operator.length; i++) {
            Operator from = Operator.from(operator[i]);
            result = from.apply(result, Double.parseDouble(operand[i + 1]));
        }

        return result;
    }

    public String[] operatorExtraction(String expression) {
        return expression.replaceAll("[\\s\\d]","")
                .split("");
    }


    public String[] operandExtraction(String expression) {
        //"2+3*4/2-3+20"
        //2342320
        return expression.replaceAll("\\s","")
                .split("\\D");
    }

    public void vaildation(String expression) {
        Pattern pattern = Pattern.compile("^\\d+( ?[(+\\-*/)] ?\\d+)*$");
        Matcher matcher = pattern.matcher(expression);

        if(!matcher.find()) {
            throw new IllegalArgumentException("잘못된 값 입니다.");
        }
    }

}
