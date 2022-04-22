package study;

import java.util.*;

public class NewStringCalculator {

    Deque<Integer> operand = new LinkedList<>();
    Queue<Character> operator = new ArrayDeque<>();

//    "2 + 3 * 4 / 2:10"
    public int add(String formula) {

        String[] values = formula.split(" ");



        for(String value : values) {
            try {
                operand.offer(Integer.parseInt(value));
            } catch (Exception e) {
                operator.offer(value.charAt(0));
            }
        }

        while (operand.size() > 0) {
            if(operator.poll() == '+') {
                plus(operand.poll(), operand.poll());
            } else if(operator.poll() == '-') {
                minus(operand.poll(), operand.poll());
            } else if(operator.poll() == '*') {
                multiply(operand.poll(), operand.poll());
            } else if(operator.poll() == '/') {
                division(operand.poll(), operand.poll());
            }
        }

        return operand.poll();
    }

    void plus(int left, int right) {
        operand.addFirst(left + right);
    }

    void minus(int left, int right) {
        operand.addFirst(left - right);
    }

    void multiply(int left, int right) {
        operand.addFirst(left * right);
    }

    void division(int left, int right) {
        operand.addFirst(left / right);
    }

}
