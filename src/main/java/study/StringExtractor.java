package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringExtractor {

    private final Pattern pattern = Pattern.compile("^\\d+( ?[(+\\-*/)] ?\\d+)*$");

    String expression;

    StringExtractor(String expression) {
        vaildation(expression);
        this.expression = expression.replaceAll("\\s","");
    }

    private void vaildation(String expression) {
        if (expression == "" || expression == null || !vaildationMatch(expression)) {
            throw new IllegalArgumentException("잘못된 값 입니다.");
        }
    }

    private boolean vaildationMatch(String expression) {
        return pattern.matcher(expression).find();
    }

    public Queue<Character> getOperator() {
        String[] operator = expression.replaceAll("[\\d]", "").split("");
        if(operator[0].length() == 0) {
            return new LinkedList<>();
        }

        return Stream.of(operator)
                .map(s -> s.charAt(0))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Queue<Double> getOperand() {
        return Stream.of(expression.split("\\D"))
                .map(s -> Double.parseDouble(s))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
