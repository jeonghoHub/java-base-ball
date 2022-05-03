package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class StringCalculator {
    public double calculate(Expression expression) {
        return calculate(operator(expression), operand(expression));
    }

    @SuppressWarnings("ConstantConditions")
    private double calculate(Queue<Character> operator, Queue<Double> operand) {
        double result = operand.poll();
        while (!operator.isEmpty()) {
            Operator operatorValue = Operator.findByOperator(operator.poll());
            result = operatorValue.apply(result, operand.poll());
        }
        return result;
    }

    private Queue<Character> operator(Expression expression) {
        String[] operators = expression.get()
                .replaceAll("\\d", "")
                .split("");

        if (operators.length == 0 || (operators.length == 1 && operators[0].isEmpty())) {
            return new LinkedList<>();
        }

        return Stream.of(operators)
                .map(s -> s.charAt(0))
                .collect(toCollection(LinkedList::new));
    }

    private Queue<Double> operand(Expression expression) {
        return Stream.of(
                        expression.get().split("\\D")
                )
                .map(Double::new)
                .collect(toCollection(LinkedList::new));
    }
}

