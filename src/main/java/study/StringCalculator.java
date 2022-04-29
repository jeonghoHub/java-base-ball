package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2 + 3 * 4 / 2 = 10/
 */
public final class StringCalculator {

    private static final Pattern PATTERN = Pattern.compile("^\\d+( ?[+\\-*/] ?\\d+)*$");

    public double calculate(String expr) {
        validation(expr);
        String[] operatorList = operatorExtractor(expr);
        String[] operandList = operandExtractor(expr);

        return 8;
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
