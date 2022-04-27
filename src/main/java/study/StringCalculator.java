package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2 + 3 * 4 / 2 = 10/
 */
public class StringCalculator {
    private int add() {
        return 0;
    }

    public String[] operatorExtractor(String value) {
            String test[] =  value.replaceAll("\\s", "")
                    .replaceAll("\\d", "")
                    .split("");

            Pattern pattern = Pattern.compile("^\\d+( ?[+\\-*/] ?\\d+)*$");
            String str = value;

            Matcher matcher = pattern.matcher(str);

            if(!matcher.matches()) {
                throw new IllegalArgumentException("잘못된 값 입니다.");
            }

        return test;
    }
}
