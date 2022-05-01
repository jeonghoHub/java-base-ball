package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2 + 3 * 4 / 2 = 10/
 */
public class StringCalculator {

    public double calculation(String expression) {
        String[] operand = operandExtraction(expression);
        String[] operator = operatorExtraction(expression);

        double result = Double.parseDouble(operand[0]);

        for(int i = 0; i < operator.length; i++) {
            double target = Double.parseDouble(operand[i + 1]);

            Operator from = Operator.from(operator[i]);
            result = from.apply(result, target);
        }

        return result;
    }

    public String[] operatorExtraction(String expression) {
        return expression.replaceAll("\\s", "")
                .replaceAll("\\d", "")
                .split("");
    }

    public String[] operandExtraction(String expression) {
        return expression.replaceAll("\\s", "")
                .replaceAll("\\D", "")
                .split("");
    }

    public void vaildation(String expression) {
        Pattern pattern = Pattern.compile("^\\d+( ?[+\\-*/] ?\\d+)* ?$");
        if(!pattern.matcher(expression).find()) {
            throw new IllegalArgumentException("잘못된 값 입니다.");
        }
    }

}
