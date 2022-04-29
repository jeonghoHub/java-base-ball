package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2 + 3 * 4 / 2 = 10/
 */
public final class StringCalculator {

    private static final Pattern PATTERN = Pattern.compile("^\\d+( ?[+\\-*/] ?\\d+)*$");

    public double calculate(String expression) {
//      2 + 2 * 5 / 2 - 2
        validation(expression);
        //연산자
        String[] operatorList = operatorExtractor(expression);
        //피연산자
        String[] operandList = operandExtractor(expression);

        double result = Double.parseDouble(operandList[0]);

        for(int i = 1; i < operandList.length; i++) {
            String operator = operatorList[i-1];
            Operator from = Operator.from(operator);

            double targetValue = Double.parseDouble(operandList[i]);

            result = from.apply(result, targetValue);
        }

        return result;
    }

    private String[] operatorExtractor(String expr) {
        return expr.replaceAll("\\s", "")
                .replaceAll("\\d", "")
                .split("");
    }
    private String[] operandExtractor(String expr) {
        return expr.replaceAll("\\s","")
                .replaceAll("\\D", "")
                .split("");
    }

    private void validation(String expr) {
        if(expr == null) {
            throw new IllegalArgumentException("잘못된 값 입니다.");
        }

        Matcher matcher = PATTERN.matcher(expr);

        if(!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 값 입니다.");
        }
    }

}
