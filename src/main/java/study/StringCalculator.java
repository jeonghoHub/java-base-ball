package study;

import java.util.*;

public class StringCalculator {
    public int add() {
        return 0;
    }


     /*"2 + 3 * 4 / 2:10",
       "5 + 5 * 4 / 2:20",
       "6 + 6 / 3:4"*/
    public int calculate(String expr) {
        String[] values = expr.split(" ");

        Deque<Integer> ints = new ArrayDeque<>();
        Queue<String> operator = new LinkedList<>();

        for (String value : values) {
            if(Character.isDigit(value.charAt(0))) {
                int i = Integer.parseInt(value);
                ints.offer(i);
            } else {
                operator.offer(value);
            }
        }

        while (!operator.isEmpty()) {
            if("+".equals(operator.peek())) {
                if(ints.size() == 2) {
                    operator.poll();
                    int sum = ints.poll() + ints.poll();
                    ints.addFirst(sum);
                }
            } else if("-".equals(operator.peek())) {
                operator.poll();
                if(ints.isEmpty()) {
                    break;
                }
                int sum = ints.poll() - ints.poll();
                ints.addFirst(sum);
            } else if("*".equals(operator.peek())) {
                operator.poll();
                int sum =  ints.poll() * ints.poll();
                ints.addFirst(sum);
            } else if("/".equals(operator.peek())) {
                operator.poll();
                int sum = ints.poll() / ints.poll();
                ints.addFirst(sum);
            }
        }

        System.out.println(ints);
        System.out.println(operator);

        return ints.poll();
    }
}
